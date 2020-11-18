/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Computador;
import Entidad.Programa;
import Entidad.Sala;
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
public class ManageSoftwareTeamsIT {
    
    public ManageSoftwareTeamsIT() {
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
     * Test of mostrarEquipos method, of class ManageSoftwareTeams.
     */
    @Test
    public void testMostrarEquiposNetbeans() {
        Precondiciones.habilitarComputadorProgramaT();
        Precondiciones.ComputadorProgramaNetBeans();
        System.out.println("mostrarEquipos");
        Programa programa = new Programa(1, "NetBeans", "8.2");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        ArrayList<String[]> expResult = new ArrayList();
        String[] computador1 = {"1", "1", "CyT", "304"};
        String[] computador2 = {"2", "1", "CyT", "402"};
        String[] computador3 = {"3", "1", "CyT", "402"};
        expResult.add(computador2);
        expResult.add(computador3);
        expResult.add(computador1);
        ArrayList<String[]> result = instance.mostrarEquipos(programa);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("tamaño del resultado " + result.size());
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            //assertEquals(expResult.get(i)[0], result.get(i)[0]);
            System.out.println("ED c: " + result.get(i)[1] + " y cr: "+ expResult.get(i)[1]);
            //assertEquals(expResult.get(i)[1], result.get(i)[1]);
            System.out.println("E c: " + result.get(i)[2] + " y cr: "+ expResult.get(i)[2]);
            //assertEquals(expResult.get(i)[2], result.get(i)[2]);
            System.out.println("S c: " + result.get(i)[3] + " y cr: "+ expResult.get(i)[3]);
            //assertEquals(expResult.get(i)[3], result.get(i)[3]);
        }
    }
    
