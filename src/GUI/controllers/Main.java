package GUI.controllers;

import Control.RealizarPrestamo;
import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ion
 */
public class Main extends Application  {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    void testBorrow(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        Computador c = new Computador();
        c.setId(2);
        ArrayList<Programa> p = new ArrayList<>();
        RealizarPrestamo RP = new RealizarPrestamo();
        System.out.println(RP.makeBorrow(u, c, p));
    }
    
    void testReturn(){
        
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        testBorrow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/views/loanRequest.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prestamo de equipos de computo");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
        primaryStage.show();
    }
    
}
