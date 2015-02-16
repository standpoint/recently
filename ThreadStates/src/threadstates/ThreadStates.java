/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadstates;

/*
 * 1. new 
 * 2. runnable
 * 3. blocked
 * 4. waiting
 * 5. timed waiting
 * 6. terminated
 */

class MyThread extends Thread {
    public static Object o = new Object();
    public void run(){
        //for (int i = 0; i < 2000000; i++);
        synchronized(o){
            try {
//                o.wait(); // waiting
                o.wait(10000);
            } catch (InterruptedException ex) {
                
            }
        }
   
    }
}
public class ThreadStates {

    public static void main(String[] args) throws InterruptedException {
        MyThread th = new MyThread();
        Object o = new Object();
        MyThread.o = o;
//        synchronized(o){      // blocked state
            th.start();
            Thread.sleep(600);
            System.out.println(th.getState());
//        }
//        th.start();   // new state
//        System.out.println(th.getState());    
    }
    
}
