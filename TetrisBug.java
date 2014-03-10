/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

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
        setColor(newColor);
    }
    public void setDirection(int newDirection)
    {
    	newDirection = 180;
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
        Location next1 = next.getAdjacentLocation(getDirection());
        if (gr.isValid(next1))
            moveTo(next1);
        else
        	removeSelfFromGrid();
      
    }

}



























































