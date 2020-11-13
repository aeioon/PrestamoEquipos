/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class AdminHomeController implements Initializable {

    @FXML
    private Button concurrenceB;
    
    @FXML
    private Button managementB;
    
    @FXML
    private Pane principalPane;
    
    @FXML
    void concurrenceBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();
        Pane newParent = (Pane)FXMLLoader.load(getClass().getResource("/GUI/views/concurrence.fxml"));
        principalPane.getChildren().add(newParent);
    }
    
    @FXML
    void managementBtnAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
