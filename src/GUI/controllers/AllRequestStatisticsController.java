/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarInformesSoftware;
import Entidad.Programa;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author ion
 */
public class AllRequestStatisticsController implements Initializable {


    @FXML private AnchorPane programRequestsPane;
    
    @FXML private AnchorPane allRequestsPane;

    @FXML private BarChart<String, Number> programRequestsBarChart;

    @FXML private Button backToAllStatsBtn;

    @FXML private BarChart<String, Number> allRequestsBarChart;
    
    @FXML private Label allProgramsLabel;

    @FXML private Label singleProgramLabel;
    
    @FXML private TableView<ProgramRequestRow> singleProgramTable;

    @FXML private Label labelSuccess;

    @FXML private Label labelNoSuccess;
    
    
    
    XYChart.Series allChartSet = new XYChart.Series<String, Number>();
    //XYChart.Series singleChartSet = new XYChart.Series<String, Number>();
    XYChart.Series allChartSet2 = new XYChart.Series<String, Number>();
    MostrarInformesSoftware MIS = new MostrarInformesSoftware();
    private ObservableList<ProgramRequestRow> requestList = FXCollections.observableArrayList();
    ArrayList<String[]> stats;
    
    static Programa selectedProgram;
    
    
    @FXML
    void backToAllStatsBtnAction(ActionEvent event) {
        
        programRequestsPane.setVisible(false);
        allRequestsPane.setVisible(true);

    }


    void allRequestsData(){
        
        stats = MIS.getRequestStats();
        for(String[] p : stats){
            
            //args NombrePrograma, cantidad numerica y Programa 
            //Se pasa programa = Programa como tercer argumento para poder seleccionar el programa de la siguiente grafica
            Programa programa =new Programa(Integer.parseInt(p[0]), p[1], p[2]); 
            allChartSet.getData().add(new XYChart.Data(p[1],Integer.parseInt(p[3]), programa));
            allChartSet2.getData().add(new XYChart.Data(p[1],Integer.parseInt(p[4])-Integer.parseInt(p[3]), programa));

        }
        //Nombres de los ejes x, y
        allRequestsBarChart.getXAxis().setLabel("Programas");
        allRequestsBarChart.getYAxis().setLabel("Solicitudes");
        allRequestsBarChart.getData().addAll(allChartSet, allChartSet2);
        allRequestsBarChart.lookupAll(".default-color0.chart-bar")
            .forEach(n -> n.setStyle("-fx-bar-fill: #588FA7;"));
        
        int i=0;
        for (Node node : allRequestsBarChart.lookupAll(".chart-legend-item")) {
                if (node instanceof Label) {
                    ((Label) node).setWrapText(true);
                    if(i==0)  ((Label) node).setText("Soliciudes Exitosas");
                    else  ((Label) node).setText("Soliciudes No Exitosas");
                    ((Label) node).setManaged(true);
                    ((Label) node).setPrefWidth(170);
                    i++;
                    
                    
                }
        }         
    Platform.runLater(() -> {            
            Node nsl = allRequestsBarChart.lookup(".default-color" + 0 + ".chart-legend-item-symbol");
            nsl.setStyle("-fx-background-color: " + "#588FA7" + ", #588FA7;");
            
            
    });
    allRequestsBarChart.setLegendVisible(true);
}
 

