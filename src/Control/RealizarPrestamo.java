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

    public boolean makeBorrow(Solicitud solicitud, Computador computador) {
        if (solicitud.getFechaHoraInicio().isBefore(LocalDateTime.now()) && LocalDateTime.now().isBefore(solicitud.getFechaHoraFin())) {
            solicitud.setFechaHoraInicio(LocalDateTime.now());
            solicitud.setFechaHoraFin(LocalDateTime.now().plusHours(1));
        }
        return solicitudDao.makeBorrow(solicitud, computador);
    }

    public Solicitud createRequest(Usuario usuario, ArrayList<Programa> programs, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Solicitud solicitud = new Solicitud();
        solicitud.setUsuario(usuario);
        solicitud.setFechaHoraInicio(fechaHoraInicio);
        System.err.println("Inicio: " + solicitud.getFechaHoraInicio());
        solicitud.setFechaHoraFin(fechaHoraFin);
        System.err.println("Fin: " + solicitud.getFechaHoraFin());
        if (solicitudDao.crear(solicitud)) {
            solicitud.setId(solicitudDao.getIdSolicitud(solicitud));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < programs.size(); i++) {
                            programaSolicitudDao.crear(programs.get(i), solicitud);
                        }
                    } catch (Exception e) {
                        System.out.println("Error Programa_Solicitud");
                    }
                }
            }).start();
            return solicitud;
        } else {
            return null;
        }
    }

    public boolean computerIsFree(Computador computador) {
        return solicitudDao.verifyComputerOccupation(computador);
    }
}
