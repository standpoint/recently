/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaport;

import java.util.Stack;

/**
 *
 * @author volodya
 */
public class Ship implements Comparable<Ship> {
    int tonnage;
    int priority;
    boolean toUnload;
    boolean toLoad;
    String name;
    private static int count;
    Stack<Container> cargo = new Stack<>();
    int cargoWeight;
    
    public Ship(int tonnage, int priority, boolean toLoad, boolean toUnload, 
            Container ... cargo){
        this.tonnage = tonnage;
        this.priority = priority;
        this.toLoad = toLoad;
        this.toUnload = toUnload;
        name = String.valueOf(++count) + "/priority:" + priority;
        for (Container container : cargo) {
            cargoWeight += container.weight;
            if (cargoWeight <= tonnage) {
                this.cargo.push(container);
            }
        }
    }
    
    @Override
    public int compareTo(Ship ship) {
        return ship.priority - this.priority;
    }
    
    public String toString(){
        return "Ship#" + name + "/cargo(pcs):" + cargo.size();
    }
    
    
}
