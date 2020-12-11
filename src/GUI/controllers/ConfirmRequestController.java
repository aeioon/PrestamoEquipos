package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarPrestamo;
import Entidad.Computador;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class ConfirmRequestController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    Computador computador = new Computador();
    RealizarPrestamo RP = new RealizarPrestamo();

    private static boolean prestamo = false;

    @FXML
    private Button cancelRequestBtn;
    @FXML
    private Button loanBtn;
    @FXML
    private Text message;
    @FXML
    private Text computerText;

    @FXML
    void loanBtnAction(ActionEvent event) throws IOException {
        if (RP.makeBorrow(cargarDatosUsuario.getUser(), computador, SoftwareSelectedController.getSelectedProgramArr(), LocalDateTime.now(), LocalDateTime.now().plusMinutes(SoftwareSelectedController.getDuracion()))) {
            prestamo = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cargarDatosUsuario.cargar(cargarDatosUsuario.getUser());
                }
            }).start();
            Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
            stage.close();
        } else {
            message.setText("Fallo el prestamo");
            computerText.setText("     El computador se encuentra ocupado");
        }
    }

    @FXML
    void cancelRequestBtnAction(ActionEvent event) {
        Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        computerText.setText("Computador #" + ComputerAvailableController.getSelectedComputer()[0]
                + " en el edificio " + ComputerAvailableController.getSelectedComputer()[1]
                + " " + ComputerAvailableController.getSelectedComputer()[2]
                + " de la sala " + ComputerAvailableController.getSelectedComputer()[3]);
        computador.setId(Integer.parseInt(ComputerAvailableController.getSelectedComputer()[0]));
    }

    public static boolean isPrestamo() {
        return prestamo;
    }

    public static void setPrestamo(boolean prestamo) {
        ConfirmRequestController.prestamo = prestamo;
    }
}
