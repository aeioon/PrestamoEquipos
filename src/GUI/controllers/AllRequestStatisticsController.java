/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import DAO.ProgramaDAO;
import Entidad.Programa;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
    
    XYChart.Series allChartSet = new XYChart.Series<String, Number>();
    XYChart.Series singleChartSet = new XYChart.Series<String, Number>();
    ProgramaDAO pd = new ProgramaDAO();
    ArrayList<Programa> programList = pd.getAllProgramsAvailable();
    
    static Programa selectedProgram;
    

    @FXML
    void backToAllStatsBtnAction(ActionEvent event) {
        
        programRequestsPane.setVisible(false);
        allRequestsPane.setVisible(true);

    }

   
        
    void allRequestsData(){
        
        //Nombres de todos los programas y una cantidad como las solicitudes
        
        for(Programa p : programList){
            
            //args NombrePrograma, cantidad numerica y Programa 
            //Se pasa p = Programa como tercer argumento para poder seleccionar el programa de la siguiente grafica
            
            allChartSet.getData().add(new XYChart.Data(p.getNombre(), p.getId(), p));

        }
        //Nombres de los ejes x, y
        allRequestsBarChart.getXAxis().setLabel("Programas");
        allRequestsBarChart.getYAxis().setLabel("Solicitudes");
        allRequestsBarChart.getData().addAll(allChartSet);
        allRequestsBarChart.setLegendVisible(false);
        
        allRequestsBarChart.lookupAll(".default-color0.chart-bar")
            .forEach(n -> n.setStyle("-fx-bar-fill: #588FA7;"));
    }
    
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
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        allRequestsData();
        allProgramsLabel.setText("Solicitudes por programa");
        //Para que JavaFX calcule los tamaños con anticipacion.
        singleProgramData();

        //Event handler para el click sobre la barra 
        for (Series<String, Number> serie: allRequestsBarChart.getData()){
            for (XYChart.Data<String, Number> item: serie.getData()){
                item.getNode().setOnMousePressed((MouseEvent event) -> {
                    selectedProgram = (Programa) item.getExtraValue();
                    System.out.println("La ID del programa clickeado es "+ selectedProgram.getId());
                    singleProgramData(selectedProgram);
                    allRequestsPane.setVisible(false);
                    singleProgramLabel.setText("Solicitudes: "+selectedProgram.getNombre());
                    programRequestsPane.setVisible(true);
                });
            }
        }
            
        
    }    
    
}
