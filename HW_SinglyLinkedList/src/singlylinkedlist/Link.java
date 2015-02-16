package singlylinkedlist;

/**
 * Link for List
 * @author volodya
 */
public class Link {
    private String entry;
    public Link next;
    
    public Link(){
        this("");
    }
    public Link(String key){
        this.entry = key;
    }

    public String getEntry() {
        return entry;
    }
    public void setEntry(String entry) {
        this.entry = entry;
    }
    
    public void displayLink(){
        System.out.print("{"+entry+"} ");
    }
}
