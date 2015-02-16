package expertpattern;

import java.util.List;

class Product{
    String type;
    int price;
}
class SalesLineItem {
    Product p;
    int quantity;
}
class Sale{                         //Expert
    List<SalesLineItem> l;
    public int getTotalSum(){
        return 0; //calculate total sum
    }
}

public class ExpertPattern {

    public static void main(String[] args) {
        
    }
    
}
