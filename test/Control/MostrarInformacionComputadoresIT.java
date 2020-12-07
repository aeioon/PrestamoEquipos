/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Computador;
import GUI.controllers.ConcurrenceController;
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
public class MostrarInformacionComputadoresIT {
    
    public MostrarInformacionComputadoresIT() {
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
     * Test of getConcurrenceInfo method, of class MostrarInformacionComputadores.
     */
    @Test
    public void testGetConcurrenceInfo1() {
        Precondiciones.habilitarDisponibilidad();
        Precondiciones.MostrarConcurrencia1();
        System.out.println("getConcurrenceInfo");
        MostrarConcurrencia instance = new MostrarConcurrencia();
        ArrayList<String[]>  expResult = new ArrayList<>();
        String[] computador1 = {"1", " ", "CyT", "304", "0"};
        String[] computador2 = {"2", " ", "CyT", "402", "0"};
        String[] computador3 = {"3", "acardenaso", "CyT", "402", "0"};
        String[] computador4 = {"4", "ggarciaro", "CyT", "304", "0"};
        expResult.add(computador2);
        expResult.add(computador3);
        expResult.add(computador1);
        expResult.add(computador4);
        ArrayList<String[]>  result = instance.getConcurrenceInfo();
        for (int i = 0; i < result.size(); i++) {
            System.out.println("resultado es: "+ result.get(i)[0]);
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
            assertEquals(expResult.get(i)[4], result.get(i)[4]);
        }
    }
    
    @Test
    public void testGetConcurrenceInfo2() {
        Precondiciones.habilitarDisponibilidad();
        Precondiciones.MostrarConcurrencia2();
        System.out.println("getConcurrenceInfo");
        MostrarConcurrencia instance = new MostrarConcurrencia();
        ArrayList<String[]> expResult = new ArrayList<>();
        String[] computador1 = {"1", "acardenaso", "CyT", "304", "0"};
        String[] computador2 = {"2", " ", "CyT", "402", "0"};
        String[] computador3 = {"3", "ggarciaro", "CyT", "402", "0"};
        String[] computador4 = {"4", " ", "CyT", "304", "0"};
        expResult.add(computador2);
        expResult.add(computador3);
        expResult.add(computador1);
        expResult.add(computador4);
        ArrayList<String[]> result = instance.getConcurrenceInfo();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
            assertEquals(expResult.get(i)[4], result.get(i)[4]);
        }
    }

    @Test
    public void testGetConcurrenceInfo3() {
        Precondiciones.habilitarDisponibilidad();
        Precondiciones.MostrarConcurrencia3();
        System.out.println("getConcurrenceInfo");
        MostrarConcurrencia instance = new MostrarConcurrencia();
        ArrayList<String[]> expResult = new ArrayList<>();
        String[] computador1 = {"1", " ", "CyT", "304", "0"};
        String[] computador2 = {"2", "acardenaso", "CyT", "402", "0"};
        String[] computador3 = {"3", "ggarciaro", "CyT", "402", "0"};
        String[] computador4 = {"4", " ", "CyT", "304", "0"};
        expResult.add(computador2);
        expResult.add(computador3);
        expResult.add(computador1);
        expResult.add(computador4);
        ArrayList<String[]> result = instance.getConcurrenceInfo();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
            assertEquals(expResult.get(i)[4], result.get(i)[4]);
        }
    }

    @Test
    public void testGetConcurrenceInfo4() {
        Precondiciones.habilitarDisponibilidad();
        System.out.println("getConcurrenceInfo");
        MostrarConcurrencia instance = new MostrarConcurrencia();
        ArrayList<String[]> expResult = new ArrayList<>();
        String[] computador1 = {"1", " ", "CyT", "304", "0"};
        String[] computador2 = {"2", " ", "CyT", "402", "0"};
        String[] computador3 = {"3", " ", "CyT", "402", "0"};
        String[] computador4 = {"4", " ", "CyT", "304", "0"};
        expResult.add(computador2);
        expResult.add(computador3);
        expResult.add(computador1);
        expResult.add(computador4);
        ArrayList<String[]> result = instance.getConcurrenceInfo();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
            assertEquals(expResult.get(i)[3], result.get(i)[3]);
            assertEquals(expResult.get(i)[4], result.get(i)[4]);
        }
    }

    /**
     * Test of getConcurrencePercentage method, of class MostrarInformacionComputadores.
     */
