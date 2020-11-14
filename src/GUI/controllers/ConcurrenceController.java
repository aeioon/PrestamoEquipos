/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

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
    private TableView<Computador> table;

    @FXML
    private Label advertenciaLB;

    @FXML
    private ProgressBar progressBar;

    @FXML
    void loupeBtnAction(ActionEvent event) {
        advertenciaLB.setVisible(false);
        computerList.clear();
        if(searchProgramTF.getText().length() != 0){
            if (JSType.isNumber(searchProgramTF.getText())) {
                for (Computador computador : computerList) {
                    String numeroBusqueda = String.valueOf(searchProgramTF.getText());
                    String numeroComputador = String.valueOf(computador.getId());
                    String numeroSala = String.valueOf(computador.getSala().getCodigo());
                    String nombreEdificio = String.valueOf(computador.getSala().getEdificio().getNombre());
                    for (int i = 0; i < numeroBusqueda.length(); i++) {
                        if(numeroBusqueda.charAt(i)== numeroComputador.charAt(i) || numeroBusqueda.charAt(i)== numeroSala.charAt(i) || nombreEdificio.charAt(i)== numeroBusqueda.charAt(i)){
                            computerList.add(computador);
                        }else{
                            return;
                        }
                    }
                }
            }
        }

        if(computerList.size() != 0){
            table.setItems(computerList);
        }else{
            advertenciaLB.setText("No se encontraron resultados");
            advertenciaLB.setVisible(true);
        }

    }

    private ObservableList<Computador> computerList = FXCollections.observableArrayList();

    void insertcomputers(){
        TableColumn teamIdCol = new TableColumn("Id");
        teamIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn teamUsuarioCol = new TableColumn("Usuario");
        teamUsuarioCol.setCellValueFactory(new PropertyValueFactory("idUsuario"));

        TableColumn teamEdificioCol = new TableColumn("Edificio");
        teamEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreSala"));

        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("codigoSala"));

        TableColumn teamDisponibilidadCol = new TableColumn("Disponibilidad");
        teamDisponibilidadCol.setCellValueFactory(new PropertyValueFactory("disponibilidad"));

        TableColumn teamInfo = new TableColumn("Mas infotmación");
        teamInfo.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
        Callback<TableColumn<Computador, String>, TableCell<Computador, String>> cellFactory = new Callback<TableColumn<Computador, String>, TableCell<Computador, String>>() {
            @Override
            public TableCell call(final TableColumn<Computador, String> param) {
                final TableCell<Computador, String> cell = new TableCell<Computador, String>() {

                    final Button btn = new Button("Disponible");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                try {
                                    Computador computador = getTableView().getItems().get(getIndex());
                                    Parent root = FXMLLoader.load(getClass().getResource("/GUI/views/equipmentInfo.fxml"));
                                    Scene scene = new Scene(root);
                                    Stage primaryStage = new Stage();
                                    primaryStage.setScene(scene);
                                    primaryStage.setTitle("Información del equipo");
                                    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
                                    primaryStage.show();
                                            } catch (IOException ex) {
                                    Logger.getLogger(ConcurrenceController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                   return cell;
               }
           };

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(teamIdCol, teamUsuarioCol, teamEdificioCol, teamSalaCol, teamDisponibilidadCol);
        table.setItems(computerList);

        table.getColumns().addAll(teamInfo);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        advertenciaLB.setVisible(false);
        loupeB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/loupe.png"))));
        insertcomputers();
        //progressBar.setProgress(0);



    }

}
