/*
 * A simple realisation of double linked list with sentinels
 */
package linkedlist;


/**
 * Container Entry includes set of key and value
 * @author volodya
 */
class Entry<K,V> {
    private K key;
    private V value;
    Entry<K,V> next;
    Entry<K,V> prev;
    
    public Entry(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
}

/**
 *
 * @author volodya
 * @param <K> key
 * @param <V> value
 */
public class LinkedList<K,V>{
    
    int size;
    
    Entry<K,V> nil = new Entry(null, null);
    {
        nil.next = nil;
        nil.prev = nil;
    }
    
    /**
     * Returns an entry at position with index i.
     * @param i an index of position;
     * @return entry at index i.
     */
    public Entry<K,V> get(int i){
        if (isEmpty()) {
            throw new UnsupportedOperationException("List is empty");
        }
        if (i >= size) {
            throw new IndexOutOfBoundsException("Index out of the list size("
                    + size + ")");
        }
        Entry pointer = nil.next;
        for (int j = 0; j < i; j++) {
            pointer = pointer.next;
        }
        return pointer;
    }
    
    public boolean add(K key, V value) {
        try {
            Entry<K,V> entry = new Entry<>(key,value);
            if (isEmpty()) {
                entry.prev = nil;
            } else {
                entry.prev = nil.prev;
                
            }
            nil.prev.next = entry;
            entry.next = nil;
            nil.prev = entry;
            size++;
            return true;
        } catch (Exception e) {
            System.err.println("The element wasn't added to list");
        }
        return false;
    }
    
    /**
     * Removes and return header of the list
     * @return 
     */
    public Entry<K,V> remove() {
        if (size == 0) return nil;
        nil.next.next.prev = nil;
        nil.next = nil.next.next;
        size--;
        return nil.next;
    }
    
    private boolean isEmpty(){
        if (nil.next == nil) return true;
        return false;
    }

    @Override
    public String toString(){
        String s = "";
        Entry<K,V> entry;
        for (int i = 0; i < size; i++) {
            entry = get(i);
            s += "Key:" + entry.getKey() + "\t" + "Value:" + entry.getValue()
                    + "\n";
        }
        return s;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer,String> l = new LinkedList<>();
        System.out.println(l.add(1, "the first"));
        l.add(2, "the second");
        l.add(3, "the third");
        System.out.println(l.toString());
        l.remove();
        l.remove();
        l.remove();
        System.out.println(l.remove().getKey());
        l.add(10, "one more");
        System.out.println(l.toString());
    }
}
