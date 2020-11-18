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
    public void testLeer1() {
        System.out.println("leer1");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setContraseña("Unal2020");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId("acardenaso");
        expResult.setContraseña("Unal2020");
        expResult.setNombres("Ángela María");
        expResult.setApellidos("Cárdenas Orjuela");
        expResult.setCarrera("Ingeniería de Sistemas y Computación");
        expResult.setFacultad("Ingeniería");
        Usuario result = instance.leer(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }
    
    @Test
    public void testLeer2() {
        System.out.println("leer2");
        Usuario usuario = new Usuario();
        usuario.setId("dbustos");
        usuario.setContraseña("123");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId("dbustos");
        expResult.setContraseña("123");
        expResult.setNombres("David Julian");
        expResult.setApellidos("Bustos Cortes");
        expResult.setCarrera("Ingeniería de Sistemas y Computación");
        expResult.setFacultad("Ingeniería");
        Usuario result = instance.leer(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }
    
    @Test
    public void testLeer3() {
        System.out.println("leer3");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        usuario.setContraseña("12345");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId("ggarciaro");
        expResult.setContraseña("12345");
        expResult.setNombres("Gabriela María");
        expResult.setApellidos("García Romero");
        expResult.setCarrera("Ingeniería de Sistemas y Computación");
        expResult.setFacultad("Ingeniería");
        Usuario result = instance.leer(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }
    
    @Test
    public void testLeer4() {
        System.out.println("leer4");
        Usuario usuario = new Usuario();
        usuario.setId("jgarciam");
        usuario.setContraseña("adios");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId("jgarciam");
        expResult.setContraseña("adios");
        expResult.setNombres("Juan Camilo");
        expResult.setApellidos("García Martinez");
        expResult.setCarrera("Ingeniería de Sistemas y Computación");
        expResult.setFacultad("Ingeniería");
        Usuario result = instance.leer(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }
    
    @Test
    public void testLeer5() {
        System.out.println("leer5");
        Usuario usuario = new Usuario();
        usuario.setId("cchavezb");
        usuario.setContraseña("hola");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = new Usuario();
        expResult.setId("cchavezb");
        expResult.setContraseña("hola");
        expResult.setNombres("Cristian Alejandro");
        expResult.setApellidos("Chávez Becerra");
        expResult.setCarrera("Ingeniería de Sistemas y Computación");
        expResult.setFacultad("Ingeniería");
        Usuario result = instance.leer(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }   
}
