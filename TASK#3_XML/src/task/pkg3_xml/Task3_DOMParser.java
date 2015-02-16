package task.pkg3_xml;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task.generated.*;

public class Task3_DOMParser {
    
    ObjectFactory factory = new ObjectFactory();
    final TypeBank bank = factory.createTypeBank();
    final TypeDepositeType deposite = factory.createTypeDepositeType();
    final TypeDeposite demand = factory.createTypeDeposite();
    final TypeDeposite fixed = factory.createTypeDeposite();
    final TypeDeposite payment = factory.createTypeDeposite();
    final TypeDeposite savings = factory.createTypeDeposite();
    final TypeDeposite metal = factory.createTypeDeposite();
        
    public void makeDOMParsing() throws SAXException, IOException {
        
        DOMParser parser = new DOMParser();
        parser.parse("depo.xml");
        
        Document doc = parser.getDocument();
        Element root = doc.getDocumentElement();
        fillBankFields(root, "name");
        fillBankFields(root, "country");
        fillBankFields(root, "type");
        
        NodeList types = root.getElementsByTagName("type");
        Element type = (Element)types.item(0);
        fillTypeDepositeTypeFields(type, "demand");
        fillTypeDepositeTypeFields(type, "fixed");
        fillTypeDepositeTypeFields(type, "payment");
        fillTypeDepositeTypeFields(type, "savings");
        fillTypeDepositeTypeFields(type, "metal");
        
        System.out.println("...parsing finished");
    }

    private void fillBankFields(Element root, String fieldName) throws DOMException {
        NodeList bankChilds = root.getElementsByTagName(fieldName);
        Node fieldNode = bankChilds.item(0);
        String fieldValue = fieldNode.getFirstChild().getNodeValue();
        System.out.println(fieldNode.getLocalName() + ":\t" + fieldValue);
        switch(fieldName){
            case "name":    bank.setName(fieldValue);
                break;
            case "country": bank.setCountry(TypeContry.fromValue(fieldValue));
                break;
            case "type":    bank.setType(deposite);
                break;
            default:    System.out.println("Invalid name of the fieald - "
                        + fieldValue);
        }
    }
    
    private void fillTypeDepositeTypeFields(Element type, String fieldName){
        NodeList fields = type.getElementsByTagName(fieldName);
        Node fieldNode = fields.item(0);
        System.out.println("\nStart of deposite type: " + fieldNode.getNodeName());
        
        switch(fieldName){
            case "demand":  
                demand.setDepositorList(fillTypeDeposite(fieldNode));
                deposite.setDemand(demand);
                break;
            case "fixed":   
                fixed.setDepositorList(fillTypeDeposite(fieldNode));
                deposite.setFixed(fixed);
                break;
            case "payment": 
                payment.setDepositorList(fillTypeDeposite(fieldNode));
                deposite.setPayment(payment);
                break;
            case "savings": 
                savings.setDepositorList(fillTypeDeposite(fieldNode));
                deposite.setSavings(savings);
                break;
            case "metal":   
                metal.setDepositorList(fillTypeDeposite(fieldNode));
                deposite.setMetal(metal);
                break;
            default:    System.out.println("Invalid name of the fieald - "
                        + fieldName);
        }
        System.out.println("End of deposite type: " + fieldNode.getNodeName());
    }

    private List<TypeDepositor> fillTypeDeposite(Node fieldNode) {
        final List<TypeDepositor> depositorList = new ArrayList<>();
        Element e = (Element)fieldNode;
        NodeList depositorNodes = e.getElementsByTagName("depositor");
        for(int i = 0; i < depositorNodes.getLength(); i++){
            System.out.println("...one more depositor ...");
            final TypeDepositor depositor = factory.createTypeDepositor();
           
            Element depo = (Element)depositorNodes.item(i);
            NamedNodeMap m = depo.getAttributes();
            Node attr = m.getNamedItem("id");
            String valueAttr = attr.getNodeValue();
            System.out.println("depositor id is " + valueAttr);
            depositor.setId(valueAttr);
            
            NodeList depositorFullname = depo.getElementsByTagName("fullname");
            Node fullnameNode = depositorFullname.item(0);
            String fullnameValue = fullnameNode.getFirstChild().getNodeValue();
            System.out.println("depositor fullname: " + fullnameValue);
            depositor.setFullname(fullnameValue);
            
            NodeList depositorAccount = depo.getElementsByTagName("account");
            Node accountNode = depositorAccount.item(0);
            Long accountValue = Long.valueOf(accountNode.getFirstChild().getNodeValue());
            System.out.println("depositor account: " + accountValue);
            depositor.setAccount(accountValue);
            
            NodeList depositorAmount = depo.getElementsByTagName("amount");
            Node amountNode = depositorAmount.item(0);
            BigDecimal amountValue = new BigDecimal(amountNode.getFirstChild().getNodeValue());
            System.out.println("depositor amount: " + amountValue);
            depositor.setAmount(amountValue);
            
            NodeList depositorProfitability = depo.getElementsByTagName("profitability");
            Node profitNode = depositorProfitability.item(0);
            BigDecimal profitValue = new BigDecimal(profitNode.getFirstChild().getNodeValue());
            System.out.println("depositor profitability: " + profitValue);
            depositor.setProfitability(profitValue);
            
            NodeList depositorPeriod = depo.getElementsByTagName("period");
            Node periodNode = depositorPeriod.item(0);
            Integer periodValue = Integer.valueOf(periodNode.getFirstChild().getNodeValue());
            System.out.println("depositor period: " + periodValue);
            depositor.setPeriod(periodValue);
            
            depositorList.add(depositor);
        }
        return depositorList;
    }
}
