package binarysearchtree;

import java.util.ArrayList;

/**
 *
 * A container for items
 * @param <K> the type of the item key (implements interface Comparable)
 * @param <V> the type of the item value
 * @author volodya
 * 
 */
class Entry<K extends Comparable,V> implements Comparable<Entry>{
    private K key;
    private V value;
    
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

    @Override
    public int compareTo(Entry e) {
        return key.compareTo(e.getKey());
    }
}

class Tree<T>{
    
    Node<Entry> node;
    Node<Entry> root;
    int size;
    
    class Node<T> {
        Node<Entry> left;
        Node<Entry> right;
        Node<Entry> parent;
        Entry item;

        public Node(Entry element, Node<Entry> p) {
            this.item = element;
            this.parent = p;
        }
    }
    
    public Tree() {
        
    }
    
    public Tree(Entry element){
        node = new Node<>(element,null);
        root = node;
        size++;
    }
    
    public void setRight(Entry element) {
        if (node.right != null && 
                element.compareTo(node.item) > 0) {
            node = node.right;
            setRight(element);
            return;
        }
        if (element.compareTo(node.item) > 0) {
            node = new Node<>(element,node);
            node.parent.right = node;
            return;
        }
        if (element.compareTo(node.item) < 0) {
            setLeft(element);
        }
    }
    
    public void setLeft(Entry element) {
        if (node.left != null && 
                element.compareTo(node.item) < 0) {
            node = node.left;
            setLeft(element);
            return;
        }
        if (element.compareTo(node.item) < 0) {
            node = new Node<>(element,node);
            node.parent.left = node;
            return;
        }
        if (element.compareTo(node.item) > 0) {
            setRight(element);
        }

    }
    
    public void add(Entry element) {
        
        if (root == null) {
            node = new Node<>(element,null);
            root = node;
            size++;
            return;
        }
        if (element.compareTo(root.item) > 0) {
            setRight(element);
            size++;
            node = root;
        }
        
        if (element.compareTo(root.item) < 0) {
            setLeft(element);
            size++;
            node = root;
        }
    }
}

/**
 * class for the demonstration
 * @author volodya
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer key;
        String value;
        Tree<Entry<Integer,String>> t = new Tree<>(new Entry(33,"first"));
        ArrayList<Entry<Integer,String>> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            key = (int) (Math.random() * 100);
            Entry<Integer,String> item = new Entry<>(key,"");
            value = item.toString();
            item.setValue(value);
            items.add(item);
        }
        for(Entry<Integer,String> item:items) {
            System.out.println("Key:" + item.getKey() + "\t" + "Value:" 
                    + item.getValue());
        }
        
        for(Entry<Integer,String> item:items) {
            t.add(item);
        }
        System.out.println(t.size);
    }
    
}
