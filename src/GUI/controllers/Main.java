package GUI.controllers;

import Control.ManageSoftwareTeams;
import Control.RealizarDevolucion;
import Control.RealizarPrestamo;
import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import java.time.LocalDateTime;
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
    
     public static void testBorrow(String userId, int computerId){
        Usuario u = new Usuario();
        u.setId(userId);
        Computador c = new Computador();
        c.setId(computerId);
        ArrayList<Programa> p = new ArrayList<>();
        p.add(new Programa(1, "NetBeans", "8.2"));
        //p.add(new Programa(2, "CodeBlocks", "3.0"));
        RealizarPrestamo RP = new RealizarPrestamo();
        System.out.println(RP.makeBorrow(u, c, p,LocalDateTime.now(), LocalDateTime.now()));
    }
    
    public void testReturn(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn11(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(1);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn12(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(1);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn13(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(1);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn21(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn22(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn23(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn31(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn32(){
        Usuario u = new Usuario();
        u.setId("jgarciam");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn33(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn34(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn41(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn42(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void testReturn43(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(u, computador, true));
    }
    
    public static void habilitarDisponibilidad(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn23();
        testReturn31();
        testReturn32();
        testReturn33();
        testReturn34();
        testReturn41();
        testReturn42();
        testReturn43();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        habilitarDisponibilidad();
        testBorrow("acardenaso", 3);
        testBorrow("ggarciaro", 4);
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/views/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prestamo de equipos de computo");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
        primaryStage.show();
    }
    
}
