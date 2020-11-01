/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

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
    
    Usuario user = SessionHolder.getInstance().getUser();
    RealizarDevolucion RD = new RealizarDevolucion();
    
    @FXML
    private Button exitReturnBtn;

    @FXML
    private Button returnEquipmentBtn;

    @FXML
    private Text equipmentText;
    
    
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
        
        if(RD.makeReturn(user)){
            System.out.println("Se realizo la devolucion!");
            Stage stage = (Stage) returnEquipmentBtn.getScene().getWindow();
            stage.close();
        } else {
            equipmentText.setText("Fallo en la devolucion");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equipmentText.setText("Revisando el estado de tu cuenta...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (RD.isInactivity(user)) {
                            equipmentText.setVisible(false);
                            stateText.setText("Debes devolver el equipo "+RD.getInfoIdEquipo()+
                                              " en la sala "+RD.getInfoCodigoSala()+
                                              " del edificio "+RD.getInfoNombreEdificio()+".");
                        } else {
                            equipmentText.setVisible(false);    
                            stateText.setText("No debes devolver ningun equipo");
                        }
                    }
                });
            }
        }).start();
    }    
    
}