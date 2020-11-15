/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarInformacionComputadores;
import Entidad.Computador;
import Entidad.Edificio;
import Entidad.Programa;
import Entidad.Sala;
import Entidad.Solicitud;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import jdk.nashorn.internal.runtime.JSType;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class ConcurrenceController implements Initializable {

    @FXML
    private TextField searchProgramTF;

    @FXML
    private Button loupeB;

    @FXML
    private TableView<ConcurrenceRow> table;

    @FXML
    private Label advertenciaLB;

    @FXML
    private ProgressBar progressBar;

    @FXML
    void loupeBtnAction(ActionEvent event) {
        advertenciaLB.setVisible(false);
        computerList.clear();
//        if(searchProgramTF.getText().length() != 0){
//            if (JSType.isNumber(searchProgramTF.getText())) {
//                for (Computador computador : computerList) {
//                    String numeroBusqueda = String.valueOf(searchProgramTF.getText());
//                    String numeroComputador = String.valueOf(computador.getId());
//                    String numeroSala = String.valueOf(computador.getSala().getCodigo());
//                    String nombreEdificio = String.valueOf(computador.getSala().getEdificio().getNombre());
//                    for (int i = 0; i < numeroBusqueda.length(); i++) {
//                        if(numeroBusqueda.charAt(i)== numeroComputador.charAt(i) || numeroBusqueda.charAt(i)== numeroSala.charAt(i) || nombreEdificio.charAt(i)== numeroBusqueda.charAt(i)){
//                            computerList.add(computador);
//                        }else{
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//
//        if(computerList.size() != 0){
//            table.setItems(computerList);
//        }else{
//            advertenciaLB.setText("No se encontraron resultados");
//            advertenciaLB.setVisible(true);
//        }

    }
    
    static Computador selectcomputador = new Computador();

    public static Computador getSelectcomputador() {
        return selectcomputador;
    }
    
    MostrarInformacionComputadores MIC = new MostrarInformacionComputadores();
    private ObservableList<ConcurrenceRow> computerList = FXCollections.observableArrayList();

    void insertcomputers(){
        TableColumn teamIdCol = new TableColumn("Id");
        teamIdCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdCol.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));

        TableColumn teamUsuarioCol = new TableColumn("Usuario");
        teamUsuarioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamUsuarioCol.setCellValueFactory(new PropertyValueFactory("idUsuario"));

        TableColumn teamEdificioCol = new TableColumn("Edificio");
        teamEdificioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamEdificioCol.setCellValueFactory(new PropertyValueFactory("codigoEdificio"));

        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setStyle( "-fx-alignment: CENTER;"); 
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("codigoSala"));

        TableColumn teamDisponibilidadCol = new TableColumn("Disponibilidad");
        teamDisponibilidadCol.setStyle( "-fx-alignment: CENTER;"); 
        teamDisponibilidadCol.setCellValueFactory(new PropertyValueFactory("disponibilidad"));
        
        TableColumn teamInfoCompCol = new TableColumn("Mas Información");
        teamInfoCompCol.setStyle( "-fx-alignment: CENTER;");  
        teamInfoCompCol.setCellValueFactory(new PropertyValueFactory("botonInfo"));

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(teamIdCol, teamUsuarioCol, teamEdificioCol, teamSalaCol, teamDisponibilidadCol, teamInfoCompCol);
        table.setItems(computerList);
        
        ArrayList<String[]> availableComputersInfo = MIC.getConcurrenceInfo();
        if(availableComputersInfo.size() != 0){
            advertenciaLB.setText("");
        }else{
            advertenciaLB.setText("No se encontraron resultados");
        }
        availableComputersInfo.forEach(computer -> {
            System.out.println(computer[0] + "" + computer[1] + "" + computer[2] + "" + computer[3] + "" + computer[4]);
            ConcurrenceRow temp = new ConcurrenceRow(computer[0], computer[1], computer[2], computer[3], computer[4]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });

        table.refresh();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        advertenciaLB.setVisible(false);
        loupeB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/loupe.png"))));
        insertcomputers();
        progressBar.setProgress(MIC.getConcurrencePercentage());
        
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    selectcomputador.setId(Integer.parseInt(table.getSelectionModel().getSelectedItem().getIdEquipo()));
                }
            }
        });



    }

}