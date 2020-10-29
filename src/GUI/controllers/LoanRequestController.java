package GUI.controllers;

import Control.ProgramaController;
import Entidad.Programa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * @author ion
 */

public class LoanRequestController implements Initializable {

    @FXML
    private TextField searchProgramTF;

    @FXML
    private Button searchProgramBtn;

    @FXML
    private TableView<Programa> availableProgramsTable;

    @FXML
    private TableView<?> selectedProgramsTable;

    @FXML
    private TableView<?> availableComputersTable;

    @FXML
    private Button askLoanBtn;

    @FXML
    private Button backHomeBtn;

    @FXML
    private Button userInfoBtn;

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

    }

    @FXML
    void userInfoBtnAction(ActionEvent event) {

    }
    
    //table 
    //a program array to test the injector
    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    
    void insertDataIntoTable(){
        
        //quizas metodo estatico
        ProgramaController PC1 = new ProgramaController();
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
        availableProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        availableProgramsTable.setItems(programList);
        availableProgramsTable.getColumns().addAll(programIdCol, programNameCol, programVersionCol);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertDataIntoTable();
    }       
}
