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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author julia
 */
public class FrequentQuestionsController implements Initializable {

    @FXML
    private Button backHomeBtn;
    @FXML
    private Label questions;
    
    @FXML
    void backHomeBtnAction(ActionEvent event) throws IOException {
        try {
            changeScene(event, "/GUI/views/studentHome.fxml");
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }
    
    //temporal
    void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questions.setText("[1] El tiempo de duración del préstamo dura por defecto una hora. Si desea especificar el tiempo\nde duración de su solicitud, ingrese el número de minutos que necesita para usar el computador.\n\n" + 
                "[2] En la sección SOLICITUDES podra ver los computadores préstados y las solicitudes hechas con\nantelación. Allí podrá realizar su devolución o cancelación previa.\n\n" + 
                "[3] En la sección SOLICITAR UN PRÉSTAMO podrá seleccionar el software que necesita para la\nrealización de su tarea. Al dar click sobre \"Buscar computadores\" se buscarán todos los equipos\nque cuenten con su selección. Si da click sobre el botón \"Solicitar préstamo\", el equipo se\nasignará a su usuario por el tiempo especificado.");
    }    
    
}
