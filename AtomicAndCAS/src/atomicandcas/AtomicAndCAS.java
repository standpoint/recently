/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomicandcas;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread extends Thread {
    AtomicInteger ai;
    public MyThread(AtomicInteger ai) {
        this.ai = ai;
    }
    public void run(){
        for(int i = 0; i < 500; i++) {
            ai.incrementAndGet();   // equal a++
        }
    }
    
}
class MyThread1 extends Thread {
    AtomicInteger ai;
    public MyThread1(AtomicInteger ai) {
        this.ai = ai;
    }
    public void run(){
        for(int i = 500; i < 1000; i++) {
            ai.incrementAndGet();   // equal a++
        }
    }
    
}
/**
 *
 * @author volodya
 */
public class AtomicAndCAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger ai = new AtomicInteger();
        MyThread mt = new MyThread(ai);
        MyThread1 mt1 = new MyThread1(ai);
        mt.start();
        mt1.start();
        mt.join();
        mt1.join();
        System.out.println(ai.get());
    }
    
}
