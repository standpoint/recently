package dddd;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars extends AbstractCollection<Car>{
    List<Car> l=new ArrayList<>();
    public Cars(){
       Car m1=new Car();
       m1.setName("BMW");
       l.add(m1);
       Car m2=new Car();
       m2.setName("Lanos");
       l.add(m2);
    }
    
    @Override
   public Iterator<Car> iterator() { 
       return l.iterator();
   }
   
    @Override
   public int size(){ return l.size(); }

    
    
}
