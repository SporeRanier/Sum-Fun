package version1;

public class Score 
{
	String player;
	int score = 0;
	
	public Score(String newPlayer)
	{
		player = newPlayer;
	}
	
	public void changeScore(int newScore)
	{
		score = newScore;
	}
	public int getScore()
	{
		return score;
	}
}
