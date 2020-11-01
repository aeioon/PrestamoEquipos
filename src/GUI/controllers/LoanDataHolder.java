/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ion
 */
public final class LoanDataHolder {

    private Usuario user;
    private Computador computer;
    private ArrayList<Programa> programs;
    private ComputerRow row;
    
    private LoanDataHolder() {}
    
    private static LoanDataHolder holder = new LoanDataHolder();
    
    public static LoanDataHolder getInstance() {
        return holder;
    }

    public ComputerRow getRow() {
        return row;
    }

    public void setRow(ComputerRow row) {
        this.row = row;
    }
    

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Computador getComputer() {
        return computer;
    }

    public void setComputer(Computador computer) {
        this.computer = computer;
    }

    public ArrayList<Programa> getPrograms() {
        return programs;
    }

    public void setPrograms(ArrayList<Programa> programs) {
        this.programs = programs;
    }
        
        
    }
