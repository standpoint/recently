/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harbor2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShipsQueue {
    Queue<Ship> queue;
    
    public ShipsQueue(Ship ... ships){
        queue = new LinkedList<>(Arrays.asList(ships)); 
    }
    
    public Ship remove() {
        Ship ship = null;
        synchronized(queue){
            while(queue.size() == 0){
                try {
                    queue.wait();
                } catch (InterruptedException ex) {}
            }
            ship = queue.poll();
            queue.notifyAll();
        }
        return ship;
    }
    
}
