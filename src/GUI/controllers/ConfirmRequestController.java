package GUI.controllers;

import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import java.net.URL;
import java.util.ArrayList;
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
        LoanDataHolder holder = LoanDataHolder.getInstance();
        Usuario u = holder.getUser();
        Computador c = holder.getComputer();
        ArrayList<Programa> p = holder.getPrograms();
        
        System.out.println("El usuariop es "+u.getNombres()+" el SO del computador es "+c.getSistemaOperativo()+ " Lista de programas "+p.toString());
    }
    
    @FXML
    void receiveData(MouseEvent event) {}

    @FXML
    void loanBtnAction(ActionEvent event) {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
