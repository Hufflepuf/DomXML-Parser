/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.thorstenweiskopf.domxmlparser.test;

import de.thorstenweiskopf.domxmlparser.MyDomParserForCompanyXML;
import de.thorstenweiskopf.domxmlparser.exception.MyDomParserException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

/**
 *
 * @author MVC6
 */
public class TestParser {

    public TestParser() {
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

    @Test
    public void testSetStringSrc() throws MyDomParserException {
        String src = "<?xml version=\"1.0\"?>\n"
                + "<company>\n"
                + "	<staff id=\"1001\">\n"
                + "		<firstname>Thorsten</firstname>\n"
                + "		<lastname>Weiskopf</lastname>\n"
                + "		<nickname>thorty</nickname>\n"
                + "		<salary>100000</salary>\n"
                + "	</staff>\n"
                + "	<staff id=\"2001\">\n"
                + "		<firstname>Thomas</firstname>\n"
                + "		<lastname>Brunner</lastname>\n"
                + "		<nickname>h4ffl</nickname>\n"
                + "		<salary>200000</salary>\n"
                + "	</staff>\n"
                + "</company>";

      MyDomParserForCompanyXML domParser = new MyDomParserForCompanyXML();
        domParser.setSrc(src);
        assertThat(domParser.getSrc(), containsString("staff"));
    }
    
    @Test
    public void testSetFileSrc() throws MyDomParserException{
        MyDomParserForCompanyXML domParser = new MyDomParserForCompanyXML();
        domParser.setFileSrc("/toParse.xml");
        System.out.println(domParser.getSrc());                      
    }

    @Test
    public void testSetFileNotAvailableSrc(){
        try {
            MyDomParserForCompanyXML domParser = new MyDomParserForCompanyXML();
            domParser.setFileSrc("/no.xml");
            System.out.println(domParser.getSrc());                      
        } catch (MyDomParserException ex) {
            assertThat(ex.getMessage(), containsString("File not found"));
        }
    }
                   
    @Test 
    public void testGetAllNickNames() throws MyDomParserException{
       String src = "<?xml version=\"1.0\"?>\n"
               + "<companys>\n" +
                    "<company id=\"1\">\n" +
                    "	<staff id=\"1001\">\n" +
                    "		<firstname>Thorsten</firstname>\n" +
                    "		<lastname>Weiskopf</lastname>\n" +
                    "		<nickname>thorty</nickname>\n" +
                    "		<salary>100000</salary>\n" +
                    "	</staff>\n" +
                    "	<staff id=\"2001\">\n" +
                    "		<firstname>Thomas</firstname>\n" +
                    "		<lastname>Brunner</lastname>\n" +
                    "		<nickname>h4ffl</nickname>\n" +
                    "		<salary>200000</salary>\n" +
                    "	</staff>\n" +
                    "</company>\n" +
                    "<company id=\"2\">\n" +
                    "	<staff id=\"1001\">\n" +
                    "		<firstname>bla</firstname>\n" +
                    "		<lastname>foo</lastname>\n" +
                    "		<nickname>fb</nickname>\n" +
                    "		<salary>0</salary>\n" +
                    "	</staff>\n" +
                    "	<staff id=\"2001\">\n" +
                    "		<firstname>muh</firstname>\n" +
                    "		<lastname>pah</lastname>\n" +
                    "		<nickname>mp</nickname>\n" +
                    "		<salary>0</salary>\n" +
                    "	</staff>\n" +
                    "</company>\n" +
                 "</companys>";

        MyDomParserForCompanyXML domParser = new MyDomParserForCompanyXML();
        domParser.setSrc(src);
        assertThat(domParser.getSrc(), containsString("nickname"));                    
        List<String> nickNames = domParser.getAllNickNames();
        assertEquals("thorty", nickNames.get(0));
        assertEquals("h4ffl", nickNames.get(1));
        assertEquals(4, nickNames.size());        
    }    
    
    
    @Test
    public void testGetAllNickNamesFromCompanyOne() throws MyDomParserException{
       String src = "<?xml version=\"1.0\"?>\n"
               + "<companys>\n" +
                    "<company id=\"1\">\n" +
                    "	<staff id=\"1001\">\n" +
                    "		<firstname>Thorsten</firstname>\n" +
                    "		<lastname>Weiskopf</lastname>\n" +
                    "		<nickname>thorty</nickname>\n" +
                    "		<salary>100000</salary>\n" +
                    "	</staff>\n" +
                    "	<staff id=\"2001\">\n" +
                    "		<firstname>Thomas</firstname>\n" +
                    "		<lastname>Brunner</lastname>\n" +
                    "		<nickname>h4ffl</nickname>\n" +
                    "		<salary>200000</salary>\n" +
                    "	</staff>\n" +
                    "</company>\n" +
                    "<company id=\"2\">\n" +
                    "	<staff id=\"1001\">\n" +
                    "		<firstname>bla</firstname>\n" +
                    "		<lastname>foo</lastname>\n" +
                    "		<nickname>fb</nickname>\n" +
                    "		<salary>0</salary>\n" +
                    "	</staff>\n" +
                    "	<staff id=\"2001\">\n" +
                    "		<firstname>muh</firstname>\n" +
                    "		<lastname>pah</lastname>\n" +
                    "		<nickname>mp</nickname>\n" +
                    "		<salary>0</salary>\n" +
                    "	</staff>\n" +
                    "</company>\n" +
                 "</companys>";

        MyDomParserForCompanyXML domParser = new MyDomParserForCompanyXML();
        domParser.setSrc(src);
        assertThat(domParser.getSrc(), containsString("nickname")); 
/*        List<String> allNickNames = domParser.getAllNickNames();
        for(String s : allNickNames){
            System.out.println(s);
        }*/
        List<String> nickNames = domParser.getAllNickNamesFromCompanyOne();
        assertEquals("thorty", nickNames.get(0));
        assertEquals("h4ffl", nickNames.get(1));
        assertEquals(2, nickNames.size());        
    }       
    
}
