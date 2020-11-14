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

    @FXML
    private TextField programNameTF;

    @FXML
    private Button createProgramBtn;

    @FXML
    private TextField programVersionTF;

    @FXML
    void createProgramBtnAction(ActionEvent event) {
        Programa programa = new Programa();
        programa.setNombre(programNameTF.getText());
        programa.setVersion(programVersionTF.getText());
        //if (AdvertenciapLB.isVisible() == false && AdvertenciausLB.isVisible() == false) {
            MS.crear(programa);
        //}
        Stage stage = (Stage) createProgramBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        programNameTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    System.out.println("Textfield on focus");
                    //AdvertenciausLB.setVisible(false);
                } else {
                    System.out.println("Textfield out focus");
                    //AdvertenciapLB.setVisible(false);
                    if (programNameTF.getText().length() != 0) {
                        //AdvertenciausLB.setVisible(false);
                        System.out.println(programNameTF.getText());
                    } else {
                        System.out.println("no hay usuario");
                        //AdvertenciausLB.setText("No se ha ingresado un usuario");
                        //AdvertenciausLB.setVisible(true);
                    }
                }
            }
        });

        programVersionTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    System.out.println("Textfield on focus");
                    //AdvertenciapLB.setVisible(false);
                } else {
                    System.out.println("Textfield out focus");
                    //AdvertenciapLB.setVisible(false);
                    if (String.valueOf(programVersionTF.getText()).length() == 0) {
                        System.out.println("no hay contraseña");
                        //AdvertenciapLB.setText("No se ha ingresado una contraseña");
                        //AdvertenciapLB.setVisible(true);
                    } else {
                        //AdvertenciapLB.setVisible(false);
                    }
                }
            }
        });
    }

}
