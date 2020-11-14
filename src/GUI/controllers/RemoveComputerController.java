/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.ManageSoftwareTeams;
import Entidad.Programa;
import static GUI.controllers.SoftwareManagementController.selectedProgram;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class RemoveComputerController implements Initializable {
    
    // Basicamente el mismo AddComputer pero con diferente respuesta a los botones, quizas se pueda
    // unificar si se manda el tipo de operacion desde la vista SoftwareManagmenteController.
    // Por ello, por ahora todas los tests se hacen en Add y luego se traen aca o se unen.

    ManageSoftwareTeams MST = new ManageSoftwareTeams();
    Programa programa = SoftwareManagementController.getSelectedProgram();
    
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
        computersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        computersTable.getColumns().addAll(computerIdCol, nombreEdificioCol, IdEdificioCol, nombreSalaCol);
        computersTable.setItems(computerList);
        
    }
    
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();
    FilteredList<ComputerRow> filteredPrograms = new FilteredList<>(computerList, b -> true);
    
    public void searchComputers() {

        searchComputersTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPrograms.setPredicate(computerRow -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (computerRow.getNombreEdificio().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } 
                if(computerRow.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });

            SortedList<ComputerRow> sortedData = new SortedList<>(filteredPrograms);
            sortedData.comparatorProperty().bind(computersTable.comparatorProperty());
            computersTable.setItems(sortedData);
        });
    }
    
    void initActions(){
        computersTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    // test
                    System.out.println(computersTable.getSelectionModel().getSelectedItems());
                    computerList.addAll(computersTable.getSelectionModel().getSelectedItems());
                    computersTable.refresh();
                }
            }
        });
        //Quizas usar esto
        computersTable.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
            }
            
            
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<String[]> availableComputersInfo = MST.equiposSinPrograma(selectedProgram);
        availableComputersInfo.forEach(computer -> {
            System.out.println(computer[0] + "" + computer[1] + "" + computer[2] + "" + computer[3]);
            ComputerRow temp = new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });
    }    
    
}
