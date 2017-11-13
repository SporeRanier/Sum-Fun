package version1;
//Author David Bell

//Creates a 9x9 board
import java.util.*;

public class GameBoard 
{
	//stores the actual board
	int gameBoard[][];
	
	//constructor that creates a board of 9*9 containing random numbers from 0 to 9
	public GameBoard()
	{	
		Random random = new Random();
		//instantiates gameBoard of 9x9
		gameBoard = new int[9][9];
		//for rows 1 - 7 (leaving 0 and 8 empty)
		for (int x = 0; x <= 8; x++){
			//for columns 1 - 7 (leaving 0 and 8 empty)
			for (int y = 0; y <= 8; y++){
				if (x == 0 || x == 8 || y == 0 || y == 8){
					//11 will be the stand-in for empty
					gameBoard[x][y] = 11;
				}
				//place a random number from 0 to 9 in the spot
				else{
					gameBoard[x][y] = random.nextInt(10);
				}
			}
		}
	}
	//returns a copy of the gameBoard to show the player
	public int [][] viewBoard()
	{
		//TODO:System.out.println("I am before");
		int [][] copyBoard = new int[9][];
		//TODO:System.out.println("I am after");
		for(int i = 0; i < 9; i++){
		    copyBoard[i] = gameBoard[i].clone();
		  //TODO:System.out.printf("%d,%d", i, copyBoard[i].length);
		}
		return copyBoard;
	}
	
	//Method taking care of the placement of a tile, returning 0 if no tiles are removed, and the score if tiles are removed
	public int placeTile(int x, int y, int value)
	{
		//if the space is already occupied (being not 11)
		if (gameBoard[x][y] != 11){
			return 12;
		}
		
		gameBoard[x][y] = value;
		
		int total= 0;
		int tileCount = 0;
		
		//indicates the bounds of checked area (being 1 away from the center (x,y))
		int xMin = x-1;
		int yMin = y-1;
		int xMax = x+1;
		int yMax = y+1;
		//if the min is out of bounds (-1), shift the min to stay in bounds
		if (xMin == -1){
			xMin++;
		}
		if (yMin == -1){
			yMin++;
		}
		//if the max is out of bounds (9), shift the max to stay in bounds
		if (xMax == 9){
			xMax--;
		}
		if (yMax == 9){
			yMax--;
		}
		//iterate through from min to max of x & y to clear the spaces
		for (int j = xMin; j <= xMax; j++){
			for (int k = yMin; k <= yMax; k++){
				if (gameBoard[j][k] != 11 && (!(j == x && k == y))){
					total += gameBoard[j][k]; 
					tileCount += 1;
				}
			}
		}
		//check to see if the total is equal to the value of the placed tile
		if ( (total % 10) == value){
			clearAround(x, y);
			if (tileCount >= 3){
				return total * tileCount;
			}
			return total;
		}
		//Result of 0 means no tiles removed
		return 0;
	}
	//clears the tiles around x,y (meaning they are replaced by the value 11)
	public void clearAround(int x, int y)
	{
		//indicates the bounds of checked area (being 1 away from the center (x,y))
		int xMin = x-1;
		int yMin = y-1;
		int xMax = x+1;
		int yMax = y+1;
		//if the min is out of bounds (-1), shift the min to stay in bounds
		if (xMin == -1){
			xMin++;
		}
		if (yMin == -1){
			yMin++;
		}
		//if the max is out of bounds (9), shift the max to stay in bounds
		if (xMax == 9){
			xMax--;
		}
		if (yMax == 9){
			yMax--;
		}
		//iterate through from min to max of x & y to clear the spaces
		for (int j = xMin; j <= xMax; j++){
			for (int k = yMin; k <= yMax; k++){
				gameBoard[j][k] = (int) 11;
				//TODO:System.out.printf("Clear method %d,%d  %d\n", j, k, gameBoard[j][k]);
			}
		}
	}
	
}
