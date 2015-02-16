/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harbor2;

/**
 *
 * @author volodya
 */
public class PortDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int berthsNum = 5;
        final int portCapacity = 1000;
        int warehouse = 400;
        int shipsNum = 10;
        int shipCap = 20;
        Ship[] ships = new Ship[shipsNum];
        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship((i+1), shipCap, (int)(Math.random()*shipCap));
        }
        ShipsQueue sq = new ShipsQueue(ships);
        Port port = new Port(portCapacity, warehouse, berthsNum, sq);
        Thread portThread = new Thread(port);
        portThread.start();
        Thread[] shipThreads = new Thread[shipsNum];
        for (int i = 0; i < shipsNum; i++) {
            shipThreads[i] = new Thread(ships[i]);
            shipThreads[i].start();
        }
        
    }
    
}
