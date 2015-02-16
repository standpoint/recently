/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executorscallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Sum implements Callable<Long>{
    int begin;
    int end;
    public Sum(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long result = 0;
        for (int i = begin; i < end; i++){
            result += i;
        }
        return result;
    }
}
/**
 *
 * @author volodya
 */
public class ExecutorsCallable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        Sum s1 = new Sum(0,500);
        Sum s2 = new Sum(500,1500);
        Sum s3 = new Sum(1500,2000);
        Future<Long> f1 = service.submit(s1);
        Future<Long> f2 = service.submit(s2);
        Future<Long> f3 = service.submit(s3);
        
        while(!f1.isDone()||!f2.isDone()||!f3.isDone()){
            Thread.sleep(100);
        }
        
        long result1 = f1.get();
        long result2 = f2.get();
        long result3 = f3.get();
        long result = result1 + result2 + result3;
        System.out.println(result);
        
        service.shutdownNow();
    }
    
}
