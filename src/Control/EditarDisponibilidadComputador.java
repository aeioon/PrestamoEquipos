/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ComputadorDAO;
import Entidad.Computador;

/**
 *
 * @author aleja
 */
public class EditarDisponibilidadComputador { 
    
    ComputadorDAO computadorDao = new ComputadorDAO();
    
    public boolean makeReturn(Computador computador){
        return computadorDao.freeComputer(computador);
    }
}
