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

    @FXML
    private Button exitReturnBtn;

    @FXML
    private Button returnEquipmentBtn;

    @FXML
    private Text equipmentText;

    @FXML
    private TableView<?> usedEquipment;

    @FXML
    void exitReturnBtnAction(ActionEvent event) {
        Stage stage = (Stage) exitReturnBtn.getScene().getWindow();
        stage.close();

    }
    @FXML
    void returnEquipmentBtnAction(ActionEvent event) {
        RealizarDevolucion RD = new RealizarDevolucion();
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
        // TODO
    }    
    
}