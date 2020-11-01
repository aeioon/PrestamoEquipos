package GUI.controllers;

import Control.CargarDatos;
import Control.RealizarPrestamo;
import Control.RealizarDevolucion;
import DAO.ComputadorDAO;
import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
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

    CargarDatos cargarDatos = CargarDatos.getInstance();

    //temporal
    void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

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
    void requestLoanBtnAction(ActionEvent event) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (!cargarDatos.isActivo()) {
                                changeScene(event, "/GUI/views/loanRequest.fxml");
                            } else {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("/GUI/views/noBorrow.fxml"));
                                Scene scene = new Scene(fxmlLoader.load(), 390, 210);
                                Stage stagePop = new Stage();
                                stagePop.setTitle("ERROR");
                                stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/error.png")));
                                stagePop.setScene(scene);
                                stagePop.showAndWait();
                            }
                        } catch (IOException e) {
                            System.err.println(String.format("Error: %s", e.getMessage()));
                        }
                    }
                });
            }
        }).start();
    }

    @FXML
    void returnEquiBtnAction(ActionEvent event) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (cargarDatos.isActivo()) {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("/GUI/views/returnEquipment.fxml"));
                                Scene scene = new Scene(fxmlLoader.load(), 390, 272);
                                Stage stagePop = new Stage();
                                stagePop.setTitle("Confirmar devolucion");
                                stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/herramienta.png")));
                                stagePop.setScene(scene);
                                stagePop.showAndWait();
                            } else {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("/GUI/views/noReturn.fxml"));
                                Scene scene = new Scene(fxmlLoader.load(), 390, 210);
                                Stage stagePop = new Stage();
                                stagePop.setTitle("Error");
                                stagePop.setScene(scene);
                                stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/error.png")));
                                stagePop.showAndWait();
                            }

                        } catch (IOException e) {
                            System.err.println(String.format("Error: %s", e.getMessage()));
                        }
                    }
                });
            }
        }).start();
    }

    @FXML
    void faqBtnAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        escudoBlanco.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/escudonNombre.png"))));
        welcomeUserText.setText("¡Hola " + cargarDatos.getUser().getId() + "!");
    }

}
