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
    public void testVerificarLogin() {
        System.out.println("verificarLogin");
        Usuario usuario = new Usuario();
        usuario.setId("acardenaso");
        usuario.setConstraseña("");
        ValidarLogin instance = new ValidarLogin();
        boolean expResult = false;
        boolean result = instance.verificarLogin(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
