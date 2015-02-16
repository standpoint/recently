/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;
import airlines.fleets.*;
import java.util.*;
/**
 *
 * @author volodya
 */
public class Airline {
    
    String name;
    String codeIATA;
    String codeICAO;
    String callsign;
    int destinations;
    String headquarter;
    String website;
    LinkedList fleets;
    
    /**
     *
     * @param fleet
     */
    public Airline(Fleet fleet){
        name = "Ukraine International Airlines";
        codeIATA = "PS";
        codeICAO = "AUI";
        callsign = "UKRAINE INTERNATIONAL";
        destinations = 75;
        headquarter = "Kiev, Ukraine";
        website = "www.flyuia.com";
        fleets = new LinkedList();
        fleets.add(fleet);
    }
    
    /**
     *
     * @param fleet
     */
    public void addFleet(Fleet fleet) {
        fleets.add(fleet);
    }
    
    /**
     *
     * @param fleet
     * @return
     */
    public int getFleetSize(Fleet fleet) {
        return fleet.getSize();
    }
    
    /**
     *
     * @return
     */
    public LinkedList getFleetsList() {
        return fleets;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s;
        s = "Name:\t" + name + "\n"
          + "Code IATA:\t" + codeIATA + "\n" 
          + "Code ICAO:\t" + codeICAO + "\n"
          + "Callsign:\t" + callsign + "\n"
          + "Destinations:\t" + destinations + "\n"
          + "Headquarter:\t" + headquarter + "\n" 
          + "Web-site:\t" + website + "\n";        
        return s;
    }
}
