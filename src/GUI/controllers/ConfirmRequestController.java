package GUI.controllers;

import Control.CargarDatos;
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

    CargarDatos cargarDatos = CargarDatos.getInstance();
    
    LoanDataHolder loanHolder = LoanDataHolder.getInstance();
    Computador c = loanHolder.getComputer();
    ArrayList<Programa> p = loanHolder.getPrograms();
    ComputerRow pr = loanHolder.getRow();
    @FXML 
    private Button cancelRequestBtn;
    
    @FXML 
    private Button loanBtn;
    
        
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
        if(RP.makeBorrow(cargarDatos.getUser(), c, p)){
            System.out.println("Se realizo el prestamo!");
            cargarDatos.setActivo(true);
            Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
            stage.close();
        } else {
            message.setText("Fallo el prestamo");
            computerText.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        computerText.setText("Computador #"+ cargarDatos.getInfoIdEquipo()+" en el edificio "+cargarDatos.getInfoIdEdificio()+" "+cargarDatos.getInfoNombreEdificio()+" de la sala "+cargarDatos.getInfoCodigoSala());
    }

}
