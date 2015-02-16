package localedates;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;


public class LocaleDates {

    public static void main(String[] args) throws ParseException {
//        String s = "May 17, 1998";
//        Locale current = Locale.US;
//        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, current);
//        Date d = df.parse(s);
//        System.out.println(d);
        
        Date d = new Date();
        Locale current = Locale.UK;
        DateFormat dfUK = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,current);
        String date = dfUK.format(d);
        System.out.println(date);
    }
    
}
