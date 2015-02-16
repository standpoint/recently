package multithreads;
class Multiply implements Runnable {
    int[][] a;
    int[][] b;
    int[][] result;
    int col;
    
    public Multiply(int[][] a,int[][] b,int[][] result,int col) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.col = col;
    }
    
    public int[][] getResult(){
        return result;
    }
    
    public void run(){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][col] += a[i][j]*b[j][col]; 
            }
        }
    }
}

public class MultiThreads {

    public static void main(String[] args) throws InterruptedException {  
        
        int[][] a  = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] b  = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        
        Thread[] threads = new Thread[b.length];
        
        for(int i = 0; i < b.length; i++) {
            Multiply m = new Multiply(a,b,result,i);
            threads[i] = new Thread(m);
            threads[i].start();
        }
        
        for(int i = 0; i < b.length; i++) {
            threads[i].join();
        }
    }   
}
