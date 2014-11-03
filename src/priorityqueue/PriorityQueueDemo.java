/*
/* A simple realization of Priority Queue (realized add(),peak(),poll())
*/

package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
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

class PriorityQueue implements Iterable<Entry>, Comparator<Entry> {
    
    Entry<Integer,String> node, left, right;
    List<Entry> queue;
    
    public PriorityQueue() {
        queue = new ArrayList();
    }
    
    public PriorityQueue(ArrayList<Entry> list) {
        queue = heapSort(list);
    }
    
    private ArrayList<Entry> heapSort(ArrayList<Entry> list) {
        buildHeap(list);
        Iterator it = list.listIterator(list.size());
        Entry task;
        for (int i = list.size(); i >= 0 ; i -= 2) {
            task = list.get(i);
            swapNodes(list.get(0),task);
        }
        return list;
    }
    
    private void swapNodes(Entry x1, Entry x2){
        Entry temp;
        temp = new Entry(x1.getPriority(),x1.getValue());
        x1.setPriority(x2.getPriority());
        x1.setValue(x2.getValue());
        x2.setPriority(temp.getPriority());
        x2.setPriority(temp.getPriority());
    }
    
    private void buildHeap(ArrayList<Entry> list) {
        for(int i = list.size(); i >=0; i -= 2) {
            heapify(list,i);
        }
    }
    
    private void heapify(ArrayList<Entry> list, int i) {
        int l = i*2+1;
        int r = i*2+2;
        int size = list.size();
        int lagest = size - 1;
        left = list.get(l);
        right = list.get(r);
        if(l < size && compare(left,list.get(i)) >= 0) {
            lagest = l;
        } else lagest = i;
        if (r < size && compare(right,list.get(i)) >= 0) {
            lagest = r;
        }
        if (lagest != i) {
            swapNodes(list.get(i), list.get(lagest));
            heapify(list, lagest);
        }
    }
    
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
        }
        return queue.remove(0);
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

    @Override
    public int compare(Entry t, Entry t1) {
        return t.getPriority() - t1.getPriority();
    }
}

public class PriorityQueueDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int priority = 0;
//        Entry[] entries = new Entry[5];
//        PriorityQueue priorityQueue = new PriorityQueue();
//        for (Entry entry : entries) {
//            priority = (int)(Math.random()*100);
//            entry = new Entry(priority,("The entry [" + priority + "]"));
//            priorityQueue.add(entry);
//            
//        }
//        priorityQueue.add(new Entry(100,"The entry with highest priority"));
//        priorityQueue.add(new Entry(0,"The entry with lowest priority"));
//        System.out.println(priorityQueue.toString());
//        System.out.println("peak: " + priorityQueue.peak().toString());
//        Iterator it = priorityQueue.iterator();
//        while (it.hasNext()) {
//            System.out.println("poll: " + priorityQueue.poll().toString());
//        }
//        System.out.println("after polling: " + priorityQueue.toString());
        Integer priority;
        String value;
        List<Entry> list = new ArrayList<>();
        Entry[] tasks = new Entry[5];
        for (Entry task : tasks) {
            priority = (int)(Math.random()*100);
            value = "The task [" + priority + "]";
            task = new Entry(priority,value);
            list.add(task);
            task.toString();
        }
        Iterator<Entry> it = list.iterator();
        while(it.hasNext()) {
            Entry task = it.next();
            task.toString();
            
        }
               
    }
    
}
