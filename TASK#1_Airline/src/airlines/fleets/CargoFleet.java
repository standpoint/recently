/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.fleets;
import aircrafts.*;
import java.util.*;

/**
 *
 * @author volodya
 */
public class CargoFleet extends Fleet {
    
    public CargoFleet() {
        super();
    }
    
    public CargoFleet(Map<Aircraft,Integer> fleet) {
        super(fleet);
    }
    
    @Override
    protected Freighter getCraft(String[] parameters) {
        return (new Freighter(parameters));
    }
    
    /**
     *
     * @param fleet
     * @return
     */
    @Override
    protected Fleet getFleet(Map<Aircraft,Integer> fleet) {
        return (new CargoFleet(fleet));
    }
    
    /**
     *
     * @return
     */
    @Override
    protected String getFleetHeader(){
        return ("Name\t\t\tPayload(ton)\tFlight Range(km)"
                + "\tHourly Fuel Consumption(kg/hr)\t\tAmount\n\n");
    }
    
    /**
     *
     * @return
     */
    @Override
    protected String getFleetCapacityHeader() {
        return "Total payload of the fleet, ton : ";
    }
    
    /**
     *
     * @return
     */
    @Override
    protected String getFuelConsumptionUnits() {
        return " kg/hour";
    }
    
}
