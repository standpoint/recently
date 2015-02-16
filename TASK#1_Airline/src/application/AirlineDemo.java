/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import airlines.*;
import airlines.fleets.*;
import java.util.*;
/**
 *
 * @author volodya
 */
public class AirlineDemo {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws Exception {
        Airline theAirline;
        LinkedList fleetList;
        theAirline = Initialization.run();
        System.out.println(theAirline.toString());
        
        fleetList = theAirline.getFleetsList();
        Fleet fleet1, fleet2;
        fleet1 = (Fleet)fleetList.getFirst();
        fleet2 = (Fleet)fleetList.getLast();

        fleet1.displayDetails();
        fleet1.displayFleetCapacity();
        fleet2.displayDetails();
        fleet2.displayFleetCapacity();
        
        Fleet sortedFleet2;
        sortedFleet2 = fleet2.sortByFlightRange();
        System.out.println("Sorted by flight range:");
        sortedFleet2.displayDetails();
        
        float fuelConsumptionLow, fuelConsumptionHigh;
        fuelConsumptionLow = 0;
        fuelConsumptionHigh = 5000;
        System.out.println("Finding crafts with the specified consumption "
                + "range (" + fuelConsumptionLow + "..." 
                + fuelConsumptionHigh + "):\n");
        System.out.println(fleet1.getCraftsByFuelConsumption(fuelConsumptionLow
                , fuelConsumptionHigh));
        System.out.println(fleet2.getCraftsByFuelConsumption(fuelConsumptionLow
                , fuelConsumptionHigh));
    }
}
