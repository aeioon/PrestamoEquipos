/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.CargarDatosUsuario;
import Control.RealizarDevolucion;
import Entidad.Computador;
import Entidad.Solicitud;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ion
 */
public class ReturnEquipmentController implements Initializable {

    CargarDatosUsuario cargarDatosUsuario = CargarDatosUsuario.getInstance();
    RealizarDevolucion RD = new RealizarDevolucion();

    private ObservableList<SolicitudRow> solicitudesList = FXCollections.observableArrayList();
    SolicitudRow solicitudRow;

    @FXML
    private Button actionBtn;

    @FXML
    private TableView<SolicitudRow> solicitudesTable;

    void insertColumnsSolicitudes() {

        TableColumn teamIdSolicitudCol = new TableColumn("Solicitud");
        teamIdSolicitudCol.setStyle("-fx-alignment: CENTER;");
        teamIdSolicitudCol.setCellValueFactory(new PropertyValueFactory<>("idSolicitud"));
        teamIdSolicitudCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.12));

        TableColumn teamIdEquipoCol = new TableColumn("Equipo");
        teamIdEquipoCol.setStyle("-fx-alignment: CENTER;");
        teamIdEquipoCol.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));
        teamIdEquipoCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.12));

        TableColumn teamNombreEdificioCol = new TableColumn("Edificio");
        teamNombreEdificioCol.setStyle("-fx-alignment: CENTER;");
        teamNombreEdificioCol.setCellValueFactory(new PropertyValueFactory("nombreEdificio"));
        teamNombreEdificioCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.12));

        TableColumn teamIdEdificioCol = new TableColumn("Edificio");
        teamIdEdificioCol.setStyle("-fx-alignment: CENTER;");
        teamIdEdificioCol.setCellValueFactory(new PropertyValueFactory("idEdificio"));
        teamIdEdificioCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.12));

        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setStyle("-fx-alignment: CENTER;");
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("codigoSala"));
        teamSalaCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.12));

        TableColumn teamFechaInicioCol = new TableColumn("Fecha inicio");
        teamFechaInicioCol.setStyle("-fx-alignment: CENTER;");
        teamFechaInicioCol.setCellValueFactory(new PropertyValueFactory("FechaInicio"));
        teamFechaInicioCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.192));

        TableColumn teamFechaFinCol = new TableColumn("Fecha fin");
        teamFechaFinCol.setStyle("-fx-alignment: CENTER;");
        teamFechaFinCol.setCellValueFactory(new PropertyValueFactory("FechaFin"));
        teamFechaFinCol.prefWidthProperty().bind(solicitudesTable.widthProperty().multiply(0.2));

        solicitudesTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        solicitudesTable.getColumns().addAll(teamIdSolicitudCol, teamIdEquipoCol, teamNombreEdificioCol, teamIdEdificioCol, teamSalaCol, teamFechaInicioCol, teamFechaFinCol);
        solicitudesTable.setItems(solicitudesList);
    }

    void insertSolicitudes() {
        ArrayList<String[]> availableComputersInfo = cargarDatosUsuario.getDatosSolicitudes();
        availableComputersInfo.forEach(computer -> {
            SolicitudRow temp = new SolicitudRow(computer[0], computer[1], computer[2], computer[3], computer[4], computer[5], computer[6]);
            if (!solicitudesList.contains(temp)) {
                solicitudesList.add(temp);
            }
        });

        solicitudesTable.refresh();
    }

    @FXML
    void actionBtnAction(ActionEvent event) {
        if (actionBtn.getText().equals("Devolver")) {
            Computador computador = new Computador();
            computador.setId(Integer.parseInt(solicitudRow.getIdEquipo()));
            if (RD.makeReturn(computador, cargarDatosUsuario.isActivo())) {
                System.out.println("Se realizo la devolucion!");
            } else {
                System.out.println("Fallo en la devolucion");
            }
            solicitudesList.clear();
            solicitudesTable.refresh();
            cargarDatosUsuario.cargarSolicitudes(cargarDatosUsuario.getUser());
            cargarDatosUsuario.cargar(cargarDatosUsuario.getUser());
            insertSolicitudes();
        } else {
            Solicitud solicitud = new Solicitud();
            solicitud.setId(Integer.parseInt(solicitudRow.getIdSolicitud()));
            if (RD.cancelRequest(solicitud)) {
                System.out.println("Cancelo solicitud");
            } else {
                System.out.println("Fallo la cancelación");
            }
            solicitudesList.clear();
            solicitudesTable.refresh();
            cargarDatosUsuario.cargarSolicitudes(cargarDatosUsuario.getUser());
            cargarDatosUsuario.cargar(cargarDatosUsuario.getUser());
            insertSolicitudes();
        }
    }

    public void evaluarAction() {
        try {
            solicitudRow = solicitudesTable.getSelectionModel().getSelectedItem();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime inicio = LocalDateTime.parse(solicitudRow.getFechaInicio(), formatter);
            LocalDateTime fin = LocalDateTime.parse(solicitudRow.getFechaFin(), formatter);

            if (inicio.isBefore(LocalDateTime.now()) && LocalDateTime.now().isBefore(fin)) {
                actionBtn.setText("Devolver");
            } else {
                actionBtn.setText("Cancelar");
            }
        } catch (Exception e) {
            actionBtn.setText("");
            actionBtn.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertColumnsSolicitudes();
        insertSolicitudes();
        solicitudesTable.getSelectionModel().select(0);
        evaluarAction();
        solicitudesTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    //toma el item seleccionado, en este casoSolicitudRow
                    evaluarAction();
                }
            }
        });
    }

}
