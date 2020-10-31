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
public class SessionHolder {

    private Usuario user;
    private SessionHolder() {}
    
    private static SessionHolder holder = new SessionHolder();
    
    public static SessionHolder getInstance() {
        return holder;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public static SessionHolder getHolder() {
        return holder;
    }

    public static void setHolder(SessionHolder holder) {
        SessionHolder.holder = holder;
    } 
}

