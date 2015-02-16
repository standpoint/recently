/*
 * simple realization of singly linked list
 */
package singlylinkedlist;

/**
 * Main class for linked list demonstration 
 * @author volodya
 */
public class LinkListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkList someList = new LinkList();
        someList.insertFirst("first entry");
        someList.insertFirst("inserted entry");
        someList.insertFirst("one more entry");
        someList.displayList();
        while(!someList.isEmpty()){
            System.out.print("Delete the link: ");
            someList.deleteFirst().displayLink();
            System.out.println("");
        }
        someList.displayList();
    }
    
}
