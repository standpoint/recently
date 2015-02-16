package multithreads;

/**
 * calculate s = 1 + 2 + 3 + ... + 1000
 * Needs to analyze what threads number will be optimal
 */

class Sum implements Runnable{ // more useful than 'extends Thread'
    
    private long begin;
    private long end;
    private long result = 0;
    private int index;
    private int threadNum;
    
    public Sum(long begin, long end, int threadNum, int index) {
        this.begin = begin;
        this.end = end;
        this.threadNum = threadNum;
        this.index = index;
    }
    
    public long getResult(){
        return result;
    }
    
    @Override
    public void run(){                          
        for (long i = (begin + index); i <= end; i += threadNum) {
            result += i;
        }
    }
}

public class MultiThreads {

    public static void main(String[] args) throws InterruptedException {       
        int threadsNum = 50;
        int passesNum = 1;
        long left = 0;
        long right = Integer.MAX_VALUE;
        long total = 0;
        long traceTime = 0;
        long traceTimes = 0;
        long end,start;
        // changes number of threads (from 1 to threadsNum) 
        for (int k = 1; k <= threadsNum; k++) {             
            // passes for average time finding
            for (int j = 0; j < passesNum; j++) {           
                start = System.currentTimeMillis();
        //-- measuring Start -------------------------------------------------        
                Sum[] sum = new Sum[k];
                Thread[] threads = new Thread[k];
                for (int i = 0; i < threads.length; i++) {
                    sum[i] = new Sum(left,right,threads.length,i);
                    threads[i] = new Thread(sum[i]);
                    threads[i].start();
                }
                for (int i = 0; i < threads.length; i++) {
                    threads[i].join();
                    total += sum[i].getResult();
                }
        //-- measuring End ---------------------------------------------------       
                end = System.currentTimeMillis();
                traceTimes += (end - start);
//                System.out.println("Result: " + total);
                total = 0;
            }
            traceTime = traceTimes/20;
            System.out.println("Threads number:" + k + "\tTrace time, ms:" + traceTime);
            traceTimes = 0;
        }
    }   
}