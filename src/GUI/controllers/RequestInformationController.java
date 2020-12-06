/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarHistorialPrestamos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class RequestInformationController implements Initializable {
    
    @FXML
    private TableView<RequestRow> table;

    @FXML
    private TextField usuarioL;
    
    String userId= HistoryRow.getSelectUsuario();
    MostrarHistorialPrestamos MIC = new MostrarHistorialPrestamos();
    private ObservableList<RequestRow> requestList = FXCollections.observableArrayList();
    
    
    void insertrequest(String user ){
        System.out.println("generar tabla");
        TableColumn teamIdCol = new TableColumn("Solicitud");
        teamIdCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdCol.setCellValueFactory(new PropertyValueFactory<>("idSolicitud"));
        teamIdCol.setResizable(false);
        teamIdCol.prefWidthProperty().bind(table.widthProperty().multiply(0.11));
        
        TableColumn teamFechaInicioCol = new TableColumn("Fecha Inicio");
        teamFechaInicioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamFechaInicioCol.setCellValueFactory(new PropertyValueFactory("fechaInicio"));
        teamFechaInicioCol.prefWidthProperty().bind(table.widthProperty().multiply(0.19));
        teamFechaInicioCol.setResizable(false);        
        
        TableColumn teamFechaFinalCol = new TableColumn("Fecha Final");
        teamFechaFinalCol.setStyle( "-fx-alignment: CENTER;"); 
        teamFechaFinalCol.setCellValueFactory(new PropertyValueFactory("fechaFinal"));
        teamFechaFinalCol.prefWidthProperty().bind(table.widthProperty().multiply(0.19));
        teamFechaFinalCol.setResizable(false);
        
        
        TableColumn teamEquipoCol = new TableColumn("Computador");
        teamEquipoCol.setStyle( "-fx-alignment: CENTER;"); 
        teamEquipoCol.setCellValueFactory(new PropertyValueFactory("computador"));
        teamEquipoCol.prefWidthProperty().bind(table.widthProperty().multiply(0.11));
        teamEquipoCol.setResizable(false);
        
        
        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setStyle( "-fx-alignment: CENTER;"); 
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("sala"));
        teamSalaCol.prefWidthProperty().bind(table.widthProperty().multiply(0.07));
        teamSalaCol.setResizable(false);
        
        TableColumn teamEdificioCol = new TableColumn("Edificio");
        teamEdificioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamEdificioCol.setCellValueFactory(new PropertyValueFactory("edificio"));
        teamEdificioCol.prefWidthProperty().bind(table.widthProperty().multiply(0.07));
        teamEdificioCol.setResizable(false);
        
        TableColumn teamProgramaCol = new TableColumn("Programa");
        teamProgramaCol.setStyle( "-fx-alignment: CENTER;"); 
        teamProgramaCol.setCellValueFactory(new PropertyValueFactory("programa"));
        teamProgramaCol.prefWidthProperty().bind(table.widthProperty().multiply(0.235));
        teamProgramaCol.setResizable(false);
        
        System.out.println("cree las columnas");

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(teamIdCol, teamFechaInicioCol, teamFechaFinalCol, teamEquipoCol, teamSalaCol, teamEdificioCol, teamProgramaCol);
        table.setItems(requestList);
        
        System.out.println("agregar lista");
        
        ArrayList<String[]> availableRequestsInfo = MIC.getHoleUserBorrowsInfo(user);
       
        if(availableRequestsInfo.size() != 0){
            //advertenciaLB.setText("");
        }else{
            //advertenciaLB.setText("No se encontraron registros");
        }
        availableRequestsInfo.forEach(request -> {
            RequestRow temp = new RequestRow(request[0], request[1], request[2],request[3], request[4], request[5],request[6]);
                requestList.add(temp);
        });

        table.refresh();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("estoy iniciando");
        usuarioL.setText(userId);
        insertrequest(userId);
    }    
    
}
