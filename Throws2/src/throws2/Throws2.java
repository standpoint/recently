/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throws2;
class Exception1 extends Exception {}
class Exception2 extends Exception1 {}

class A{
    public void f() throws Exception1 {}
}

class B extends A {
    public void f() throws Exception2,Exception1 {}
}

/**
 *
 * @author vladimir
 */
public class Throws2 {
    
    static public A method(){
        return new B();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        A pa=method();
        try {
            pa.f();
        } catch (Exception1 e) {
            e.printStackTrace();
        }
    }
    
}
