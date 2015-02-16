package multithreads;

/**
 * calculate s = 1 + 2 + 3 + ... + 1000
 * 
 */

class Sum extends Thread {
    
    int begin;
    int end;
    int result = 0;
    boolean flag = false;
    boolean isOdd = false;
    
    public Sum(int begin, int end, boolean isOdd) {
        this.begin = begin;
        this.end = end;
        this.isOdd = isOdd;
    }
    
    public int getResult(){
        return result;
    }
    
    @Override
    public void run(){                          // entering into the thread
        if (isOdd ^ (begin%2 != 0)) {
            begin++;
        }
        for (int i = begin; i < end; i+=2) {
            result += i;
        }
        flag = true;
    }
    public boolean getFlag(){
        return flag;
    }
}

public class MultiThreads {

    public static void main(String[] args) throws InterruptedException {        //parent thread for s1,s2
        
        Sum s1 = new Sum(0,1001,false);                    
        Sum s2 = new Sum(0,1001,true);
        s1.start();                                 // start the thread s1
        s2.start();                                 // start the thread s2
        
//        while(!s1.getFlag() || !s2.getFlag()){}   //wait for the ending s1,s2
                                                    //NOT GOOD
        
        s1.join();              // block the main() while s1 is running
        s2.join();
        
        int sum1 = s1.getResult();
        int sum2 = s2.getResult();
        int total = sum1+sum2;
        System.out.println(total);
    }   
}
