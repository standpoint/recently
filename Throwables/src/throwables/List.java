/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throwables;

class BadArgumentException extends Exception {
    private String message;
    public BadArgumentException(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}

class ListFullException extends Exception {
    
}

class ListEmptyException extends Exception {
    
}

/**
 *
 * @author vladimir
 */
public class List {
    private class Node{
        public int data;
        public Node next;
    }
    Node head;
    int size = 0;
    int maxSize;
    public List(int maxSize) throws BadArgumentException {
        if(maxSize<=0) throw new BadArgumentException("maxSize is zero or less than zero " + maxSize);
        this.maxSize = maxSize;
        head = new Node();
        head.data = 0;
        size++;
    }
    public void add(int element,int position) throws BadArgumentException, ListFullException {
        if (position < 0) throw new BadArgumentException("the argument position is less than zero" + position);
        if (position >= size) throw new BadArgumentException("the argument position is more then number of list's element" + size + " " + position);
        if (size == maxSize) throw new ListFullException();
        Node temp = new Node();
        temp.data = element;
        if (position == 0) {
            temp.next = head;
            head = temp;
            size++;
            return;     // немедленный выход из метода
        }
        if (position > 0) {
            Node time = head;
            for(int i = 0; i < position-1; i++){
                time = time.next;
            }
            temp.next = time.next;
            time.next = temp;
            size++;
        }
        
    }
    public int remove(int position) throws BadArgumentException, ListEmptyException {
        if (size == 0) throw new ListEmptyException();
        if (position < 0) throw new BadArgumentException("the argument position is less than zero" + position);
        if (position >= size) throw new BadArgumentException("the argument position is more then number of list's element" + size + " " + position);
        if (position == 0) {
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
        Node time = head;
        for (int i = 0; i < position - 1; i++) {
            time = time.next;
        }
        Node temp = time.next;
        time.next = temp.next;
        size--;
        return temp.data;
    }
}
