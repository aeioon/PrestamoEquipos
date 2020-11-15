package GUI.controllers;

import Control.CargarDatosAdministrador;
import Control.CargarDatosUsuario;
import Control.ValidarLogin;
import Entidad.Encargado;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class LoginController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    CargarDatosAdministrador cargarDatosAdministrador = CargarDatosAdministrador.getInstance();

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Text logoAppLogin;

    @FXML
    private TextField userLoginTF;

    @FXML
    private Label AdvertenciausLB;

    @FXML
    private Label AdvertenciapLB;

    @FXML
    private Label userLogoLB;

    @FXML
    private Label lockLogoLB;

    @FXML
    private PasswordField passwordLoginTF;

    @FXML
    private Button loginBtn;

    @FXML
    private Pane panelLogin;

    @FXML
    private Label escudolb;

    @FXML
    void loginBtnAction(ActionEvent event) throws IOException {
        if (AdvertenciapLB.isVisible() == false && AdvertenciausLB.isVisible() == false) {
            ValidarLogin validar = new ValidarLogin();
            Usuario usuario = new Usuario();
            usuario.setId(userLoginTF.getText());
            usuario.setContraseña(passwordLoginTF.getText());
            if (validar.verificarUsuario(usuario)) {
                cargarDatosUsuario.cargar(usuario);
                cargarDatosUsuario.cargarUsuario(usuario);
                Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
                Scene newScene = new Scene(newParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(newScene);
                window.show();
            } else {
                Encargado encargado = new Encargado();
                encargado.setId(userLoginTF.getText());
                encargado.setContraseña(passwordLoginTF.getText());
                if (validar.verificarAdministrador(encargado)) {
                    cargarDatosAdministrador.cargar(encargado);
                    Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/adminHome.fxml"));
                    Scene newScene = new Scene(newParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(newScene);
                    window.show();
                }
                AdvertenciapLB.setText("El usuario y la contraseña no coinciden");
                AdvertenciapLB.setVisible(true);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AdvertenciapLB.setVisible(false);
        AdvertenciausLB.setVisible(false);
        userLoginTF.requestFocus();

        AdvertenciapLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/alert.png"))));
        AdvertenciausLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/alert.png"))));
        escudolb.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Escudo_color.png"))));
        userLogoLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/user.png"))));
        lockLogoLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/lock.png"))));

        userLoginTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    System.out.println("Textfield on focus");
                    AdvertenciausLB.setVisible(false);
                } else {
                    System.out.println("Textfield out focus");
                    AdvertenciapLB.setVisible(false);
                    if (userLoginTF.getText().length() != 0) {
                        AdvertenciausLB.setVisible(false);
                        System.out.println(userLoginTF.getText());
                    } else {
                        System.out.println("no hay usuario");
                        AdvertenciausLB.setText("No se ha ingresado un usuario");
                        AdvertenciausLB.setVisible(true);
                    }
                }
            }
        });

        passwordLoginTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    System.out.println("Textfield on focus");
                    AdvertenciapLB.setVisible(false);
                } else {
                    System.out.println("Textfield out focus");
                    AdvertenciapLB.setVisible(false);
                    if (String.valueOf(passwordLoginTF.getText()).length() == 0) {
                        System.out.println("no hay contraseña");
                        AdvertenciapLB.setText("No se ha ingresado una contraseña");
                        AdvertenciapLB.setVisible(true);
                    } else {
                        AdvertenciapLB.setVisible(false);
                    }
                }
            }
        });
    }
}
