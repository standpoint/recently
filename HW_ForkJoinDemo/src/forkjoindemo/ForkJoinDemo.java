/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkjoindemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Function{
    private double x;
    private final double a = 1000;
    private final double b = 10;
    private final double exp = Math.E;
    private boolean flag = false;
    
    double calc(double x){
        return a/Math.pow(exp,x) - b;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Task extends RecursiveAction {
    private final Function f;
    private final double alpha = 0.001;
    private boolean hasResolve = false;
    private final double left;
    private final double right;
    private final double diff;
    public static int count = 0;

    
    public Task(Function f, double left, double right){
        
        this.f = f;
        this.left = left;
        this.right = right;
        this.diff = Math.abs(left-right);
        hasResolve = f.calc(left)*f.calc(right) <= 0;
    }

    @Override
    protected void compute() {
        if (diff <= alpha) {
            f.setX(right);
            f.setFlag(true);
        } else if(hasResolve) {
            double mid = (left + right)/2.;
            Task t1 = new Task(f,left,mid);
            Task t2 = new Task(f,mid,right);
            count++;
            invokeAll(t1,t2);
        }
    }
}
/**
 *
 * @author volodya
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        Function f = new Function();
        double left = Double.MIN_VALUE;
        double right = Double.MAX_VALUE;
        Task t = new Task(f,left,right);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(t);
        pool.shutdown();
        System.out.println("1000/e^x - 10 = 0");
        if (f.isFlag()) {
            System.out.println("Result: " + f.getX());
            System.out.println("number of devisions = " + Task.count);
        } else {
            System.out.println("Has no solutions in the range (" + left
                    + "; " + right + ")");
        }
        
    }
}
