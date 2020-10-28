package Control;

import DAO.ProgramaDAO;
import Entidad.Programa;
import java.util.ArrayList;

public class ProgramaController {
    
    ProgramaDAO programaDao = new ProgramaDAO();

    public ProgramaController() {
    }
    
    public ArrayList<Programa> getAllPrograms(){
        ArrayList<Programa> programas = programaDao.getAll(); 
        return programas;
    }
    
}
