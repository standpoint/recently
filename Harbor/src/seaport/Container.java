/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaport;

import java.util.List;

/**
 *
 * @author volodya
 */
public class Container {
    int weight;
    String serialNumber;
    
    public Container(int weight){
        this.weight = weight;
        this.serialNumber = String.valueOf(String.valueOf(weight).hashCode());
    }
    
    public String toString(){
        return "Container #" + serialNumber;
    }
    
    
}
