/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalizabledemo;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class A implements Externalizable{
    private int a=10;
    transient private int b=400;
    public A(){
        
    }
    public A(int value){
        this.a = value;
    }
    
    public int getA(){
        return a;
    }
    
    public int getB(){
        return b;
    }

    @Override
    public void writeExternal(ObjectOutput oo) throws IOException {
        oo.writeInt(a);
    }

    @Override
    public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
        this.a = oi.readInt();
        this.b = a*40;
    }
}


/**
 *
 * @author volodya
 */
public class ExternalizableDemo {

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
