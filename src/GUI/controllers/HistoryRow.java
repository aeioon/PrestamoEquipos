/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import static GUI.controllers.ConcurrenceRow.selectcomputador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class HistoryRow {
    public String idUsuario;
    public String SoftwareMásUtilizado;
    public String TiempoTotalDeLosPréstamos;
    public Button botonInfo;
    
    static String selectUsuario;

    public static String getSelectUsuario() {
        return selectUsuario;
    }

    public HistoryRow(String idUsuario, String SoftwareMásUtilizado, String TiempoTotalDeLosPréstamos) {
        this.idUsuario = idUsuario;
        this.SoftwareMásUtilizado = SoftwareMásUtilizado;
        this.TiempoTotalDeLosPréstamos = TiempoTotalDeLosPréstamos;
        this.botonInfo = new Button("+");
        botonInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    selectUsuario = idUsuario;

                    Stage primaryStage = new Stage();
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/GUI/views/requestInformation.fxml"));
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.setTitle("Información usuario");
                        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
                        primaryStage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ConcurrenceRow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSoftwareMásUtilizado() {
        return SoftwareMásUtilizado;
    }

    public void setSoftwareMásUtilizado(String SoftwareMásUtilizado) {
        this.SoftwareMásUtilizado = SoftwareMásUtilizado;
    }

    public String getTiempoTotalDeLosPréstamos() {
        return TiempoTotalDeLosPréstamos;
    }

    public void setTiempoTotalDeLosPréstamos(String TiempoTotalDeLosPréstamos) {
        this.TiempoTotalDeLosPréstamos = TiempoTotalDeLosPréstamos;
    }

    public Button getBotonInfo() {
        return botonInfo;
    }

    public void setBotonInfo(Button botonInfo) {
        this.botonInfo = botonInfo;
    }

}
