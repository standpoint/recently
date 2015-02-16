/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite2;

/**
 *
 * @author volodya
 */
public class InvalidArgs extends Exception {
    String value = "Invalid arguments\n(must be a single string expression,\n"
            + "without any spaces, e.g.: (2.0+6)*4.1 )";
}
