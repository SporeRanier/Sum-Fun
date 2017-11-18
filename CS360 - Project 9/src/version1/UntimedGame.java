package version1;
//Author David Bell\
/*holds all information for a single, timed game 
 *(including Gameboard, Queue, Moves, and Score) 
 */
import java.util.Observable;

public class UntimedGame extends Observable
{
	private static UntimedGame untimedInstance = new UntimedGame();
	
	private GameBoard gameBoard;
	private Queue queue;
	private int moves;
	private int totalScore = 0;
	private int moveScore = 0;
	//Constructor for a singleton UntimedGame
	private UntimedGame()
	{
		gameBoard = GameBoard.getBoard();
		queue = Queue.getQueue();
		moves = 50;
	}
	//access to the UntimedGame
	public static UntimedGame getUntimedGame()
	{
		return untimedInstance;
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
		moves--;
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
	//refreshes the queue, true means the refresh happened
	public boolean refreshQueue()
	{
		return queue.refreshQueue();
	}
	//checks to see if there is a refresh remaining, value true means there is
	public boolean refreshLeft()
	{
		return queue.refreshLeft();
	}
	//returns the remaining moves
	public int getMoves()
	{
		return moves;
	}
	//removes a move and returns the turns remaining
	//TODO: Remove?
	public int useMove()
	{
		moves--;
		//notify observers
		setChanged();
		notifyObservers();
		return moves;
	}
	//returns the value of totalScore
	public int getScore()
	{
		return totalScore;
	}
}