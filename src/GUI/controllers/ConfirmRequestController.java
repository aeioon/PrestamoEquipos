package GUI.controllers;

import Control.RealizarDevolucion;
import Control.RealizarPrestamo;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */

public class ConfirmRequestController implements Initializable {

    @FXML private Button cancelRequestBtn;
    @FXML private Button loanBtn;
    
    LoanDataHolder loanHolder = LoanDataHolder.getInstance();
    Usuario u = SessionHolder.getInstance().getUser();
    Computador c = loanHolder.getComputer();
    ArrayList<Programa> p = loanHolder.getPrograms();
    ComputerRow pr = loanHolder.getRow();
        
    int idSelected;
    
    @FXML
    private Text message;
    
    @FXML
    private Text computerText;

    @FXML
    void cancelRequestBtnAction(ActionEvent event) {
        Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void loanBtnAction(ActionEvent event) {
        RealizarPrestamo RP = new RealizarPrestamo();
        if(RP.makeBorrow(u, c, p)){
            System.out.println("Se realizo el prestamo!");
            Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
            stage.close();
        } else {
            message.setText("Fallo el prestamo");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        computerText.setText("Computador #"+ pr.getId()+" en el edificio "+pr.getNombreEdificio()+" con ID "+pr.getIdEdificio()+" en la sala "+pr.getNombreSala());
    }

}
