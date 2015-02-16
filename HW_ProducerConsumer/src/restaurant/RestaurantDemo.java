/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

public class RestaurantDemo {
    
    public static void main(String[] args) {
        TableAppointments menu = new TableAppointments();
        Cook cook1 = new Cook(menu, Dish.BORSCH);
        Cook cook2 = new Cook(menu, Dish.CAKE);
        Cook cook3 = new Cook(menu, Dish.COFFEE);
        Visitor visitor = new Visitor(menu);
        Thread cookThread1 = new Thread(cook1);
        Thread cookThread2 = new Thread(cook2);
        Thread cookThread3 = new Thread(cook3);
        Thread[] visitorThreads = new Thread[20];
        for (Thread visitorThread : visitorThreads) {
            visitorThread = new Thread(visitor);
            visitorThread.start();
        }
        cookThread3.start();
        cookThread1.start();
        cookThread2.start();
    }
    
    
}
