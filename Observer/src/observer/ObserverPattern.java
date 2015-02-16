package observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

class Updates {                                     //Subject
    private String updates;
    private final ArrayList<HostObserver> observers;
    public Updates(){
        observers = new ArrayList<>();
    }
    public void registerObserver(HostObserver observer) {
        observers.add(observer);
    }
    public void unregisterObserver(HostObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {                 
        Iterator<HostObserver> it = observers.iterator();
        while (it.hasNext()) {
            HostObserver host = it.next();
            host.notifyHost(this);
        }
    }
    
    @Override
    public String toString(){
        return getUpdates();
    }

    public String getUpdates() {
        return updates;
    }
    public void setUpdates(String updates) {
        this.updates = updates;
    }
}

abstract class HostObserver {                               //Observer
    String app;
    public abstract void notifyHost(Updates currentUpdate);
    @Override
    public abstract String toString();
}

class Host1 extends HostObserver {                          //ConcreteObserver1
    @Override
    public void notifyHost(Updates currentUpdate) {
        app = currentUpdate.getUpdates();
    }
    @Override
    public String toString() {
        return "App at Host1 updates:" + app; 
    }
}

class Host2 extends HostObserver {                          //ConcreteObserver2
    @Override
    public void notifyHost(Updates currentUpdate) {
        app = currentUpdate.getUpdates();
    }
    @Override
    public String toString() {
        return "App at Host2 updates:" + app; 
    }
}


public class ObserverPattern {

    public static void main(String[] args) throws InterruptedException {
        String update1 = "update1-" + Calendar.getInstance().getTime();
        Thread.sleep(2000);
        String update2 = "update2-" + Calendar.getInstance().getTime();
        Thread.sleep(2000);
        String update3 = "update3-" + Calendar.getInstance().getTime();
        Updates upd = new Updates();
        Host1 host1 = new Host1();
        Host2 host2 = new Host2();
        
        upd.registerObserver(host1);
        upd.registerObserver(host2);
        upd.setUpdates(update1);
        printUpdates(upd, host1, host2);
        
        upd.setUpdates(update2);
        upd.notifyObservers();
        printUpdates(upd, host1, host2);
        
        upd.unregisterObserver(host1);
        upd.setUpdates(update3);
        upd.notifyObservers();
        printUpdates(upd, host1, host2);
        
    }

    public static void printUpdates(Updates up, Host1 h1, Host2 h2) {
        System.out.println(up.toString());
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println("-------------------");
    }
    
}   
