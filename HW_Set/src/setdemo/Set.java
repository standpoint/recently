package setdemo;

/**
 * 
 * @author vladimir
 */
class Set {

    /**
     * @param args the command line arguments
     */
    
    private final Container c;
    
    public Set(Container c) {
        this.c = c;
    }
    
    public Set union (Set s) {
        final Container C1 = this.c.copy();
        final Container C2 = s.c.copy();
        Set resultSet = new Set(C1);
        int element;
        for (int i = 0; i < C2.size(); i++) {
            element = C2.get(i);
            if (!C1.contains(element)) {
                resultSet.c.add(element);
            }
        }
        return resultSet;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < c.size(); i++) {
            s += "{" + c.get(i) + "}";
        }
        s += "\n";
        return s;
    }
}