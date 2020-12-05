/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

/**
 *
 * @author Gabriela
 */
public class ProgramRequestRow {
        String idSolicitud;
        String usuario;
        String fechaInicio;
        String fechafinal;
        String exito;

    public ProgramRequestRow(String idSolicitud, String usuario, String fechaInicio, String fechafinal, String exito) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechafinal = fechafinal;
        this.exito = exito;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public String getExito() {
        return exito;
    }
        
    
        
}
