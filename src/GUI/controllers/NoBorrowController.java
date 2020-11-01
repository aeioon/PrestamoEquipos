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
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author julia
 */
public class NoBorrowController implements Initializable {

    @FXML
    private Button aceptarBtn;

    @FXML
    private Text stateText;

    @FXML
    void returnEquipmentBtnAction(ActionEvent event) {
        Stage stage = (Stage) aceptarBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stateText.setText("No puede solicitar mas de un dispositivo de computo");
    }

}
