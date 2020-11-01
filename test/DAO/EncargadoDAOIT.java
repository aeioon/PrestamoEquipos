/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Encargado;
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
public class EncargadoDAOIT {
    
    public EncargadoDAOIT() {
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
     * Test of crear method, of class EncargadoDAO.
     */
//    @Test
//    public void testCrear() {
//        System.out.println("crear");
//        Encargado object = null;
//        EncargadoDAO instance = new EncargadoDAO();
//        boolean expResult = false;
//        boolean result = instance.crear(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of leer method, of class EncargadoDAO.
     */
    @Test
    public void testLeer() {
        System.out.println("leer");
        Encargado par = new Encargado();
        par.setId("jruiz");
        EncargadoDAO instance = new EncargadoDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizar method, of class EncargadoDAO.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Encargado oldEncargado = null;
//        Encargado newEncargado = null;
//        EncargadoDAO instance = new EncargadoDAO();
//        boolean expResult = false;
//        boolean result = instance.actualizar(oldEncargado, newEncargado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminar method, of class EncargadoDAO.
//     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        Encargado object = null;
//        EncargadoDAO instance = new EncargadoDAO();
//        boolean expResult = false;
//        boolean result = instance.eliminar(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
