package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarPrestamo;
import Entidad.Programa;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ComputerAvailableController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    RealizarPrestamo RP = new RealizarPrestamo();

    private static String[] selectedComputer = {"", "", "", ""};
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();
    private ObservableList<Programa> selectedProgramList = FXCollections.observableArrayList();

    @FXML
    private Button backHomeBtn;
    @FXML
    private AnchorPane computerTableSection;
    @FXML
    private Button askLoanBtn;
    @FXML
    private Label warningText;
    @FXML
    private TableView<ComputerRow> availableComputersTable;
    @FXML
    private Label infoText;

    void searchComputers() {
        computerTableSection.setVisible(true);
        computerList.clear();
        availableComputersTable.refresh();

        ArrayList<String[]> availableComputersInfo;
        availableComputersInfo = SoftwareSelectedController.getAvailableComputersInfo();

        availableComputersInfo.forEach(computer -> {
            ComputerRow temp = new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });
        availableComputersTable.refresh();
    }

    @FXML
    void AskLoanBtnAction(ActionEvent event) {
        try {
            selectedComputer[0] = availableComputersTable.getSelectionModel().getSelectedItem().getId();
            selectedComputer[1] = availableComputersTable.getSelectionModel().getSelectedItem().getNombreEdificio();
            selectedComputer[2] = availableComputersTable.getSelectionModel().getSelectedItem().getIdEdificio();
            selectedComputer[3] = availableComputersTable.getSelectionModel().getSelectedItem().getNombreSala();

            RP.createRequest(cargarDatosUsuario.getUser(), SoftwareSelectedController.getSelectedProgramArr(), LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/confirmRequest.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 437, 209);
            Stage stagePop = new Stage();
            stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/herramienta.png")));
            stagePop.setTitle("Confirmar prestamo");
            stagePop.setScene(scene);
            stagePop.showAndWait();

            //Vuelve al home si se hizo un prestamo.
            if (ConfirmRequestController.isPrestamo()) {
                changeScene(event, "/GUI/views/studentHome.fxml");
            } else {
                changeScene(event, "/GUI/views/softwareSelected.fxml");
            }

        } catch (Exception e) {
            warningText.setText("Olvidaste seleccionar un computador");
        }
    }

    void insertComputers() {
        TableColumn computerIdCol = new TableColumn("Id");
        computerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        computerIdCol.prefWidthProperty().bind(availableComputersTable.widthProperty().multiply(0.7));
        TableColumn nombreEdificioCol = new TableColumn("Nombre Edificio");
        nombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));
        nombreEdificioCol.prefWidthProperty().bind(availableComputersTable.widthProperty().multiply(0.7));
        TableColumn IdEdificioCol = new TableColumn("Id Edificio");
        IdEdificioCol.setCellValueFactory(new PropertyValueFactory("idEdificio"));
        IdEdificioCol.prefWidthProperty().bind(availableComputersTable.widthProperty().multiply(0.7));
        TableColumn nombreSalaCol = new TableColumn("Codigo Sala");
        nombreSalaCol.setCellValueFactory(new PropertyValueFactory("nombreSala"));
        nombreSalaCol.prefWidthProperty().bind(availableComputersTable.widthProperty().multiply(0.7));

        //asigna la lista de items y las columnas a la TableView
        availableComputersTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        availableComputersTable.getColumns().addAll(computerIdCol, nombreEdificioCol, IdEdificioCol, nombreSalaCol);
        availableComputersTable.setItems(computerList);
    }

    @FXML
    void backHomeBtn(ActionEvent event) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarDatosUsuario.cargar(cargarDatosUsuario.getUser());
            }
        }).start();
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/softwareSelected.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertComputers();
        searchComputers();
        infoText.setText("Equipos disponibles en la Facultad de Ingeniería");
    }

    public static String[] getSelectedComputer() {
        return selectedComputer;
    }

    public static void setSelectedComputer(String[] selectedComputer) {
        ComputerAvailableController.selectedComputer = selectedComputer;
    }

}
