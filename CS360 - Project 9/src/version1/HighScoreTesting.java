package version1;
import java.io.*;
public class HighScoreTesting {

	public static void main(String[] args) throws IOException{
		High_Scores highScores = new High_Scores();
		int[] numbers = {55, 23, 41, 67, 80, 94, 100, 22, 3, 47, 120, 150, 133, 123, 144};
		String[] strings = {"Alex", "Brittney","Cindy", "Daniel", "Evan","Francesca", "Gil", "Hilary", "Ike", "Julie", "Kate", "Luke", "Michelle", "Nick", "Olivia"};
		/*for(int i = 0; i< numbers.length; i++){
			highScores.addScore(strings[i], numbers[i]);
		}
		highScores.fillTopTen();
		highScores.showTopTen();*/
		highScores.testScores(strings, numbers);
		highScores.showTopTen();
		
	}
}

