GroupC
======
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Jumper extends Bug{

	/**
	 * @param args
	 */


	    /**
	     * Constructs a box bug that traces a square of a given side length
	     * @param length the side length
	     */
	    public Jumper()
	    {

	    }

	    /**
	     * Moves to the next location of the square.
	     */
	    public void act()
	    {
	        if(canJump() == true && canMove() == false)
	        {
	        	jump();
	        }
	        if (canMove())
	        {
	        	move();
	        }
	        else
	        {
	        	turn();
	        }
	    }
	    public void jump()
	    {
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        Location next1 = next.getAdjacentLocation(getDirection());
	        if (gr.isValid(next1))
	            moveTo(next1);
	        else
	        	removeSelfFromGrid();
	      
	    }
	    public boolean canJump()
	    {
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        Location next1 = next.getAdjacentLocation(getDirection());
	        if (!gr.isValid(next1))
	            return false;
	        Actor neighbor = gr.get(next1);
	        return (neighbor == null) || (neighbor instanceof Flower);
	        // ok to move into empty location or onto flower
	        // not ok to move onto any other actor
	    }
	}