    void singleTableData(){        
        
        TableColumn idSolicitud = new TableColumn("Id Solicitud");
        idSolicitud.setCellValueFactory(new PropertyValueFactory<>("idSolicitud"));
        idSolicitud.prefWidthProperty().bind(singleProgramLabel.widthProperty().multiply(0.2));
        idSolicitud.setResizable(false);

        TableColumn userName = new TableColumn("Usuario");
        userName.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        userName.prefWidthProperty().bind(singleProgramLabel.widthProperty().multiply(0.52));
        userName.setResizable(false);
        
        TableColumn startDate = new TableColumn("Fecha de inicio");
        startDate.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        startDate.prefWidthProperty().bind(singleProgramLabel.widthProperty().multiply(0.52));
        startDate.setResizable(false);
        
        TableColumn endDate = new TableColumn("Fecha de Fin");
        endDate.setCellValueFactory(new PropertyValueFactory<>("fechafinal"));
        endDate.prefWidthProperty().bind(singleProgramLabel.widthProperty().multiply(0.52));
        endDate.setResizable(false);
        
        TableColumn success = new TableColumn("Éxito");
        success.setCellValueFactory(new PropertyValueFactory<>("exito"));
        success.prefWidthProperty().bind(singleProgramLabel.widthProperty().multiply(0.22));
        success.setResizable(false);
        
        singleProgramTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        singleProgramTable.getColumns().addAll(idSolicitud, userName, startDate, endDate, success);

    }
    /*  
    void singleProgramData(){
            
        //Se añade inicialmente y se mantiene oculto. Se añade inicialmente por que JavaFX no redimensiona bien las barras en tiempo real.
        
        programRequestsBarChart.setLegendVisible(false);
        //Nombres de los ejes x, y
        programRequestsBarChart.getXAxis().setLabel("Tipos");
        programRequestsBarChart.getYAxis().setLabel("Solicitudes");
        
        singleChartSet.getData().add(new XYChart.Data("Dummy1", 12));
        singleChartSet.getData().add(new XYChart.Data("Dummy2", 20));
        
        programRequestsBarChart.setBarGap(20);

        programRequestsBarChart.getData().addAll(singleChartSet);
            
    }
    void singleProgramData(Programa selectedProgram){
        
        //Función que se ejecuta tras dar clicken un programa.
        
        
        programRequestsBarChart.getData().clear();
        singleChartSet.getData().clear();

        ArrayList<Programa> listaTest = new ArrayList<>();
        
        listaTest.add(selectedProgram);
        
        //La lista quizas no sea necesaria. Se trae algun objeto que contenga el numero de solicitudes exitosas y no exitosas.
        //En el primer add se pone las exitosas, en el segundo las no exitosas. Deben tener diferente nombre

        singleChartSet.getData().add(new XYChart.Data(listaTest.get(0).getNombre(), 2*listaTest.get(0).getId()));
        singleChartSet.getData().add(new XYChart.Data(listaTest.get(0).getNombre()+" no finalizado", listaTest.get(0).getId()));
        programRequestsBarChart.getData().addAll(singleChartSet);
        
        programRequestsBarChart.lookupAll(".default-color0.chart-bar")
            .forEach(n -> n.setStyle("-fx-bar-fill: #588FA7;"));
       
    }
     */

    void actualizarTabla(Programa selected) {
        requestList.clear();
        singleProgramTable.refresh();
        ArrayList<String[]> cols = MIS.getProgramRequestHistory(selected);
        for(String[] col: cols){
            requestList.add( new ProgramRequestRow(col[0], col[1], col[2], col[3], col[4]));
        }
        singleProgramTable.setItems(requestList);
        
        int[] success = MIS.getRequestStats(selected);
        double perSuccess = ((double)(success[0])/(success[1]+success[0])*100)+0.0001;
        String texto = "", doubleString = Double.toString(perSuccess);
        
        for (int i = 1; i <= 4; i++) {
            try {
                texto = doubleString.substring(0, i);
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        labelSuccess.setText("Porcentaje solicitudes exitosas " + texto + "%");
        perSuccess = ((double) (success[1]) / (success[1] + success[0])*100);
        texto = "";
        doubleString = Double.toString(perSuccess);

        for (int i = 1; i <= 4; i++) {
            try {
                texto = doubleString.substring(0, i);
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        labelNoSuccess.setText("Porcentaje solicitudes no exitosas " + texto + "%");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        allRequestsData();
        singleTableData();
        allProgramsLabel.setText("Solicitudes por programa");

        //Event handler para el click sobre la barra 
        for (Series<String, Number> serie : allRequestsBarChart.getData()) {
            for (XYChart.Data<String, Number> item : serie.getData()) {

                item.getNode().setOnMousePressed((MouseEvent event) -> {
                    selectedProgram = (Programa) item.getExtraValue();
                    allRequestsPane.setVisible(false);
                    actualizarTabla(selectedProgram);
                    singleProgramLabel.setText("Solicitudes: " + selectedProgram.getNombre());
                    programRequestsPane.setVisible(true);

                });
            }
        }
        
    }  
}
