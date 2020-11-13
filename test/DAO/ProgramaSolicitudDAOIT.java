/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Programa;
import Entidad.Solicitud;
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
public class ProgramaSolicitudDAOIT {
    
    public ProgramaSolicitudDAOIT() {
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
     * Test of crear method, of class ProgramaSolicitudDAO.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        Programa programa = new Programa();
        programa.setId(1);
        Solicitud solicitud = new Solicitud();
        solicitud.setId(168);
        ProgramaSolicitudDAO instance = new ProgramaSolicitudDAO();
        boolean expResult = true;
        boolean result = instance.crear(programa, solicitud);
        assertEquals(expResult, result);
    }
    
}
