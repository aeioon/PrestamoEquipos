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
 * @author Camilo
 */
public class SessionHolder {

    private SessionHolder() {}
    
    private static SessionHolder holder = new SessionHolder();
    
    public static SessionHolder getInstance() {
        return holder;
    }
    
}

