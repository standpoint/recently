/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdownlatchdemo;
class CountDownLatch{
    int value;
    public CountDownLatch(int value){
        this.value = value;
    }
    
    public synchronized void await() throws InterruptedException{
        while(value > 0) {
            wait();
        }
    }
    
    public synchronized void countDown(){
        value--;
        notifyAll();
    }
}
/**
 *
 * @author volodya
 */
public class CountDownLatchDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
