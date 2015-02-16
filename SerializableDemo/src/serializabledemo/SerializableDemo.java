/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializabledemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A extends B implements Serializable{
    private int a=10;
    transient private int b=400;
    public A(int value){
        this.a = value;
    }
    
    public int getA(){
        return a;
    }
    
    public int getB(){
        return b;
    }
}

class B{
    int a;
    public B(){
        System.out.println("Hello");
    }
}
/**
 *
 * @author volodya
 */
public class SerializableDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        A ts = new A(100);
        oos.writeObject(ts);
        oos.flush();
        oos.close();
        
        // deserialization
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        A myts = (A)oin.readObject();
        System.out.println("version=" + myts.getA());
        System.out.println("vertion=" + myts.getB());
    }
    
}
