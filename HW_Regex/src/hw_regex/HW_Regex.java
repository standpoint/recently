/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class EmailValidation {
    private static Pattern p  = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)"
            + "*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$");
    
    public static boolean isEmail(String email){
        Matcher m = p.matcher(email);
        return m.find();
    }
}

class LeapYearValidator {
    private static Pattern p = Pattern.compile("((1[6789]|2[01])"
            + "(([2468][048])|(0[48])|[13579][26]))|(1600)|(2000)");
    public static boolean isLeapYear(String year){
        Matcher m = p.matcher(year);
        return m.find();
    }
}

class Canonical {
    private static Pattern p = Pattern.compile("(?i)<link\\srel=\"canonical\"[^>]*>");
    
    public static String getCanonical(String page){
        String s = "";
        Matcher m = p.matcher(page);
        while(m.find()){
            s += m.group() + "\n";
        }
        return s;
    }
}

class Paragraph {
    private static Pattern p = Pattern.compile("(?i)(?<=<p>).*[[^(<p>)]*]");
    
    public static ArrayList<String> getParagraphs(String page){
        ArrayList<String> listP = new ArrayList<>();
        Matcher m = p.matcher(page);
        while(m.find()){
            listP.add(m.group());
        }
        return listP;
    }
}

/**
 *
 * @author volodya
 */
public class HW_Regex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Leap Year
        for(int i = 1590; i < 2101; i++){
            if(LeapYearValidator.isLeapYear(String.valueOf(i)))
                System.out.println(i);
        }
        
        //canonical-teg
        String filename = System.getProperty("user.dir") + "\\db\\canonical.html";
        File f = new File(filename);
        FileInputStream in = new FileInputStream(f);
        int c = 0;
        char[] ch = new char[(int)f.length()];
        int i = -1;
        while((c = in.read()) != -1){
            ch[++i] = (char)c;
        }
        String s = new String(ch);
        
        System.out.println(Canonical.getCanonical(s));
        ArrayList<String> listP = Paragraph.getParagraphs(s);
        for(String p:listP){
            System.out.println(p);
        }
        String email = "v.kamenskyi@gmail.com";
        System.out.println(email + " - " + EmailValidation.isEmail(email));
    }
}
