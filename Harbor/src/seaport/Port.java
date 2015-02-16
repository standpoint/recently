/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaport;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 *
 * @author volodya
 */
public class Port implements Runnable {
    List<Container> warehouse = new LinkedList<>();
    int portCapacity;
    List<Berth> berths;
    Queue<Ship> shipsQueue;
    
    public Port(int portCapacity, int berthNum) {
        this.portCapacity = portCapacity;
        berths = new LinkedList<>();
        for (int i = 1; i <= berthNum; i++) {
            berths.add(new Berth(i));
        }
        shipsQueue = new PriorityQueue<>();
    }

    class Berth implements Runnable {
        
        private final int serialNum;
        private boolean handled = false;
        Ship ship;
        
        protected Berth(int serialNumber){
            this.serialNum = serialNumber;
        }
        
        public synchronized void handle() throws InterruptedException {
            ship = shipsQueue.poll();
            handled = true;
            while(ship.toUnload) {
                System.out.println(ship.toString() + " under unloading at " 
                        + this.toString());
                System.out.println(ship.toString() + " cargo:" + ship.cargo);
                unload();
            }
            while(ship.toLoad) {
                System.out.println(ship.toString() + " under loading at " 
                        + this.toString());
                System.out.println(ship.toString() + " cargo:" + ship.cargo);
                load();
            }
            System.out.println("\n" + ship.toString() + " is sailed away\n");
            handled = false;
            notifyAll();
        }

        /**
         * @return the handled
         */
        public synchronized boolean isHandled() {
            return handled;
        }
        
        public void load() throws InterruptedException {
            synchronized(warehouse) {
                while(warehouse.isEmpty()) {
                    warehouse.wait();
                }
                if((ship.cargoWeight + warehouse.get(0).weight) < ship.tonnage) {
                    ship.cargo.push(warehouse.remove(0));
                } else {
                    ship.toLoad = false;
                }
                warehouse.notifyAll();
            }
        }
            
        public void unload() throws InterruptedException {
            synchronized(warehouse){
                while (warehouse.size() >= portCapacity){
                    warehouse.wait();
                }
                if(!ship.cargo.isEmpty()){
                    warehouse.add(ship.cargo.pop());
                } else {
                    ship.toUnload = false;
                }
                warehouse.notifyAll();
            }
        }
        
        @Override
        public void run() {
            while(!shipsQueue.isEmpty()) {
                while(!handled){
                    if (warehouse.size() >= portCapacity) unloadWarehouse(5);
                    try {
                        handle();
                    } catch (InterruptedException ex) {}
                }
            }
            System.out.println("There are not ships at the queue to the port");
        }
        
        @Override
        public String toString(){
            return "Breth#" + serialNum;
        }
    }
    
    /**
     * Queued the ships in port. Synchronized.
     * @param ships
     */
    public void queuedShips(Ship ... ships) {
        shipsQueue.addAll(Arrays.asList(ships));
    }
    
    /**
     * Loads the containers to the port warehouse.
     * @param containers
     */
    public void loadWarehouse(Container ... containers) {
        int count = 0;
        while(count < containers.length && count < portCapacity) {
            this.warehouse.add(containers[count]);
            count++;
        }
        if (count == portCapacity) {
            System.out.println("Port warehouse is fully loaded (" + count + ")\n");
        }
        System.out.println("Port warehouse is ready (load:" + count + ")\n");
    }
    
    /**
     * Unloads the containers from the port warehouse. Synchronized.
     * @param number - number of the containers which will be unloaded from 
     * the warehouse (not to the ships), - must be less than current the port 
     * warehouse size. If not, this number will be decreased to warehouse size.
     */
    public synchronized void unloadWarehouse(int number){
        if (number > warehouse.size()) {
            number = warehouse.size();
        }
        for (int i = 0; i < number; i++) {
            System.out.println(warehouse.remove(0).toString() 
                    + " is dispatced from Port");
        }
    }
    
    @Override
    public void run() {
        Thread[] threads = new Thread[berths.size()];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(berths.get(i));
            threads[i].start();
        }
        if (shipsQueue.isEmpty()) {
            System.out.println("There are not any ship in the queue to the Port\n");
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {}
        }
        System.out.println("The port is pending\n");
    }
}