//    @Test
//    public void testGetConcurrencePercentage1() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.MostrarPorcentage1();
//        System.out.println("getConcurrencePercentage");
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        double expResult = 0.25;
//        double result = instance.getConcurrencePercentage();
//        System.out.println("Resultado: " + result);
//        assertEquals(expResult, result,0.0);
//    }
//    
//    @Test
//    public void testGetConcurrencePercentage2() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.MostrarPorcentage2();
//        System.out.println("getConcurrencePercentage");
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        double expResult = 0.5;
//        double result = instance.getConcurrencePercentage();
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testGetConcurrencePercentage3() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.MostrarPorcentage3();
//        System.out.println("getConcurrencePercentage");
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        double expResult = 0.75;
//        double result = instance.getConcurrencePercentage();
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testGetConcurrencePercentage4() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.MostrarPorcentage4();
//        System.out.println("getConcurrencePercentage");
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        double expResult = 1;
//        double result = instance.getConcurrencePercentage();
//        assertEquals(expResult, result,0.0);
//    }
//    
//    @Test
//    public void testGetConcurrencePercentage5() {
//        Precondiciones.habilitarDisponibilidad();
//        System.out.println("getConcurrencePercentage");
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        double expResult = 0;
//        double result = instance.getConcurrencePercentage();
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of getHoleComputerInfo method, of class MostrarInformacionComputadores.
//     */
//    @Test
//    public void testGetHoleComputerInfo1() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.MostrarPorcentage1();
//        System.out.println("getHoleComputerInfo");
//        Computador computer = new Computador();
//        computer.setId(1);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        String[] expResult = {"1","acardenaso","CyT","304","0","Hard","jruiz","Juan","Ruiz"};
//        String[] result = instance.getHoleComputerInfo(computer);
//            assertEquals(expResult[0], result[0]);
//            assertEquals(expResult[1], result[1]);
//            assertEquals(expResult[2], result[2]);
//            assertEquals(expResult[3], result[3]);
//            assertEquals(expResult[4], result[4]);
//            assertEquals(expResult[5], result[5]);
//            assertEquals(expResult[6], result[6]);
//            assertEquals(expResult[7], result[7]);
//            assertEquals(expResult[8], result[8]);
//    }
//    
//    @Test
//    public void testGetHoleComputerInfo2() {
//        Precondiciones.habilitarDisponibilidad();
//        System.out.println("getHoleComputerInfo");
//        Computador computer = new Computador();
//        computer.setId(2);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        String[] expResult = {"2",null,"CyT","402","0","RAM 4","jruiz","Juan","Ruiz"};
//        String[] result = instance.getHoleComputerInfo(computer);
//            assertEquals(expResult[0], result[0]);
//            assertEquals(expResult[1], result[1]);
//            assertEquals(expResult[2], result[2]);
//            assertEquals(expResult[3], result[3]);
//            assertEquals(expResult[4], result[4]);
//            assertEquals(expResult[5], result[5]);
//            assertEquals(expResult[6], result[6]);
//            assertEquals(expResult[7], result[7]);
//            assertEquals(expResult[8], result[8]);
//    }
//    
//    @Test
//    public void testGetHoleComputerInfo3() {
//        Precondiciones.habilitarDisponibilidad();
//        System.out.println("getHoleComputerInfo");
//        Computador computer = new Computador();
//        computer.setId(3);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        String[] expResult = {"3",null,"CyT","402","0","RAM 8","jruiz","Juan","Ruiz"};
//        String[] result = instance.getHoleComputerInfo(computer);
//            assertEquals(expResult[0], result[0]);
//            assertEquals(expResult[1], result[1]);
//            assertEquals(expResult[2], result[2]);
//            assertEquals(expResult[3], result[3]);
//            assertEquals(expResult[4], result[4]);
//            assertEquals(expResult[5], result[5]);
//            assertEquals(expResult[6], result[6]);
//            assertEquals(expResult[7], result[7]);
//            assertEquals(expResult[8], result[8]);
//    }
//
//    @Test
//    public void testGetHoleComputerInfo4() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.MostrarPorcentage1();
//        System.out.println("getHoleComputerInfo");
//        Computador computer = new Computador();
//        computer.setId(4);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        String[] expResult = {"4",null,"CyT","304","0","hardware","jruiz","Juan","Ruiz"};
//        String[] result = instance.getHoleComputerInfo(computer);
//            assertEquals(expResult[0], result[0]);
//            assertEquals(expResult[1], result[1]);
//            assertEquals(expResult[2], result[2]);
//            assertEquals(expResult[3], result[3]);
//            assertEquals(expResult[4], result[4]);
//            assertEquals(expResult[5], result[5]);
//            assertEquals(expResult[6], result[6]);
//            assertEquals(expResult[7], result[7]);
//            assertEquals(expResult[8], result[8]);
//    }
    
    /**
     * Test of getComputerPrograms method, of class MostrarInformacionComputadores.
     */
