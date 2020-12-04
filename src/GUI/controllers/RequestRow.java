/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

/**
 *
 * @author angel
 */
public class RequestRow {
    
    public String idSolicitud;
        public String fechaInicio;
        public String fechaFinal;
        public String computador;
        public String sala;
        public String edificio;
        public String programa;

    public RequestRow(String idSolicitud, String fechaInicio, String fechaFinal, String computador, String sala, String edificio, String programa) {
        this.idSolicitud = idSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.computador = computador;
        this.sala = sala;
        this.edificio = edificio;
        this.programa = programa;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
        
    
    
}
