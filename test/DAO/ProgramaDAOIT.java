/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class ProgramaDAOIT {
    
    public ProgramaDAOIT() {
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
     * Test of crear method, of class ProgramaDAO.
     */
//    @Test
//    public void testCrear() {
//        System.out.println("crear");
//        Programa object = new Programa();
//        object.setNombre("Acces");
//        object.setVersion("6.0");
//        ProgramaDAO instance = new ProgramaDAO();
//        boolean expResult = true;
//        boolean result = instance.crear(object);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of leer method, of class ProgramaDAO.
     */
    @Test
    public void testLeer1() {
        System.out.println("leer1");
        Programa par = new Programa();
        par.setId(1);
        ProgramaDAO instance = new ProgramaDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLeer2() {
        System.out.println("leer2");
        Programa par = new Programa();
        par.setId(2);
        ProgramaDAO instance = new ProgramaDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLeer3() {
        System.out.println("leer3");
        Programa par = new Programa();
        par.setId(3);
        ProgramaDAO instance = new ProgramaDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizar method, of class ProgramaDAO.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Programa oldPrograma = new Programa();
//        oldPrograma.setId(6);
//        Programa newPrograma = new Programa();
//        newPrograma.setNombre("Soft5");
//        newPrograma.setVersion("ver2");
//        ProgramaDAO instance = new ProgramaDAO();
//        boolean expResult = true;
//        boolean result = instance.actualizar(oldPrograma, newPrograma);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of eliminar method, of class ProgramaDAO.
//     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        Programa object = new Programa();
//        object.setId(9);
//        ProgramaDAO instance = new ProgramaDAO();
//        boolean expResult = true;
//        boolean result = instance.eliminar(object);
//        assertEquals(expResult, result);
//    }
    
}
