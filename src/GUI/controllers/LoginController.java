package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.ValidarLogin;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyEvent;
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
    private Button registroBtn;
      
    @FXML
    void registroBtnAction(ActionEvent event) throws IOException {
        Parent newParent;
        newParent = FXMLLoader.load(getClass().getResource("/GUI/views/register.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void loginBtnAction(ActionEvent event) throws IOException {
        if (AdvertenciapLB.isVisible() == false && AdvertenciausLB.isVisible() == false) {
            ValidarLogin validar = new ValidarLogin();
            Usuario usuario = new Usuario();
            usuario.setId(userLoginTF.getText());
            usuario.setContraseña(passwordLoginTF.getText());
            usuario = validar.verificarUsuario(usuario);
            if (usuario != null) {
                Parent newParent;
                if (usuario.getRol() ==0 ){
                    cargarDatosUsuario.cargar(usuario);
                    cargarDatosUsuario.setUser(usuario);
                    newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
                    
                } else{
                    cargarDatosUsuario.setCarga(true);
                    cargarDatosUsuario.setUser(usuario);
                    newParent = FXMLLoader.load(getClass().getResource("/GUI/views/adminHome.fxml"));
                }
                Scene newScene = new Scene(newParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(newScene);
                window.show();
            } else {
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
        registroBtn.setDisable(false);

        AdvertenciapLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/alert.png"))));
        AdvertenciausLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/alert.png"))));
        escudolb.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Escudo_color.png"))));
        userLogoLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/user.png"))));
        lockLogoLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/lock.png"))));

        userLoginTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    AdvertenciausLB.setVisible(false);
                } else {
                    AdvertenciapLB.setVisible(false);
                    if (userLoginTF.getText().length() != 0) {
                        AdvertenciausLB.setVisible(false);
                    } else {
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
                    AdvertenciapLB.setVisible(false);
                } else {
                    AdvertenciapLB.setVisible(false);
                    if (String.valueOf(passwordLoginTF.getText()).length() == 0) {
                        AdvertenciapLB.setText("No se ha ingresado una contraseña");
                        AdvertenciapLB.setVisible(true);
                    } else {
                        AdvertenciapLB.setVisible(false);
                    }
                }
            }
        });
        userLoginTF.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation());
    }
    
    
    public EventHandler<KeyEvent> letter_Validation() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (!Character.isAlphabetic(e.getCharacter().charAt(0)) && !Character.isSpaceChar(e.getCharacter().charAt(0))) {
                    e.consume();
                }
            }
        };
    }
    
}
