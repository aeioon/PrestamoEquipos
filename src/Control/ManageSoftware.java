package Control;

import DAO.ProgramaDAO;
import Entidad.Programa;
import java.util.ArrayList;

public class ManageSoftware {
    
    ProgramaDAO programaDao = new ProgramaDAO();
    
    public ArrayList<Programa> getAllPrograms(){
        ArrayList<Programa> programas = programaDao.getAllProgramsAvailable();
        return programas;
    }
    
    public boolean crear (Programa programa){
        boolean crear = programaDao.crear(programa);
        return crear;
    }
    
    public boolean actualizar (Programa oldPrograma, Programa newPrograma){
        boolean actualizar = programaDao.actualizar(oldPrograma, newPrograma);
        return actualizar;
    }
    
    public boolean eliminar (Programa programa){
        boolean eliminar = programaDao.eliminar(programa);
        return eliminar;
    }
    
}
