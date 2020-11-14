/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class RemoveComputerController implements Initializable {
    
    // Basicamente el mismo AddComputer pero con diferente respuesta a los botones, quizas se pueda
    // unificar si se manda el tipo de operacion desde la vista SoftwareManagmenteController.
    // Por ello, por ahora todas los tests se hacen en Add y luego se traen aca o se unen.

     @FXML
    private TextField searchComputersTF;

    @FXML
    private TableView<ComputerRow> computersTable;

    @FXML
    private Button removeAllBtn;

    @FXML
    private Button removeBtn;

    @FXML
    void removeAllBtnAction(ActionEvent event) {

    }

    @FXML
    void removeBtnAction(ActionEvent event) {

    }
    
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();
    FilteredList<ComputerRow> filteredPrograms = new FilteredList<>(computerList, b -> true);
    
    public void searchComputers() {

        searchComputersTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPrograms.setPredicate(computerRow -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (computerRow.getNombreEdificio().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });

            SortedList<ComputerRow> sortedData = new SortedList<>(filteredPrograms);
            sortedData.comparatorProperty().bind(computersTable.comparatorProperty());
            computersTable.setItems(sortedData);
        });
    }
    
     void insertComputers() {
        
        TableColumn computerIdCol = new TableColumn("Id");
        computerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn nombreEdificioCol = new TableColumn("Nombre Edificio");
        nombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));
        TableColumn IdEdificioCol = new TableColumn("Id Edificio");
        IdEdificioCol.setCellValueFactory(new PropertyValueFactory("idEdificio"));
        TableColumn nombreSalaCol = new TableColumn("Codigo Sala");
        nombreSalaCol.setCellValueFactory(new PropertyValueFactory("nombreSala"));

        //asigna la lista de items y las columnas a la TableView
        computersTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        computersTable.getColumns().addAll(computerIdCol, nombreEdificioCol, IdEdificioCol, nombreSalaCol);
        computersTable.setItems(computerList);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
