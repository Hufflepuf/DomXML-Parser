/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.thorstenweiskopf.domxmlparser;


import de.thorstenweiskopf.domxmlparser.exception.MyDomParserException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author MVC6
 */
public class MyDomParserForCompanyXML extends MyDomParser{
    
    public MyDomParserForCompanyXML(){
        super();
    }
    
 
    /***
     * 
     * @return List<String> of all the nicknames of all companys
     * @throws MyDomParserException 
     */
    public List<String> getAllNickNames() throws MyDomParserException{
        ArrayList<String> list = new ArrayList<String>();
        if (doc != null){
            NodeList nList = doc.getElementsByTagName("nickname");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                String nick = nList.item(temp).getTextContent();
                System.out.println(nick);
                list.add(nick);
            }
        }else {
            throw new MyDomParserException("No XML doc available.");
        }
        return list;
        
    }

    /***
     * 
     * @return List<String> of all the nicknames of the first company
     * @throws MyDomParserException 
     */
    public List<String> getAllNickNamesFromCompanyOne() throws MyDomParserException{
        ArrayList<String> list = new ArrayList<String>();
        if (doc != null){    
            NodeList elementsByTagName = doc.getElementsByTagName("company");
            for(int i = 0 ; elementsByTagName.getLength() < i ; i++){
                System.out.println("---> "+elementsByTagName.item(i));
            }
            Node firstCompanyNode = doc.getFirstChild().getFirstChild().getFirstChild();
            System.out.println(firstCompanyNode.getChildNodes().toString());
            if(firstCompanyNode instanceof Element) {
                Element companyOneElement = (Element) firstCompanyNode;
                companyOneElement.getElementsByTagName("nickname");
                NodeList nList = doc.getElementsByTagName("nickname");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    String nick = nList.item(temp).getTextContent();
                    System.out.println(nick);
                    list.add(nick);
                }
            }
        }else {
            throw new MyDomParserException("No XML doc available.");
        }
        return list;
        
    }    
    
  
    
}
