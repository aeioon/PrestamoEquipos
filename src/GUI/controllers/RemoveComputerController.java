/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.ManageSoftwareTeams;
import Entidad.Computador;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class RemoveComputerController implements Initializable {
    
    ManageSoftwareTeams MST = new ManageSoftwareTeams();
    Programa programa = SoftwareManagementController.getSelectedProgram();
    
    @FXML private TextField searchComputersTF;
    @FXML private TableView<ComputerRow> computersTable;  
    @FXML private TableView<ComputerRow> selectedComputersTable;
    @FXML private Button removeBtn;
    
    private ObservableList<ComputerRow> selectedList = FXCollections.observableArrayList();
    ArrayList<Computador> selectedListArr = new ArrayList<>();

    void insertComputersTable() {
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
    void insertSelectedCompsTable(){
        TableColumn computerIdCol = new TableColumn("Id");
        computerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn nombreEdificioCol = new TableColumn("Nombre Edificio");
        nombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));
        TableColumn IdEdificioCol = new TableColumn("Id Edificio");
        IdEdificioCol.setCellValueFactory(new PropertyValueFactory("idEdificio"));
        TableColumn nombreSalaCol = new TableColumn("Codigo Sala");
        nombreSalaCol.setCellValueFactory(new PropertyValueFactory("nombreSala"));

        //asigna la lista de items y las columnas a la TableView
        selectedComputersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        selectedComputersTable.getColumns().addAll(computerIdCol, nombreEdificioCol, IdEdificioCol, nombreSalaCol);
        selectedComputersTable.setItems(selectedList); 
    }
    void updateComputerData(){
        //En remove se cambia por basicamente la misma tabla que esa en SoftwareManagementController
        
        ArrayList<String[]> availableComputersInfo = MST.mostrarEquipos(selectedProgram);
        
        /* if (availableComputersInfo.size() != 0) {
            warningText.setText("");
        } else {
            warningText.setText("No hay computadores asignados a este equipo");
        }*/
        
        availableComputersInfo.forEach(computer -> {
            ComputerRow temp = new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });
        computersTable.refresh();
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
    
    void addComputer(ComputerRow c) {
        if (!selectedList.contains(c)) {
            selectedList.add(c);
            selectedComputersTable.refresh();
            initActions();
        }

    }

    void unselectProgram(ComputerRow c) {
        if (selectedList.contains(c)) {
            selectedList.remove(c);
            initActions();
        }
    }
    void initActions(){
        computersTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    addComputer(computersTable.getSelectionModel().getSelectedItem());
                }
            }
        });
        selectedComputersTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    unselectProgram(selectedComputersTable.getSelectionModel().getSelectedItem());
                }
            }
        });
        
    }
       
    @FXML
    void removeBtnAction(ActionEvent event) {
        //Ahora convertimos lo seleccionado a un arrayList de Computadores
        selectedList.forEach(computerRow -> {
            Computador temp = new Computador();
            temp.setId(Integer.parseInt(computerRow.getId()));
            selectedListArr.add(temp);
        });
        if(MST.quitarEquipos(selectedListArr, programa)){
            System.out.println("Se removieron los computadores");
            Stage stage = (Stage) removeBtn.getScene().getWindow();
            stage.close();           
        } else {
            System.out.println("Hubo un errror, imprimir en Label");
        }     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       System.out.println("Programa seleccionado en la otra ventana "+  SoftwareManagementController.getSelectedProgram().getNombre());
        
       insertComputersTable();
       insertSelectedCompsTable();
       Thread thread = new Thread(new Runnable() {
            @Override
                public void run() {
                     updateComputerData();
                     searchComputers();
                     initActions();
                }
            });
        thread.setDaemon(true);
        thread.start();
      
    }     
}
