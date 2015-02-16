package task.pkg3_xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Task3_StAXParser {
    
    public static void staxparsing() throws FileNotFoundException, XMLStreamException{
        InputStream in = new FileInputStream("depo.xml");
        XMLInputFactory f = XMLInputFactory.newInstance();
        XMLStreamReader r = f.createXMLStreamReader(in);
        int current = r.getEventType();
        int preview = current;
        String shift = "   ";
        
        System.out.print("Document start...");
        while(r.hasNext()){
            current = r.next();
            switch(current){
                case XMLStreamConstants.START_ELEMENT: 
                    if(preview == XMLStreamConstants.CHARACTERS) {
                        shift += "   ";
                        System.out.print("\n" + shift + r.getLocalName().toUpperCase());
                    } else {
                        System.out.print("\n" + r.getLocalName().toUpperCase());
                    }
                    if(r.getAttributeCount() > 0) {
                        System.out.print("\t" + r.getAttributeLocalName(0) 
                                + ":\t" + r.getAttributeValue(0));
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (!r.getText().trim().equals("")) {
                        System.out.print("\t'" + r.getText() + "'");
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    shift = shift.substring(3);
                    break;
            }
            preview = current;
        }
        System.out.println("\n...end of document");
    }
}
