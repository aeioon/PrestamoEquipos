/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

/**
 *
 * @author ion
 */
 public class ConcurrenceRow {

        public String idEquipo;
        public String idUsuario;
        public String codigoEdificio;
        public String codigoSala;
        public String disponibilidad;

    public ConcurrenceRow(String idEquipo, String idUsuario, String codigoEdificio, String codigoSala, String disponibilidad) {
        this.idEquipo = idEquipo;
        this.idUsuario = idUsuario;
        this.codigoEdificio = codigoEdificio;
        this.codigoSala = codigoSala;
        this.disponibilidad = disponibilidad;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoEdificio() {
        return codigoEdificio;
    }

    public void setCodigoEdificio(String codigoEdificio) {
        this.codigoEdificio = codigoEdificio;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

        

    }
