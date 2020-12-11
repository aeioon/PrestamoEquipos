/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.ManageSoftware;
import Entidad.Programa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class AddProgramController implements Initializable {

    ManageSoftware MS = new ManageSoftware();

    @FXML private TextField programNameTF;

    @FXML private TextField programVersionTF;
    
    @FXML private Button createProgramBtn;
    
    @FXML private Label nameTFWarning;

    @FXML private Label versionTFWarning;

    @FXML
    void createProgramBtnAction(ActionEvent event) {
        //Si los TF estan vacios no se hace nada, manda notificacion.
        if (programNameTF.getText().length() != 0 && programVersionTF.getText().length() != 0) {
            Programa programa = new Programa();
            programa.setNombre(programNameTF.getText());
            programa.setVersion(programVersionTF.getText());
            if(MS.crear(programa)){
                Stage stage = (Stage) createProgramBtn.getScene().getWindow(); 
                stage.close();
            }
          

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        programNameTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    nameTFWarning.setVisible(false);
                } else {
                    nameTFWarning.setVisible(false);
                    if (programNameTF.getText().length() != 0) {
                        nameTFWarning.setVisible(false);
                    } else {
                        nameTFWarning.setText("No se ha ingresado un nombre");
                        nameTFWarning.setVisible(true);
                    }
                }
            }
        });

        programVersionTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    versionTFWarning.setVisible(false);
                } else {
                    versionTFWarning.setVisible(false);
                    if (String.valueOf(programVersionTF.getText()).length() == 0) {
                        versionTFWarning.setText("No se ha ingresado una version");
                        versionTFWarning.setVisible(true);
                    } else {
                        versionTFWarning.setVisible(false);
                    }
                }
            }
        });
    }

}
