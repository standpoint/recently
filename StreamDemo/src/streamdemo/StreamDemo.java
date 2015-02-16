/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author volodya
 */
public class StreamDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1","a2","b1","c2","c1");
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println("");
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
    }
    
}
