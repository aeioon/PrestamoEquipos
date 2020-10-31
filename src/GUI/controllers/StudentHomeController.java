package GUI.controllers;

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

public class StudentHomeController  implements Initializable{
    
    
    SessionHolder sessionHolder = SessionHolder.getInstance();
    
    //temporal
    void changeScene(ActionEvent event, String fxml) throws IOException{
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        changeScene(event, "/GUI/views/loanRequest.fxml");
    }

    @FXML
    void returnEquiBtnAction(ActionEvent event) {
        /*
        * data para test
        * se testea con el usuario de id 1
        * se instancia un computador con la id del computador seleccinoado
        * se instancia una lista de programas con los seleccionados
        * se envian a las demas vistos por medio de un singleton LoanDataHolder.
         */
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/returnEquipment.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 390, 272);
            Stage stagePop = new Stage();
            stagePop.setTitle("Confirmar devolucion");
            stagePop.setScene(scene);
            stagePop.showAndWait();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }
    
    @FXML
    void faqBtnAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        escudoBlanco.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/escudonNombre.png"))));
        welcomeUserText.setText("¡Hola "+sessionHolder.getUser().getId()+"!");
    }

}
