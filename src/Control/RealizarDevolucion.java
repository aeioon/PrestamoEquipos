package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

public class RealizarDevolucion {

    SolicitudDAO solicitudDao = new SolicitudDAO();
    ComputadorDAO computadorDao = new ComputadorDAO();
    boolean estadoSolicitud = true;

    public RealizarDevolucion() {
    }

    public boolean makeReturn(Usuario usuario, int id_Equipo, boolean activo) {
        if (activo) {
            estadoSolicitud = estadoSolicitud && computadorDao.freeComputer(id_Equipo);
            return estadoSolicitud;
        } else {
            return false;
        }
    }
}
