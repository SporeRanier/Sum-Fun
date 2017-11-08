package version1;

public class GameType 
{
	int type;
	int moves;
	
	public GameType(int newType)
	{
		
		type = newType;
		//Type 0 means Move 
		if (type == 0)
		{
			moves = 50;
		}
	}
	
	public int moveTaken()
	{
		moves--;
		return moves;
	}
	
}
