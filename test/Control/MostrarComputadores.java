/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Programa;
import java.util.ArrayList;
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
public class MostrarComputadores {
    
    public MostrarComputadores() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testGetInfoComputers() {
        System.out.println("getInfoComputers");
        ArrayList<Programa> programs = new ArrayList<>();
        programs.add(new Programa(1, "NetBeans", "8.2"));
        RealizarPrestamo instance = new RealizarPrestamo();
        ArrayList<String[]> expResult = new ArrayList<>();
        String[] exp2 ={"2","CyT","1","402"};
        String[] exp3 ={"3","CyT","1","402"};
        expResult.add(exp2);
        expResult.add(exp3);
        ArrayList<String[]> result = instance.getInfoComputers(programs);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j <4 ; j++) {
                assertEquals(expResult.get(i)[0], result.get(i)[0]);
                assertEquals(expResult.get(i)[1], result.get(i)[1]);
                assertEquals(expResult.get(i)[2], result.get(i)[2]);
                assertEquals(expResult.get(i)[3], result.get(i)[3]);
            }
        }
    }
}
