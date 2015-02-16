/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

class MyQueue{
    Queue q = new LinkedList();
    int maxElements;
    public MyQueue(int maxElements){
        this.maxElements = maxElements;
    }
    
    public void add(Object o){
        synchronized(q) {   
            while(q.size() >= maxElements) {
                try {
                    q.wait();
                } catch (InterruptedException ex) {
                    
                }
            }
            q.add(o);
            q.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " add the object");
    }
    
    public Object remove(){
        Object o = null;
        synchronized(q){
            while(q.size() == 0){
                try {
                    q.wait();
                } catch (InterruptedException ex) {
                    
                }
            }
            o = q.poll();
            q.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " remove the object");
        return o;
    }
}
class Producer implements Runnable{
    MyQueue mq;
    public Producer(MyQueue mq){
        this.mq = mq;
    }

    @Override
    public void run() {
        while(true){
            mq.add(new Object());
        }
    }
}

class Consumer implements Runnable {
    MyQueue mq;
    public Consumer(MyQueue mq) {
        this.mq = mq;
    }

    @Override
    public void run() {
        while(true){
            mq.remove();
        }
    }
}
public class ProducerConsumer {

    
    public static void main(String[] args) {
        MyQueue m = new MyQueue(10);
        Producer p = new Producer(m);
        Consumer c = new Consumer(m);
        Thread prod1 = new Thread(p);
        Thread prod2 = new Thread(p);
        Thread prod3 = new Thread(p);
        Thread cons1 = new Thread(c);
        Thread cons2 = new Thread(c);
        prod1.start();
        prod2.start();
        prod3.start();
        cons1.start();
        cons2.start();
        
    }
    
}
