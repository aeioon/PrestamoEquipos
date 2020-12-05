package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarDevolucion;
import Control.RealizarPrestamo;
import Entidad.Computador;
import Entidad.Programa;
import Entidad.Solicitud;
import Entidad.Usuario;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Solicitud solicitud = new Solicitud();
    Computador computador = new Computador();

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
        cargarDatos.getDatosEquipos().remove(cargarDatos.getDatosEquipos().size() - 1);
        Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void loanBtnAction(ActionEvent event) {
        RealizarPrestamo RP = new RealizarPrestamo();
        solicitud = LoanRequestController.getSolicitud();
        System.out.println("ESTA LIBRE: " + RP.computerIsFree(computador));
        if (RP.computerIsFree(computador)) {
            if (RP.makeBorrow(solicitud, computador)) {
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        computerText.setText("Computador #" + LoanRequestController.getSelectedComputer()[0]
                + " en el edificio " + LoanRequestController.getSelectedComputer()[1]
                + " " + LoanRequestController.getSelectedComputer()[2]
                + " de la sala " + LoanRequestController.getSelectedComputer()[3]);
        computador.setId(Integer.parseInt(LoanRequestController.getSelectedComputer()[0]));
    }
}
