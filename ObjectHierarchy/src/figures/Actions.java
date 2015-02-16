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
public interface Actions {
    public void display();
    public void move(Coordinates newCenter);
    public void resize(float multiplicity);
    public void hide();
}
