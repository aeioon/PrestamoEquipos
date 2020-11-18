package Control;

import DAO.ComputadorProgramaDAO;
import DAO.ProgramaDAO;
import Entidad.Computador;
import Entidad.Programa;
import java.util.ArrayList;

public class ManageSoftwareTeams {

    ProgramaDAO programaDao = new ProgramaDAO();
    ComputadorProgramaDAO computadorProgramaDao = new ComputadorProgramaDAO();

    public ArrayList<String[]> mostrarEquipos(Programa programa) {
        ArrayList<String[]> computadores = computadorProgramaDao.mostrar(programa);
        return computadores;
    }

    public ArrayList<String[]> equiposSinPrograma(Programa programa){
        ArrayList<String[]> computadores = computadorProgramaDao.equiposSinPrograma(programa);
        return computadores;
    }
    
    public boolean adherirEquipos(ArrayList<Computador> computadores, Programa programa) {
        boolean adicion = true;
        for (int i = 0; i < computadores.size(); i++) {
            adicion = adicion && computadorProgramaDao.crear(computadores.get(i), programa);
        }
        return adicion;
    }

    public boolean quitarEquipos(ArrayList<Computador> computadores, Programa programa) {
        boolean adicion = true;
        for (int i = 0; i < computadores.size(); i++) {
            boolean resultado = computadorProgramaDao.quitar(computadores.get(i), programa);
            adicion = adicion && resultado;
        }
        return adicion;
    }

}
