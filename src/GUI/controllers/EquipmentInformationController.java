/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarConcurrencia;
import Control.RealizarDevolucion;
import Entidad.Computador;
import java.net.URL;
import java.util.ArrayList;
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
 * @author angel
 */
public class EquipmentInformationController implements Initializable {
    
    Computador computador = new Computador();
    MostrarConcurrencia MIC = new MostrarConcurrencia();

    @FXML
    private Text IDEquipoTX;
    @FXML
    private Text edifioTX;
    @FXML
    private Text salaTX;
    @FXML
    private Text softwareTX;
    @FXML
    private Text hardwareTX;
    @FXML
    private Text encargadoNombreTX;
    @FXML
    private Text encargadoUsuarioTX;
    @FXML
    private Text usuarioTX;
    @FXML
    private Button returnComputer;

    @FXML
    void returnComputerAction(ActionEvent event) {
        RealizarDevolucion RD = new RealizarDevolucion();
        RD.makeReturn(computador, true);
        Stage stage = (Stage) returnComputer.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        computador = ConcurrenceRow.getSelectcomputador();
        String[] datos = MIC.getWholeComputerInfo(computador); 
        ArrayList<String> software = MIC.getComputerPrograms(computador);
        
        String softwareText = "";
        
        IDEquipoTX.setText(datos[0]);
        usuarioTX.setText(datos[1]);
        edifioTX.setText(datos[2]);
        salaTX.setText(datos[3]);
        hardwareTX.setText(datos[5]);
        encargadoUsuarioTX.setText(" " + datos[6]+"@unal.edu.co");
        encargadoNombreTX.setText(datos[7] + " " + datos[8]);
        
        for (int i = 0; i < software.size(); i++) {
            softwareText = softwareText + software.get(i);
            if(i != software.size() - 1){
                softwareText = softwareText + ", ";
            }
        }
        softwareTX.setText(softwareText);
    }    
    
}

