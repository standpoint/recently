/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harbor2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author volodya
 */
public class Port implements Runnable {
    
    static List<Berth> berths = new LinkedList<>();
    int berthsNum;
    ShipsQueue shipsQueue;
    final int capacity;
    Integer warehouse;
    Ship ship;
    
    public Port(int capacity, int warehouse, int berthsNum, ShipsQueue sq){
        this.capacity = capacity;
        this.warehouse = warehouse;
        this.berthsNum = berthsNum;
        shipsQueue = sq;
    }
    
    public boolean isAccept(){
        synchronized(berths) {
            for(Berth berth : berths){
                if(berth.available) {
                    berths.notifyAll();
                    return true;
                }
            }
            berths.notifyAll();
        }
        return false;
    }
    
    public static Berth moor(Ship ship){
        synchronized(berths){
            Iterator<Berth> it = berths.iterator();
            while(it.hasNext()){
                final Berth berth;
                berth = it.next();
                if(berth.available) {
                    System.out.println(ship.toString() 
                            + " is mooring to the berth#" + berth.serialNum);
                    berth.available = false;
                    berth.ship = ship;
//                    berths.notifyAll();
                    return berth;
                }
            }
            berths.notifyAll();
        }
        return null;
    }

    @Override
    public void run() {
        Thread[] berthThreads = new Thread[berthsNum];
        for(int i = 0; i < berthsNum; i++) {
            Berth berth = new Berth(i+1);
            berths.add(berth);
            berthThreads[i] = new Thread(berth);
            berthThreads[i].start();
        }
//        Thread[] shipThreads = new Thread[shipsQueue.queue.size()];
//        for(int i = 1; !shipsQueue.queue.isEmpty(); i++) {
//            Ship ship = shipsQueue.remove();
//            shipThreads[i] = new Thread(ship);
//            shipThreads[i].start();
//        }

    }
    
    class Berth implements Runnable {
        Ship ship;
        final int serialNum;
        boolean available = true;

        public Berth(int serialNum) {
            this.serialNum = serialNum;
        }
        
        public void unload() {
            Port port = Port.this;
            synchronized(port){
                while(warehouse >= capacity) {
                    try {
                        port.wait();
                    } catch (InterruptedException ex) {}
                }
                if (ship.cargo == 0) {
                    System.out.println(ship.toString() + " is unloaded");
                } else {
                    warehouse++;
                    ship.cargo--;
                    if (ship.cargo == 0) ship.toUnload = false;
                    System.out.println(ship.toString() + " unoloading");
                }
                port.notifyAll();
            }
        }

        public void load() {
            Port port = Port.this;
            synchronized(port){
                while(warehouse == 0) {
                    try {
                        System.out.println("Warehouse is empty");
                        port.wait();
                    } catch (InterruptedException ex) {}
                }
                if (ship.cargo == ship.tonnage) {
                    System.out.println(ship.toString() + " is loaded");
                    ship = null;
                } else {
                    warehouse--;
                    ship.cargo++;
                    if (ship.cargo == ship.tonnage) ship.toLoad = false;
                    System.out.println(ship.toString() + " loading");
                }
                port.notifyAll();
            }
        }

        
        @Override
        public void run() {
            while(!Thread.currentThread().interrupted()){
                while(!available) {
                    while(ship.toUnload){
                        unload();
                    }
                    if (ship == null) {
                        available = true;
                        Thread.currentThread().interrupt();
                    }
                    while(ship.toLoad){
                        load();
                    }
                }
            }
            System.err.println(ship.toString() + " sail the sea");
        }
        
        @Override
        public String toString(){
            return "Berth#" + serialNum;
        }
    }
}
