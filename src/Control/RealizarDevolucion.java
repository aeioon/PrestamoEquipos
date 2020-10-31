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
    
    public String makeReturn(Usuario usuario) {        
        if(!SolicitudDao.ChangeRequestStatus(usuario)){
            return "Error en la devolución del equipo";
        }else{
            return SolicitudDao.getInfo(usuario);
        }        
    }
    
}
