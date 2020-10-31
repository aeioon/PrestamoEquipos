package GUI.controllers;

import Control.RealizarDevolucion;
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
    
    private static Usuario usuarioLogueado;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    void testBorrow(String userId, int computerId){
        Usuario u = new Usuario();
        u.setId(userId);
        Computador c = new Computador();
        c.setId(computerId);
        ArrayList<Programa> p = new ArrayList<>();
        p.add(new Programa(1, "NetBeans", "8.2"));
        RealizarPrestamo RP = new RealizarPrestamo();
        System.out.println(RP.makeBorrow(u, c, p));
    }
    
    void testReturn(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u));
        System.out.println(RD.getInfoIdEquipo()+" "+RD.getInfoIdEdificio()+" "+RD.getInfoCodigoSala()+" "+RD.getInfoNombreEdificio());
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        testReturn();
        testBorrow("dbustos", 1);
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/views/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prestamo de equipos de computo");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
        primaryStage.show();
    }
    
}
