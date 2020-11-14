/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Entidad.Computador;
import Entidad.Programa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class SoftwareManagementController implements Initializable {

    @FXML  private Label escudoBlanco;
    @FXML private TableView<Programa> allProgramsTable;
    @FXML private TextField programSearchTF;
    @FXML private Button addProgramBtn;
    @FXML private AnchorPane computerListPane;
    @FXML private TableView<ComputerRow> computerTable;
    @FXML private Text programPaneText;
    @FXML private Button deleteComputerBtn;
    @FXML private Button addComputerBtn;
    
    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();
    
    void insertPrograms() {
         /*Solamente llena tabla de programas. */
        TableColumn softwareNameCol = new TableColumn("Software");
        softwareNameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn versionNumCol = new TableColumn("Version");
        versionNumCol.setCellValueFactory(new PropertyValueFactory("version"));

        allProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allProgramsTable.getColumns().addAll(softwareNameCol, versionNumCol);
        allProgramsTable.setItems(programList);
    }
    
    void insertComputers(){
        
        //User Computador o ComputerRow?
        //Actualmente usa ComputerRow
        TableColumn computerId = new TableColumn("ID Equipo");
        computerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn buildingName = new TableColumn("Edificio");
        buildingName.setCellValueFactory(new PropertyValueFactory<>("idEdificio"));
        
        TableColumn classroomId = new TableColumn("Sala");
        classroomId.setCellValueFactory(new PropertyValueFactory<>("nombreSala"));
        
        computerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        computerTable.getColumns().addAll(computerId, buildingName, classroomId);
        computerTable.setItems(computerList);
    }

    
    @FXML void addProgramBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/addProgram.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 470, 210);
            Stage stagePop = new Stage();
            stagePop.setScene(scene);
            stagePop.showAndWait();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
        
    }
    
    @FXML void addComputerBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/addComputer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 730, 400);
            Stage stagePop = new Stage();
            stagePop.setScene(scene);
            stagePop.showAndWait();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML void deleteComputerBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/removeComputer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 730, 400);
            Stage stagePop = new Stage();
            stagePop.setScene(scene);
            stagePop.showAndWait();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }
    
    
    //Buscador de programas
    
    FilteredList<Programa> filteredPrograms = new FilteredList<>(programList, b -> true);

    public void searchProgram() {

        programSearchTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPrograms.setPredicate(programa -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (programa.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });

            SortedList<Programa> sortedData = new SortedList<>(filteredPrograms);
            sortedData.comparatorProperty().bind(allProgramsTable.comparatorProperty());
            allProgramsTable.setItems(sortedData);
        });
    }
     
    void initActions() {
        allProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    System.out.println(allProgramsTable.getSelectionModel().getSelectedItem());
                    Programa programSelected = allProgramsTable.getSelectionModel().getSelectedItem();
                    System.out.println(programSelected.getNombre());
                    //Debe llamar a los computadores que usan este programa.
                    //La forma mas sencilla es con una consulta que dada la Id traiga los computadores.
                    ComputerRow comTeste = new ComputerRow(Integer.toString(programSelected.getId()), "Test", "Test", "Test");
                    computerList.add(comTeste);
                    computerTable.refresh();
                }
            }
        });
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertPrograms();
        insertComputers();
        
        //Test Buscador de programas
        
        Programa p1 = new Programa(999, "Nicotine", "1.5");
        Programa p2 = new Programa(997, "Polybar", "2.0");
        Programa p3 = new Programa(998, "Rofi", "3");
        programList.add(p1);
        programList.add(p2);
        programList.add(p3);
        
        initActions();
        searchProgram();
    }    
    
}
