/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircrafts;

/**
 *
 * @author volodya
 */
public class Liner extends Aircraft{
    
    private final int seatingCapacity;
    private final float specificFuelConsumption;

    public Liner(String[] line) {
        name = line[0];
        flightRange = Integer.parseInt(line[1]);
        seatingCapacity = Integer.parseInt(line[2]);              
        specificFuelConsumption = Float.parseFloat(line[3]);
    }
    
    @Override
    public int getCapacity() {
        return seatingCapacity;
    };
    
    @Override
    public int getFlightRange(){
        return flightRange;
    };
    
    @Override
    public float getFuelConsumption(){
        return specificFuelConsumption;
    };
}
