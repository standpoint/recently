/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ThreadPool{
    Queue<Runnable> tasks;
    Queue<MyThread> threads = new LinkedList<>();
    int maxThreads;
    
    private class MyThread extends Thread {
        volatile public Runnable r;
        boolean isFree = true;
        public void run(){
            while(!interrupted()) {
                synchronized(tasks){
                    r = tasks.poll();
                    while(r == null) {          
                        try {
                            tasks.wait();
                            r = tasks.poll();
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                isFree = false;
                r.run();
                r = null;
                isFree = true;
            }
        }
        
    }
        
    public ThreadPool(Queue<Runnable> tasks, int maxThreads){
        this.tasks = tasks;
        this.maxThreads = maxThreads;
    }
    
    public void executeTasks(){
        if(tasks.size() > 0) {
            int countThreads;
            if(tasks.size() < maxThreads) {
                countThreads = tasks.size();
            } else {
                countThreads = maxThreads;
            }
            int count = 0;
            while(count < countThreads) {
                MyThread t = new MyThread();
                t.start();
                threads.add(t);
                count++;
            }
        }
    }
    
    public void shutdown(){
        for(MyThread t : threads) {
            t.interrupt();
        }
    }
    
    public boolean isDone(){
        boolean flag = true;
        synchronized(tasks){
            if(tasks.size() == 0){
                for (MyThread t : threads) {
                    if(t.isFree!=true){
                        flag = false;
                    }
                }
            } else {
                flag = false;
            }
        }
        return flag;
    }
    
}

class Task implements Runnable{
    
    int size;
    int[] mass;
    long result;
    
    public Task(int size){
        this.size = size;
        mass = new int[size];
        for (int i = 0; i < mass.length; i++){
            mass[i] = i;
        }
    }
    
    @Override
    public void run() {
        for (int el:mass){
            result += el;
        }
    }
    
}
/**
 *
 * @author volodya
 */
public class ThreadPoolDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int maxThreads = 10;
        Queue<Runnable> tq = new LinkedList<>();
        for(int i = 0; i < maxThreads; i++){
            Task task = new Task(i*100);
            tq.add(task);
        }
        ThreadPool pool = new ThreadPool(tq, maxThreads);
        pool.executeTasks();
        pool.shutdown();
    }
}
