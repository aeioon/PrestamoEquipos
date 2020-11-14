/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarDevolucion;
import Entidad.Computador;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    CargarDatosUsuario cargarDatos = CargarDatosUsuario.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();

    @FXML
    private Button exitReturnBtn;

    @FXML
    private Button returnEquipmentBtn;

    @FXML
    private Text stateText;

    @FXML
    private Button aceptarBtn;

    @FXML
    void exitReturnBtnAction(ActionEvent event) {
        Stage stage = (Stage) exitReturnBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void returnEquipmentBtnAction(ActionEvent event) throws IOException {
        Computador computador = new Computador();
        computador.setId(Integer.parseInt(cargarDatos.getDatosSolicitud().get(0)[1]));
        if (RD.makeReturn(cargarDatos.getUser(), computador, cargarDatos.isActivo())) {
            System.out.println("Se realizo la devolucion!");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cargarDatos.cargar(cargarDatos.getUser());
                }
            }).start();
            Stage stage = (Stage) returnEquipmentBtn.getScene().getWindow();
            stage.close();
        } else {
            stateText.setText("Fallo en la devolucion");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stateText.setText("Debes devolver el equipo " + cargarDatos.getDatosSolicitud().get(0)[1]
                + " en la sala " + cargarDatos.getDatosSolicitud().get(0)[4]
                + " del edificio " + cargarDatos.getDatosSolicitud().get(0)[2] + ".");
    }

}
