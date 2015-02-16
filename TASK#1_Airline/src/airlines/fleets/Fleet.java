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
public abstract class Fleet {
    
    Map<Aircraft,Integer> fleet;
    
    /**
     *
     */
    public Fleet(){
        fleet = new TreeMap<>((Aircraft t1, Aircraft t2) 
                -> {
            return t1.getName().compareTo(t2.getName());
        });
    }
    
    /**
     *
     * @param fleet
     */
    public Fleet(Map<Aircraft,Integer> fleet){
        this.fleet = fleet;
    }
    
    abstract Aircraft getCraft(String[] parameters);
    abstract Fleet getFleet(Map<Aircraft,Integer> fleet);
    abstract String getFleetHeader();
    abstract String getFleetCapacityHeader();
    abstract String getFuelConsumptionUnits();
    
    /**
     *
     * @param parameters
     */
    public void addCraft(String[] parameters) {
        Aircraft craft = getCraft(parameters);
        Integer craftNumber = Integer.parseInt(parameters[4]);
        fleet.put(craft, craftNumber);
    }
    
    /**
     *
     * @return
     */
    public int getSize() {
        Collection numbers;
        numbers = fleet.values();
        int amount = 0;
        for (Object craftNumber : numbers) {
            amount += (int)craftNumber;
        }
        return amount;
    }
    
    /**
     *
     */
    public void displayDetails() {
        Iterator<Map.Entry<Aircraft,Integer>> entries;
        entries = fleet.entrySet().iterator();
        System.out.print(getFleetHeader());
        while (entries.hasNext()) {
            Map.Entry<Aircraft,Integer> entry = entries.next();
            System.out.print(entry.getKey().getName() + "\t");
            System.out.print(entry.getKey().getCapacity() + "\t\t");
            System.out.print(entry.getKey().getFlightRange() + "\t\t\t");
            System.out.print(entry.getKey().getFuelConsumption() 
                            + "\t\t\t\t\t");
            System.out.println(entry.getValue());
        }
        System.out.println("Size of the fleet: " + this.getSize() 
                        + " aircrafts\n");
    }
    
    /**
     *
     */
    public void displayFleetCapacity() {
        System.out.print(getFleetCapacityHeader());
        System.out.println(this.getFleetCapacity() + "\n");
    }
    
    /**
     *
     * @return
     */
    public int getFleetCapacity() {
        Set<Aircraft> crafts  = fleet.keySet();
        Iterator<Aircraft> entries;
        entries = crafts.iterator();
        int capacity = 0;
        while(entries.hasNext()) {
            Aircraft craft = entries.next();
            capacity += craft.getCapacity();
        }
        return capacity;
    }
    
    /**
     *
     * @return
     */
    public Fleet sortByFlightRange() {
        Map<Aircraft,Integer> sortedFleet;
        sortedFleet = new TreeMap<>((Aircraft t1, Aircraft t2) 
                -> t1.getFlightRange() - t2.getFlightRange());
        sortedFleet.putAll(fleet);
        
        return getFleet(sortedFleet);
    }
    
    /**
     *
     * @param low
     * @param high
     * @return
     */
    public String getCraftsByFuelConsumption(float low, float high) {
        ArrayList list;
        String s, err;
        s = "";
        err = "There ara no aircrafts with the specified "
                + "parameters in this fleet (" + low + " .. " 
                + high + ", " + getFuelConsumptionUnits() + ")";
        Aircraft craft;
        float consumption;
        list = new ArrayList(fleet.keySet());
        for (Object obj : list) {
            craft = (Aircraft)obj;
            consumption = craft.getFuelConsumption();
            if (consumption >= low && consumption <= high) {
                s += (craft.getName() + "\t(" + consumption 
                        + getFuelConsumptionUnits() + ")\n");
            }
        }
        return s.equals("") ? err : s;
    }
}
