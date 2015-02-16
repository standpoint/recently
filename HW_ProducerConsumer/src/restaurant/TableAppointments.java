/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableAppointments {
    List<Dish> menu = new ArrayList<>();
    int maxNumDishes;
    public TableAppointments(){
        this.maxNumDishes = Dish.values().length - 1;
    }
    
    public void add(Dish dish){
        boolean isAdded = false;
        synchronized(menu){
            while(menu.size() >= maxNumDishes) {
                try {
                    menu.wait();
                } catch(InterruptedException ie) {
                    
                }
            }
            if (!menu.contains(dish)) {
                isAdded = menu.add(dish);
            }
            if (isAdded) {
                System.out.println(Thread.currentThread().getName() 
                        + " added " + dish.toString());
            }
            menu.notifyAll();
        }

    }
    
    public Dish pickup(Dish prevDish) {
        Dish dish = Dish.NOTHING;
        synchronized(menu){
            while(menu.isEmpty() || prevDish == Dish.COFFEE) {
                try {
                    menu.wait();
                } catch (InterruptedException ie) {
                    
                }
            }
            switch(prevDish) {
                case BORSCH:   
                    if(menu.contains(Dish.CAKE)) {
                        dish = menu.remove(menu.indexOf(Dish.CAKE));
                    }
                    break;
                case CAKE:  
                    if(menu.contains(Dish.COFFEE)) {
                        dish = menu.remove(menu.indexOf(Dish.COFFEE));
                    }
                    break;
                case NOTHING:   
                    if(menu.contains(Dish.BORSCH)) {
                        dish = menu.remove(menu.indexOf(Dish.BORSCH));
                    }
                    break;
            }
            if (dish != Dish.NOTHING) {
                System.out.println(Thread.currentThread().getName() 
                + " picked up " + dish.toString() 
                + "(available: " + Arrays.toString(menu.toArray()) + ")");
            }
            menu.notifyAll();
            return dish;
        }
    }
}
