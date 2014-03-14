import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class TetrisBug extends Bug
{
    

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     * @return 
     */
  

    
    
    public TetrisBug(Color newColor)
    
    {
    	super();
    	setDirection(180);
    }


    /**
     * Moves to the next location of the square.
     */
    
    public void act()
    {
        
    }
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
        	removeSelfFromGrid();
      
    }

}
