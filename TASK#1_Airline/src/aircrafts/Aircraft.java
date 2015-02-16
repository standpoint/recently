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
public abstract class Aircraft {

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected int flightRange;
    
    /**
     *
     * @return
     */
    public abstract int getCapacity();

    /**
     *
     * @return
     */
    public abstract int getFlightRange();

    /**
     *
     * @return
     */
    public abstract float getFuelConsumption();
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
