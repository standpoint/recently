package localedemo;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Locale myLocale = new Locale("uk","UA");
        ResourceBundle rb = ResourceBundle.getBundle("base", myLocale);
        String str1 = rb.getString("str1");
        String str2 = rb.getString("str2");
        System.out.println(str1 + " " + str2);
    }
}
