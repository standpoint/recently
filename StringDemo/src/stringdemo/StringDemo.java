/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringdemo;

/**
 *
 * @author volodya
 */
public class StringDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "Hello";
        String s1 = new String("Hello");
        String s2 = s1.intern();            // строка из s1 записывается в пул строк
        System.out.println(s==s1);
        System.out.println(s==s2);
    }
    
}
