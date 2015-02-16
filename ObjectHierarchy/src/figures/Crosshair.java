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
public class Crosshair extends HorizontalLine {
    protected int lengthVertical;
    
    public Crosshair(){
        this(new Coordinates(), 400, 400);
    }
    
    public Crosshair(Coordinates center, int lengthVertical, int lengthHorizontal) {
        this.center = center;
        this.lengthVertical = lengthVertical;
        length = lengthHorizontal;
    }

    /**
     * @return the lengthVertical
     */
    public int getLengthVertical() {
        return lengthVertical;
    }

    /**
     * @param lengthVertical the lengthVertical to set
     */
    public void setLengthVertical(int lengthVertical) {
        this.lengthVertical = lengthVertical;
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
        lengthVertical = Math.round(lengthVertical*multiplicity);
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
