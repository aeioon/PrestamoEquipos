/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriela
 */
public class RegisterController implements Initializable {

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Pane panelLogin;

    @FXML
    private Label escudoLB;

    @FXML
    private Text logoAppLogin;

    @FXML
    private PasswordField passwordPTFLD;

    @FXML
    private PasswordField passwordRePTFLD;

    @FXML
    private ChoiceBox<String> facultadCB;

    @FXML
    private ChoiceBox<String> carreraCB;

    @FXML
    private TextField nombresTFD;

    @FXML
    private TextField apellidosTFD;

    @FXML
    private TextField usuarioTFD;

    @FXML
    private Button baskToLoginBtn;

    @FXML
    private Button registrarseBtn;

    @FXML
    private Label alertContraseñaLB;

    @FXML
    private Label alertGeneralLB;

    @FXML
    void baskToLoginBtnAction(ActionEvent event) {

    }

    @FXML
    void registrarseBtnAction(ActionEvent event) throws IOException {
        Parent newParent;
        newParent = FXMLLoader.load(getClass().getResource("/GUI/views/login.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    @FXML
    void facultadEsgogidaBTN(ContextMenuEvent event) {
        if(facultadCB.getValue().equals("")){
            
        }
        carreraCB.getItems().addAll("ahhah","dewhi");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertContraseñaLB.setVisible(false);
        alertGeneralLB.setVisible(false);
        escudoLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Escudo_Color.png")))); 
        facultadCB.getItems().addAll("Facultad de Artes",
                            "Facultad de Ciencias",
                            "Facultad de Ciencias Agrarias",
                            "Facultad de Ciencias Económicas",
                            "Facultad de Ciencias Humanas",
                            "Facultad de Derecho, Ciencias Políticas y Sociales",
                            "Facultad de Enfermería",
                            "Facultad de Ingeniería",
                            "Facultad de Medicina",
                            "Facultad de Medicina Veterinaria y de Zootecnia",
                            "Facultad de Odontología");
        ObservableList<String> list= FXCollections.observableArrayList();
        facultadCB.setItems(list);
    }    
    
}
