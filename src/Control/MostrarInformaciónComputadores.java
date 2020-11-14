/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ComputadorDAO;
import Entidad.Computador;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class MostrarInformaciónComputadores {
    
    ComputadorDAO cdao = new ComputadorDAO();
    
    public ArrayList<String[]> getConcurrenceInfo(){        
        return cdao.getConcurrenceInfo();
    }
    
    public double getConcurrencePercentage(){
        return cdao.getConcurrencePercentage();
    }    
    
    public ArrayList<String> getHoleComputerInfo(Computador computer) {
        return cdao.getHoleComputerInfo(computer);
    }
    
    public ArrayList<String> getComputerPrograms(Computador computer) {
        return cdao.getComputerPrograms(computer);
    }
}
