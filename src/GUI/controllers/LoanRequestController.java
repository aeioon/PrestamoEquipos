package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarPrestamo;
import Control.RealizarDevolucion;
import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class LoanRequestController implements Initializable {

    //quizas metodo estatico
    CargarDatosUsuario cargarDatos = CargarDatosUsuario.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();
    RealizarPrestamo RP = new RealizarPrestamo();

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
    private TableView<ComputerRow> availableComputersTable;
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

    private ObservableList<Programa> programList = FXCollections.observableArrayList();
    private ObservableList<Programa> selectedProgramList = FXCollections.observableArrayList();
    private ObservableList<ComputerRow> computerList = FXCollections.observableArrayList();

    private int idComputerSelected;
    private static LocalDateTime fechaInicio;
    private static LocalDateTime fechaFinal;

    public static LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public static void setFechaInicio(LocalDateTime fechaInicio) {
        LoanRequestController.fechaInicio = fechaInicio;
    }

    public static LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public static void setFechaFinal(LocalDateTime fechaFinal) {
        LoanRequestController.fechaFinal = fechaFinal;
    }

    void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    //Buscador de programas
    FilteredList<Programa> filteredPrograms = new FilteredList<>(programList, b -> true);

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

    @FXML
    private Label warningText;

    @FXML
    private AnchorPane computerTableSection;

    @FXML
    void AskLoanBtnAction(ActionEvent event) {

        Usuario user = cargarDatos.getUser();
        Computador selectedComputer = new Computador();
        selectedComputer.setId(idComputerSelected);
        ArrayList<Programa> programList = new ArrayList<>();

        selectedProgramList.forEach(p -> {
            programList.add(p);
        });

        if (user.getId() == null) {
            warningText.setText("Error relacionado a la sesion");
            System.out.println("Error relacionado a la sesion.");
        }

        if (idComputerSelected != 0) {
            try {

                cargarDatos.setPrograms(programList);
                String[] computadorSelecionado = {"", "", "", "", ""};
                computadorSelecionado[0] = "0";
                computadorSelecionado[1] = availableComputersTable.getSelectionModel().getSelectedItem().getId();
                computadorSelecionado[2] = availableComputersTable.getSelectionModel().getSelectedItem().getNombreEdificio();
                computadorSelecionado[3] = availableComputersTable.getSelectionModel().getSelectedItem().getIdEdificio();
                computadorSelecionado[4] = availableComputersTable.getSelectionModel().getSelectedItem().getNombreSala();
                cargarDatos.getDatosEquipos().add(computadorSelecionado);

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/views/confirmRequest.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 437, 209);
                Stage stagePop = new Stage();
                stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/herramienta.png")));
                stagePop.setTitle("Confirmar prestamo");
                stagePop.setScene(scene);
                stagePop.showAndWait();

                //Vuelve al home si se hizo un prestamo.
                if (cargarDatos.isActivo()) {
                    changeScene(event, "/GUI/views/studentHome.fxml");
                }

            } catch (IOException e) {
                System.err.println(String.format("Error: %s", e.getMessage()));
            }
        } else {
            System.out.println("Olvidaste seleccionar un computador");
            warningText.setText("Olvidaste seleccionar un computador");
        }

    }

    @FXML
    void backHomeBtn(ActionEvent event) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarDatos.cargar(cargarDatos.getUser());
            }
        }).start();
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    void insertComputers() {

        /*Solamente llena tabla de computadores.
         *crea columnas y selecciona el atributo de Programa
        
         */
        TableColumn computerIdCol = new TableColumn("Id");
        computerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn nombreEdificioCol = new TableColumn("Nombre Edificio");
        nombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));
        TableColumn IdEdificioCol = new TableColumn("Id Edificio");
        IdEdificioCol.setCellValueFactory(new PropertyValueFactory("idEdificio"));
        TableColumn nombreSalaCol = new TableColumn("Codigo Sala");
        nombreSalaCol.setCellValueFactory(new PropertyValueFactory("nombreSala"));

        //asigna la lista de items y las columnas a la TableView
        availableComputersTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        availableComputersTable.getColumns().addAll(computerIdCol, nombreEdificioCol, IdEdificioCol, nombreSalaCol);
        availableComputersTable.setItems(computerList);

    }

    @FXML
    void searchComputersBtnAction(ActionEvent event) {

        computerTableSection.setVisible(true);
        computerList.clear();
        availableComputersTable.refresh();
        ArrayList<Programa> selectedProgramArr = new ArrayList<>();
        selectedProgramList.forEach(p -> {
            selectedProgramArr.add(p);
        });

        ArrayList<String[]> availableComputersInfo;

        if (checkBoxReserva.isSelected()) {
            String[] minutes = comboBoxHoraInicio.getValue().toString().split(":");
            fechaInicio = LocalDateTime.of(date.getValue(), LocalTime.of(Integer.parseInt(minutes[0]), Integer.parseInt(minutes[1])));
            fechaFinal = fechaInicio.plusHours(1);
            availableComputersInfo = RP.getInfoComputers(selectedProgramArr, fechaInicio, fechaFinal);
        } else {
            fechaInicio = LocalDateTime.now();
            fechaFinal = fechaInicio.plusHours(1);
            availableComputersInfo = RP.getInfoComputers(selectedProgramArr, fechaInicio, fechaFinal);
        }

        if (availableComputersInfo.size() != 0) {
            warningText.setText("");
        } else {
            warningText.setText("No hay computadores disponibles");
        }
        availableComputersInfo.forEach(computer -> {
            System.out.println(computer[0] + "" + computer[1] + "" + computer[2] + "" + computer[3]);
            ComputerRow temp = new ComputerRow(computer[0], computer[1], computer[2], computer[3]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });

        availableComputersTable.refresh();
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
            initActions();
        }
    }

    @FXML
    void userInfoBtnAction(ActionEvent event) {
    }

    void insertAvailablePrograms() {

        //crea columnas y selecciona el atributo de Programa        
        TableColumn programNameCol = new TableColumn("Programa");
        programNameCol.setCellValueFactory(new PropertyValueFactory("nombre"));
        programNameCol.prefWidthProperty().bind(availableProgramsTable.widthProperty().multiply(0.7));
        programNameCol.setResizable(false);
        TableColumn programVersionCol = new TableColumn("Version");
        programVersionCol.setCellValueFactory(new PropertyValueFactory("version"));
        programVersionCol.prefWidthProperty().bind(availableProgramsTable.widthProperty().multiply(0.29));
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
        programVersionCol.prefWidthProperty().bind(selectedProgramsTable.widthProperty().multiply(0.29));
        programVersionCol.setResizable(false);

        selectedProgramsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        selectedProgramsTable.setItems(selectedProgramList);
        selectedProgramsTable.getColumns().addAll(programNameCol, programVersionCol);
    }

    void initActions() {

        /*
         *Cumplen la misma función que las flechas, se mantienen por usabilidad.
         */
        availableProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    System.out.println(availableProgramsTable.getSelectionModel().getSelectedItem());
                    Programa programSelected = availableProgramsTable.getSelectionModel().getSelectedItem();
                    addProgram(programSelected);
                }
            }
        });

        selectedProgramsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    System.out.println(availableProgramsTable.getSelectionModel().getSelectedItem());
                    Programa programSelected = availableProgramsTable.getSelectionModel().getSelectedItem();
                    unselectProgram(programSelected);
                }
            }
        });

        availableComputersTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    try {
                        idComputerSelected = Integer.parseInt(availableComputersTable.getSelectionModel().getSelectedItem().getId());
                        System.out.println("Id del computador seleccionado " + idComputerSelected);
                    } catch (Exception e) {

                    }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        insertSelectedPrograms();
        initActions();
        insertComputers();

        new Thread(new Runnable() {
            @Override
            public void run() {
                insertAvailablePrograms();
                searchProgram();
                /* Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            
                        }
                    });*/
            }
        }).start();

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
            System.out.println("get date: " + date.getValue());
            if (date.getValue().equals(LocalDate.now())) {
                int now = LocalTime.now().getHour();
                System.out.println(now);
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
}
