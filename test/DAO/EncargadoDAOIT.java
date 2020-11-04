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
    
}
