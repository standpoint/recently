package task.pkg3_xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;

public class TASK3_XML {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, FileNotFoundException, XMLStreamException {
        
        System.out.println("-------------------------------------------\n"
                + "SAX Parsing\n"
                + "-------------------------------------------");
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        Task3_SAXParser mp = new Task3_SAXParser();
        parser.parse("depo.xml", mp);
        
        System.out.println("-------------------------------------------\n"
                + "DOM Parsing\n"
                + "-------------------------------------------");
        new Task3_DOMParser().makeDOMParsing();
        
        System.out.println("-------------------------------------------\n"
                + "StAX Parsing\n"
                + "-------------------------------------------");
        Task3_StAXParser.staxparsing();
    }
}
