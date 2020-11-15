package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;
import Entidad.Computador;

public class RealizarDevolucion {

    SolicitudDAO solicitudDao = new SolicitudDAO();
    ComputadorDAO computadorDao = new ComputadorDAO();

    public RealizarDevolucion() {
    }

    public boolean makeReturn(Usuario usuario, Computador computador, boolean activo) {
        if (activo) {
            return computadorDao.freeComputer(computador);
        } else {
            return false;
        }
    }
    
    public boolean cancelRequest(){
        return true;
    }
}
