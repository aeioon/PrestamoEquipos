package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

public class RealizarDevolucion {
    
    SolicitudDAO SolicitudDao = new SolicitudDAO();
    
    public RealizarDevolucion() {
    }
    
    public void makeReturn(Usuario usuario) {
        SolicitudDao.ChangeRequestStatus(usuario);
        return;
    }
    
}
