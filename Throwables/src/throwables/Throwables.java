/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throwables;

/**
 *
 * @author vladimir
 */
class MyException extends Exception {
        
    }
    class A{
        void f(int s){
            try{
            for (int i = 0; i<10; i++){}
            if (s==0) throw new MyException(); // перехват исключения в месте его возникновени
            for (int j = 0; j<20; j++){}
            } catch (MyException e) {
                e.printStackTrace();
            } catch (Exception e) {
                
            } finally {
                
            }
        }
    }
    
    class B{
        void f(int s) throws MyException {  // отложенній перехват
            
            for (int i = 0; i<10; i++){}
            if (s==20) throw new MyException();
            for (int j = 0; j<20; j++){}
            
        }
    }

public class Throwables {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        A pa = new A();
        B pb = new B();
        try{
            pb.f(20);
        } catch (MyException e){
            
        }
        try{
            List l = new List(10);
            l.add(3, 0);
            l.add(12, 1);
            l.add(4, 2);
            l.add(12,13);
            System.out.println(l.remove(1));
                    
        } catch (BadArgumentException e) {
            System.err.println(e.getMessage());
        } catch (ListFullException e) {
            e.printStackTrace();
        } catch (ListEmptyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
    
}
