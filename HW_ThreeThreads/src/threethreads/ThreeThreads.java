/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threethreads;
class Sum implements Runnable {
    
    long start;
    long end;
    private static long right;
    private static long result;
    
    public Sum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long res = getResult();
        for (long i = start; i < end && i <= 100000; i++) {
            res += i;
        }
        setResult(res);
    }

    public static long getRight() {
        return right;
    }

    public static synchronized void setRight(long r) {
        right = r;
    }
    
    public static synchronized void setResult(long res) {
        result += res;
    }

    public long getResult() {
        return result;
    }

}
/**
 *
 * @author volodya
 */
public class ThreeThreads {
    static int nThreads = 3;
    static Sum[] s = new Sum[nThreads];
    static long end = 100000;
    
    static long left;
    static long right;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        long begin = 0;
        long sum = 0;
        
        
        int threadCapacity = 300;
        
        Sum.setRight(begin);
        Thread[] threads = new Thread[nThreads];
        
        for (int i = 0; i < threads.length; i++) {
            right = initNextThread(i, threadCapacity, right, threads);
        }
        
        while (right <= end) {
            
            for (int i = 0; i< nThreads; i++){
                if(!threads[i].isAlive()) {
                    sum += s[i].getResult();
                    right = initNextThread(i, threadCapacity, right, threads);
                    System.out.println(threads[i].getName() + " " + right);
                }
            }
        }
        System.out.println(sum);
    }

    public static long initNextThread(int i, int threadCapacity, long right, Thread[] threads) {
        long left;
        left = Sum.getRight() + i * threadCapacity;
        if (right < end) right = left + threadCapacity;
        else right = end;
        s[i] = new Sum(left,right);
        threads[i] = new Thread(s[i]);
        threads[i].start();
        Sum.setRight(right);
        return right;
    }
}
