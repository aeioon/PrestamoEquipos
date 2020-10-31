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
        
    int idSelected;
    
    @FXML
    private Text message;

    @FXML
    void cancelRequestBtnAction(ActionEvent event) {
        RealizarDevolucion RD = new RealizarDevolucion();
        if(RD.makeReturn(u)){
            System.out.println("Se realizo la devolucion!");
            Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
            stage.close();
        } else {
            message.setText("Fallo devolucion");
        }
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
    void printData(){
        System.out.println("Id de usuario es "+u.getId()+" del computador es "+c.getId()+ " Lista de programas ");
        p.forEach(program-> {
            System.out.println(program.getNombre());
        });
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        printData();
    }

}
