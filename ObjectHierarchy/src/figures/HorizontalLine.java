/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figures;

/**
 *
 * @author volodya
 */
public class HorizontalLine extends Point {
    protected int length;
    
    public HorizontalLine() {
        this(new Coordinates(), 400);
    }
    
    public HorizontalLine(Coordinates center, int length) {
        center = new Coordinates(center);
        this.length = length;
    }
    
    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(Coordinates newCenter) {
        center = new Coordinates(newCenter);
    }

    @Override
    public void resize(float multiplicity) {
        length = Math.round(length*multiplicity);
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
