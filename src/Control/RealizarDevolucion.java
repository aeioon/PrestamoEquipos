package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;
import Entidad.Computador;
import Entidad.Solicitud;

public class RealizarDevolucion {

    SolicitudDAO solicitudDao = new SolicitudDAO();
    ComputadorDAO computadorDao = new ComputadorDAO();

    public RealizarDevolucion() {
    }

    public boolean makeReturn(Computador computador, boolean activo) {
        if (activo) {
            return computadorDao.returnComputer(computador);
        } else {
            return false;
        }
    }
    
    public boolean cancelRequest(Solicitud solicitud){
        return solicitudDao.eliminar(solicitud);
    }
}
