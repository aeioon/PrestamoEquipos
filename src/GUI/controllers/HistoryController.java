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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
public class HistoryController implements Initializable {

    @FXML
    private TableView<HistoryRow> table;

    @FXML
    private TextField searchTF;
    
    MostrarHistorialPrestamos MIC = new MostrarHistorialPrestamos();
    private ObservableList<HistoryRow> requestList = FXCollections.observableArrayList();
    
    FilteredList<HistoryRow> filteredHistory = new FilteredList<>(requestList, b -> true);
    
    public void searchRequestThings() {

//        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredHistory.setPredicate(historyRow -> {
//                String lowerCaseFilter = newValue.toLowerCase();
//                if ((historyRow.getId().toLowerCase().indexOf(lowerCaseFilter) != -1)
//                        || (historyRow.getIdUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1)
//                        || (historyRow.getIdEquipo().toLowerCase().indexOf(lowerCaseFilter) != -1)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            });
//
//            SortedList<HistoryRow> sortedData = new SortedList<>(filteredHistory);
//            sortedData.comparatorProperty().bind(table.comparatorProperty());
//            table.setItems(sortedData);
//        });
    }
    
    void insertrequest(){
        TableColumn teamIdCol = new TableColumn("Id");
        teamIdCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdCol.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));

        TableColumn teamUsuarioCol = new TableColumn("Software");
        teamUsuarioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamUsuarioCol.setCellValueFactory(new PropertyValueFactory("SoftwareMásUtilizado"));

        TableColumn teamIdEquipoCol = new TableColumn("Promedio de prestamos");
        teamIdEquipoCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdEquipoCol.setCellValueFactory(new PropertyValueFactory("TiempoTotalDeLosPréstamos"));
        
        TableColumn teamInfoCompCol = new TableColumn("Mas Información");
        teamInfoCompCol.setStyle( "-fx-alignment: CENTER;");  
        teamInfoCompCol.setCellValueFactory(new PropertyValueFactory("botonInfo"));

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(teamIdCol, teamUsuarioCol, teamIdEquipoCol, teamInfoCompCol);
        table.setItems(requestList);
        
        ArrayList<String[]> availableRequestsInfo = MIC.getBorrowsHistoryInfo();
        if(availableRequestsInfo.size() != 0){
            //advertenciaLB.setText("");
        }else{
            //advertenciaLB.setText("No se encontraron registros");
        }
        availableRequestsInfo.forEach(request -> {
            HistoryRow temp = new HistoryRow(request[0], request[1], request[2]);
            if (!requestList.contains(temp)) {
                requestList.add(temp);
            }
        });

        table.refresh();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertrequest();
        searchRequestThings();
    }    
    
}