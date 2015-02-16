/*
 * Set realization
 */
package setdemo;
import java.util.*;
/**
 * Main class for Set demonstration
 * @author vladimir
 */
public class SetDemo {
    
    public static void main(String[] args) {
        int element = 10;
        int size = 5;
        Random r = new Random();
        Container array1 = new MyArray();
        Container list1 = new MyList();
        for (int i = 0; i < size; i++) {
            array1.add(r.nextInt()/100000000);
            list1.add(r.nextInt()/100000000);
        }
        Container array2 = array1.copy();
        Container list2 = list1.copy();
        array2.add(element);
        list2.add(element);
        System.out.print("array1:\t" + array1.toString());
        System.out.print("list1:\t" + list1.toString());
        System.out.print("array2:\t" + array2.toString());
        System.out.print("list2:\t" + list2.toString());
        element++;
        System.out.println("Does contain " + element + " in array2?\t" 
                            + array2.contains(element));
        System.out.println("Does contain " + element + " in list2?\t" 
                            + list2.contains(element));
        System.out.println("array2 size = " + array2.size());
        System.out.println("list2 size = " + list2.size());
        
        Set s1 = new Set(array1);
        Set s2 = new Set(list1);
        Set s = s1.union(s2);
        System.out.print("Set s1: " + s1.toString());
        System.out.print("Set s2: " + s2.toString());
        System.out.print("union of s1 and s2: " + s.toString());
    }
}
