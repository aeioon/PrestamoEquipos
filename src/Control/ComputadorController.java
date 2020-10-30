package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaSolicitudDAO;
import DAO.SolicitudDAO;
import DAO.UsuarioDAO;
import Entidad.Programa;
import Entidad.Computador;
import Entidad.Solicitud;
import Entidad.Usuario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ComputadorController {

    ComputadorDAO computadorDao = new ComputadorDAO();
    SolicitudDAO solicitudDao = new SolicitudDAO();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    ProgramaSolicitudDAO programaSolicitudDao = new ProgramaSolicitudDAO();

    public ComputadorController() {
    }

    public ArrayList<String[]> getInfoComputadores(ArrayList<Programa> programs) {
        ArrayList<String[]> computadores = new ArrayList<>();
        if (programs.size() != 0) {
            computadores = computadorDao.getInfoComputersAvailable(programs);
        }
        return computadores;
    }

    public void makeBorrow(Usuario usuario, Computador comp, ArrayList<Programa> programs) {
        LocalDateTime now = LocalDateTime.now();
        Solicitud solicitud = new Solicitud(0, now, comp, usuario, 1);
        solicitudDao.crear(solicitud);
        computadorDao.changeAvailabilityWhenBorrow(comp);
        for(int i = 0; i < programs.size(); i++){
            programaSolicitudDao.crear(programs.get(i), solicitud);
        }
        return;
    }

    public void makeReturn(Usuario usuario) {
        computadorDao.changeAvailabilityWhenReturn(usuario);
        return;
    }

}
