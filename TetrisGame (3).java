//TetrisGame.java
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * This is a clone of the classic Tetris game.
 * The GUI is the standard for GridWorld.
 * It will compile and execute after class TetrisBug is written
 * ...see Question 0
 */
public class TetrisGame {

	/**
	 * World variable used for GUI...
	 * Initialized to 19x17 Grid for aesthetic viewing.
	 * ..leaves some columns at the right for extra game elements
	 * like 'upcoming piece' and 'score' information
	 */
	public static ActorWorld world = new ActorWorld(new BoundedGrid(19, 17));

	/**
	 * A reference to the currently controlled TetrisBlock in the game.
	 * Its direction and rotation is controlled by the keyboard arrow keys.
	 */
	public static TetrisBlock currentBlock;

	/**
	 * The number of lines cleared during a the game
	 */
	public static int score;

	/**
	 * Handles game simulation and KeyEvent handling
	 * NOTE: YOU DO NOT NEED TO WRITE ANY CODE IN THE main
	 */
	public static void main(String[] args) {

		//set up world
		for (int i = 0; i < 19; i++) {
			world.add(new Location(i,11),new Rock());
			world.add(new Location(i,0),new Rock());
		}
		nextTetrisBlock();
		//needed code for keyboard event handling
		java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager()
		.addKeyEventDispatcher(new java.awt.KeyEventDispatcher() {
			public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) {
				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
				
				if (key.equals("pressed UP"))
					currentBlock.rotate();
				if (key.equals("pressed RIGHT"))
					currentBlock.moveRight();
				if (key.equals("pressed DOWN"))
					currentBlock.act();
				if (key.equals("pressed LEFT"))
					currentBlock.moveLeft();
				world.show();
				return true;
			}
		});
		world.show();

	}

	/**
	 * Calls removeCompleteRows and chooses a new TetrisBlock at random
	 */
	public static void nextTetrisBlock() {

		removeCompleteRows();
		TetrisBlock randomBlock = new TetrisBlock();//default 2block piece
		//choose random block
		int randNum = (int)(Math.random()*7)+1;//random number between 1 and 7
		//if(randNum == 1)
		// randomBlock = new TetrisBlockO();
		//if(randNum == 2)
		// randomBlock = new TetrisBlockI();
		//if(randNum == 3)
		// randomBlock = new TetrisBlockT();
		//if(randNum == 4)
		// randomBlock = new TetrisBlockL();
		//if(randNum == 5)
		// randomBlock = new TetrisBlock_L();
		//if(randNum == 6)
		// randomBlock = new TetrisBlockZ();
		//if(randNum == 7)
		// randomBlock = new TetrisBlock_Z();

		currentBlock = randomBlock;
	}
	/**
	 * checks each row 1 through 18 (skip row 0) for full rows
	 * if a row is full, then remove the actor from each cell in that row
	 * and ask each actor located above the just deleted row to act and
	 * update the score++
	 */
	public static void removeCompleteRows() {
		Grid<Actor> gr = world.getGrid();

		//Your code goes here ... see Question 2
		for(int i = 18; i > 0; i--)
		{
				if(isFullRow(i))
				{
					for(int j = 10; j > 0; j--)
					{
					gr.remove(new Location(i,j));
					if(gr.isValid(new Location(i-1,j)) == false)
					{
						gr.get(new Location (i,j)).moveTo(new Location(i--,j));
					}
					}
					score++;
					i++;
				}
		}
	}
	
	private static boolean isFullRow(int i)
	{
		Grid<Actor> grA = world.getGrid();

		for(int x = 1; x < 11; x++)
		{
			if(grA.get(new Location(i,x)) == null)
			{
				return false;
			}
		}
		return true;
	}
}