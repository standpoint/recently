/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setdemo;
import java.util.*;
/**
 *
 * @author vladimir
 */
public class SetDemo {
    
    public static void main(String[] args) {
        Container<Table> c1 = new MyList<>();   // Table container
        Container<Chair> c2 = new MyList();     // Chair container
        Table table = new Table();
        Table roundTable = new RoundTable();
        Chair chair = new Chair();
        
        c1.add(table);
        c1.add(roundTable);
//        c1.add(chair);    //incorrectly: can't cast Chair to Table
        c2.add(chair);  
//        c2.add(table);    //incorrectly
        Set s1 = new Set(c1);
        Set s2 = new Set(c2);
    }
}
