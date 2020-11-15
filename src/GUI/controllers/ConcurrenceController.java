/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import Control.MostrarInformacionComputadores;
import Entidad.Computador;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import jdk.nashorn.internal.runtime.JSType;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class ConcurrenceController implements Initializable {

    @FXML
    private TextField searchProgramTF;

    @FXML
    private Label percentage;
    
    @FXML
    private Button loupeB;

    @FXML
    private TableView<ConcurrenceRow> table;

    @FXML
    private Label advertenciaLB;

    @FXML
    private ProgressBar progressBar;
    
    MostrarInformacionComputadores MIC = new MostrarInformacionComputadores();
    private ObservableList<ConcurrenceRow> computerList = FXCollections.observableArrayList();

    @FXML
    void loupeBtnAction(ActionEvent event) {
        advertenciaLB.setVisible(false);
        computerList.clear();
        table.getColumns().get(0).setVisible(false);
        table.getColumns().get(0).setVisible(true);
        table.setItems(computerList);
        table.refresh();
        
        System.out.println("el tamaño de la lista es: " + computerList.size());
        
        Computador computador = new Computador();
        if (searchProgramTF.getText().length() != 0) {
            ArrayList<String[]> computadoresInfo = MIC.getConcurrenceInfo();
            
            for (String[] computadorTabla : computadoresInfo) {
                System.out.println("El ID Del computador es el: " + computadorTabla[0]);
               computador.setId(Integer.parseInt(computadorTabla[0]));
                String[] computadorInfo = MIC.getHoleComputerInfo(computador);
                ArrayList<String> programasComputador = MIC.getComputerPrograms(computador);
                String busqueda = String.valueOf(searchProgramTF.getText()).toLowerCase();
                
                    for (int j = 0; j < computadorInfo.length; j++) {
                        System.out.println("");
                        System.out.println("Busqueda:" + busqueda);
                        System.out.println("Comparación de busqueda:" + computadorInfo[j]);
                        
                        if (computadorInfo[j] != null) {
                            System.out.println("no esta vacio");
                            
                            if (busqueda.charAt(0) == computadorInfo[j].toLowerCase().charAt(0)) {
                                System.out.println("tienen algo igual: " + busqueda.charAt(0) + " es igual a " + computadorInfo[j].toLowerCase().charAt(0));
                                System.out.println("");
                                ConcurrenceRow concurrenceRow = new ConcurrenceRow(computadorInfo[0], computadorInfo[1], computadorInfo[2], computadorInfo[3], computadorInfo[4]);
                                System.out.println("el concurrenceRow queda:" + " id computador: ;"+ computadorInfo[0]
                                + " usuario: "+ computadorInfo[1]
                                +" id edifico: "+ computadorInfo[2]
                                       + " id sala: "+ computadorInfo[3]
                                + " disponibilidad: "+ computadorInfo[0]);
                                System.out.println("");
                                if (!computerList.contains(concurrenceRow)) {
                                    System.out.println("como no esta en la lista la vamos a agregar " + computadorInfo[0]);
                                    System.out.println("");
                                    computerList.add(concurrenceRow);
                                    System.out.println("vamos a imprimir que hay en el computerlist");
                                    for (ConcurrenceRow row : computerList) {
                                        System.out.println("");
                                        System.out.println("el concurrenceRow queda:" + " id computador: ;"+ row.getIdEquipo()
                                + " usuario: "+ row.getIdUsuario()
                                +" id edifico: "+ row.getCodigoEdificio()
                                       + " id sala: "+ row.getCodigoSala()
                                + " disponibilidad: "+ row.getDisponibilidad());
                                        
                                    }
                                    System.out.println("");
                                    table.refresh();
                            }
                        }
                    }
                    }
                table.refresh();
                for (String programa : programasComputador) {
                    System.out.println("");
                        System.out.println("Busqueda:" + busqueda);
                        System.out.println("Comparación de busqueda:" + programa);
                    for (int i = 0; i < busqueda.length(); i++) {
                        if (programa.toLowerCase().charAt(i) == busqueda.charAt(i)) {
                            System.out.println("tienen algo igual: " + busqueda.charAt(0) + " es igual a " + programa.toLowerCase().charAt(0));
                            ConcurrenceRow concurrenceRow = new ConcurrenceRow(computadorInfo[0], computadorInfo[1], computadorInfo[2], computadorInfo[3], computadorInfo[4]);
                            System.out.println("el concurrenceRow queda:" + " id computador: ;"+ computadorInfo[0]
                                + " usuario: ;"+ computadorInfo[1]
                                +" id edifico: ;"+ computadorInfo[2]
                                       + " id sala: ;"+ computadorInfo[3]
                                + " disponibilidad: ;"+ computadorInfo[4]);
                                System.out.println("");
                            if (!computerList.contains(concurrenceRow)) {
                                System.out.println("como no esta en la lista la vamos a agregar " + computadorInfo[0]);
                                    System.out.println("");
                                    computerList.add(concurrenceRow);
                                    System.out.println("vamos a imprimir que hay en el computerlist");
                                    for (ConcurrenceRow row : computerList) {
                                        System.out.println("");
                                        System.out.println("el concurrenceRow queda:" + " id computador: "+ row.getIdEquipo()
                                + " usuario: "+ row.getIdUsuario()
                                +" id edifico: "+ row.getCodigoEdificio()
                                       + " id sala: "+ row.getCodigoSala()
                                + " disponibilidad: "+ row.getDisponibilidad());
                                        
                                    }
                                    table.getColumns().get(0).setVisible(false);
table.getColumns().get(0).setVisible(true);
                                    System.out.println("");
                                    table.refresh();
                            }
                        }
                    }
                }
            }
        }

        if(computerList.size() != 0){
            //computerList.stream().distinct();
            System.out.println("El tamaño de la lista es " + computerList.size());
            System.out.println("la lista si tiene resultados");
            table.setItems(computerList);
            table.refresh();
            table.setVisible(true);
        }else{
            advertenciaLB.setText("No se encontraron resultados");
            advertenciaLB.setVisible(true);
        }

    }

    void insertcomputers(){
        TableColumn teamIdCol = new TableColumn("Id");
        teamIdCol.setStyle( "-fx-alignment: CENTER;"); 
        teamIdCol.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));

        TableColumn teamUsuarioCol = new TableColumn("Usuario");
        teamUsuarioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamUsuarioCol.setCellValueFactory(new PropertyValueFactory("idUsuario"));

        TableColumn teamEdificioCol = new TableColumn("Edificio");
        teamEdificioCol.setStyle( "-fx-alignment: CENTER;"); 
        teamEdificioCol.setCellValueFactory(new PropertyValueFactory("codigoEdificio"));

        TableColumn teamSalaCol = new TableColumn("Sala");
        teamSalaCol.setStyle( "-fx-alignment: CENTER;"); 
        teamSalaCol.setCellValueFactory(new PropertyValueFactory("codigoSala"));

        TableColumn teamDisponibilidadCol = new TableColumn("Disponibilidad");
        teamDisponibilidadCol.setStyle( "-fx-alignment: CENTER;"); 
        teamDisponibilidadCol.setCellValueFactory(new PropertyValueFactory("disponibilidad"));
        
        TableColumn teamInfoCompCol = new TableColumn("Mas Información");
        teamInfoCompCol.setStyle( "-fx-alignment: CENTER;");  
        teamInfoCompCol.setCellValueFactory(new PropertyValueFactory("botonInfo"));

        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(teamIdCol, teamUsuarioCol, teamEdificioCol, teamSalaCol, teamDisponibilidadCol, teamInfoCompCol);
        table.setItems(computerList);
        
        ArrayList<String[]> availableComputersInfo = MIC.getConcurrenceInfo();
        if(availableComputersInfo.size() != 0){
            advertenciaLB.setText("");
        }else{
            advertenciaLB.setText("No se encontraron resultados");
        }
        availableComputersInfo.forEach(computer -> {
            System.out.println(computer[0] + "" + computer[1] + "" + computer[2] + "" + computer[3] + "" + computer[4]);
            ConcurrenceRow temp = new ConcurrenceRow(computer[0], computer[1], computer[2], computer[3], computer[4]);
            if (!computerList.contains(temp)) {
                computerList.add(temp);
            }
        });

        table.refresh();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        advertenciaLB.setVisible(false);
        loupeB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/loupe.png"))));
        insertcomputers();
        Double percentageNum = MIC.getConcurrencePercentage();
        progressBar.setProgress(percentageNum);
        percentage.setText(String.valueOf(percentageNum*100).substring(0, 2) + "%");
    }

}