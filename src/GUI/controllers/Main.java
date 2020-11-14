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
    
    public static void testBorrow(String userId, int computerId){
        Usuario u = new Usuario();
        u.setId(userId);
        Computador c = new Computador();
        c.setId(computerId);
        ArrayList<Programa> p = new ArrayList<>();
        p.add(new Programa(1, "NetBeans", "8.2"));
        //p.add(new Programa(2, "CodeBlocks", "3.0"));
        RealizarPrestamo RP = new RealizarPrestamo();
        System.out.println(RP.makeBorrow(u, c, p));
    }
    
    void testReturn(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 2, true));
    }
    
    public static void testReturn11(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 1, true));
    }
    
    public static void testReturn12(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 1, true));
    }
    
    public static void testReturn21(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 2, true));
    }
    
    public static void testReturn22(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 2, true));
    }
    
    public static void testReturn31(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 3, true));
    }
    
    public static void testReturn32(){
        Usuario u = new Usuario();
        u.setId("jgarciam");
        RealizarDevolucion RD = new RealizarDevolucion();
        System.out.println(RD.makeReturn(u, 3, true));
    }
    
    public static void precondicionesPrestamoCasoA(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32();        
        testBorrow("cchavez", 1);
    }
    
    public static void precondicionesPrestamoCasoB(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32(); 
        testBorrow("dbustos", 1);
        testBorrow("ggarciaro", 3);
    }
    
    public static void precondicionesDevolucion(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32(); 
        testBorrow("dbustos", 2);
        testBorrow("acardenaso", 1);
    }
    
    public static void precondicionesMostrarComputadores1(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32(); 
        testBorrow("ggarciaro", 3);
    }
    
    public static void precondicionesMostrarComputadores2(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32(); 
        testBorrow("ggarciaro", 3);
        testBorrow("dbustos", 2);
    }
    
    public static void precondicionesMostrarSolicitud(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32(); 
        testBorrow("acardenaso", 1);
    }
    
    public static void habilitarDisponibilidad(){
        testReturn11();
        testReturn12();
        testReturn21();
        testReturn22();
        testReturn31();
        testReturn32();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //habilitarDisponibilidad();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/views/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prestamo de equipos de computo");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logotipo_UN_16.png")));
        primaryStage.show();
    }
    
}
