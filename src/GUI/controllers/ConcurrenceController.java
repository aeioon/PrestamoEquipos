/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarConcurrencia;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class ConcurrenceController implements Initializable {

    @FXML
    private TextField searchTF;

    @FXML
    private Label percentage;

    @FXML
    private Button loupeB;

    @FXML
    private TableView<ConcurrenceRow> table;

    @FXML
    private Label advertenciaLB;

    @FXML
    private ProgressBar progressBar;

    MostrarConcurrencia MIC = new MostrarConcurrencia();
    private ObservableList<ConcurrenceRow> computerList = FXCollections.observableArrayList();

    FilteredList<ConcurrenceRow> filteredConcurrence = new FilteredList<>(computerList, b -> true);

    public void searchComputers() {

        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredConcurrence.setPredicate(concurrenceRow -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if ((concurrenceRow.getCodigoSala().toLowerCase().indexOf(lowerCaseFilter) != -1)
                        || (concurrenceRow.getNombreEdificio().toLowerCase().indexOf(lowerCaseFilter) != -1)
                        || (concurrenceRow.getIdEquipo().toLowerCase().indexOf(lowerCaseFilter) != -1)
                        || (concurrenceRow.getIdUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1)) {
                    return true;
                } else {
                    return false;
                }
            });

            SortedList<ConcurrenceRow> sortedData = new SortedList<>(filteredConcurrence);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);
        });
    }

    void insertcomputers() {
        computerList.clear();
        table.refresh();
        TableColumn teamIdCol = new TableColumn("Id");
        teamIdCol.setStyle("-fx-alignment: CENTER;");
        teamIdCol.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));

        TableColumn teamUsuarioCol = new TableColumn("Usuario");
        teamUsuarioCol.setStyle("-fx-alignment: CENTER;");
        teamUsuarioCol.setCellValueFactory(new PropertyValueFactory("idUsuario"));

        TableColumn teamEdificioCol = new TableColumn("Edificio");
        teamEdificioCol.setStyle("-fx-alignment: CENTER;");
        teamEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));

        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setStyle("-fx-alignment: CENTER;");
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("codigoSala"));

        TableColumn teamDisponibilidadCol = new TableColumn("Disponibilidad");
        teamDisponibilidadCol.setStyle("-fx-alignment: CENTER;");
        teamDisponibilidadCol.setCellValueFactory(new PropertyValueFactory("disponibilidad"));

        TableColumn teamInfoCompCol = new TableColumn("Mas Información");
        teamInfoCompCol.setStyle("-fx-alignment: CENTER;");
        teamInfoCompCol.setCellValueFactory(new PropertyValueFactory("botonInfo"));

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(teamIdCol, teamUsuarioCol, teamEdificioCol, teamSalaCol, teamDisponibilidadCol, teamInfoCompCol);
        table.setItems(computerList);

        ArrayList<String[]> availableComputersInfo = MIC.getConcurrenceInfo();
        if (availableComputersInfo.size() != 0) {
            advertenciaLB.setText("");
        } else {
            advertenciaLB.setText("No se encontraron resultados");
        }
        availableComputersInfo.forEach(computer -> {
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
        insertcomputers();
        Double percentageNum = MIC.getConcurrencePercentage();
        progressBar.setProgress(percentageNum);
        percentage.setText(String.valueOf(percentageNum * 100).substring(0, 2) + "%");
        new Thread(new Runnable() {
            @Override
            public void run() {
                searchComputers();
            }
        }).start();
    }

}
