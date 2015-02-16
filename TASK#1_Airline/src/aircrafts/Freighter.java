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
public class Freighter extends Aircraft {
    
    private final int payload;
    private final float hourlyFuelConsumption;
    
    /**
     *
     * @param line
     */
    public Freighter(String[] line) {
        name = line[0];
        flightRange = Integer.parseInt(line[1]);
        payload = Integer.parseInt(line[2]);
        hourlyFuelConsumption = Float.parseFloat(line[3]);
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getCapacity() {
        return payload;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getFlightRange(){
        return flightRange;
    }
    
    /**
     *
     * @return
     */
    @Override
    public float getFuelConsumption(){
        return hourlyFuelConsumption;
    }
    
}
