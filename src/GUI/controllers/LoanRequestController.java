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
    
    public class ComputerRow {
            String id;
            String idEdifio;
            String nombreEdificio;
            String nombreSala;

            ComputerRow(String id, String idEdifio, String nombreEdificio, String nombreSala) {
                this.id = id;
                this.idEdifio = idEdifio;
                this.nombreEdificio = nombreEdificio;
                this.nombreSala = nombreSala;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIdEdifio() {
                return idEdifio;
            }

            public void setIdEdifio(String idEdifio) {
                this.idEdifio = idEdifio;
            }

            public String getNombreEdificio() {
                return nombreEdificio;
            }

            public void setNombreEdificio(String nombreEdificio) {
                this.nombreEdificio = nombreEdificio;
            }

            public String getNombreSala() {
                return nombreSala;
            }

            public void setNombreSala(String nombreSala) {
                this.nombreSala = nombreSala;
            }
            
        }
    
    @FXML private TextField searchProgramTF;
    @FXML private Button searchProgramBtn;
    @FXML private TableView<Programa> availableProgramsTable;
    @FXML private TableView<Programa> selectedProgramsTable;
    @FXML private TableView<ComputerRow> availableComputersTable;
    @FXML private Button askLoanBtn;
    @FXML private Button rightArrowBtn;
    @FXML private Button leftArrowBtn;
    @FXML private Button backHomeBtn;
    @FXML private Button userInfoBtn;
    
    
    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    private ObservableList<Programa> selectedProgramList = FXCollections.observableArrayList();
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();
    
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
        
        //lanzar popUp de confirmacion
        
        
    }
    
    @FXML
    void backHomeBtn(ActionEvent event) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    
    
    void insertComputers(){
        
        /*
        ArrayList<Programa> selectedProgramArr = new ArrayList<>();
        selectedProgramList.forEach(p->{
            selectedProgramArr.add(p);
        });
        CC1.getInfoComputadores(selectedProgramArr)
        CC1.getInfoComputadores(selectedProgramArr).forEach(p -> {
            computerList.add(p);
        });  
        */
        
        //crea columnas y selecciona el atributo de Programa
        TableColumn computerIdCol = new TableColumn("Id");
        computerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn IdEdificioCol = new TableColumn("Edificio");
        IdEdificioCol.setCellValueFactory(new PropertyValueFactory("IdEdificio"));
        TableColumn nombreEdificioCol = new TableColumn("Nombre Edificio");
        nombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));
        TableColumn nombreSalaCol = new TableColumn("Nombre Sala");
        nombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreSala"));
        
        //asigna la lista de items y las columnas a la TableView
        
        availableComputersTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        availableComputersTable.setItems(computerList);
        availableComputersTable.getColumns().addAll(computerIdCol, IdEdificioCol, nombreEdificioCol, nombreSalaCol);
    }
    @FXML
    void searchProgramBtnAction(ActionEvent event) {
        
        //Se instancia un arrayList de programas y se llena con los programas seleccionados 
        
        ArrayList<Programa> selectedProgramArr = new ArrayList<>();
        selectedProgramList.forEach(program->{
            selectedProgramArr.add(program);
        });

        //Hacerlo con funcion de control  = CC1.();
        ArrayList<String[]> availableComputersInfo = new ArrayList<>();
        String test [] = new String [4];  
        test [0] = "texto1";
        test [1] = "texto2";
        test [2] = "texto3";
        test [3] = "texto4";
        
        /* descomentar para probar
        availableComputersInfo.forEach(computer -> {
            computerList.add(new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
        });    
        */
        
        //test
        availableComputersInfo.add(test);
        
        availableComputersInfo.forEach(computer -> {
            ComputerRow temp = new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
            if(!computerList.contains(temp)){
                computerList.add(temp);
            }
        });
        selectedProgramsTable.refresh();
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
    void userInfoBtnAction(ActionEvent event) {}

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
        insertComputers();
        initActions();
        searchProgram();
    }       
}
