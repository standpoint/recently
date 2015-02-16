/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadgroups;

class MyThread implements Runnable {
    public void run(){
        while(true);
    }
}

public class ThreadGroups {

    public static void main(String[] args) {
        MyThread tt = new MyThread();
        ThreadGroup parentGroup = new ThreadGroup("parent group");
        ThreadGroup tg = new ThreadGroup(parentGroup,"mygroup");
        tg.setMaxPriority(7); // in 'tg' can't be no one thread with priority more than 7
        Thread t = new Thread(tg,tt);
        Thread t1 = new Thread(tg,tt);
        t.start();
        t1.start();
        Thread[] masOfThreads = new Thread[2];
        parentGroup.enumerate(masOfThreads,true);   // true - recursive, false - without recursive
        for(Thread cur : masOfThreads) {
            System.out.println(cur);
        }
        System.out.println(tg.activeCount());
    }
    
}
