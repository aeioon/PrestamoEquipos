package GUI.controllers;

import Control.ComputadorController;
import Control.ProgramaController;
import DAO.ComputadorDAO;
import Entidad.Computador;
import Entidad.Programa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */

public class StudentHomeController  implements Initializable{
    
    //temporal
    void changeScene(ActionEvent event, String fxml) throws IOException{
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private Button userInfoBtn;

    @FXML
    private Button requestLoanBtn;

    @FXML
    private Button returnEquiBtn;

    @FXML
    void requestLoanBtnAction(ActionEvent event) throws IOException {
        changeScene(event, "/GUI/views/loanRequest.fxml");
    }

    @FXML
    void returnEquiBtnAction(ActionEvent event) {
        
    }

    @FXML
    void userInfoBtnAction(ActionEvent event) throws IOException {
        changeScene(event, "/GUI/views/login.fxml");   
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
