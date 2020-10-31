package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

public class RealizarDevolucion {

    SolicitudDAO solicitudDao = new SolicitudDAO();
    String infoReturn = "";

    public RealizarDevolucion() {
    }

    public boolean makeReturn(Usuario usuario) {
        if (solicitudDao.VerifyInactivity(usuario)) {
            infoReturn = solicitudDao.getInfo(usuario);
            if (solicitudDao.ChangeRequestStatus(usuario)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
