package Control;

import DAO.ProgramaDAO;
import Entidad.Programa;
import java.util.ArrayList;

public class MostrarInformesSoftware {
    
    ProgramaDAO programaDao = new ProgramaDAO();
    
    public ArrayList<String[]> getRequestStats(){
        return programaDao.getRequestStats();
    }
    
    public ArrayList<String[]> getProgramRequestHistory(Programa selected){
        return programaDao.getProgramRequestHistory(selected);
    }
    
    public int[] getRequestStats(Programa selected){
        return programaDao.getRequestStats(selected);
    }
}