    @Test
    public void testMostrarEquiposCodeblocks() {
        Precondiciones.habilitarComputadorProgramaT();
        Precondiciones.ComputadorProgramaCodeblocks();
        System.out.println("mostrarEquipos");
        Programa programa = new Programa(2, "Codeblocks", "4.0");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        ArrayList<String[]> expResult = new ArrayList();
        String[] computador2 = {"2", "1", "CyT", "402"};
        expResult.add(computador2);
        ArrayList<String[]> result = instance.mostrarEquipos(programa);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            System.out.println("ED c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            System.out.println("E c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            System.out.println("S c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
        }
    }
   
    @Test
    public void testMostrarEquiposVisualParadigm() {
        Precondiciones.habilitarComputadorProgramaT();
        Precondiciones.ComputadorProgramaVisualParadigm();
        System.out.println("mostrarEquipos");
        Programa programa = new Programa(3, "VisualParadigm", "4.0");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        ArrayList<String[]> expResult = new ArrayList();
        String[] computador2 = {"2", "1", "CyT", "402"};
        String[] computador3 = {"3", "1", "CyT", "402"};
        expResult.add(computador3);
        expResult.add(computador2);
        ArrayList<String[]> result = instance.mostrarEquipos(programa);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            System.out.println("ED c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            System.out.println("E c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            System.out.println("S c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
        }
    }
    @Test
    public void testMostrarEquiposVim() {
        Precondiciones.habilitarComputadorProgramaT();
        Precondiciones.ComputadorProgramaVim();
        System.out.println("mostrarEquipos");
        Programa programa = new Programa(4, "Vim", "1");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        ArrayList<String[]> expResult = new ArrayList<>();
        String[] computador1 = {"1", "1", "CyT", "304"};
        String[] computador3 = {"3", "1", "CyT", "402"};
        expResult.add(computador1);
        expResult.add(computador3);
        ArrayList<String[]> result = instance.mostrarEquipos(programa);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
        }
    }
    
    /**
     * Test of equiposSinPrograma method, of class ManageSoftwareTeams.
     */
//    @Test
//    public void testEquiposSinPrograma() {
//        System.out.println("equiposSinPrograma");
//        Programa programa = null;
//        ManageSoftwareTeams instance = new ManageSoftwareTeams();
//        ArrayList expResult = null;
//        ArrayList result = instance.equiposSinPrograma(programa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of adherirEquipos method, of class ManageSoftwareTeams.
     */
    @Test
    public void testAdherirEquipos1() {
        Precondiciones.habilitarComputadorProgramaT();
        System.out.println("adherirEquipos1");
        ArrayList<Computador> computadores = new ArrayList<>();
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador2 = new Computador();
        computador2.setId(2);
        computadores.add(computador1);
        computadores.add(computador2);
        Programa programa = new Programa(1, "NetBeans", "8.2");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        boolean expResult = true;
        boolean result = instance.adherirEquipos(computadores, programa);
        assertEquals(expResult, result);
    }

    @Test
    public void testAdherirEquipos2() {
        Precondiciones.habilitarComputadorProgramaT();
        System.out.println("adherirEquipos2");
        ArrayList<Computador> computadores = new ArrayList<>();
        Computador computador1 = new Computador();
        computador1.setId(1);
        Programa programa = new Programa(2, "Codeblocks", "4.0");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        boolean expResult = true;
        boolean result = instance.adherirEquipos(computadores, programa);
        computadores.add(computador1);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAdherirEquipos3() {
        Precondiciones.habilitarComputadorProgramaT();
        System.out.println("adherirEquipos3");
        ArrayList<Computador> computadores = new ArrayList<>();
        Computador computador1 = new Computador();
        computador1.setId(1);
        Computador computador3 = new Computador();
        computador3.setId(3);
        computadores.add(computador1);
        computadores.add(computador3);
        Programa programa = new Programa(3, "VisualParadigm", "4.0");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        boolean expResult = true;
        boolean result = instance.adherirEquipos(computadores, programa);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAdherirEquipos4() {
        Precondiciones.habilitarComputadorProgramaT();
        System.out.println("adherirEquipos4");
        ArrayList<Computador> computadores = new ArrayList<>();
        Computador computador2 = new Computador();
        computador2.setId(2);
        Computador computador3 = new Computador();
        computador3.setId(3);
        computadores.add(computador2);
        computadores.add(computador3);
        Programa programa = new Programa(4, "Vim", "1");
        ManageSoftwareTeams instance = new ManageSoftwareTeams();
        boolean expResult = true;
        boolean result = instance.adherirEquipos(computadores, programa);
        assertEquals(expResult, result);
    }
    /**
     * Test of quitarEquipos method, of class ManageSoftwareTeams.
     */
//    @Test
//    public void testQuitarEquipos1() {
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.ComputadorProgramaNetBeans1();
//        System.out.println("quitarEquipos1");
//        ArrayList<Computador> computadores = new ArrayList<>();
//        Computador computador1 = new Computador();
//        computador1.setId(1);
//        Computador computador2 = new Computador();
//        computador2.setId(2);
//        computadores.add(computador1);
//        computadores.add(computador2);
//        Programa programa = new Programa(1, "NetBeans", "8.2");
//        ManageSoftwareTeams instance = new ManageSoftwareTeams();
//        boolean expResult = true;
//        boolean result = instance.quitarEquipos(computadores, programa);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testQuitarEquipos2() {
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.ComputadorProgramaCodeblocks1();
//        System.out.println("quitarEquipos2");
//        ArrayList<Computador> computadores = new ArrayList<>();
//        Computador computador1 = new Computador();
//        computador1.setId(1);
//        computadores.add(computador1);
//        Programa programa = new Programa(2, "CodeBlocks", "3.0");
//        ManageSoftwareTeams instance = new ManageSoftwareTeams();
//        boolean expResult = true;
//        boolean result = instance.quitarEquipos(computadores, programa);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testQuitarEquipos3() {
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.ComputadorProgramaVisualParadigm1();
//        System.out.println("quitarEquipos3");
//        ArrayList<Computador> computadores = new ArrayList<>();
//        Computador computador1 = new Computador();
//        computador1.setId(1);
//        Computador computador3 = new Computador();
//        computador3.setId(3);
//        computadores.add(computador1);
//        computadores.add(computador3);
//        Programa programa = new Programa(3, "VisualParadigm", "4.0");
//        ManageSoftwareTeams instance = new ManageSoftwareTeams();
//        boolean expResult = true;
//        boolean result = instance.quitarEquipos(computadores, programa);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testQuitarEquipos4() {
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.ComputadorProgramaVim1();
//        System.out.println("quitarEquipos4");
//        ArrayList<Computador> computadores = new ArrayList<>();
//        Computador computador2 = new Computador();
//        computador2.setId(2);
//        Computador computador3 = new Computador();
//        computador3.setId(3);
//        computadores.add(computador2);
//        computadores.add(computador3);
//        Programa programa = new Programa(4, "Vim", "1");
//        ManageSoftwareTeams instance = new ManageSoftwareTeams();
//        boolean expResult = true;
//        boolean result = instance.quitarEquipos(computadores, programa);
//        assertEquals(expResult, result);
//    }
}
