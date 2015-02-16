/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrupted;

import java.util.logging.Level;
import java.util.logging.Logger;

class Thread1 extends Thread{
    Thread2 th;
    public Thread1(Thread2 th){
        this.th = th;
    }
    
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            
        }
        th.interrupt();
    }
}

class Thread2 extends Thread{
    public void run(){
//        while(!interrupted()){            // корректное завершение потока
//            System.out.println("Thread running");
//        }
//        System.out.println("Thread stopped");
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.err.println("error");
            System.err.println(isInterrupted());
            
        }
    }
}

public class Interrupted {

    public static void main(String[] args) {
        Thread2 th2 = new Thread2();
        Thread1 th1 = new Thread1(th2);
        th2.start();
        th1.start();
        
    }
    
}
