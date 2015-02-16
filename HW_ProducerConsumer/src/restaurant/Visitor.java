/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

public class Visitor implements Runnable {
    
    TableAppointments myMenu;
    Dish prevDish = Dish.NOTHING;
    
    public Visitor(TableAppointments menu) {
        myMenu = menu;        
    }
    
    @Override
    public void run() {
        while(true) {
            prevDish = myMenu.pickup(prevDish);
            if (prevDish == Dish.COFFEE) {
                System.out.println("Waiting for the next visitor...");
            }
        }
    }
    
}
