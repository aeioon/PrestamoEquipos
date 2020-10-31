package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

public class RealizarDevolucion {

    SolicitudDAO solicitudDao = new SolicitudDAO();
    ComputadorDAO computadroDao = new ComputadorDAO();
    String infoIdEquipo = "";
    String infoIdEdificio = "";
    String infoNombreEdificio = "";
    String infoCodigoSala = "";

    public RealizarDevolucion() {
    }

    public boolean makeReturn(Usuario usuario) {
        if (!solicitudDao.VerifyInactivity(usuario)) {
            infoIdEquipo = solicitudDao.getInfo(usuario)[0];
            infoIdEdificio = solicitudDao.getInfo(usuario)[1];
            infoNombreEdificio = solicitudDao.getInfo(usuario)[2];
            infoCodigoSala = solicitudDao.getInfo(usuario)[3];
            if (solicitudDao.ChangeRequestStatus(usuario)) {                
                computadroDao.freeComputer(Integer.parseInt(infoIdEquipo));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
