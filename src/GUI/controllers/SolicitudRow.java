/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.MostrarInformacionComputadores;
import Control.RealizarDevolucion;
import Entidad.Computador;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLACK;
import javafx.stage.Stage;

/**
 *
 * @author ion
 */
public class SolicitudRow {

    public String idSolicitud;
    public String idEquipo;
    public String nombreEdificio;
    public String idEdificio;
    public String codigoSala;
    public String fechaInicio;
    public String fechaFin;

    public Button botonInfo;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio, formatter);
        LocalDateTime fin = LocalDateTime.parse(fechaFin, formatter);

        if (inicio.isBefore(LocalDateTime.now()) && LocalDateTime.now().isBefore(fin)) {
            this.botonInfo = new Button("Devolver");
        } else {
            this.botonInfo = new Button("Cancelar");

        }

        botonInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    System.out.println("El computador seleccionado es: " + idEquipo);
                    selectcomputador.setId(Integer.parseInt(idEquipo));
                    if (botonInfo.getText().equals("Devolver")) {
                        Computador computador = new Computador();
                        computador.setId(Integer.parseInt(idEquipo));
                        if (RD.makeReturn(cargarDatosUsuario.getUser(), computador, cargarDatosUsuario.isActivo())) {
                            System.out.println("Se realizo la devolucion!");
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    cargarDatosUsuario.cargar(cargarDatosUsuario.getUser());
                                }
                            }).start();
                        } else {
                            System.out.println("Fallo en la devolucion");
                        }
                    } else {
                        if(RD.cancelRequest()){
                            
                        }
                    }
                }
            }
        });
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

    public Button getBotonInfo() {
        return botonInfo;
    }

    public void setBotonInfo(Button botonInfo) {
        this.botonInfo = botonInfo;
    }

}
