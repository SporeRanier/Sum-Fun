package version1;
//Author David Bell
/*holds all information for a single, untimed game 
 *(including Gameboard, Queue, Moves, and Score) 
 */
import java.util.*;

public class TimedGame extends Observable
{
	private static TimedGame timedInstance = new TimedGame();
	
	private GameBoard gameBoard;
	private Queue queue;
	private Timer time;
	private int totalScore = 0;
	private int moveScore = 0;
	//constructor for a singleton TimedGame
	private TimedGame()
	{
		gameBoard = GameBoard.getBoard();
		queue = Queue.getQueue();
		time = new Timer();
		//TODO: Time = 2:00;
	}
	//accessor for a TimedGame
	public static TimedGame getTimedGame()
	{
		return timedInstance;
	}
	//returns a copy of the board
	public int[][] viewBoard()
	{
		return gameBoard.viewBoard();
	}
	/* Places a tile, using the top of the queue
	 * Return value of -1 means the tile is occupied, 
	 * value 0 means the tile was simply place,
	 * value >= 1 means a tile was placed, and the returned value is the score
	 */
	public int placeTile(int x, int y)
	{
		moveScore = gameBoard.placeTile(x, y, queue.viewTop());
		//score of -1 indicates that tile is already occupied, so nothing is done
		if (moveScore == -1)
		{
			return moveScore;
		}
		//remove the top of the queue and generate a new value
		queue.useQueue();
		totalScore += moveScore;
		//notify observers
		setChanged();
		notifyObservers();
		return moveScore;
	}
	//returns a copy of the queue
	public int[] viewQueue()
	{
		return queue.viewQueue();
	}
	//Allows the caller to view what the top of the queue is without using it
	public int viewTop()
	{
		return queue.viewTop();
	}
	//refreshes the queue, true means the refresh happened
	public boolean refreshQueue()
	{
		boolean refreshed = queue.refreshQueue();
		setChanged();
		notifyObservers();
		return refreshed;
	}
	//checks to see if there is a refresh remaining, value true means there is
	public boolean refreshLeft()
	{
		return queue.refreshLeft();
	}
	//returns the value of totalScore
	public int getScore()
	{
		return totalScore;
	}
	//returns the score acquired from a single move, before it is added to total
	public int getMoveScore()
	{
		return moveScore;
	}
	//returns the number of non-null (non 11) tiles on the board, to determine how close a player is to winning
	public int getBoardStatus()
	{
		return gameBoard.boardStatus();
	}
}
