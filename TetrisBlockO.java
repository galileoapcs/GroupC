import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


public class TetrisBlockO extends TetrisBlock
{

	public TetrisBlockO() {
		super();
		rotationPos = 0;

		TetrisBug b;
		TetrisBug d;
		// create TetrisBugs for ArrayList blocks and put them in Grid gr

		b = new TetrisBug(Color.red);
		b.putSelfInGrid(gr, new Location(0, 6));
		d = new TetrisBug(Color.red);
		d.putSelfInGrid(gr, new Location(1, 6));

		blocks.add(b);
		blocks.add(d);

		// TetrisBlock subclasses will add two more TetrisBug objects to blocks

	}
	public void act() {
		setDirection(180);
		for (TetrisBug tb : blocks)
			tb.setDirection(180);
		if (canMoveDown())
			moveDown();
		else if (!TetrisGame.currentBlock.canMoveDown())
			TetrisGame.nextTetrisBlock();
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
			blocks.get(2).move();
			blocks.get(1).move();
		} else if (rotationPos == 1) {
			move();
			blocks.get(1).move();

		}
		
	}

	/**
	 * Returns true if the TetrisBlock and its TetrisBugs can move (they should
	 * already be facing down) Otherwise, returns false.
	 */
	public boolean canMoveDown() {
		if (rotationPos == 0)
			return canMove() && blocks.get(2).canMove();
		else if (rotationPos == 1)
			return canMove() && blocks.get(1).canMove();
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
			if (blocks.get(1).canMove() && blocks.get(2).canMove()) {
				blocks.get(2).move();
				blocks.get(1).move();
				blocks.get(0).move();
				move();
			}
		} else if (rotationPos == 1) {

			if (canMove() && blocks.get(0).canMove()) {
				move();
				blocks.get(0).move();
				blocks.get(1).move();
				blocks.get(2).move();

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
				move();
				blocks.get(0).move();
				blocks.get(1).move();
				blocks.get(2).move();
			}
			
		} else if (rotationPos == 1) {
			if (blocks.get(0).canMove()) {
				blocks.get(2).move();
				blocks.get(1).move();
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
	

	}


