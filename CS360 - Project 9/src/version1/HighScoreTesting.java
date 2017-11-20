package version1;
import java.io.*;
public class HighScoreTesting {

	public static void main(String[] args) throws IOException{
		High_Scores highScores = new High_Scores();
		int[] numbers = {55, 23, 41, 67, 80, 94, 100, 22, 3, 47};
		String[] strings = {"Alex", "Brittney","Cindy", "Daniel", "Evan","Francesca", "Gil", "Hilary", "Ike", "Julie"};
		highScores.testScores(strings, numbers);
		//highScores.add("Olivia", 86);
		//highScores.showTopTen();
		//highScores.writeToFile();
		highScores.fill();
		
		
	}
}

