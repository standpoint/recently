/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.*;
import airlines.fleets.*;
import airlines.*;

/**
 *
 * @author vladimir
 */
class Initialization {
    
    public static Airline run() throws Exception {
        String[] files;
        files = new String[2];
        String userDir;
        userDir = System.getProperty("User.dir");
        files[0] = userDir + "Dropbox/NetBeansProjects/Airline/db/liners.csv";
        files[1] = userDir + "Dropbox/NetBeansProjects/Airline/db/freighters.csv";
        BufferedReader br;
        br = null;
        String line;
        final String splitter;
        splitter = ";";
        Fleet passangerFleet, cargoFleet;
        passangerFleet = new PassengerFleet();
        cargoFleet = new CargoFleet();
        
        try {
            for (int i = 0; i < files.length; i++) {
                br = new BufferedReader(new FileReader(files[i]));
                while ((line = br.readLine()) != null) {
                    String[] craft = line.split(splitter);
                    switch (i) {
                        case 0: passangerFleet.addCraft(craft);
                            break;
                        case 1: cargoFleet.addCraft(craft);
                    }
                }
            }   
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        
        Airline theAirline;
        theAirline = new Airline(cargoFleet);
        theAirline.addFleet(passangerFleet);
        return theAirline;
    }
}