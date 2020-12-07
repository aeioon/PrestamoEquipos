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
public class MostrarInformesSoftwareIT {
    
    public MostrarInformesSoftwareIT() {
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
     * Test of getProgramRequestHistory method, of class MostrarInformesSoftware.
     */
    @Test
    public void testGetProgramRequestHistory1() {
        System.out.println("getProgramRequestHistory");
        Programa selected = new Programa();
        selected.setId(1);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        ArrayList<Integer> expResult = new ArrayList();
        expResult.add(385);    
        expResult.add(386);
        expResult.add(390);
        expResult.add(391);
        expResult.add(395);
        expResult.add(396);
        expResult.add(400);
        expResult.add(401);
        expResult.add(407);
        expResult.add(408);
        expResult.add(409);
        expResult.add(410);
        expResult.add(411);
        expResult.add(412);
        expResult.add(413);
        expResult.add(414);
        expResult.add(415);
        expResult.add(417);
        expResult.add(419);
        expResult.add(421);
        expResult.add(423);
        expResult.add(425);
        expResult.add(427);
        expResult.add(429);
        expResult.add(431);
        expResult.add(432);
        expResult.add(433);
        expResult.add(435);
        expResult.add(436);
        expResult.add(437);
        expResult.add(438);
        expResult.add(439);
        expResult.add(440);
        expResult.add(441);
        expResult.add(442);
        expResult.add(443);
        expResult.add(444);
        expResult.add(445);
        expResult.add(446);
        expResult.add(447);
        expResult.add(448);
        expResult.add(449);
        expResult.add(450);
        expResult.add(451);
        expResult.add(452);
        expResult.add(453);
        expResult.add(454);
        expResult.add(455);
        expResult.add(456);
        expResult.add(457);
        expResult.add(458);
        expResult.add(459);
        expResult.add(460);
        expResult.add(461);
        expResult.add(465);
        expResult.add(466);
        expResult.add(467);
        expResult.add(468);
        expResult.add(469);
        expResult.add(470);
        expResult.add(471);
        expResult.add(472);
        expResult.add(473);
        expResult.add(474);
        expResult.add(475);
        expResult.add(477);
        expResult.add(479);
        expResult.add(481);
        expResult.add(482);
        expResult.add(483);
        expResult.add(484);
        expResult.add(485);
        expResult.add(486);
        expResult.add(487);
        expResult.add(488);
        expResult.add(489);
        expResult.add(490);
        expResult.add(491);
        expResult.add(492);
        expResult.add(493);
        expResult.add(494);
        expResult.add(495);
        expResult.add(496);
        expResult.add(497);
        expResult.add(498);
        expResult.add(499);
        expResult.add(500);
        expResult.add(501);
        expResult.add(502);
        expResult.add(503);
        expResult.add(504);
        expResult.add(506);
        expResult.add(507);
        expResult.add(508);
        expResult.add(509);
        expResult.add(510);
        expResult.add(511);
        expResult.add(512);
        expResult.add(514);
        expResult.add(515);
        expResult.add(516);
        expResult.add(517);
        expResult.add(518);
        expResult.add(519);
        expResult.add(520);
        expResult.add(521);
        expResult.add(522);
        expResult.add(523);
        expResult.add(524);
        expResult.add(525);
        expResult.add(526);
        expResult.add(527);
        expResult.add(528);
        expResult.add(529);
        expResult.add(530);
        expResult.add(535);
        expResult.add(536);
        expResult.add(548);
        expResult.add(549);
        expResult.add(552);
        expResult.add(673);
        expResult.add(756);
        expResult.add(758);
        expResult.add(759);
        expResult.add(760);
        expResult.add(762);
        expResult.add(764);
        expResult.add(765);
        expResult.add(766);
        expResult.add(767);
        expResult.add(768);
        ArrayList<String[]> result = instance.getProgramRequestHistory(selected);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(String.valueOf(expResult.get(i)), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetProgramRequestHistory2() {
        System.out.println("getProgramRequestHistory");
        Programa selected = new Programa();
        selected.setId(2);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(97);
        expResult.add(106);
        expResult.add(107);
        expResult.add(111);
        expResult.add(167);
        expResult.add(169);
        expResult.add(247);
        expResult.add(248);
        expResult.add(249);
        expResult.add(289);
        expResult.add(329);
        expResult.add(344);
        expResult.add(348);
        expResult.add(351);
        expResult.add(352);
        expResult.add(353);
        expResult.add(354);
        expResult.add(355);
        expResult.add(358);
        expResult.add(361);
        expResult.add(366);
        expResult.add(368);
        expResult.add(375);
        expResult.add(384);
        expResult.add(389);
        expResult.add(394);
        expResult.add(399);
        expResult.add(404);
        expResult.add(531);
        expResult.add(540);
        expResult.add(543);
        expResult.add(549);
        expResult.add(661);
        expResult.add(662);
        expResult.add(663);
        expResult.add(664);
        expResult.add(665);
        expResult.add(668);
        expResult.add(669);
        expResult.add(672);
        expResult.add(680);
        expResult.add(681);
        expResult.add(682);
        expResult.add(685);
        expResult.add(689);
        expResult.add(720);
        expResult.add(755);
        expResult.add(756);
        expResult.add(765);
        expResult.add(769);
        expResult.add(773);
        expResult.add(774);
        expResult.add(775);
        expResult.add(776);
        expResult.add(778);
        expResult.add(779);
        expResult.add(780);
        ArrayList<String[]> result = instance.getProgramRequestHistory(selected);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(String.valueOf(expResult.get(i)), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetProgramRequestHistory3() {
        System.out.println("getProgramRequestHistory");
        Programa selected = new Programa();
        selected.setId(3);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(387);
        expResult.add(392);
        expResult.add(397);
        expResult.add(402);
        expResult.add(555);
        expResult.add(678);
        expResult.add(746);
        expResult.add(747);
        expResult.add(748);
        expResult.add(749);
        expResult.add(750);
        expResult.add(771);
        expResult.add(772);
        expResult.add(773);
        expResult.add(789);
        expResult.add(799);
        ArrayList<String[]> result = instance.getProgramRequestHistory(selected);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(String.valueOf(expResult.get(i)), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetProgramRequestHistory4() {
        System.out.println("getProgramRequestHistory");
        Programa selected = new Programa();
        selected.setId(4);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(537);
        expResult.add(540);
        expResult.add(543);
        expResult.add(545);
        expResult.add(556);
        expResult.add(593);
        expResult.add(594);
        expResult.add(596);
        expResult.add(597);
        expResult.add(598);
        expResult.add(603);
        expResult.add(661);
        expResult.add(662);
        expResult.add(663);
        expResult.add(664);
        expResult.add(665);
        expResult.add(668);
        expResult.add(669);
        expResult.add(672);
        expResult.add(674);
        expResult.add(675);
        expResult.add(679);
        expResult.add(688);
        expResult.add(699);
        expResult.add(703);
        expResult.add(725);
        expResult.add(727);
        expResult.add(728);
        expResult.add(755);
        expResult.add(810);
        expResult.add(814);
        ArrayList<String[]> result = instance.getProgramRequestHistory(selected);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(String.valueOf(expResult.get(i)), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetProgramRequestHistory() {
        System.out.println("getProgramRequestHistory");
        Programa selected = new Programa();
        selected.setId(21);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(677);
        ArrayList<String[]> result = instance.getProgramRequestHistory(selected);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(String.valueOf(expResult.get(i)), result.get(i)[0]);
        }
    }
    
    
    /**
     * Test of getRequestStats method, of class MostrarInformesSoftware.
     */
    @Test
    public void testGetRequestStats_Programa1() {
        System.out.println("getRequestStats");
        Programa selected = new Programa();
        selected.setId(1);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        int[] expResult = {123, 8};
        int[] result = instance.getRequestStats(selected);
        for (int i = 0; i < result.length; i++) {
            System.out.println("ID c: " + result[i] + " y cr: "+ expResult[i]);
            assertEquals(expResult[i], result[i]);
        }
    }
    
    @Test
    public void testGetRequestStats_Programa2() {
        System.out.println("getRequestStats");
        Programa selected = new Programa();
        selected.setId(2);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        int[] expResult = {47, 10};
        int[] result = instance.getRequestStats(selected);
        for (int i = 0; i < result.length; i++) {
            System.out.println("ID c: " + result[i] + " y cr: "+ expResult[i]);
            assertEquals(expResult[i], result[i]);
        }
    }
    
    @Test
    public void testGetRequestStats_Programa3() {
        System.out.println("getRequestStats");
        Programa selected = new Programa();
        selected.setId(3);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        int[] expResult = {5, 11} ;
        int[] result = instance.getRequestStats(selected);
        for (int i = 0; i < result.length; i++) {
            System.out.println("ID c: " + result[i] + " y cr: "+ expResult[i]);
            assertEquals(expResult[i], result[i]);
        }
    }
    
    @Test
    public void testGetRequestStats_Programa4() {
        System.out.println("getRequestStats");
        Programa selected = new Programa();
        selected.setId(4);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        int[] expResult = {17, 14};
        int[] result = instance.getRequestStats(selected);
        for (int i = 0; i < result.length; i++) {
            System.out.println("ID c: " + result[i] + " y cr: "+ expResult[i]);
            assertEquals(expResult[i], result[i]);
        }
    }
    
    @Test
    public void testGetRequestStats_Programa5() {
        System.out.println("getRequestStats");
        Programa selected = new Programa();
        selected.setId(5);
        MostrarInformesSoftware instance = new MostrarInformesSoftware();
        int[] expResult = {0,0};
        int[] result = instance.getRequestStats(selected);
        for (int i = 0; i < result.length; i++) {
            System.out.println("ID c: " + result[i] + " y cr: "+ expResult[i]);
            assertEquals(expResult[i], result[i]);
        }
    }
}
