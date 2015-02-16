/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_domparser;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author volodya
 */
public class XML_DOMParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException {
        // получаем парсер и передаем xml-файл
        DOMParser parser = new DOMParser();
        parser.parse("flowers.xml");
        // получаем корневой элемент
        Document doc = parser.getDocument();
        Element root = doc.getDocumentElement();
        // получаем дочерние элементы с именем тега "flower"
        NodeList childs = root.getElementsByTagName("flower");
        
        for(int i = 0; i < childs.getLength(); i++) {
            System.out.println("we found flower");
            Element e = (Element)childs.item(i);
            //получаем список атрибутов
            NamedNodeMap m = e.getAttributes();
            Node attr = m.getNamedItem("id");
            String valueAttr = attr.getNodeValue();
            System.out.println("id flower is " + valueAttr);
            
            //получаем дочерние элементы у соответствующего flower
            NodeList childsOfFlower = e.getElementsByTagName("name");
            Node name = childsOfFlower.item(0);
            Node textName = name.getFirstChild();
            String textN = textName.getNodeValue();
            System.out.println(textN);
            
            NodeList childsOfSoil = e.getElementsByTagName("soil");
            Node soil = childsOfSoil.item(0);
            Node textSoil = soil.getFirstChild();
            String textS = textSoil.getNodeValue();
            System.out.println(textS);
            
            System.out.println("end of flower\n");
        }        
    }    
}
