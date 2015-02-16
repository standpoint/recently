/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

public class Cook implements Runnable{
    TableAppointments myMenu;
    Dish dish;
    public Cook(TableAppointments menu, Dish dish){
        myMenu = menu;
        this.dish = dish;
    }

    @Override
    public void run() {
        while(true){
            myMenu.add(dish);
        }
        
    }
}
