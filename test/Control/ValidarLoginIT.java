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
public class ValidarLoginIT {
    
    public ValidarLoginIT() {
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

    /* TESTS SPRING 1*/
    @Test
    public void testUsuarioIncorrecto1() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("DBUSTOS");
        usuario.setContraseña("123");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testUsuarioIncorrecto2() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("Acardenaso");
        usuario.setContraseña("Unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testContraseñaIncorrecta1() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setContraseña("unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testContraseñaIncorrecta2() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        usuario.setContraseña("54321");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosIncorrectos() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("Acardenaso");
        usuario.setContraseña("unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosCorrectos1() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        usuario.setContraseña("12345");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = true;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosCorrectos2() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("dbustos");
        usuario.setContraseña("123");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = true;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosCorrectos3() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setContraseña("Unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = true;
        boolean result = instance.verificarUsuario(usuario) != null;
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    /* TESTS SPRING 2*/
    /**
     * Test of verificarUsuario method, of class ValidarLogin.
     */
    @Test
    public void testVerificarUsuario1() {
        System.out.println("verificarUsuario");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setContraseña("Unal2020");
        ValidarLogin instance = new ValidarLogin();
        Usuario expResult = new Usuario();
        expResult.setId("acardenaso");
        expResult.setContraseña("Unal2020");
        expResult.setNombres("Ángela María");
        expResult.setApellidos("Cárdenas Orjuela");
        expResult.setCarrera("Ingeniería de Sistemas y Computación");
        expResult.setFacultad("Ingeniería");
        Usuario result = instance.verificarUsuario(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }

    @Test
    public void testVerificarUsuario2() {
        System.out.println("verificarUsuario");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        usuario.setContraseña("12345");
        ValidarLogin instance = new ValidarLogin();
        Usuario expResult = new Usuario("ggarciaro", "12345", "Gabriela María", "García Romero", "Ingeniería de Sistemas y Computación", "Ingeniería", 0);
        Usuario result = instance.verificarUsuario(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }

    @Test
    public void testVerificarUsuario3() {
        System.out.println("verificarUsuario");
        Usuario usuario = new Usuario();
        usuario.setId("jgarciam");
        usuario.setContraseña("adios");
        ValidarLogin instance = new ValidarLogin();
        Usuario expResult = new Usuario("jgarciam", "adios", "Juan Camilo", "García Martinez", "Ingeniería de Sistemas y Computación", "Ingeniería", 0);
        Usuario result = instance.verificarUsuario(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }

    @Test
    public void testVerificarUsuario4() {
        System.out.println("verificarUsuario");
        Usuario usuario = new Usuario();
        usuario.setId("cchavezb");
        usuario.setContraseña("hola");
        ValidarLogin instance = new ValidarLogin();
        Usuario expResult = new Usuario("cchavezb", "hola", "Cristian Alejandro", "Chávez Becerra", "Ingeniería de Sistemas y Computación", "Ingeniería", 0);
        Usuario result = instance.verificarUsuario(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }

    @Test
    public void testVerificarUsuario5() {
        System.out.println("verificarUsuario");
        Usuario usuario = new Usuario();
        usuario.setId("dbustos");
        usuario.setContraseña("123");
        ValidarLogin instance = new ValidarLogin();
        Usuario expResult = new Usuario("dbustos", "123", "David Julian", "Bustos Cortes", "Ingeniería de Sistemas y Computación", "Ingeniería", 0);
        Usuario result = instance.verificarUsuario(usuario);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContraseña(), result.getContraseña());
        assertEquals(expResult.getNombres(), result.getNombres());
        assertEquals(expResult.getApellidos(), result.getApellidos());
        assertEquals(expResult.getCarrera(), result.getCarrera());
        assertEquals(expResult.getFacultad(), result.getFacultad());
    }

}
