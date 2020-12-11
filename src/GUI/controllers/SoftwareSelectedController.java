package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarPrestamo;
import Control.RealizarDevolucion;
import Entidad.Programa;
import Entidad.Solicitud;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;

public class SoftwareSelectedController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();
    RealizarPrestamo RP = new RealizarPrestamo();
    LocalDateTime fechaInicio;
    LocalDateTime fechaFinal;
    Solicitud solicitud;

    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    private ObservableList<Programa> selectedProgramList = FXCollections.observableArrayList();

    FilteredList<Programa> filteredPrograms = new FilteredList<>(programList, b -> true);
    private static ArrayList<Programa> selectedProgramArr = new ArrayList<>();
    private static ArrayList<String[]> availableComputersInfo;
    private static boolean solicitudCreada = false;
    private static boolean prestamo = true;
    private static int duracion;

    @FXML
    private TextField searchProgramTF;
    @FXML
    private Label user;
    @FXML
    private Button searchComputersBtn;
    @FXML
    private TableView<Programa> availableProgramsTable;
    @FXML
    private TableView<Programa> selectedProgramsTable;
    @FXML
    private Button askLoanBtn;
    @FXML
    private Button rightArrowBtn;
    @FXML
    private Button leftArrowBtn;
    @FXML
    private Button backHomeBtn;
    @FXML
    private Button userInfoBtn;
    @FXML
    private CheckBox checkBoxReserva;
    @FXML
    private DatePicker date;
    @FXML
    private Label labelFecha;
    @FXML
    private Label labelHoraInicial;
    @FXML
    private ComboBox comboBoxHoraInicio;
    @FXML
    private Label warningText;
    @FXML
    private AnchorPane computerTableSection;
    @FXML
    private TextField numeroDeHoras;

    @FXML
    void searchComputersBtnAction(ActionEvent event) throws IOException {
        selectedProgramArr.clear();
        selectedProgramList.forEach(p -> {
            selectedProgramArr.add(p);
        });
        try {
            duracion = Integer.parseInt(numeroDeHoras.getText());
        } catch (Exception e) {
            duracion = 60;
        }
        if (checkBoxReserva.isSelected() && comboBoxHoraInicio.getValue() != null && date.getValue() != null) {
            String[] minutes = comboBoxHoraInicio.getValue().toString().split(":");
            fechaInicio = LocalDateTime.of(date.getValue(), LocalTime.of(Integer.parseInt(minutes[0]), Integer.parseInt(minutes[1])));
            fechaFinal = fechaInicio.plusMinutes(duracion);
        } else {
            fechaInicio = LocalDateTime.now();
            fechaFinal = fechaInicio.plusMinutes(duracion);
        }
        availableComputersInfo = RP.getInfoComputers(selectedProgramArr, fechaInicio, fechaFinal);
        if (!availableComputersInfo.isEmpty()) {
            Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/computerAvailable.fxml"));
            Scene newScene = new Scene(newParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        } else {
            warningText.setText("No hay computadores disponibles");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        solicitud = RP.createRequest(cargarDatosUsuario.getUser(), selectedProgramArr, fechaInicio, fechaFinal);
                    } catch (Exception e) {
                        System.out.println("Error en la creación de la solicitud");
                    }
                }
            }).start();
        }
    }

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
        if (programSelected != null) {
            addProgram(programSelected);
        }
    }

    @FXML
    void leftArrowBtnAction(ActionEvent event) {
        Programa programSelected = selectedProgramsTable.getSelectionModel().getSelectedItem();
        unselectProgram(programSelected);
    }

    void addProgram(Programa p) {
        if (!selectedProgramList.contains(p)) {
            selectedProgramList.add(p);
            selectedProgramsTable.refresh();
            initActions();
        }
    }

    void unselectProgram(Programa p) {
        if (selectedProgramList.contains(p)) {
            selectedProgramList.remove(p);
            selectedProgramsTable.refresh();
            initActions();
        }
    }

    void insertAvailablePrograms() {
        //crea columnas y selecciona el atributo de Programa        
        TableColumn programNameCol = new TableColumn("Programa");
        programNameCol.setCellValueFactory(new PropertyValueFactory("nombre"));
        programNameCol.prefWidthProperty().bind(availableProgramsTable.widthProperty().multiply(0.7));
        programNameCol.setResizable(false);
        TableColumn programVersionCol = new TableColumn("Version");
        programVersionCol.setCellValueFactory(new PropertyValueFactory("version"));
        programVersionCol.prefWidthProperty().bind(availableProgramsTable.widthProperty().multiply(0.294));
        programVersionCol.setResizable(false);

        //asigna la lista de items y las columnas a la TableView
        availableProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        availableProgramsTable.setItems(programList);
        availableProgramsTable.getColumns().addAll(programNameCol, programVersionCol);

        RP.getAllPrograms().forEach(p -> {
            programList.add(p);
        });
    }

    void insertSelectedPrograms() {
        TableColumn programNameCol = new TableColumn("Programa");
        programNameCol.setCellValueFactory(new PropertyValueFactory("nombre"));
        programNameCol.prefWidthProperty().bind(selectedProgramsTable.widthProperty().multiply(0.7));
        programNameCol.setResizable(false);
        TableColumn programVersionCol = new TableColumn("Version");
        programVersionCol.setCellValueFactory(new PropertyValueFactory("version"));
        programVersionCol.prefWidthProperty().bind(selectedProgramsTable.widthProperty().multiply(0.294));
        programVersionCol.setResizable(false);

        selectedProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        selectedProgramsTable.setItems(selectedProgramList);
        selectedProgramsTable.getColumns().addAll(programNameCol, programVersionCol);
    }

    void initActions() {
        availableProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Programa programSelected = availableProgramsTable.getSelectionModel().getSelectedItem();
                    addProgram(programSelected);
                }
            }
        });

        selectedProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Programa programSelected = selectedProgramsTable.getSelectionModel().getSelectedItem();
                    unselectProgram(programSelected);
                }
            }
        });

        date.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                int dias = LocalTime.now().getHour() < 19 ? 0 : 1;
                setDisable(empty || date.compareTo(today.plusDays(dias)) < 0 || date.compareTo(today.plusDays(6)) > 0);
            }
        });
    }

    @FXML
    void reservaAction(ActionEvent event) {
        if (checkBoxReserva.isSelected()) {
            labelFecha.setDisable(false);
            labelHoraInicial.setDisable(true);
            date.setDisable(false);
            comboBoxHoraInicio.setDisable(true);
        } else {
            labelFecha.setDisable(true);
            labelHoraInicial.setDisable(true);
            date.setDisable(true);
            comboBoxHoraInicio.setDisable(true);
            date.setValue(null);
            comboBoxHoraInicio.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void dateAction(ActionEvent event) {
        if (date.getValue() != null) {
            int hour = 7;
            if (date.getValue().equals(LocalDate.now())) {
                int now = LocalTime.now().getHour();
                hour = now >= 6 ? now + 1 : 7;
            }
            ObservableList<Object> hours = FXCollections.observableArrayList();
            for (int i = hour; i < 20; i++) {
                if (i == 13) {
                    hours.add(new Separator());
                } else {
                    hours.add(Integer.toString(i).concat(":00"));
                }
            }
            comboBoxHoraInicio.setItems(hours);
            labelHoraInicial.setDisable(false);
            comboBoxHoraInicio.setDisable(false);
        }
    }

    @FXML
    void backHomeBtn(ActionEvent event) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarDatosUsuario.cargar(cargarDatosUsuario.getUser());
            }
        }).start();
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
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
        initActions();
        insertSelectedPrograms();
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertAvailablePrograms();
                searchProgram();
            }
        }).start();
    }

    public static ArrayList<String[]> getAvailableComputersInfo() {
        return availableComputersInfo;
    }

    public static void setAvailableComputersInfo(ArrayList<String[]> availableComputersInfo) {
        SoftwareSelectedController.availableComputersInfo = availableComputersInfo;
    }

    public static boolean isSolicitudCreada() {
        return solicitudCreada;
    }

    public static void setSolicitudCreada(boolean solicitudCreada) {
        SoftwareSelectedController.solicitudCreada = solicitudCreada;
    }

    public static boolean isPrestamo() {
        return prestamo;
    }

    public static void setPrestamo(boolean prestamo) {
        SoftwareSelectedController.prestamo = prestamo;
    }

    public static ArrayList<Programa> getSelectedProgramArr() {
        return selectedProgramArr;
    }

    public static void setSelectedProgramArr(ArrayList<Programa> selectedProgramArr) {
        SoftwareSelectedController.selectedProgramArr = selectedProgramArr;
    }

    public static int getDuracion() {
        return duracion;
    }

    public static void setDuracion(int duracion) {
        SoftwareSelectedController.duracion = duracion;
    }

}
