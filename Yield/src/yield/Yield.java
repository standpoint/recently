/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yield;
class MyThread extends Thread {
    boolean flag = false;
    String word;
    public MyThread(boolean flag, String word){
        this.flag = flag;
        this.word = word;
    }
    
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println(word);
            if(flag) {
                yield();
            }
        }
    }
}
public class Yield {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyThread th1 = new MyThread(true,"aaa");
        MyThread th2 = new MyThread(true,"bbb");
        th1.start();
        th2.start();
        
    }
    
}
