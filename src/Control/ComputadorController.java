package Control;
    
import DAO.ComputadorDAO;
import Entidad.Programa;
import Entidad.Computador;
import java.util.ArrayList;

public class ComputadorController {
    
    ComputadorDAO computadorDao = new ComputadorDAO();

    public ComputadorController() {
    }
    
    public String[][] getInfoComputadores(ArrayList<Programa> programs){
        String[][] computadores = computadorDao.getInfo(programs);
        return computadores;
    }
    
    public boolean changeComputerAvailability(Computador comp){
        return computadorDao.changeAvailability(comp);
    }
}


/*
        ComputadorController computadorControl = new ComputadorController();
        ArrayList<Programa> programs = new ArrayList<>();
        Programa programa1 = new Programa(1, "Join", "18.4");
        Programa programa2 = new Programa(2, "Join", "18.4");
        Programa programa3 = new Programa(3, "Join", "18.4");
        programs.add(programa1);
        programs.add(programa2);
        programs.add(programa3);
        String[][] computadores = computadorControl.getInfoComputadores(programs);
        for(int i = 0; i < computadores.length; i++){
            for(int j = 0; j < computadores[i].length; j++){
                System.out.print(computadores[i][j] + " ");
            }
            System.out.print("\n");
        }
        */
        /*
        Computador comp = new Computador(1, "Sistem", "Ram", true, null);
        ComputadorController computadorControl = new ComputadorController();
        boolean confirmacion = computadorControl.changeComputerAvailability(comp);
        System.out.println(confirmacion);
        */

        /*ProgramaController pc = new ProgramaController();
        ArrayList<Programa> programs = pc.getAllPrograms();
        for(int i = 0; i < programs.size(); i++){
            System.out.println(programs.get(i).getId() + " " + programs.get(i).getNombre() + " " + programs.get(i).getVersion());
        }
        */