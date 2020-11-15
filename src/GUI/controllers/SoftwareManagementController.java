/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.ManageSoftware;
import Control.ManageSoftwareTeams;
import Entidad.Computador;
import Entidad.Programa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @FXML
    private TableView<Programa> allProgramsTable;
    @FXML
    private TextField programSearchTF;
    @FXML
    private Button addProgramBtn;
    @FXML
    private AnchorPane computerListPane;
    @FXML
    private TableView<ComputerRow> computerTable;
    @FXML
    private Text programPaneText;
    @FXML
    private Button removeComputerBtn;
    @FXML
    private Button addComputerBtn;
    @FXML
    private Label warningText;
    @FXML
    private Button removeProgramBtn;

    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();
    ManageSoftware MS = new ManageSoftware();
    ManageSoftwareTeams MST = new ManageSoftwareTeams();

    static Programa selectedProgram = new Programa();

    void insertPrograms() {

        /*Solamente llena tabla de programas. */
        TableColumn softwareNameCol = new TableColumn("Software");
        softwareNameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn versionNumCol = new TableColumn("Version");
        versionNumCol.setCellValueFactory(new PropertyValueFactory("version"));

        allProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allProgramsTable.getColumns().addAll(softwareNameCol, versionNumCol);
        allProgramsTable.setItems(programList);

        MS.getAllPrograms().forEach(p -> {
            programList.add(p);
        });

    }

    void insertComputers() {

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

        ArrayList<String[]> availableComputersInfo = MST.mostrarEquipos(selectedProgram);
        if (availableComputersInfo.size() != 0) {
            warningText.setText("");
        } else {
            warningText.setText("No hay computadores asignados a este equipo");
        }
        availableComputersInfo.forEach(computer -> {
            System.out.println(computer[0] + "" + computer[1] + "" + computer[2] + "" + computer[3]);
            ComputerRow temp = new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });
    }

    @FXML
    void removeProgramBtnAction(ActionEvent event) {
        try {
            MS.eliminar(selectedProgram);
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el programa");
        }
    }

    @FXML
    void addProgramBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/addProgram.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 470, 210);
            Stage stagePop = new Stage();
            stagePop.setScene(scene);
            stagePop.showAndWait();

            Thread computerInfo = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            computerInfo.setDaemon(true);
            computerInfo.start();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }

    }

    //AddComputer y removeComputer deben enviar la informacion del programa seleccionado originalmente a las ventanas correspondiente
    //Debe ser almacenado o solo se necesita la ID?
    @FXML
    void addComputerBtnAction(ActionEvent event) {
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

    @FXML
    void removeComputerBtnAction(ActionEvent event) {
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

    //esta vez se usara un getter estatico para enviar los datos.
    public static Programa getSelectedProgram() {
        return selectedProgram;
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
                    selectedProgram.setId(allProgramsTable.getSelectionModel().getSelectedItem().getId());
                    selectedProgram.setNombre(allProgramsTable.getSelectionModel().getSelectedItem().getNombre());
                    selectedProgram.setVersion(allProgramsTable.getSelectionModel().getSelectedItem().getVersion());
                    System.out.println(selectedProgram.getNombre());
                    computerList.clear();
                    computerTable.refresh();
                    insertComputers();
                    computerTable.refresh();
                    initActions();
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertPrograms();

        initActions();
        searchProgram();
    }

}
