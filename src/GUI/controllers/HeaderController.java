/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosUsuario;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class HeaderController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();

    @FXML
    private Rectangle userBox;

    @FXML
    private Text nombreEstudianteT;

    @FXML
    private Text correoEstudianteT;

    @FXML
    private Label formatoIngenieriaL;

    @FXML
    private Button logoutBtn;

    @FXML
    void logoutBtnAction(ActionEvent event) throws IOException {
        //Cerrar sesion.
        cargarDatosUsuario.resetData();
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/login.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //nombreEstudianteT.setText(Main.getUsuarioLogueado().getNombres() + " " + Main.getUsuarioLogueado().getApellidos());
        //correoEstudianteT.setText(Main.getUsuarioLogueado().getId() + "@unal.edu.co");
        formatoIngenieriaL.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Logo_n.png"))));
        //Luego con getNombres();
        if (cargarDatosUsuario.isCarga()) {
            nombreEstudianteT.setText(cargarDatosUsuario.getUser().getNombres() + " " + cargarDatosUsuario.getUser().getApellidos());
            correoEstudianteT.setText(cargarDatosUsuario.getUser().getId() + "@unal.edu.co");
        }
    }

}
