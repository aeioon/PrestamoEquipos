/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.EdificioDAO;
import Entidad.Edificio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriela
 */
public class TestCRUDEdificio {
    
    EdificioDAO dao = new EdificioDAO();
    
    public TestCRUDEdificio() {
    }

    @Test
    public void testCreate() {
        Edificio edificio = new Edificio();
        edificio.setCodigo(454);
        edificio.setNombre("Ciencia y tecnología");
        boolean expResult = true;
        boolean result = dao.crear(edificio);
        assertEquals(expResult, result);
    }
}
