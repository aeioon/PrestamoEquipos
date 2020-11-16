package GUI.controllers;

import Control.CargarDatosUsuario;
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

    CargarDatosUsuario cargarDatos = CargarDatosUsuario.getInstance();
    
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
        cargarDatos.getDatosEquipos().remove(cargarDatos.getDatosEquipos().size()-1);
        Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void loanBtnAction(ActionEvent event) {
        RealizarPrestamo RP = new RealizarPrestamo();
        Computador comp = new Computador();
        comp.setId(Integer.parseInt(cargarDatos.getDatosEquipos().get(cargarDatos.getDatosEquipos().size()-1)[1]));
        
        if (RP.makeBorrow(cargarDatos.getUser(), comp, cargarDatos.getPrograms(),LoanRequestController.getFechaInicio(), LoanRequestController.getFechaFinal())) {
            System.out.println("Se realizo el prestamo!");
            cargarDatos.setActivo(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cargarDatos.cargar(cargarDatos.getUser());
                }
            }).start();
            Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
            stage.close();
        } else {
            message.setText("Fallo el prestamo");
            computerText.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        computerText.setText("Computador #" + cargarDatos.getDatosEquipos().get(cargarDatos.getDatosEquipos().size()-1)[1]
                + " en el edificio " + cargarDatos.getDatosEquipos().get(cargarDatos.getDatosEquipos().size()-1)[2]
                + " " + cargarDatos.getDatosEquipos().get(cargarDatos.getDatosEquipos().size()-1)[3]
                + " de la sala " + cargarDatos.getDatosEquipos().get(cargarDatos.getDatosEquipos().size()-1)[4]);
    }

}
