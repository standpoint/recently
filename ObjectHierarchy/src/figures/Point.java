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
public class Point implements Actions{
    protected Coordinates center;
    
    public Point() {
        this(0,0);
    }
    
    public Point(int x, int y) {
        center.setX(x);
        center.setY(y);
    }
    
    public Point(Coordinates center) {
        this(center.getX(), center.getY());
    }
    
    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void move(Coordinates newCenter) {
        this.center = new Coordinates(newCenter);
    }

    @Override
    public void resize(float multiplicity) {}

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
