//TetrisBlock.java
import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.ArrayList;
import java.awt.Color;

/**
 * TetrisBlock is a type of Bug. It will act in GridWorld by moving down
 * (direction 180) if it can, otherwise it will ask TetrisGame to make a new
 * TetrisBlock for the game.
 */
public class TetrisBlockI extends TetrisBlock {

	/**
	 * value of the current rotation position {0,1,2 or 3}
	 */
	protected int rotationPos;

	/**
	 * blocks will have three TetrisBug objects in it... they will be added in the
	 * constructor
	 */
	protected ArrayList<TetrisBug> blocks;
	/**
	 * used as a convenient reference to the Grid
	 */
	protected Grid<Actor> gr;

	/**
	 * default constructor
	 */
	
	
	public TetrisBlockI() {
		super();
		rotationPos = 0;
		gr = TetrisGame.world.getGrid();

		// ==> LAMEST GAME OVER EVER !!! <==
		// if the Grid does not have room for the TetrisBlock.. GameOver
		if  (gr.get(new Location(2,5)) == null || gr.get(new Location(3,5)) != null ) 
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Score: "
					+ TetrisGame.score, "GAME OVER!", 0);
			System.exit(0);
		}
		
		

		blocks = new ArrayList<TetrisBug>();
		TetrisBug i;
		TetrisBug i1;
		
		
		// create TetrisBugs for ArrayList blocks and put them in Grid gr
		i = new TetrisBug(Color.ORANGE);
		i.putSelfInGrid(gr, new Location(2, 5));
		blocks.add(i);
		i1 = new TetrisBug(Color.ORANGE);
		i1.putSelfInGrid(gr, new Location(3,5));
		blocks.add(i1);
	
		// TetrisBlock subclasses will add two more TetrisBug objects to blocks

	}

	/**
	 * TetrisBlock and its TetrisBugs must face down (direction 180) If they can
	 * move down, they will. Otherwise, it will ask TetrisGame to create a new
	 * TetrisBlock since this one is stuck at the bottom.
	 */
	public void act() {
		setDirection(180);
		for (TetrisBug tb : blocks)
			tb.setDirection(180);
		if (canMoveDown())
			moveDown();
		else if (!TetrisGame.currentBlock.canMoveDown())
			TetrisGame.nextTetrisBlock();
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
        
      
    }
	/**
	 * Move the TetrisBlock and its TetrisBugs one cell. (they should already be
	 * facing down) Note: The order in which all the TetrisBugs move is important
	 * and depends on the current rotationPos.
	 */
	public void moveDown() {
		if (rotationPos == 0) {
			move();
			blocks.get(0).move();
			blocks.get(1).move();
			blocks.get(2).move();
		} else if (rotationPos == 1) {
			blocks.get(0).move();
			blocks.get(1).move();
			
			move();
			
		}
	}

	/**
	 * Returns true if the TetrisBlock and its TetrisBugs can move (they should
	 * already be facing down) Otherwise, returns false.
	 */
	public boolean canMoveDown() {
		if (rotationPos == 0)
			return canMove();
		else if (rotationPos == 1)
			return canMove() && blocks.get(0).canMove();
		else
			return true;
	}

	/**
	 * Sets the direction of the TetrisBlock and its TetrisBugs to 90 (right) If
	 * they can move, they will move one cell (to the right)
	 */
	public void moveRight() {
		setDirection(90);
		for (TetrisBug tb : blocks)
			tb.setDirection(90);
		if (rotationPos == 0) {
			if (canMove() && blocks.get(0).canMove()) {
				blocks.get(0).move();
				move();
			}
		} else if (rotationPos == 1) {

			if (canMove()) {
				move();
				blocks.get(0).move();
				turn();
			}
		}
	}

	/**
	 * Sets the direction of the TetrisBlock and its TetrisBugs to 90 (right) If
	 * they can move, they will move one cell (to the right)
	 */
	public void moveLeft() {

		// Your code goes here ... see Question 1
		setDirection(270);
		for (TetrisBug tb : blocks)
			tb.setDirection(270);
		if (rotationPos == 0) {
			if (canMove() && blocks.get(0).canMove()) {
				blocks.get(0).move();
				move();
			}
			
		} else if (rotationPos == 1) {
			if (blocks.get(0).canMove()) {
				blocks.get(0).move();
				move();
			}
		}

	}

	/**
	 * If the TetrisBlock and its TetrisBugs can rotate, then they will all move
	 * to their proper location for the given rotation designated by
	 * rotationPos... Update rotationPos.
	 */
	public void rotate() {
		Location nextLoc;
		if (rotationPos == 0) {
			// only one block must move
			nextLoc = new Location(getLocation().getRow() - 1,
					getLocation().getCol() + 1);
			if (gr.isValid(nextLoc) && gr.get(nextLoc) == null) {
				moveTo(nextLoc);
				rotationPos = (rotationPos + 1) % 4;// will be % 4 with 4 blocks
			}
		} else if (rotationPos == 1) {
			nextLoc = new Location(getLocation().getRow() + 1,
					getLocation().getCol() - 1);
			if (gr.isValid(nextLoc) && gr.get(nextLoc) == null) {
				moveTo(nextLoc);
				rotationPos = (rotationPos + 1) % 4;// will be % 4 with 4 blocks
			}

			// Your code goes here ... see Question 1

			
		}

	}
	

}