package GUI.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */

public class ConfirmRequestController implements Initializable {

    @FXML private Button cancelRequestBtn;
    @FXML private Button loanBtn;
    
    
    int idSelected;

    @FXML
    void cancelRequestBtnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        idSelected =  (int) stage.getUserData();
        System.out.println("El computador seleccionado es "+idSelected);
    }
    
    @FXML
    void receiveData(MouseEvent event) {
       
    }

    @FXML
    void loanBtnAction(ActionEvent event) {
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
