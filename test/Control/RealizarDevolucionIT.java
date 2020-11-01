/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
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
public class RealizarDevolucionIT {
    
    public RealizarDevolucionIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeReturn method, of class RealizarDevolucion.
     */
    @Test
    public void testDevolucion() {
        System.out.println("makeReturn");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        RealizarDevolucion instance = new RealizarDevolucion();
        boolean expResult = true;
        boolean result = instance.makeReturn(usuario, 2, true);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFalloDevolucion1() {
        System.out.println("testFalloDevolucion1");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        RealizarDevolucion instance = new RealizarDevolucion();
        boolean expResult = false;
        boolean result = instance.makeReturn(usuario, 2, true);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFalloDevolucion2() {
        System.out.println("testFalloDevolucion2");
        Usuario usuario = new Usuario();
        usuario.setId("cchavezb");
        RealizarDevolucion instance = new RealizarDevolucion();
        boolean expResult = false;
        boolean result = instance.makeReturn(usuario, 3, false);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFalloDevolucion3() {
        System.out.println("testFalloDevolucion3");
        Usuario usuario = new Usuario();
        usuario.setId("jgarciam");
        RealizarDevolucion instance = new RealizarDevolucion();
        boolean expResult = false;
        boolean result = instance.makeReturn(usuario, 3, true);
        assertEquals(expResult, result);
    }

   
    
}
