/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarInformacionComputadores;
import Entidad.Computador;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class EquipmentInformationController implements Initializable {
    
    Computador computador = new Computador();
    MostrarInformacionComputadores MIC = new MostrarInformacionComputadores();

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
    private Text disponibilidadTX;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        computador = ConcurrenceController.getSelectcomputador();
        //ArrayList<String[]> datos = MIC.getHoleComputerInfo(computador);       
    }    
    
}

