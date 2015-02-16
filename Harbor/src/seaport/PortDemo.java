/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaport;

import java.util.PriorityQueue;

/**
 *
 * @author volodya
 */
public class PortDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int portCapacity = 100;
        int maxContainerWeight = 3;
        int berthNum = 10;
        int shipsNum = 10;
        
        Container[] containers = new Container[portCapacity/2];
        
        for(int i = 0; i < containers.length; i++){
            containers[i] = new Container((int) (Math.random() * maxContainerWeight));
        }
        
        Port port = new Port(portCapacity,berthNum);
        port.loadWarehouse(containers);
        
        Ship[] ships = new Ship[shipsNum];
        int priority = 0;
        int tonnage = 0;
        Container[] cargo;
        
        for(int i = 0; i < ships.length; i++) {
            int size = (int) (Math.random() * shipsNum);
            cargo = new Container[size];
            System.arraycopy(containers, 0, cargo, 0, size);
            for(Container container : cargo) {
                tonnage += container.weight;
            }
            tonnage *= 3;
            ships[i] = new Ship(tonnage, ++priority, true, true,cargo);
            tonnage = 0;
        }
        
        port.queuedShips(ships);
        
        Thread portThread = new Thread(port);
        portThread.start();
        System.out.println("");
    }
}
