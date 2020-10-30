package Control;

import DAO.ComputadorDAO;
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

    public ComputadorController() {
    }

    public String[][] getInfoComputadores(ArrayList<Programa> programs) {
        String[][] computadores = new String[0][0];
        if (programs.size() != 0) {
            computadores = computadorDao.getInfoComputersAvailable(programs);
        }
        return computadores;
    }

    public boolean makeBorrow(Usuario usuario, Computador comp){
        LocalDateTime now = LocalDateTime.now();
        Solicitud solicitud = new Solicitud(0, now, comp.getId(), usuario.getId(), 1);
        solicitudDao.crear(solicitud);
        return computadorDao.changeAvailabilityWhenBorrow(comp);
    }
    
    public boolean makeReturn(Usuario usuario){
        return computadorDao.changeAvailabilityWhenReturn(usuario);
    }

}
