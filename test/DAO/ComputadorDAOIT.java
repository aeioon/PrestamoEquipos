/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Computador;
import Entidad.Programa;
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
public class ComputadorDAOIT {
    
    public ComputadorDAOIT() {
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
        Computador par = new Computador();
        par.setId(1);
        ComputadorDAO instance = new ComputadorDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLeer2() {
        System.out.println("leer");
        Computador par = new Computador();
        par.setId(2);
        ComputadorDAO instance = new ComputadorDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLeer3() {
        System.out.println("leer");
        Computador par = new Computador();
        par.setId(3);
        ComputadorDAO instance = new ComputadorDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }

    /**
     * Test of crear method, of class ComputadorDAO.
     */
//    @Test
//    public void testCrear() {
//        System.out.println("crear");
//        Computador object = null;
//        ComputadorDAO instance = new ComputadorDAO();
//        boolean expResult = false;
//        boolean result = instance.crear(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of leer method, of class ComputadorDAO.
     */

    /**
     * Test of actualizar method, of class ComputadorDAO.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Computador oldComp = null;
//        Computador newComp = null;
//        ComputadorDAO instance = new ComputadorDAO();
//        boolean expResult = false;
//        boolean result = instance.actualizar(oldComp, newComp);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminar method, of class ComputadorDAO.
//     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        Computador object = null;
//        ComputadorDAO instance = new ComputadorDAO();
//        boolean expResult = false;
//        boolean result = instance.eliminar(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of occupyComputer method, of class ComputadorDAO.
     */
//    @Test
//    public void testOccupyComputer() {
//        System.out.println("occupyComputer");
//        Computador computer = null;
//        ComputadorDAO instance = new ComputadorDAO();
//        boolean expResult = false;
//        boolean result = instance.occupyComputer(computer);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of freeComputer method, of class ComputadorDAO.
//     */
//    @Test
//    public void testFreeComputer() {
//        System.out.println("freeComputer");
//        int computer = 0;
//        ComputadorDAO instance = new ComputadorDAO();
//        boolean expResult = false;
//        boolean result = instance.freeComputer(computer);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getInfoComputersAvailable method, of class ComputadorDAO.
//     */
//    @Test
//    public void testGetInfoComputersAvailable() {
//        System.out.println("getInfoComputersAvailable");
//        ArrayList<Programa> programs = null;
//        ComputadorDAO instance = new ComputadorDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getInfoComputersAvailable(programs);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
