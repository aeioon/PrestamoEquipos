/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Edificio;
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
public class EdificioDAOIT {
    
    public EdificioDAOIT() {
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
    
    @Test
    public void testLeer1() {
        System.out.println("leer");
        Edificio par = new Edificio();
        par.setId(1);
        EdificioDAO instance = new EdificioDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLeer2() {
        System.out.println("leer");
        Edificio par = new Edificio();
        par.setId(25);
        EdificioDAO instance = new EdificioDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }

    /**
     * Test of crear method, of class EdificioDAO.
     */
//    @Test
//    public void testCrear() {
//        System.out.println("crear");
//        Edificio object = null;
//        EdificioDAO instance = new EdificioDAO();
//        boolean expResult = false;
//        boolean result = instance.crear(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
 //   @Test
//    public void testCreate() {
//        Edificio edificio = new Edificio();
//        edificio.setCodigo(454);
//        edificio.setNombre("Ciencia y tecnología");
//        boolean expResult = true;
//        boolean result = inst.crear(edificio);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of leer method, of class EdificioDAO.
     */

    /**
     * Test of actualizar method, of class EdificioDAO.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Edificio oldEd = null;
//        Edificio newEd = null;
//        EdificioDAO instance = new EdificioDAO();
//        boolean expResult = false;
//        boolean result = instance.actualizar(oldEd, newEd);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of eliminar method, of class EdificioDAO.
     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        Edificio object = null;
//        EdificioDAO instance = new EdificioDAO();
//        boolean expResult = false;
//        boolean result = instance.eliminar(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
//     @Test
//    public void testCreate() {
//        Edificio edificio = new Edificio();
//        edificio.setCodigo(454);
//        edificio.setNombre("Ciencia y tecnología");
//        boolean expResult = true;
//        boolean result = inst.crear(edificio);
//        assertEquals(expResult, result);
//    }
    
}
