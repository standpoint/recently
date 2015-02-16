package task.pkg3_xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Task3_SAXParser extends DefaultHandler {
    
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
            case "bank":        System.out.println("Bank");
                break;
            case "name":        System.out.print("Name\t\t");
                current = 1;
                break;
            case "country":     System.out.print("Country\t\t");
                current = 2;
                break;
            case "type":        System.out.println("Type");
                break;
            case "demand":      System.out.println("Demand");
                break;
            case "fixed":       System.out.println("Fixed");
                break;
            case "payment":     System.out.println("Payment");
                break;
            case "savings":     System.out.println("Savings");
                break;
            case "metal":       System.out.println("Metal");
                break;    
            case "depositor":   System.out.print("Depositor\t");
                String valueOfAttribute = attrs.getValue(0);
                System.out.println("  " + valueOfAttribute);
                break;
            case "fullname":    System.out.print("Fullname\t");
                current = 3;
                break;
            case "account":     System.out.print("Account\t\t");
                current = 4;
                break;
            case "amount":      System.out.print("Amount\t\t");
                current = 5;
                break;
            case "profitability":   System.out.print("Profitability\t");
                current = 6;
                break;
            case "period":      System.out.print("Period\t\t");
                current = 7;
                break;
        }
    }
    
    @Override
    public void endElement(String uri, String LocalName, String qName){
        switch(qName){
            case "bank":        System.out.println("\tend Bank");
                break;
            case "name":        System.out.println("\tend Name");
                break;
            case "country":     System.out.println("\tend Country");
                break;
            case "type":        System.out.println("end Type");
                break;
            case "demand":      System.out.println("end Demand");
                break;
            case "fixed":      System.out.println("end Fixed");
                break;
            case "payment":      System.out.println("end Payment");
                break;
            case "savings":      System.out.println("end Savings");
                break;
            case "metal":      System.out.println("end Metal");
                break;
            case "depositor":   System.out.println("end Depositor");
                break;
            case "fullname":    System.out.println("\tend Fullname");
                break;
            case "account":     System.out.println("end Account");
                break;
            case "amount":      System.out.println("\tend Amount");
                break;
            case "profitability":   System.out.println("\t\tend Profitability");
                break;
            case "period":      System.out.println("\t\tend Period");
                break;
        }        
    }
    
    @Override
    public void characters(char[] ch, int start, int length){
        if(current != 0) {
            String text = new String(ch,start,length);
            System.out.print("  " + text + "\t");
            current = 0;
        }
    }
}
