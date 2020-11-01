/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        System.out.println("crear");
        Solicitud object = new Solicitud();
        Usuario usuario = new Usuario();
        usuario.setId("jgarciam");
        Computador computador = new Computador();
        computador.setId(3);
        object.setUsuario(usuario);
        object.setComputador(computador);
        SolicitudD instance = new SolicitudD();
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
        par.setId(106);
        SolicitudD instance = new SolicitudD();
        boolean expResult = true;
        boolean result = instance.leer(par);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfo method, of class SolicitudDAO.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Usuario user = new Usuario();
        user.setId("acardenaso");
        SolicitudD instance = new SolicitudD();
        String[] expResult ={"2","1","CyT","1"};
        String[] result = instance.getInfo(user);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of actualizar method, of class SolicitudDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Solicitud oldSolicitud = new Solicitud();
        oldSolicitud.setId(109);
        Solicitud newSolicitud = new Solicitud();
        newSolicitud.setEstado(0);
        SolicitudD instance = new SolicitudD();
        boolean expResult = true;
        boolean result = instance.actualizar(oldSolicitud, newSolicitud);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminar method, of class SolicitudDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Solicitud object = new Solicitud();
        object.setId(123);
        SolicitudD instance = new SolicitudD();
        boolean expResult = true;
        boolean result = instance.eliminar(object);
        assertEquals(expResult, result);
    }
    
}
