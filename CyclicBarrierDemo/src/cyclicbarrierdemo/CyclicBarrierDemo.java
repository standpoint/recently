/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclicbarrierdemo;

import java.util.logging.Level;
import java.util.logging.Logger;

class CyclicBarrier{
    final int valueMax;
    int currentValue;
    boolean flag = false;
    public CyclicBarrier(int value) {
        this.valueMax = value;
    }
    
    public synchronized void await() throws InterruptedException{
        if (currentValue == 0) {
            flag = false;
        }
        currentValue++;
        while(currentValue < valueMax && !flag) {
            wait();
        }
        flag = true;
        currentValue = 0;
        notifyAll();
    }
}

class MyThread extends Thread {
    CyclicBarrier cb;
    public MyThread(CyclicBarrier cb) {
        this.cb = cb;
    }
    
    @Override
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " started");
        try {
            cb.await();
        } catch (InterruptedException ex) {
            
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " continue");
    }
}
/**
 *
 * @author volodya
 */
public class CyclicBarrierDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3);
        MyThread thread1 = new MyThread(cb);
        MyThread thread2 = new MyThread(cb);
        MyThread thread3 = new MyThread(cb);
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
        
    }
    
}
