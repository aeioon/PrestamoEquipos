package Control;
    
import DAO.ComputadorDAO;
import Entidad.Programa;
import Entidad.Computador;

public class ComputadorController {
    
    ComputadorDAO computadorDao = new ComputadorDAO();

    public ComputadorController() {
    }
    
    public String[][] getInfoComputadores(Programa[] programs){
        String[][] computadores = computadorDao.getInfo(programs);
        return computadores;
    }
    
    public void changeComputerAvailability(Computador comp){
        computadorDao.changeAvailability(comp);
        return;
    }
}
