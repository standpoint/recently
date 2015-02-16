/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadlocaldemo;

class MyThread extends Thread {
    ThreadLocal<String> tl;
    String name;
    public MyThread(ThreadLocal<String> tl, String name){
        this.tl = tl;
        this.name = name;
    }
    
    public void run(){
        try {
            tl.set(name);
            Thread.sleep(3000);
            System.out.println(tl.get());
        } catch (InterruptedException ex) {
        
        }
    }
}

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> tl = new InheritableThreadLocal<>();
        MyThread th1 = new MyThread(tl, "aaa");
        MyThread th2 = new MyThread(tl, "bbb");
        th1.start();
        Thread.sleep(1000);
        th2.start();
        
    }
    
}
