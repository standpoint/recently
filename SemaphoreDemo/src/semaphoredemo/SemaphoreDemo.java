/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoredemo;

import java.util.logging.Level;
import java.util.logging.Logger;

class Semaphore{
    int value;
    public Semaphore(int value) {
        this.value = value;
    }
    
    public synchronized void acquire() throws InterruptedException{
        while(value==0){
            wait();
        }
        value--;
    }
    
    public synchronized void release() {
        value++;
        notifyAll();
    }
}

class MyThread extends Thread{
    Semaphore s;
    public MyThread(Semaphore s){
        this.s = s;
    }
    
    @Override
    public void run(){
        try {
            s.acquire();
            /*
            synchronized code
            */
            s.release();
        } catch (InterruptedException ex) {
            
        }
    }
}
/**
 *
 * @author volodya
 */
public class SemaphoreDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
