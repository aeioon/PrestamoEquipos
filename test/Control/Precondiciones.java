/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Precondiciones {
    
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
    
    
}
