package DAO;

import Entidad.Computador;
import Entidad.Solicitud;
import Entidad.Usuario;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
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
public class SolicitudDAOIT {
    
    public SolicitudDAOIT() {
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
     * Test of crear method, of class SolicitudDAO.
     */
    @Test
    public void testCrear() {
        Control.Precondiciones.habilitarDisponibilidad();
        System.out.println("crear");
        Solicitud object = new Solicitud();
        Usuario usuario = new Usuario();
        usuario.setId("jgarciam");
        Computador computador = new Computador();
        computador.setId(3);
        object.setUsuario(usuario);
        object.setComputador(computador);
        SolicitudDAO instance = new SolicitudDAO();
        boolean expResult = true;
        boolean result = instance.crear(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of leer method, of class SolicitudDAO.
     */
    @Test
    public void testLeer() {
        System.out.println("leer");
        Solicitud par = new Solicitud();
        par.setId(98);
        SolicitudDAO instance = new SolicitudDAO();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    } 

    /**
     * Test of eliminar method, of class SolicitudDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Solicitud object = new Solicitud();
        object.setId(106);
        SolicitudDAO instance = new SolicitudDAO();
        boolean expResult = true;
        boolean result = instance.eliminar(object);
        assertEquals(expResult, result);
    }
    
}
