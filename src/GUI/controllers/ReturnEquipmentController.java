/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarDevolucion;
import Entidad.Computador;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class ReturnEquipmentController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();
    
    private ObservableList<SolicitudRow> solicitudesList = FXCollections.observableArrayList();

    @FXML
    private Button aceptarBtn;

    @FXML
    private TableView<SolicitudRow> solicitudesTable;
    
    @FXML
    void exitReturnBtnAction(ActionEvent event) {
        Stage stage = (Stage) aceptarBtn.getScene().getWindow();
        stage.close();
    }

    /*
    @FXML
    void returnEquipmentBtnAction(ActionEvent event) throws IOException {
        Computador computador = new Computador();
        computador.setId(Integer.parseInt(cargarDatos.getDatosEquipos().get(0)[1]));
        if (RD.makeReturn(cargarDatos.getUser(), computador, cargarDatos.isActivo())) {
            System.out.println("Se realizo la devolucion!");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cargarDatos.cargar(cargarDatos.getUser());
                }
            }).start();
            Stage stage = (Stage) returnEquipmentBtn.getScene().getWindow();
            stage.close();
        } else {
            //stateText.setText("Fallo en la devolucion");
        }
    }
    */

    void insertSolicitudes(){

        TableColumn teamIdSolicitudCol = new TableColumn("Solicitud");
        teamIdSolicitudCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdSolicitudCol.setCellValueFactory(new PropertyValueFactory<>("idSolicitud"));
        
        TableColumn teamIdEquipoCol = new TableColumn("Equipo");
        teamIdEquipoCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdEquipoCol.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));

        TableColumn teamNombreEdificioCol = new TableColumn("Edificio");
        teamNombreEdificioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamNombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));

        TableColumn teamIdEdificioCol = new TableColumn("Edificio");
        teamIdEdificioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdEdificioCol.setCellValueFactory(new PropertyValueFactory("idEdificio"));

        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setStyle( "-fx-alignment: CENTER;"); 
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("codigoSala"));

        TableColumn teamFechaInicioCol = new TableColumn("Fecha inicio");
        teamFechaInicioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamFechaInicioCol.setCellValueFactory(new PropertyValueFactory("FechaInicio"));
        
        TableColumn teamFechaFinCol = new TableColumn("Fecha fin");
        teamFechaFinCol.setStyle( "-fx-alignment: CENTER;"); 
        teamFechaFinCol.setCellValueFactory(new PropertyValueFactory("FechaFin"));
        
        TableColumn teamInfoCompCol = new TableColumn("Mas Información");
        teamInfoCompCol.setStyle( "-fx-alignment: CENTER;");  
        teamInfoCompCol.setCellValueFactory(new PropertyValueFactory("botonInfo"));

        solicitudesTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        solicitudesTable.getColumns().addAll(teamIdSolicitudCol, teamIdEquipoCol, teamNombreEdificioCol, teamIdEdificioCol, teamSalaCol, teamFechaInicioCol, teamFechaFinCol, teamInfoCompCol);
        solicitudesTable.setItems(solicitudesList);
        
        ArrayList<String[]> availableComputersInfo = cargarDatosUsuario.getDatosSolicitudes();
        availableComputersInfo.forEach(computer -> {
            System.out.println(computer[0] + "" + computer[1] + "" + computer[2] + "" + computer[3] + "" + computer[4] + "" + computer[5]+ "" + computer[6]);
            SolicitudRow temp = new SolicitudRow(computer[0], computer[1], computer[2], computer[3], computer[4], computer[5], computer[6]);
            if (!solicitudesList.contains(temp)) {
                solicitudesList.add(temp);
            }
        });

        solicitudesTable.refresh();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertSolicitudes();
    }

}
