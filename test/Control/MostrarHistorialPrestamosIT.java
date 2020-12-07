/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
public class MostrarHistorialPrestamosIT {
    
    public MostrarHistorialPrestamosIT() {
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
     * Test of getBorrowsHistoryInfo method, of class MostrarHistorialPrestamos.
     */
    @Test
    public void testGetBorrowsHistoryInfo1() {
        System.out.println("getBorrowsHistoryInfo");
        MostrarInformesHistorial instance = new MostrarInformesHistorial();
        ArrayList<String[]> expResult = new ArrayList();
        String[] usuario1 = {"acardenaso", "NetBeans", "65:23:46"};
        String[] usuario2 = {"cchavezb", "NetBeans", "28:14:29"};
        String[] usuario3 = {"dbustos", "CodeBlocks", "230:00:56"};
        String[] usuario4 = {"ggarciaro", "NetBeans", "41:04:48"};
        String[] usuario5 = {"jgarciam", "NetBeans, CodeBlocks","15:57:03"};
        expResult.add(usuario1);
        expResult.add(usuario2);
        expResult.add(usuario3);
        expResult.add(usuario4);
        expResult.add(usuario5);
        ArrayList<String[]> result = instance.getBorrowsHistoryInfo();
        for (int i = 0; i < result.size(); i++) {
            System.out.println("tamaño del resultado " + result.size());
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
            assertEquals(expResult.get(i)[0], result.get(i)[0]);
            System.out.println("p c: " + result.get(i)[1] + " y cr: "+ expResult.get(i)[1]);
            assertEquals(expResult.get(i)[1], result.get(i)[1]);
            System.out.println("h c: " + result.get(i)[2] + " y cr: "+ expResult.get(i)[2]);
            assertEquals(expResult.get(i)[2], result.get(i)[2]);
        }
    }
//    
//    @Test
//    public void testGetBorrowsHistoryInfo2() {
//        System.out.println("getBorrowsHistoryInfo");
//        MostrarHistorialPrestamos instance = new MostrarHistorialPrestamos();
//        ArrayList<String[]> expResult = new ArrayList();
//        String[] usuario1 = {"acardenaso", "NetBeans", "65:23:46"};
//        String[] usuario2 = {"cchavezb", "NetBeans", "28:14:29"};
//        String[] usuario3 = {"dbustos", "CodeBlocks", "228:37:51"};
//        String[] usuario4 = {"ggarciaro", "NetBeans", "41:04:48"};
//        String[] usuario5 = {"jgarciam", "NetBeans,CodeBlocks","15:45:56"};
//        expResult.add(usuario1);
//        expResult.add(usuario2);
//        expResult.add(usuario3);
//        expResult.add(usuario4);
//        expResult.add(usuario5);
//        ArrayList<String[]> result = instance.getBorrowsHistoryInfo();
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println("tamaño del resultado " + result.size());
//            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
//            assertEquals(expResult.get(i)[0], result.get(i)[0]);
//            System.out.println("p c: " + result.get(i)[1] + " y cr: "+ expResult.get(i)[1]);
//            assertEquals(expResult.get(i)[1], result.get(i)[1]);
//            System.out.println("h c: " + result.get(i)[2] + " y cr: "+ expResult.get(i)[2]);
//            assertEquals(expResult.get(i)[2], result.get(i)[2]);
//        }
//    }
//    
//    @Test
//    public void testGetBorrowsHistoryInfo3() {
//        System.out.println("getBorrowsHistoryInfo");
//        MostrarHistorialPrestamos instance = new MostrarHistorialPrestamos();
//        ArrayList<String[]> expResult = new ArrayList();
//        String[] usuario1 = {"acardenaso", "NetBeans", "65:23:46"};
//        String[] usuario2 = {"cchavezb", "NetBeans", "28:14:29"};
//        String[] usuario3 = {"dbustos", "CodeBlocks", "228:37:51"};
//        String[] usuario4 = {"ggarciaro", "NetBeans", "41:04:48"};
//        String[] usuario5 = {"jgarciam", "NetBeans,CodeBlocks","15:45:56"};
//        expResult.add(usuario1);
//        expResult.add(usuario2);
//        expResult.add(usuario3);
//        expResult.add(usuario4);
//        expResult.add(usuario5);
//        ArrayList<String[]> result = instance.getBorrowsHistoryInfo();
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println("tamaño del resultado " + result.size());
//            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
//            assertEquals(expResult.get(i)[0], result.get(i)[0]);
//            System.out.println("p c: " + result.get(i)[1] + " y cr: "+ expResult.get(i)[1]);
//            assertEquals(expResult.get(i)[1], result.get(i)[1]);
//            System.out.println("h c: " + result.get(i)[2] + " y cr: "+ expResult.get(i)[2]);
//            assertEquals(expResult.get(i)[2], result.get(i)[2]);
//        }
//    }
//    
//    @Test
//    public void testGetBorrowsHistoryInfo4() {
//        System.out.println("getBorrowsHistoryInfo");
//        MostrarHistorialPrestamos instance = new MostrarHistorialPrestamos();
//        ArrayList<String[]> expResult = new ArrayList();
//        String[] usuario1 = {"acardenaso", "NetBeans", "65:23:46"};
//        String[] usuario2 = {"cchavezb", "NetBeans", "28:14:29"};
//        String[] usuario3 = {"dbustos", "CodeBlocks", "228:37:51"};
//        String[] usuario4 = {"ggarciaro", "NetBeans", "41:04:48"};
//        String[] usuario5 = {"jgarciam", "NetBeans,CodeBlocks","15:45:56"};
//        expResult.add(usuario1);
//        expResult.add(usuario2);
//        expResult.add(usuario3);
//        expResult.add(usuario4);
//        expResult.add(usuario5);
//        ArrayList<String[]> result = instance.getBorrowsHistoryInfo();
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println("tamaño del resultado " + result.size());
//            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i)[0]);
//            assertEquals(expResult.get(i)[0], result.get(i)[0]);
//            System.out.println("p c: " + result.get(i)[1] + " y cr: "+ expResult.get(i)[1]);
//            assertEquals(expResult.get(i)[1], result.get(i)[1]);
//            System.out.println("h c: " + result.get(i)[2] + " y cr: "+ expResult.get(i)[2]);
//            assertEquals(expResult.get(i)[2], result.get(i)[2]);
//        }
//    }
////
//    /**
//     * Test of getHoleUserBorrowsInfo method, of class MostrarHistorialPrestamos.
//     */
    @Test
    public void testGetHoleUserBorrowsInfo1() {
        System.out.println("getHoleUserBorrowsInfo");
        String userId = "acardenaso";
        MostrarInformesHistorial instance = new MostrarInformesHistorial();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("2");
        expResult.add("3");
        expResult.add("4");
        expResult.add("5");
        expResult.add("6");
        expResult.add("7");
        expResult.add("8");
        expResult.add("9");
        expResult.add("10");
        expResult.add("37");
        expResult.add("41");
        expResult.add("43");
        expResult.add("44");
        expResult.add("58");
        expResult.add("60");
        expResult.add("61");
        expResult.add("64");
        expResult.add("69");
        expResult.add("73");
        expResult.add("77");
        expResult.add("84");
        expResult.add("86");
        expResult.add("88");
        expResult.add("91");
        expResult.add("95");
        expResult.add("98");
        expResult.add("99");
        expResult.add("108");
        expResult.add("112");
        expResult.add("115");
        expResult.add("117");
        expResult.add("119");
        expResult.add("121");
        expResult.add("123");
        expResult.add("125");
        expResult.add("127");
        expResult.add("129");
        expResult.add("135");
        expResult.add("137");
        expResult.add("139");
        expResult.add("143");
        expResult.add("144");
        expResult.add("146");
        expResult.add("148");
        expResult.add("154");
        expResult.add("159");
        expResult.add("165");
        expResult.add("166");
        expResult.add("172");
        expResult.add("174");
        expResult.add("191");
        expResult.add("193");
        expResult.add("196");
        expResult.add("197");
        expResult.add("199");
        expResult.add("205");
        expResult.add("208");
        expResult.add("211");
        expResult.add("222");
        expResult.add("228");
        expResult.add("229");
        expResult.add("298");
        expResult.add("300");
        expResult.add("301");
        expResult.add("305");
        expResult.add("384");
        expResult.add("389");
        expResult.add("394");
        expResult.add("399");
        expResult.add("404");
        expResult.add("408");
        expResult.add("410");
        expResult.add("412");
        expResult.add("414");
        expResult.add("415");
        expResult.add("417");
        expResult.add("419");
        expResult.add("421");
        expResult.add("423");
        expResult.add("425");
        expResult.add("427");
        expResult.add("429");
        expResult.add("431");
        expResult.add("433");
        expResult.add("435");
        expResult.add("436");
        expResult.add("437");
        expResult.add("438");
        expResult.add("439");
        expResult.add("441");
        expResult.add("444");
        expResult.add("448");
        expResult.add("449");
        expResult.add("451");
        expResult.add("452");
        expResult.add("454");
        expResult.add("457");
        expResult.add("458");
        expResult.add("460");
        expResult.add("462");
        expResult.add("463");
        expResult.add("464");
        expResult.add("465");
        expResult.add("466");
        expResult.add("468");
        expResult.add("471");
        expResult.add("475");
        expResult.add("476");
        expResult.add("477");
        expResult.add("478");
        expResult.add("479");
        expResult.add("480");
        expResult.add("481");
        expResult.add("483");
        expResult.add("485");
        expResult.add("487");
        expResult.add("489");
        expResult.add("491");
        expResult.add("493");
        expResult.add("494");
        expResult.add("496");
        expResult.add("498");
        expResult.add("500");
        expResult.add("502");
        expResult.add("504");
        expResult.add("505");
        expResult.add("506");
        expResult.add("508");
        expResult.add("510");
        expResult.add("512");
        expResult.add("513");
        expResult.add("514");
        expResult.add("516");
        expResult.add("517");
        expResult.add("519");
        expResult.add("521");
        expResult.add("523");
        expResult.add("525");
        expResult.add("527");
        expResult.add("530");
        expResult.add("531");
        expResult.add("535");
        ArrayList<String[]> result = instance.getWholeUserBorrowsInfo(userId);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(expResult.get(i), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetHoleUserBorrowsInfo2() {
        System.out.println("getHoleUserBorrowsInfo");
        String userId = "cchavezb";
        MostrarInformesHistorial instance = new MostrarInformesHistorial();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("42");
        expResult.add("63");
        expResult.add("66");
        expResult.add("67");
        expResult.add("68");
        expResult.add("71");
        expResult.add("72");
        expResult.add("75");
        expResult.add("76");
        expResult.add("78");
        expResult.add("79");
        expResult.add("80");
        expResult.add("81");
        expResult.add("82");
        expResult.add("83");
        expResult.add("85");
        expResult.add("87");
        expResult.add("90");
        expResult.add("107");
        expResult.add("113");
        expResult.add("116");
        expResult.add("118");
        expResult.add("120");
        expResult.add("122");
        expResult.add("124");
        expResult.add("126");
        expResult.add("244");
        expResult.add("386");
        expResult.add("391");
        expResult.add("396");
        expResult.add("401");
        expResult.add("405");
        expResult.add("533");
        expResult.add("548");
        ArrayList<String[]> result = instance.getWholeUserBorrowsInfo(userId);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(expResult.get(i), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetHoleUserBorrowsInfo3() {
        System.out.println("getHoleUserBorrowsInfo");
        String userId = "dbustos";
        MostrarInformesHistorial instance = new MostrarInformesHistorial();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("11");
        expResult.add("12");
        expResult.add("13");
        expResult.add("14");
        expResult.add("15");
        expResult.add("16");
        expResult.add("17");
        expResult.add("18");
        expResult.add("19");
        expResult.add("20");
        expResult.add("21");
        expResult.add("22");
        expResult.add("23");
        expResult.add("24");
        expResult.add("25");
        expResult.add("26");
        expResult.add("27");
        expResult.add("28");
        expResult.add("29");
        expResult.add("30");
        expResult.add("31");
        expResult.add("32");
        expResult.add("33");
        expResult.add("34");
        expResult.add("35");
        expResult.add("36");
        expResult.add("38");
        expResult.add("39");
        expResult.add("40");
        expResult.add("45");
        expResult.add("46");
        expResult.add("47");
        expResult.add("48");
        expResult.add("49");
        expResult.add("50");
        expResult.add("51");
        expResult.add("52");
        expResult.add("53");
        expResult.add("54");
        expResult.add("55");
        expResult.add("56");
        expResult.add("57");
        expResult.add("59");
        expResult.add("93");
        expResult.add("96");
        expResult.add("97");
        expResult.add("106");
        expResult.add("110");
        expResult.add("111");
        expResult.add("114");
        expResult.add("131");
        expResult.add("132");
        expResult.add("133");
        expResult.add("134");
        expResult.add("141");
        expResult.add("142");
        expResult.add("145");
        expResult.add("147");
        expResult.add("151");
        expResult.add("153");
        expResult.add("157");
        expResult.add("158");
        expResult.add("162");
        expResult.add("164");
        expResult.add("169");
        expResult.add("185");
        expResult.add("186");
        expResult.add("189");
        expResult.add("190");
        expResult.add("195");
        expResult.add("203");
        expResult.add("204");
        expResult.add("207");
        expResult.add("209");
        expResult.add("210");
        expResult.add("215");
        expResult.add("216");
        expResult.add("219");
        expResult.add("220");
        expResult.add("221");
        expResult.add("225");
        expResult.add("226");
        expResult.add("227");
        expResult.add("232");
        expResult.add("234");
        expResult.add("235");
        expResult.add("236");
        expResult.add("237");
        expResult.add("238");
        expResult.add("239");
        expResult.add("240");
        expResult.add("241");
        expResult.add("242");
        expResult.add("243");
        expResult.add("245");
        expResult.add("246");
        expResult.add("247");
        expResult.add("248");
        expResult.add("249");
        expResult.add("250");
        expResult.add("251");
        expResult.add("252");
        expResult.add("253");
        expResult.add("254");
        expResult.add("255");
        expResult.add("256");
        expResult.add("257");
        expResult.add("258");
        expResult.add("259");
        expResult.add("260");
        expResult.add("261");
        expResult.add("262");
        expResult.add("263");
        expResult.add("264");
        expResult.add("265");
        expResult.add("266");
        expResult.add("267");
        expResult.add("268");
        expResult.add("269");
        expResult.add("270");
        expResult.add("271");
        expResult.add("272");
        expResult.add("273");
        expResult.add("274");
        expResult.add("275");
        expResult.add("276");
        expResult.add("277");
        expResult.add("278");
        expResult.add("279");
        expResult.add("280");
        expResult.add("281");
        expResult.add("282");
        expResult.add("283");
        expResult.add("284");
        expResult.add("285");
        expResult.add("286");
        expResult.add("287");
        expResult.add("288");
        expResult.add("289");
        expResult.add("290");
        expResult.add("291");
        expResult.add("292");
        expResult.add("293");
        expResult.add("294");
        expResult.add("295");
        expResult.add("296");
        expResult.add("297");
        expResult.add("299");
        expResult.add("302");
        expResult.add("303");
        expResult.add("304");
        expResult.add("308");
        expResult.add("310");
        expResult.add("311");
        expResult.add("312");
        expResult.add("313");
        expResult.add("314");
        expResult.add("315");
        expResult.add("316");
        expResult.add("317");
        expResult.add("318");
        expResult.add("319");
        expResult.add("320");
        expResult.add("321");
        expResult.add("322");
        expResult.add("323");
        expResult.add("324");
        expResult.add("325");
        expResult.add("326");
        expResult.add("327");
        expResult.add("329");
        expResult.add("330");
        expResult.add("331");
        expResult.add("332");
        expResult.add("333");
        expResult.add("335");
        expResult.add("337");
        expResult.add("338");
        expResult.add("339");
        expResult.add("341");
        expResult.add("342");
        expResult.add("343");
        expResult.add("344");
        expResult.add("346");
        expResult.add("347");
        expResult.add("348");
        expResult.add("349");
        expResult.add("351");
        expResult.add("352");
        expResult.add("353");
        expResult.add("354");
        expResult.add("355");
        expResult.add("356");
        expResult.add("359");
        expResult.add("364");
        expResult.add("372");
        expResult.add("373");
        expResult.add("376");
        expResult.add("377");
        expResult.add("378");
        expResult.add("379");
        expResult.add("381");
        expResult.add("383");
        expResult.add("387");
        expResult.add("392");
        expResult.add("397");
        expResult.add("402");
        expResult.add("406");
        expResult.add("407");
        expResult.add("409");
        expResult.add("411");
        expResult.add("413");
        expResult.add("443");
        expResult.add("446");
        expResult.add("447");
        expResult.add("456");
        expResult.add("470");
        expResult.add("473");
        expResult.add("529");
        expResult.add("534");
        expResult.add("537");
        expResult.add("539");
        expResult.add("540");
        expResult.add("541");
        expResult.add("543");
        expResult.add("545");
        expResult.add("546");
        expResult.add("547");
        expResult.add("549");
        expResult.add("567");
        expResult.add("573");
        expResult.add("577");
        expResult.add("625");
        expResult.add("634");
        expResult.add("638");
        expResult.add("642");
        expResult.add("644");
        expResult.add("646");
        expResult.add("647");
        expResult.add("648");
        expResult.add("652");
        expResult.add("653");
        expResult.add("655");
        expResult.add("658");
        expResult.add("659");
        expResult.add("660");
        expResult.add("663");
        expResult.add("664");
        expResult.add("665");
        expResult.add("669");
        expResult.add("670");
        expResult.add("671");
        expResult.add("674");
        expResult.add("675");
        expResult.add("679");
        expResult.add("680");
        expResult.add("681");
        expResult.add("687");
        expResult.add("693");
        expResult.add("707");
        expResult.add("708");
        expResult.add("709");
        expResult.add("711");
        expResult.add("712");
        expResult.add("713");
        expResult.add("714");
        expResult.add("716");
        expResult.add("718");
        expResult.add("720");
        expResult.add("725");
        expResult.add("726");
        expResult.add("727");
        expResult.add("728");
        expResult.add("732");
        expResult.add("733");
        expResult.add("734");
        expResult.add("752");
        expResult.add("753");
        expResult.add("754");
        expResult.add("755");
        expResult.add("756");
        expResult.add("757");
        expResult.add("774");
        expResult.add("775");
        expResult.add("776");
        expResult.add("777");
        expResult.add("779");
        expResult.add("780");
        expResult.add("781");
        expResult.add("782");
        expResult.add("784");
        expResult.add("785");
        expResult.add("786");
        expResult.add("787");
        expResult.add("790");
        expResult.add("793");
        expResult.add("795");
        expResult.add("796");
        expResult.add("799");
        expResult.add("800");
        expResult.add("803");
        expResult.add("805");
        expResult.add("810");
        expResult.add("811");
        expResult.add("812");
        expResult.add("813");
        expResult.add("814");
        expResult.add("815");
        expResult.add("816");
        expResult.add("817");
        expResult.add("818");
        ArrayList<String[]> result = instance.getWholeUserBorrowsInfo(userId);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(expResult.get(i), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetHoleUserBorrowsInfo4() {
        System.out.println("getHoleUserBorrowsInfo");
        String userId = "ggarciaro";
        MostrarInformesHistorial instance = new MostrarInformesHistorial();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("62");
        expResult.add("65");
        expResult.add("70");
        expResult.add("74");
        expResult.add("89");
        expResult.add("92");
        expResult.add("94");
        expResult.add("109");
        expResult.add("128");
        expResult.add("130");
        expResult.add("136");
        expResult.add("138");
        expResult.add("140");
        expResult.add("149");
        expResult.add("152");
        expResult.add("155");
        expResult.add("156");
        expResult.add("160");
        expResult.add("163");
        expResult.add("167");
        expResult.add("170");
        expResult.add("183");
        expResult.add("184");
        expResult.add("187");
        expResult.add("188");
        expResult.add("192");
        expResult.add("194");
        expResult.add("198");
        expResult.add("200");
        expResult.add("201");
        expResult.add("202");
        expResult.add("206");
        expResult.add("212");
        expResult.add("213");
        expResult.add("214");
        expResult.add("217");
        expResult.add("218");
        expResult.add("223");
        expResult.add("224");
        expResult.add("230");
        expResult.add("233");
        expResult.add("385");
        expResult.add("388");
        expResult.add("390");
        expResult.add("393");
        expResult.add("395");
        expResult.add("398");
        expResult.add("400");
        expResult.add("403");
        expResult.add("416");
        expResult.add("418");
        expResult.add("420");
        expResult.add("422");
        expResult.add("424");
        expResult.add("426");
        expResult.add("428");
        expResult.add("430");
        expResult.add("432");
        expResult.add("434");
        expResult.add("440");
        expResult.add("442");
        expResult.add("445");
        expResult.add("450");
        expResult.add("453");
        expResult.add("455");
        expResult.add("459");
        expResult.add("461");
        expResult.add("467");
        expResult.add("469");
        expResult.add("472");
        expResult.add("482");
        expResult.add("484");
        expResult.add("486");
        expResult.add("488");
        expResult.add("490");
        expResult.add("492");
        expResult.add("495");
        expResult.add("497");
        expResult.add("499");
        expResult.add("501");
        expResult.add("503");
        expResult.add("507");
        expResult.add("509");
        expResult.add("511");
        expResult.add("515");
        expResult.add("518");
        expResult.add("520");
        expResult.add("522");
        expResult.add("524");
        expResult.add("526");
        expResult.add("528");
        expResult.add("536");
        expResult.add("552");
        ArrayList<String[]> result = instance.getWholeUserBorrowsInfo(userId);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(expResult.get(i), result.get(i)[0]);
        }
    }
    
    @Test
    public void testGetHoleUserBorrowsInfo5() {
        System.out.println("getHoleUserBorrowsInfo");
        String userId = "jgarciam";
        MostrarInformesHistorial instance = new MostrarInformesHistorial();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("171");
        expResult.add("173");
        expResult.add("175");
        expResult.add("176");
        expResult.add("177");
        expResult.add("178");
        expResult.add("179");
        expResult.add("180");
        expResult.add("181");
        expResult.add("182");
        expResult.add("358");
        expResult.add("361");
        expResult.add("366");
        expResult.add("368");
        expResult.add("375");
        expResult.add("474");
        expResult.add("758");
        expResult.add("759");
        expResult.add("760");
        expResult.add("761");
        expResult.add("763");
        expResult.add("769");
        expResult.add("770");
        expResult.add("806");
        expResult.add("808");
        ArrayList<String[]> result = instance.getWholeUserBorrowsInfo(userId);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("ID c: " + result.get(i)[0] + " y cr: "+ expResult.get(i));
            assertEquals(expResult.get(i), result.get(i)[0]);
        }
    }
    
}
