/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarDevolucion;
import Entidad.Computador;

/**
 *
 * @author ion
 */
public class SolicitudRow {

    public int id;
    public String idSolicitud;
    public String idEquipo;
    public String nombreEdificio;
    public String idEdificio;
    public String codigoSala;
    public String fechaInicio;
    public String fechaFin;

    static Computador selectcomputador = new Computador();
    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();

    public static Computador getSelectcomputador() {
        return selectcomputador;
    }

    public SolicitudRow(String idSolicitud, String idEquipo, String nombreEdificio, String idEdificio, String codigoSala, String fechaInicio, String fechaFin) {
        this.idSolicitud = idSolicitud;
        this.idEquipo = idEquipo;
        this.nombreEdificio = nombreEdificio;
        this.idEdificio = idEdificio;
        this.codigoSala = codigoSala;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(String idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.fechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.fechaFin = fechaFin;
    }
    
}