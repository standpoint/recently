package xml_saxparser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxParser extends DefaultHandler {
    int current = 0;
    @Override
    public void startDocument(){
        System.out.println("starting...");
    }
    
    @Override
    public void endDocument(){
        System.out.println("...end");
    }
    
    @Override
    public void startElement(String uri, String LocalName, String qName, 
            Attributes attrs){
        switch(qName){
            case "flowers": System.out.println("flowers");
                break;
            case "flower":  System.out.println("start new flower");
                String valueOfAttribute = attrs.getValue(0);
                System.out.println("  " + valueOfAttribute);
                break;
            case "name":    System.out.println("name");
                current = 1;
                break;
            case "soil":    System.out.println("soil");
                current = 2;
                break;
        }
    }
    
    @Override
    public void endElement(String uri, String LocalName, String qName){
        switch(qName){
            case "flowers": System.out.println("end flowers");
                break;
            case "flower":  System.out.println("end new flower");
                break;
            case "name":    System.out.println("end name");
                break;
            case "soil":    System.out.println("end soil");
                break;
        }        
    }
    
    @Override
    public void characters(char[] ch, int start, int length){
        String text = new String(ch,start,length);
        switch(current){
            case 1: System.out.println("  " + text);
                current = 0;    
                break;
            case 2: System.out.println("  " + text);
                current = 0;
                break;
        }
    }
}
