package GUI.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AdminHomeController implements Initializable {

    boolean oprimido = true;

    @FXML
    private Button concurrenceB;
    @FXML
    private Button managementB;
    @FXML
    private Button reportB;
    @FXML
    private Button flechaB;
    @FXML
    private Button deSoftwareB;
    @FXML
    private Button historialB;
    @FXML
    private Pane principalPane;
    
    @FXML
    void concurrenceBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();
        Pane newParent = (Pane) FXMLLoader.load(getClass().getResource("/GUI/views/concurrence.fxml"));
        principalPane.getChildren().add(newParent);
        concurrenceB.setStyle("-fx-background-color:    #565a5c" + "; -fx-radius: 0;");
        managementB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0;");
        flechaB.setStyle("-fx-background-color:   #696969");
        reportB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0;");
        flechaB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/flecha-correcta.png"))));
        oprimido = true;
        deSoftwareB.setVisible(!oprimido);
        historialB.setVisible(!oprimido);
    }

    @FXML
    void managementBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();
        Pane newParent = (Pane) FXMLLoader.load(getClass().getResource("/GUI/views/softwareManagement.fxml"));
        principalPane.getChildren().add(newParent);
        managementB.setStyle("-fx-background-color:    #565a5c"+ "; -fx-radius: 0;");
        concurrenceB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0;");
        reportB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0;");
        flechaB.setStyle("-fx-background-color:   #696969;");
        flechaB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/flecha-correcta.png"))));
        oprimido = true;
        deSoftwareB.setVisible(!oprimido);
        historialB.setVisible(!oprimido);
    }
    
    @FXML
    void reportBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();        
        managementB.setStyle("-fx-background-color:    #696969"+ "; -fx-radius: 0");
        concurrenceB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0");
        reportB.setStyle("-fx-background-color:   #565a5c"+ "; -fx-radius: 0");
        flechaB.setStyle("-fx-background-color:   #565a5c");
        if(oprimido){
            flechaB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/flecha-invertida.png"))));
            deSoftwareB.setVisible(true);
            historialB.setVisible(true);
            oprimido = false;
        }else{
            flechaB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/flecha-correcta.png"))));
            oprimido = true;
            deSoftwareB.setVisible(false);
            historialB.setVisible(false);
        }
    }
    
    @FXML
    void historialBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();
        Pane newParent = (Pane) FXMLLoader.load(getClass().getResource("/GUI/views/history.fxml"));
        principalPane.getChildren().add(newParent);
        
        managementB.setStyle("-fx-background-color:    #696969"+ "; -fx-radius: 0");
        concurrenceB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0");
        reportB.setStyle("-fx-background-color:   #565a5c"+ "; -fx-radius: 0");
        flechaB.setStyle("-fx-background-color:   #565a5c");
    }
    
    @FXML
    void deSoftwareBBtnAction(ActionEvent event) throws IOException {
        principalPane.getChildren().clear();
        Pane newParent = (Pane) FXMLLoader.load(getClass().getResource("/GUI/views/allRequestStatistics.fxml"));
        principalPane.getChildren().add(newParent);
        
        managementB.setStyle("-fx-background-color:    #696969"+ "; -fx-radius: 0");
        concurrenceB.setStyle("-fx-background-color:   #696969"+ "; -fx-radius: 0");
        reportB.setStyle("-fx-background-color:   #565a5c"+ "; -fx-radius: 0");
        flechaB.setStyle("-fx-background-color:   #565a5c");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deSoftwareB.setVisible(!oprimido);
        historialB.setVisible(!oprimido);
        flechaB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/flecha-correcta.png"))));
        try {
            principalPane.getChildren().clear();
            Pane newParent = (Pane) FXMLLoader.load(getClass().getResource("/GUI/views/concurrence.fxml"));
            principalPane.getChildren().add(newParent);
        } catch (IOException ex) {
            Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
