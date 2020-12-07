/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProgramaSolicitudDAO;
import DAO.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class MostrarInformesHistorial {
    
    ProgramaSolicitudDAO proSolDAO = new ProgramaSolicitudDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    //IdUsuario, SoftwareMásUtilizado, TiempoTotalDeLosPréstamos
    public ArrayList<String[]> getBorrowsHistoryInfo(){
        return proSolDAO.getBorrowsHistoryInfo();
    }
    
    //IdSolicitud, Fecha Inicio, Fecha Final, Computador, Sala, Edificio, Programas
    public ArrayList<String[]> getWholeUserBorrowsInfo(String userId){ 
        return usuarioDAO.getWholeUserBorrowsInfo(userId);
    }
}
