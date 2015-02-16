/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regexpdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author volodya
 */
public class RegExpDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("// удовлетворяет ли данная строка шаблону");
        Pattern p1 = Pattern.compile("([\\w]+(,|\\s|,\\s)?)+!");
        Matcher m1 = p1.matcher("aaay kjkkj sdfsdf,dsf, fdsfg sdfsf!");
        boolean b = m1.matches();
        System.out.println(b);
        //--------------------------------------
        System.out.println("// поиск подстроки, соответствующей данному шаблону");
        Pattern p2 = Pattern.compile("[A-Z][a-z0-9\\s]*\\?");   // вопросительные предложения
        Matcher m2 = p2.matcher("Aaayat jkhjkh fjakehjabnbkuuyuihknaaaayfdf!"
                + "H fsgsdg fgdg ggg?"
                + "Gdfs gdfg gdfgdf gdg?"
                + "Ddgsg sdfgfgg ddsg sdgs dd ggdsg.");
        while(m2.find()){
            System.out.println(m2.group());
        }
    }
    
}
