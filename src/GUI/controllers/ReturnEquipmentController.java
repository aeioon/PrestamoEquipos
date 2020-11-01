/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatos;
import Control.RealizarDevolucion;
import Entidad.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class ReturnEquipmentController implements Initializable {

    CargarDatos cargarDatos = CargarDatos.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();

    @FXML
    private Button exitReturnBtn;

    @FXML
    private Button returnEquipmentBtn;

    @FXML
    private Text stateText;

    @FXML
    private TableView<?> usedEquipment;

    @FXML
    void exitReturnBtnAction(ActionEvent event) {
        Stage stage = (Stage) exitReturnBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void returnEquipmentBtnAction(ActionEvent event) {
        if (RD.makeReturn(cargarDatos.getUser(), Integer.parseInt(cargarDatos.getInfoIdEquipo()), cargarDatos.isActivo())) {
            System.out.println("Se realizo la devolucion!");
            cargarDatos.setActivo(false);
            Stage stage = (Stage) returnEquipmentBtn.getScene().getWindow();
            stage.close();
        } else {
            stateText.setText("Fallo en la devolucion");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stateText.setText("Debes devolver el equipo " + cargarDatos.getInfoIdEquipo()
                + " en la sala " + cargarDatos.getInfoCodigoSala()
                + " del edificio " + cargarDatos.getInfoNombreEdificio() + ".");
    }

}
