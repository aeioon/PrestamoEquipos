package GUI.controllers;

import Control.ComputadorController;
import Control.ProgramaController;
import Entidad.Computador;
import Entidad.Programa;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.MenuItem;


/**
 * FXML Controller class
 * @author ion
 */

public class LoanRequestController implements Initializable {
    
    //quizas metodo estatico
    ProgramaController PC1 = new ProgramaController();
    ComputadorController CC1 = new ComputadorController();
    
    @FXML private TextField searchProgramTF;
    @FXML private Button searchProgramBtn;
    @FXML private TableView<Programa> availableProgramsTable;
    @FXML private TableView<Programa> selectedProgramsTable;
    @FXML private TableView<Computador> availableComputersTable;
    @FXML private Button askLoanBtn;
    @FXML private Button rightArrowBtn;
    @FXML private Button leftArrowBtn;
    @FXML private Button backHomeBtn;
    @FXML private Button userInfoBtn;
    
    
    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    private ObservableList<Programa> selectedProgramList = FXCollections.observableArrayList();


    //Buscador de programas
    FilteredList<Programa> filteredPrograms = new FilteredList<>(programList, b->true);
    public void searchProgram() {
        searchProgramTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPrograms.setPredicate(programa -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (programa.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
            
            SortedList<Programa> sortedData = new SortedList<>(filteredPrograms);
            sortedData.comparatorProperty().bind(availableProgramsTable.comparatorProperty());
            availableProgramsTable.setItems(sortedData);
        });
    }
    
    @FXML
    void rightArrowBtnAction(ActionEvent event) {
        Programa programSelected = availableProgramsTable.getSelectionModel().getSelectedItem();
        addProgram(programSelected);
    }

    @FXML
    void leftArrowBtnAction(ActionEvent event) {
        Programa programSelected = selectedProgramsTable.getSelectionModel().getSelectedItem();
        unselectProgram(programSelected);
    }
 
    @FXML
    void AskLoanBtnAction(ActionEvent event) {
    }
    
    @FXML
    void backHomeBtn(ActionEvent event) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void searchProgramBtnAction(ActionEvent event) {
        
        ArrayList<Programa> arrayListTest = new ArrayList<>();
        selectedProgramList.forEach(p-> {
            arrayListTest.add(p);
        });
        
        String[][] arrayComputers = CC1.getInfoComputadores(arrayListTest);
        System.out.println(arrayComputers[0][2]);    
    }
    
    void addProgram(Programa p){
        if(!selectedProgramList.contains(p)){
            selectedProgramList.add(p);
            selectedProgramsTable.refresh();
            initActions();
        }
        
    }
    
    void unselectProgram(Programa p){
        if(selectedProgramList.contains(p)){
            selectedProgramList.remove(p);
            initActions();
        }    
    }

    @FXML
    void userInfoBtnAction(ActionEvent event) {
    }
    
    void insertAvailablePrograms(){
        
        PC1.getAllPrograms().forEach(p -> {
            programList.add(p);
        });  
        
        //crea columnas y selecciona el atributo de Programa
        TableColumn programIdCol = new TableColumn("Id");
        programIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn programNameCol = new TableColumn("Programa");
        programNameCol.setCellValueFactory(new PropertyValueFactory("nombre"));
        TableColumn programVersionCol = new TableColumn("Version");
        programVersionCol.setCellValueFactory(new PropertyValueFactory("version"));
        
        //asigna la lista de items y las columnas a la TableView
        availableProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        availableProgramsTable.setItems(programList);
        availableProgramsTable.getColumns().addAll(programIdCol, programNameCol, programVersionCol);
   
    }
    
    void insertSelectedPrograms(){
        //crea columnas y selecciona el atributo de Programa
        TableColumn programIdCol = new TableColumn("Id");
        programIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn programNameCol = new TableColumn("Programa");
        programNameCol.setCellValueFactory(new PropertyValueFactory("nombre"));
        TableColumn programVersionCol = new TableColumn("Version");
        programVersionCol.setCellValueFactory(new PropertyValueFactory("version"));
        
        selectedProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        selectedProgramsTable.setItems(selectedProgramList);
        selectedProgramsTable.getColumns().addAll(programIdCol, programNameCol, programVersionCol);
    }
    
    void initActions(){
        availableProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent click) {
                if(click.getClickCount()==2){
                    System.out.println(availableProgramsTable.getSelectionModel().getSelectedItem());
                    Programa programSelected = availableProgramsTable.getSelectionModel().getSelectedItem();
                    addProgram(programSelected);
                }
            }
        });
        
        selectedProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent click) {
                if(click.getClickCount()==2){
                    System.out.println(availableProgramsTable.getSelectionModel().getSelectedItem());
                    Programa programSelected = availableProgramsTable.getSelectionModel().getSelectedItem();
                    unselectProgram(programSelected);
                }
            }
        });    
        
        /*
        availableProgramsTable.setOnMouseClicked((MouseEvent click) -> {
            if(click.getButton() == MouseButton.SECONDARY){
                ContextMenu contextMenu = new ContextMenu();
                MenuItem item1 = new MenuItem("MenuItem1");
                item1.setOnAction((ActionEvent event) -> {
                    
                });
                MenuItem item2 = new MenuItem("MenuItem2");
                item2.setOnAction((ActionEvent event) -> {

                });
                contextMenu.getItems().addAll(item1, item2);
                 availableProgramsTable.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
                        @Override
                        public void handle(ContextMenuEvent event) {
                            contextMenu.show(availableProgramsTable, event.getScreenX(), event.getScreenY());
                        }
                    });
                }
            }
        );
        */
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertAvailablePrograms();
        insertSelectedPrograms();
        initActions();
        searchProgram();
    }       
}
