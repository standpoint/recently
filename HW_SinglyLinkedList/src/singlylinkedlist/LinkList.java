package singlylinkedlist;

/**
 * List with Link
 * @author volodya
 */
class LinkList {
    private Link first;

    public LinkList(){
        first = null;
    }
    public boolean isEmpty(){
        return (first==null);
    }
    public void insertFirst(String entry){
        Link newLink = new Link(entry);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList(){
        if (!isEmpty()){
            Link current = first;
            System.out.print("the list: ");
            while(current != null){
                current.displayLink();
                current = current.next;
            }
            System.out.println("");
        } else {
            System.out.println("the list is empty");
        }
    }
}
