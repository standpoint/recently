/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synch;

class A{
    private int x;
    public A(){
        x = 0;
    }
    public void increament(){
        x++;
    }
    public void decrement(){
        x--;
    }
    public int getX(){
        return x;
    }
}

class ThreadIncrement implements Runnable {
    A pa;
    public ThreadIncrement(A pa){
        this.pa = pa;
    }
    public void run(){      // wait while 'lock' will be set in 0
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
                synchronized(pa){
                    pa.increament();
                    System.out.println("thread " 
                            + Thread.currentThread().getName() + " " + pa.getX());
                }       // set 'lock' to 0        

        }
    }
}

class ThreadDecrement implements Runnable {
    A pa;
    public ThreadDecrement(A pa){
        this.pa = pa;
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
                synchronized(pa){
                    pa.decrement();
                    System.out.println("thread " 
                            + Thread.currentThread().getName() + " " + pa.getX());
                }
  
        }
    }
}

public class Synch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        A pa = new A();
        ThreadIncrement ti = new ThreadIncrement(pa);
        ThreadDecrement td = new ThreadDecrement(pa);
        Thread thread1 = new Thread(ti);
        Thread thread2 = new Thread(ti);
        Thread thread3 = new Thread(td);
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
}
