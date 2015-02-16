/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchangerdemo;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread extends Thread{
    Exchanger<Integer> ex;
    public MyThread(Exchanger<Integer> ex){
        this.ex = ex;
    }
    
    public void run(){
        try {
            Integer i = ex.exchange(10);
            System.out.println(i.intValue());
        } catch (InterruptedException ex) {
            
        }
    }
}
class MyThread1 extends Thread{
    Exchanger<Integer> ex;
    public MyThread1(Exchanger<Integer> ex){
        this.ex = ex;
    }
    
    public void run(){
        try {
            Integer i = ex.exchange(5);
            System.out.println(i.intValue());
        } catch (InterruptedException ex) {
            
        }
    }
}
/**
 *
 * @author volodya
 */
public class ExchangerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exchanger<Integer> ex = new Exchanger<>();
        MyThread th = new MyThread(ex);
        MyThread1 th1 = new MyThread1(ex);
        th.start();
        th1.start();
    }
    
}
