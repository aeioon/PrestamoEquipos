/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Computador;
import Entidad.Programa;
import Entidad.Usuario;
import Control.ManageSoftwareTeams;
import java.time.LocalDateTime;
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
        System.out.println(RP.makeBorrow(u, c, p,LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
    }
    
    public void testReturn(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn11(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(1);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn12(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(1);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn13(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(1);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn21(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn22(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn23(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(2);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn31(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn32(){
        Usuario u = new Usuario();
        u.setId("jgarciam");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn33(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn34(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(3);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn41(){
        Usuario u = new Usuario();
        u.setId("dbustos");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn42(){
        Usuario u = new Usuario();
        u.setId("acardenaso");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn43(){
        Usuario u = new Usuario();
        u.setId("ggarciaro");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(computador, true));
    }
    
    public static void testReturn44(){
        Usuario u = new Usuario();
        u.setId("jgarciam");
        RealizarDevolucion RD = new RealizarDevolucion();
        Computador computador = new Computador();
        computador.setId(4);
        System.out.println(RD.makeReturn(computador, true));
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
        testReturn23();
        testReturn31();
        testReturn32();
        testReturn33();
        testReturn34();
        testReturn41();
        testReturn42();
        testReturn43();
    }
    
    public static void habilitarComputadorPrograma1(){
        Programa programa = new Programa();
        programa.setId(1);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        Computador computador4 = new Computador();
        computador4.setId(4);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        computadores.add(computador3);
        computadores.add(computador4);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.quitarEquipos(computadores, programa);
    }
    
    public static void habilitarComputadorPrograma2(){
        Programa programa = new Programa();
        programa.setId(2);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        Computador computador4 = new Computador();
        computador4.setId(4);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        computadores.add(computador3);
        computadores.add(computador4);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.quitarEquipos(computadores, programa);
    }
    
    public static void habilitarComputadorPrograma3(){
        Programa programa = new Programa();
        programa.setId(3);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        Computador computador4 = new Computador();
        computador4.setId(4);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        computadores.add(computador3);
        computadores.add(computador4);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.quitarEquipos(computadores, programa);
    }
    
    public static void habilitarComputadorPrograma4(){
        Programa programa = new Programa();
        programa.setId(4);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        Computador computador4 = new Computador();
        computador4.setId(4);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        computadores.add(computador3);
        computadores.add(computador4);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.quitarEquipos(computadores, programa);
    }
    
    public static void habilitarComputadorPrograma21(){
        Programa programa = new Programa();
        programa.setId(21);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        Computador computador4 = new Computador();
        computador4.setId(4);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        computadores.add(computador3);
        computadores.add(computador4);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.quitarEquipos(computadores, programa);
    }
    
    public static void habilitarComputadorProgramaT(){
        habilitarComputadorPrograma1();
        habilitarComputadorPrograma2();
        habilitarComputadorPrograma3();
        habilitarComputadorPrograma4();
        habilitarComputadorPrograma21();
    }
    
    public static void ComputadorProgramaNetBeans(){
        Programa programa = new Programa();
        programa.setId(1);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        computadores.add(computador3);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaCodeblocks(){
        Programa programa = new Programa();
        programa.setId(2);
        
        Computador computador2 = new Computador();
        computador2.setId(2);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador2);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaVisualParadigm(){
        Programa programa = new Programa();
        programa.setId(3);
        
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador2);
        computadores.add(computador3);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaVim(){
        Programa programa = new Programa();
        programa.setId(4);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador3 = new Computador();
        computador3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador3);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaNetBeans1(){
        Programa programa = new Programa();
        programa.setId(1);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador2);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaCodeblocks1(){
        Programa programa = new Programa();
        programa.setId(2);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaVisualParadigm1(){
        Programa programa = new Programa();
        programa.setId(3);
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador3 = new Computador();
        computador3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        computadores.add(computador3);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    public static void ComputadorProgramaVim1(){
        Programa programa = new Programa();
        programa.setId(4);
        
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador2);
        computadores.add(computador3);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa);
    }
    
    
    public static void MostrarConcurrencia1(){
        testBorrow("acardenaso", 3);
        testBorrow("ggarciaro", 4);
    }
    
    public static void MostrarConcurrencia2(){
        testBorrow("acardenaso", 1);
        testBorrow("ggarciaro", 3);
    }
    
    public static void MostrarConcurrencia3(){
        testBorrow("acardenaso", 2);
        testBorrow("ggarciaro", 3);
    }
    
    public static void MostrarPorcentage1(){
        testBorrow("acardenaso", 1);
    }
    
    public static void MostrarPorcentage2(){
        testBorrow("acardenaso", 1);
        testBorrow("ggarciaro", 2);
    }
    
    public static void MostrarPorcentage3(){
        testBorrow("acardenaso", 1);
        testBorrow("ggarciaro", 2);
        testBorrow("dbustos", 3);
    }
    
    public static void MostrarPorcentage4(){
        testBorrow("acardenaso", 1);
        testBorrow("ggarciaro", 2);
        testBorrow("dbustos", 3);
        testBorrow("jgarciam", 4);
    }
    
    public static void Computador1(){
        
        Computador computador1 = new Computador();
        computador1.setId(1);
        
        Programa programa1 = new Programa();
        programa1.setId(1);
        Programa programa2 = new Programa();
        programa2.setId(2);
        Programa programa3 = new Programa();
        programa3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa1);
        MST.adherirEquipos(computadores, programa2);
        MST.adherirEquipos(computadores, programa3);
    }
    
    public static void Computador2(){
        
        Computador computador1 = new Computador();
        computador1.setId(2);
        
        Programa programa1 = new Programa();
        programa1.setId(1);
        Programa programa2 = new Programa();
        programa2.setId(2);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa1);
        MST.adherirEquipos(computadores, programa2);
    }
    
    public static void Computador3(){
        
        Computador computador1 = new Computador();
        computador1.setId(3);
        
        Programa programa1 = new Programa();
        programa1.setId(1);
        Programa programa3 = new Programa();
        programa3.setId(3);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa1);
        MST.adherirEquipos(computadores, programa3);
    }
    
    public static void Computador4(){
        
        Computador computador1 = new Computador();
        computador1.setId(4);
        
        Programa programa1 = new Programa();
        programa1.setId(1);
        
        ArrayList<Computador> computadores = new ArrayList<>();
        computadores.add(computador1);
        
        ManageSoftwareTeams MST = new ManageSoftwareTeams();
        MST.adherirEquipos(computadores, programa1);
    }
}
