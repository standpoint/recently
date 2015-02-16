/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localenumbers;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author volodya
 */
public class LocaleNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        String sum = "12,345.67";
        Locale current = Locale.US;
        NumberFormat nb = NumberFormat.getInstance(current);
        Number n = nb.parse(sum);
        System.out.println(n.doubleValue());
    }
    
}
