package prestamoequipos.GUI.controllers;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class LoginController implements Initializable {

    
    @FXML
    private Text welcomeText;

    @FXML
    private TextField passwordLoginTF;

    @FXML
    private TextField userLoginTF;

    @FXML
    private Button loginBtn;

    @FXML
    void loginBtnAction(ActionEvent event) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource("../views/studentHome.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
