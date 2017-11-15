package version1;

public class TimedGame 
{
	GameBoard gameBoard;
	Queue queue;
	//TODO Time Variable;
	
	public TimedGame()
	{
		gameBoard = GameBoard.getBoard();
		queue = Queue.getQueue();
		//TODO: Initialize the time variable
	}
	public int getTime(){
		return 0;
	}
}
