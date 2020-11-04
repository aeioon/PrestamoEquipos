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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class RealizarPrestamoIT {
    
    public RealizarPrestamoIT() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of getAllPrograms method, of class RealizarPrestamo.
     */
    @Test
    public void testGetAllPrograms() {
        System.out.println("getAllPrograms");
        RealizarPrestamo instance = new RealizarPrestamo();
        ArrayList<Programa> expResult = new ArrayList<>();
        expResult.add(new Programa(1, "NetBeans", "8.2"));
        expResult.add(new Programa(2, "CodeBlocks", "3.0"));
        expResult.add(new Programa(3, "VisualParadigm", "4.0"));
        ArrayList<Programa> result = instance.getAllPrograms();
        assertEquals(result, expResult);
    }

    /**
     * Test of makeBorrow method, of class RealizarPrestamo.
     */
    
    
    //Caso A
    @Test
    public void testPrestamoEsudianteNoDisponibleyComputadorDisponible1CasoA() {
        System.out.println("makeBorrow");
        Usuario usuario = new Usuario();
        usuario.setId("cchavezb");
        Computador computer = new Computador();
        computer.setId(3);
        ArrayList<Programa> programs = new ArrayList<>();
        programs.add(new Programa(1, "NetBeans", "8.2"));
        RealizarPrestamo instance = new RealizarPrestamo();
        boolean expResult = false;
        boolean result = instance.makeBorrow(usuario, computer, programs, true);
        System.out.println("Resultado:" + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrestamoEsudianteyComputadorDisponible1CasoA() {
        System.out.println("makeBorrow");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        Computador computer = new Computador();
        computer.setId(2);
        ArrayList<Programa> programs = new ArrayList<>();
        programs.add(new Programa(2, "CodeBlocks", "3.0"));
        RealizarPrestamo instance = new RealizarPrestamo();
        boolean expResult = true;
        boolean result = instance.makeBorrow(usuario, computer, programs, false);
        System.out.println("Resultado:" + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrestamoEsudianteyComputadorDisponible2CasoA() {
        System.out.println("makeBorrow");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        Computador computer = new Computador();
        computer.setId(3);
        ArrayList<Programa> programs = new ArrayList<>();
        programs.add(new Programa(1, "NetBeans", "8.2"));
        RealizarPrestamo instance = new RealizarPrestamo();
        boolean expResult = true;
        boolean result = instance.makeBorrow(usuario, computer, programs, false);
        System.out.println("Resultado:" + result);
        assertEquals(expResult, result);
    }
    
    //Caso B
    @Test
    public void testPrestamoEsudianteNoDisponibleyComputadorDisponible1CasoB() {
        System.out.println("makeBorrow");
        Usuario usuario = new Usuario();
        usuario.setId("dbustos");
        Computador computer = new Computador();
        computer.setId(2);
        ArrayList<Programa> programs = new ArrayList<>();
        programs.add(new Programa(3,"VisualParadigm", "4.0"));
        RealizarPrestamo instance = new RealizarPrestamo();
        boolean expResult = false;
        boolean result = instance.makeBorrow(usuario, computer, programs, true);
        System.out.println("Resultado:" + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrestamoEsudianteNoDisponibleyComputadorDisponible2CasoB() {
        System.out.println("makeBorrow");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        Computador computer = new Computador();
        computer.setId(2);
        ArrayList<Programa> programs = new ArrayList<>();
        programs.add(new Programa(2, "CodeBlocks", "3.0"));
        RealizarPrestamo instance = new RealizarPrestamo();
        boolean expResult = false;
        boolean result = instance.makeBorrow(usuario, computer, programs, true);
        System.out.println("Resultado:" + result);
        assertEquals(expResult, result);
    }
    
    
    
    
    
}
