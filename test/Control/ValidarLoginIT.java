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

    /**
     * Test of verificarLogin method, of class ValidarLogin.
     */
    @Test
    public void testUsuarioIncorrecto1() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("DBUSTOS");
        usuario.setConstraseña("123");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testUsuarioIncorrecto2() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("Acardenaso");
        usuario.setConstraseña("Unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testContraseñaIncorrecta1() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setConstraseña("unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testContraseñaIncorrecta2() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        usuario.setConstraseña("54321");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosIncorrectos() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("Acardenaso");
        usuario.setConstraseña("unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosCorrectos1() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("ggarciaro");
        usuario.setConstraseña("12345");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = true;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosCorrectos2() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("dbustos");
        usuario.setConstraseña("123");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = true;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDatosCorrectos3() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setConstraseña("Unal2020");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = true;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
