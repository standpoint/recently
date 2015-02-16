/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xslt_demo;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author volodya
 */
public class XSLT_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer(
                    new StreamSource("flowers.xsl"));
            transformer.transform(
                    new StreamSource("flowers.xml"),
                    new StreamResult("flowers.html"));
        } catch (TransformerException e){ 
            e.printStackTrace(); 
        }
    }
    
}
