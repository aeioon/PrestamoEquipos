package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.ProgramaSolicitudDAO;
import DAO.SolicitudDAO;
import DAO.UsuarioDAO;
import Entidad.Programa;
import Entidad.Computador;
import Entidad.Solicitud;
import Entidad.Usuario;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.application.Platform;

public class RealizarPrestamo {

    ProgramaSolicitudDAO programaSolicitudDao = new ProgramaSolicitudDAO();
    ComputadorDAO computadorDao = new ComputadorDAO();
    SolicitudDAO solicitudDao = new SolicitudDAO();
    ProgramaDAO programaDao = new ProgramaDAO();

    public RealizarPrestamo() {
    }

    public ArrayList<Programa> getAllPrograms() {
        ArrayList<Programa> programas = programaDao.getAllProgramsAvailable();
        return programas;
    }

    public ArrayList<String[]> getInfoComputers(ArrayList<Programa> programs, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        ArrayList<String[]> computadores = new ArrayList<>();
        computadores = computadorDao.getInfoComputersAvailable(programs, fechaHoraInicio, fechaHoraFin);
        return computadores;
    }

    public boolean makeBorrow(Usuario usuario, Computador computer, ArrayList<Programa> programs, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Solicitud solicitud = new Solicitud();
        solicitud.setUsuario(usuario);
        solicitud.setComputador(computer);
        solicitud.setFechaHoraInicio(fechaHoraInicio);
        solicitud.setFechaHoraFin(fechaHoraFin);
        if (solicitudDao.crear(solicitud)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean estadoPrestamo = true;
                    solicitud.setId(solicitudDao.getIdSolicitud(solicitud));
                    for (int i = 0; i < programs.size(); i++) {
                        estadoPrestamo = estadoPrestamo && programaSolicitudDao.crear(programs.get(i), solicitud);
                    }
                }
            }).start();
            return true;
        } else {
            return false;
        }
    }
}
