/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflectiondemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {
    private int a;
    public A(int a){
        this.a = a;
    }
    
    public void setA(int a){
        this.a = a;
    }
    public int getA(){
        return a;
    }
}

class B{
    public void f(int a, int b){
        System.out.println(a + " " + b);
    }
    
    public static void g(int c, int d){
        System.out.println(c + " " + d);
    }
}
/**
 *
 * @author volodya
 */
public class ReflectionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class c = Class.forName("reflectiondemo.A");   // creats object of class Class
        Field[] fields = c.getDeclaredFields(); // gets fields
        for(Field f:fields){
            System.out.println(f.getType() + " " + f.getName());
        }
        Method[] methods = c.getDeclaredMethods();
        for(Method m:methods){
            String s = m.getReturnType() + " " + m.getName() + "(";
            Class[] types = m.getParameterTypes();
            if(types.length!=0)
                for (Class t:types) {
                    s+= " " + t.getName();
                }
            s += ")";
            System.out.println(s);
        }
        
        Constructor[] cons = c.getDeclaredConstructors();
        for(Constructor con:cons){
            String s = "A(";
            Class[] types = con.getParameterTypes();
            if(types.length!=0)
                for (Class typeClass:types) {
                    s+= " " + typeClass.getName();
                }
            s += ")";
            System.out.println(s);
        }
        
        Class[] typesOfParam = {int.class};
        Constructor con = c.getDeclaredConstructor(typesOfParam);
        Object[] param = {new Integer(100)};
        A pa = (A)con.newInstance(param);       // equal to A pa = new A(100);
        System.out.println(pa.getA());
        Field f = c.getDeclaredField("a");
        f.setAccessible(true);  // remove 'private' modificator
        f.set(pa, new Integer(200));
        System.out.println(pa.getA());
        
        Class[] typesParam = {int.class};
        Method m = c.getDeclaredMethod("setA", typesParam);
        Object[] par = {new Integer(500)};
        m.invoke(pa, par);
        System.out.println(pa.getA());
        
        
        Class c1 = B.class;     // creat object of class Class
        B pb = new B();
        
//        Class c2 = pb.getClass();
//        Class c3 = Class.forName("reflectiondemo.B");
        Class[] param1 = {int.class,int.class};
        Method m1 = c1.getMethod("f", param1);
        Object[] params = {new Integer(100),new Integer(200)};
        m1.invoke(pb, params);
    }
}
