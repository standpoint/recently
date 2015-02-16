/*
/* A simple realization of Priority Queue (realized add(),peak(),poll())
/*
*/

package priorityqueue;

import java.util.ArrayList;
import java.util.Iterator;

class Entry<Key,Value> implements Comparable<Entry> {
    private Integer priority;
    private String value;
    public Entry(Integer priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

//    public void setPriority(int priority) {
//        this.priority = priority;
//    }

    public String getValue() {
        return value;
    }

//    public void setValue(String value) {
//        this.value = value;
//    }
    @Override
    public String toString(){
        String s;
        s = "Priority: " + this.priority + ";\t" + "Value: " + this.value;
        return s;
    }
    
    @Override
    public int compareTo(Entry t) {
        return this.getPriority() - t.getPriority();
    }
}

class PriorityQueue implements Iterable<Entry>{
    
    Entry<Integer,String> node, left, right;
    ArrayList<Entry> queue;
    int heapSize;
    int lagest;
    int l, r;
    
    public PriorityQueue() {
        queue = new ArrayList();
    }
    
    public PriorityQueue(ArrayList<Entry> list) {
        queue = new ArrayList();
        queue.addAll(list);
        heapSize = list.size();
//        heapSort();
        buildHeap();
    }
    
    private void heapify(int i) {
        l = i*2+1;
        r = i*2+2;
        if (l < heapSize) left = queue.get(l);
        else left = null;
        if (r < heapSize) right = queue.get(r);
        else right = null;
        lagest = i;
        node = queue.get(i);
        if(l < heapSize && left.compareTo(node) > 0) {
            lagest = l;
        } else lagest = i;
        if (r < heapSize && right.compareTo(queue.get(lagest)) > 0) {
            lagest = r;
        }
        if (lagest != i) {
            swapNodes(i, lagest);
            heapify(lagest);
        }
    }
    
    private void swapNodes(int i, int j){
        Entry temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);
    }
    
    private void buildHeap() {
        for(int i = heapSize/2-1; i >= 0; i--) {
            heapify(i);
        }
    }
    
    private void heapSort() {
        buildHeap();
        for (int i = heapSize-1; i >= 0 ; i--) {
            swapNodes(0,i);
            heapSize--;
            heapify(0);
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
        if (heapSize < 1) {
            return new Entry(0,"queue is empty");
        }
        if (heapSize < 2) {
            heapSize--;
            return queue.remove(0);
        }
        Entry max = queue.get(0);
        queue.set(0, queue.remove(heapSize-1));
        heapSize--;
        heapify(0);
        return max;
    }
    
    public String toString() {
        String s;
        s = "Priority Queue, hashCode:" + hashCode() + "\n";
        if (queue.isEmpty()) {
            return "Queue is empty";
        }
        for (int i = 0; i < queue.size(); i++) {
            s += queue.get(i).toString() + "\n";
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
        final int n = 20;
        Integer priority;
        String value;
        ArrayList<Entry> list = new ArrayList<>();
        Entry[] tasks = new Entry[n];
        for (Entry task : tasks) {
            priority = (int)(Math.random()*100);
            value = "The task [" + priority + "]";
            task = new Entry(priority,value);
            list.add(task);
        }
        
        Iterator<Entry> it = list.iterator();
        while(it.hasNext()) {
            Entry task = it.next();
            System.out.println(task.toString());
        }

        PriorityQueue queue = new PriorityQueue(list);
        System.out.println("\n" + queue.toString());
        for(int i = 0; i < n; i++) {
            System.out.println("polling:" + queue.poll().toString());
        }
        
                
    }
    
}
