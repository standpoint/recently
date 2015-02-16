/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harbor2;
import harbor2.Port.Berth;
import harbor2.Port;

/**
 *
 * @author volodya
 */

public class Ship implements Runnable {

    public final int tonnage;
    boolean toLoad = false;
    boolean toUnload = false;
    int cargo;
    int serialNumber;
    
    public Ship(int serialNumber, int tonnage, int cargo) {
        this.tonnage = tonnage;
        if (cargo > tonnage) this.cargo = tonnage;
        else this.cargo = cargo;
        toLoad = true;
        toUnload = true;
        this.serialNumber = serialNumber;
    }

    @Override
    public void run() {
        while(true){
            Berth berth = Port.moor(this);
            while(berth != null){
                while(toUnload){
                    berth.unload();
                }
                while(toLoad){
                    berth.load();
                }
                berth = null;
            }
        }
    }
    
    @Override
    public String toString(){
        return ("Ship#" + serialNumber + "/" + cargo);
    }
}
