package GUI.controllers;

import Control.CargarDatosUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class StudentHomeController implements Initializable {

    CargarDatosUsuario cargarDatos = CargarDatosUsuario.getInstance();


    @FXML
    private Button requestLoanBtn;

    @FXML
    private Button returnEquiBtn;

    @FXML
    private Label iconTest;

    @FXML
    private Button faqBtn;

    @FXML
    private Label escudoBlanco;

    @FXML
    private Text welcomeUserText;

    @FXML
    private Text currentComputerHomeText;

    @FXML
    void requestLoanBtnAction(ActionEvent event) throws IOException {
        try {
            changeScene(event, "/GUI/views/softwareSelected.fxml");
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public void cargarInformación() {
        Thread computerInfo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!cargarDatos.isCargaEquipos() || !cargarDatos.isCargarActividad() || !cargarDatos.isCargarUsuario()) {
                        Thread.sleep(500);
                    }
                    if (cargarDatos.isActivo()) {
                        String computadores = "Actualmente tiene asignado:\n\n";
                        for (int i = 0; i < cargarDatos.getDatosEquipos().size(); i++) {
                            computadores = computadores + "Computador #" + cargarDatos.getDatosEquipos().get(i)[1] + " en el edificio "
                                    + cargarDatos.getDatosEquipos().get(i)[2] + " " + cargarDatos.getDatosEquipos().get(i)[3] + ", Sala " + cargarDatos.getDatosEquipos().get(i)[4] + "\n";
                        }
                        currentComputerHomeText.setText(computadores);
                    } else {
                        currentComputerHomeText.setText("");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(StudentHomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        computerInfo.setDaemon(true);
        computerInfo.start();
    }

    @FXML
    void returnEquiBtnAction(ActionEvent event) {
        try {
            if (cargarDatos.isCargaEquipos()) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/views/returnEquipment.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 786, 321);
                Stage stagePop = new Stage();
                stagePop.setTitle("Solicitudes");
                stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/herramienta.png")));
                stagePop.setScene(scene);
                stagePop.showAndWait();

                cargarInformación();
            } else {
                System.out.println("pensando");
            }

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML
    void faqBtnAction(ActionEvent event) throws IOException {
        try {
            changeScene(event, "/GUI/views/frequentQuestions.fxml");
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        escudoBlanco.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/escudonNombre.png"))));
        welcomeUserText.setText("¡Hola " + cargarDatos.getUser().getId() + "!");

        cargarInformación();
    }

}
