/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriela
 */
public class ConfirmRegistrationController implements Initializable {
    
    static private boolean creado;
    private Usuario usuario;
    private UsuarioDAO uDao = new UsuarioDAO();

    public static boolean isCreado() {
        return creado;
    }

    public static void setCreado(boolean creado) {
        ConfirmRegistrationController.creado = creado;
    }   
    
    
    @FXML
    private Button cancelRequestBtn;

    @FXML
    private Button continueBtn;

    @FXML
    private Text message;

    @FXML
    private Text computerText;

    @FXML
    void cancelRequestBtnAction(ActionEvent event) {
        creado = false;
        Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void continueBtnAction(ActionEvent event) {
        if (uDao.crear(usuario)){
            creado=true;
        } else{
            creado = false;
        }
        Stage stage = (Stage) cancelRequestBtn.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuario = RegisterController.getUsuario();
        message.setText(message.getText().concat(usuario.getId())+ "?");
    }    
    
}
