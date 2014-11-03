/*
/* A simple realization of Priority Queue (realized add(),peak(),poll())
*/

package priorityqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Entry<Key,Value> {
    private Integer priority;
    private String value;
    public Entry(Integer priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String toString(){
        String s;
        s = "Priority: " + this.priority + ";\t" + "Value: " + this.value;
        return s;
    }
}

class PriorityQueue implements Iterable<Object>{
    

    List<Entry> queue = new ArrayList<>();
    
    public Entry peak() {
        if (queue.isEmpty()) {
            return new Entry(0,"queue is empty");
        } else {
            return queue.get(0);
        }
    }
    
    public Entry poll() {
        if (queue.isEmpty()) {
            return new Entry(0,"queue is empty");
        } else {
            return queue.remove(0);
        }
    }
    
    public boolean add(Entry item) {
        if (queue.isEmpty()) {
            queue.add(item);
            return true;
        }
        Iterator<Entry> it = queue.iterator();
        while (it.hasNext()) {
            Entry e = it.next();
            if (item.getPriority() >= e.getPriority()) {
                queue.add(queue.indexOf(e), item);
                return true;
            }
        }
        return queue.add(item);
    }
    
    public String toString() {
        String s;
        s = "Priority Queue, hashCode:" + hashCode() + "\n";
        if (queue.isEmpty()) {
            return "Queue is empty";
        }
        for (Entry e : queue) {
            s += e.toString() + "\n";
        }
        return s;
    }

    
    public Iterator iterator() {
        return queue.iterator();
    }
}

public class PriorityQueueDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int priority = 0;
        Entry[] entries = new Entry[5];
        PriorityQueue priorityQueue = new PriorityQueue();
        for (Entry entry : entries) {
            priority = (int)(Math.random()*100);
            entry = new Entry(priority,("The entry [" + priority + "]"));
            priorityQueue.add(entry);
            
        }
        priorityQueue.add(new Entry(100,"The entry with highest priority"));
        priorityQueue.add(new Entry(0,"The entry with lowest priority"));
        System.out.println(priorityQueue.toString());
        System.out.println("peak: " + priorityQueue.peak().toString());
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            System.out.println("poll: " + priorityQueue.poll().toString());
        }
        System.out.println("after polling: " + priorityQueue.toString());
               
    }
    
}
