/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class HeaderController implements Initializable {

    
    @FXML
    private Rectangle userBox;

    @FXML
    private Text nombreEstudianteT;

    @FXML
    private Text correoEstudianteT;

    @FXML
    private Label formatoIngenieriaL;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreEstudianteT.setText(Main.getUsuarioLogueado().getNombres() + " " + Main.getUsuarioLogueado().getApellidos());
        correoEstudianteT.setText(Main.getUsuarioLogueado().getId() + "@unal.edu.co");
        formatoIngenieriaL.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Logo_n.png"))));
    }    
    
}
