/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.fleets;
import java.util.*;
import aircrafts.*;
/**
 *
 * @author volodya
 */
public class PassengerFleet extends Fleet {
   
    /**
     *
     */
    public PassengerFleet() {
        super();
    }
    
    /**
     *
     * @param fleet
     */
    public PassengerFleet(Map fleet) {
        super(fleet);
    }
    
    /**
     *
     * @param parameters
     * @return
     */
    @Override
    protected Liner getCraft(String[] parameters) {
        return (new Liner(parameters));
    }
    
    /**
     *
     * @param fleet
     * @return
     */
    @Override
    protected Fleet getFleet(Map<Aircraft,Integer> fleet) {
        return (new PassengerFleet(fleet));
    }
    
    /**
     *
     * @return
     */
    @Override
    protected String getFleetHeader() {
        return ("Name\t\t\tCapacity(seats)\tFlight Range(km)"
                + "\tSpec.Fuel Consumption(g/pass-km)\tAmount\n\n");
    }
    
    /**
     *
     * @return
     */
    @Override
    protected String getFleetCapacityHeader() {
        return "Total capacity of the fleet, seats : ";
    }
    
    /**
     *
     * @return
     */
    @Override
    protected String getFuelConsumptionUnits() {
        return " g/pass-km";
    }
}
