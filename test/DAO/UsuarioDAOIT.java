/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class UsuarioDAOIT {
    
    public UsuarioDAOIT() {
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
     * Test of leer method, of class UsuarioDAO.
     */
    @Test
    public void testLeer() {
        System.out.println("leer");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setConstraseña("Unal2020");
        UsuarioDAO instance = new UsuarioDAO();
        boolean expResult = true;
        boolean result = instance.validar(usuario);
        assertEquals(expResult, result);
    }
    
}
