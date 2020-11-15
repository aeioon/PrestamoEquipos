/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosAdministrador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    CargarDatosAdministrador cargarDatosAdministrador = CargarDatosAdministrador.getInstance();
    
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
    void managementBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();
        Pane newParent = (Pane)FXMLLoader.load(getClass().getResource("/GUI/views/softwareManagement.fxml"));
        principalPane.getChildren().add(newParent);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            principalPane.getChildren().clear();
            Pane newParent = (Pane)FXMLLoader.load(getClass().getResource("/GUI/views/concurrence.fxml"));
            principalPane.getChildren().add(newParent);
        } catch (IOException ex) {
            Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
