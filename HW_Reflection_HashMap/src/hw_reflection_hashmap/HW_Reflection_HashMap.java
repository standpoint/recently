/*
 * Using only reflection:
 * 1) Creat instance of HashMap
 * 2) Fill this one
 */
package hw_reflection_hashmap;

import java.lang.reflect.*;

/**
 *
 * @author volodya
 */
public class HW_Reflection_HashMap {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        Class c = Class.forName("java.util.HashMap");
        Constructor con = c.getConstructor();
        Object ph = con.newInstance();

        Class[] param = {Object.class,Object.class};
      
        Method add = c.getDeclaredMethod("put",param);
        for(int i = 0; i < 10; i++) {
            add.invoke(ph, "el.#"+i,i*2);
        }
        
        System.out.println(c.getSimpleName());
        System.out.println(add.getName());
        System.out.println(ph.toString());
        
        
    }
    
}
