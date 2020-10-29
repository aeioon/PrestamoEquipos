/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class ReturnEquipmentController implements Initializable {

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

    }

    @FXML
    void returnEquipmentBtnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}