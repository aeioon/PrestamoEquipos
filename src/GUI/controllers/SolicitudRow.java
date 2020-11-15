/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarInformacionComputadores;
import Entidad.Computador;
import java.io.IOException;
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
    public String FechaInicio;
    public String FechaFin;
    
    public Button botonInfo;

    static Computador selectcomputador = new Computador();

    public static Computador getSelectcomputador() {
        return selectcomputador;
    }
    
    public SolicitudRow(String idSolicitud, String idEquipo, String nombreEdificio, String idEdificio, String codigoSala, String FechaInicio, String FechaFin) {
        this.idSolicitud = idSolicitud;
        this.idEquipo = idEquipo;
        this.nombreEdificio = nombreEdificio;
        this.idEdificio = idEdificio;
        this.codigoSala = codigoSala;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;        
        this.botonInfo = new Button("+");
        botonInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    System.out.println("El computador seleccionado es: " + idEquipo);
                    selectcomputador.setId(Integer.parseInt(idEquipo));

                    Stage primaryStage = new Stage();
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/GUI/views/equipmentInformation.fxml"));
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.setTitle("Prestamo de equipos de computo");
                        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
                        primaryStage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ConcurrenceRow.class.getName()).log(Level.SEVERE, null, ex);
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
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public Button getBotonInfo() {
        return botonInfo;
    }

    public void setBotonInfo(Button botonInfo) {
        this.botonInfo = botonInfo;
    }
      
}
