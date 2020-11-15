/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarInformacionComputadores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLACK;
import javafx.stage.Stage;

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
    public Button botonInfo;

    public ConcurrenceRow(String idEquipo, String idUsuario, String codigoEdificio, String codigoSala, String disponibilidad) {
        this.idEquipo = idEquipo;
        this.idUsuario = idUsuario;
        this.codigoEdificio = codigoEdificio;
        this.codigoSala = codigoSala;
        this.disponibilidad = disponibilidad;
        if (disponibilidad.equals("1")) {
            this.disponibilidad = "No disponible";
        } else {
            this.disponibilidad = "Disponible";
        }
        this.botonInfo = new Button("+");
        this.botonInfo.setOnAction((ActionEvent event) -> {
            try {
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/views/equipmentInformation.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Prestamo de equipos de computo");
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
                primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(ConcurrenceRow.class.getName()).log(Level.SEVERE, null, ex);
            }
                        });
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

    public Button getBotonInfo() {
        return botonInfo;
    }

    public void setBotonInfo(Button botonInfo) {
        this.botonInfo = botonInfo;
    }
    
    
}