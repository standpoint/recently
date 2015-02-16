/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author volodya
 */
interface House{
    public void show();
}
class Cotage implements House{
    public void show(){}
}
class MultistoredHouse implements House{
    public void show(){}
}
abstract class Builder {
    House h;
    abstract public void buildBasement();
    abstract public void buildWalls();
    abstract public void buildRoof();
    public House getHouse(){
        return h;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

class MultiStoredHouseBuilder extends Builder {
    public MultiStoredHouseBuilder(){
        h = new MultistoredHouse();
    }
    public void buildBasement(){};
    public void buildWalls(){};
    public void buildRoof(){};
}
class CotageBuilder extends Builder {
    public CotageBuilder(){
        h = new MultistoredHouse();
    }
    public void buildBasement(){};
    public void buildWalls(){};
    public void buildRoof(){};
}

class Director{
    Builder builder;
    public Director(Builder build){
        this.builder = build;
    }
    public void createHouse(){
        builder.buildBasement();
        builder.buildWalls();
        builder.buildRoof();
    }
}

public class Demo{

    public static void main(String[] args){
        Builder builder = new CotageBuilder();
        Director foreman = new Director(builder);
        foreman.createHouse();
        House h = builder.getHouse();
        h.show();
    }
}