//    @Test
//    public void testGetComputerPrograms1() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.Computador1();
//        System.out.println("getComputerPrograms");
//        Computador computer = new Computador();
//        computer.setId(1);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        ArrayList<String> expResult = new ArrayList<>();
//        expResult.add("NetBeans");
//        expResult.add("CodeBlocks");
//        expResult.add("VisualParadigm");
//        ArrayList<String> result = instance.getComputerPrograms(computer);
//        for (int i = 0; i < result.size(); i++) {
//            assertEquals(expResult.get(i), result.get(i));
//        }
//    }
//    
//    @Test
//    public void testGetComputerPrograms2() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.Computador2();
//        System.out.println("getComputerPrograms");
//        Computador computer = new Computador();
//        computer.setId(2);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        ArrayList<String> expResult = new ArrayList<>();
//        expResult.add("NetBeans");
//        expResult.add("CodeBlocks");
//        ArrayList<String> result = instance.getComputerPrograms(computer);
//        for (int i = 0; i < result.size(); i++) {
//            assertEquals(expResult.get(i), result.get(i));
//        }
//    }
//    
//    @Test
//    public void testGetComputerPrograms3() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.Computador3();
//        System.out.println("getComputerPrograms");
//        Computador computer = new Computador();
//        computer.setId(3);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        ArrayList<String> expResult = new ArrayList<>();
//        expResult.add("NetBeans");
//        expResult.add("VisualParadigm");
//        ArrayList<String> result = instance.getComputerPrograms(computer);
//        System.out.println("El tamaño de resultado es: "+ result.size());
//        for (int i = 0; i < result.size(); i++) {
//            assertEquals(expResult.get(i), result.get(i));
//        }
//    }
    
//    @Test
//    public void testGetComputerPrograms4() {
//        Precondiciones.habilitarDisponibilidad();
//        Precondiciones.habilitarComputadorProgramaT();
//        Precondiciones.Computador4();
//        System.out.println("getComputerPrograms");
//        Computador computer = new Computador();
//        computer.setId(1);
//        MostrarInformacionComputadores instance = new MostrarInformacionComputadores();
//        ArrayList<String> expResult = new ArrayList<>();
//        expResult.add("NetBeans");
//        ArrayList<String> result = instance.getComputerPrograms(computer);
//        for (int i = 0; i < result.size(); i++) {
//            assertEquals(expResult.get(i), result.get(i));
//        }
//    }
    
}
