/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Sala;
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
public class SalaDAOIT {
    
    public SalaDAOIT() {
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
     * Test of leer method, of class SalaDAO.
     */
    @Test
    public void testLeer() {
        System.out.println("leer");
        Sala par = new Sala();
        par.setId(1);
        SalaDAO instance = new SalaDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLeer2() {
        System.out.println("leer");
        Sala par = new Sala();
        par.setId(2);
        SalaDAO instance = new SalaDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }

    /**
     * Test of crear method, of class SalaDAO.
     */
//    @Test
//    public void testCrear() {
//        System.out.println("crear");
//        Sala object = new Sala();
//        SalaDAO instance = new SalaDAO();
//        boolean expResult = false;
//        boolean result = instance.crear(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of actualizar method, of class SalaDAO.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Sala oldSala = null;
//        Sala newSala = null;
//        SalaDAO instance = new SalaDAO();
//        boolean expResult = false;
//        boolean result = instance.actualizar(oldSala, newSala);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of eliminar method, of class SalaDAO.
     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        Sala object = null;
//        SalaDAO instance = new SalaDAO();
//        boolean expResult = false;
//        boolean result = instance.eliminar(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
