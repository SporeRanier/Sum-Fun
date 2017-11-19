package version1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class High_Scores {
	private String[] names;
	private int[] scores;

	public High_Scores() {
		names = new String[10];
		scores = new int[10];
	}
/**
 * This method writes a new score and name value to the HighScores text file.
 * @param name The name value to be written to the file.
 * @param score the numerical score value to be written to the file.
 * @throws IOException
 */
	public void addScore(String name, int score) throws IOException {
		FileWriter fwriter = new FileWriter("HighScores.txt", true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		outputFile.println(name + " " + score);
		fillTopTen();
		fwriter.close();
		outputFile.close();
	}
/**
 * This reads the scores and names from the file and finds the top 10 scores from the scores in the file and organizes them numerically in the
 * scores field and also organizes the corresponding name in the correct order as well.
 * @throws IOException
 */
	public void fillTopTen() throws IOException {
		File file = new File("HighScores.txt");
		Scanner inputFile = new Scanner(file);
		String data;
		int counter = 0;
		while (inputFile.hasNext()) {
			data = inputFile.nextLine();
			StringTokenizer strTokenizer = new StringTokenizer(data, " ");
			while (strTokenizer.hasMoreTokens()) {
				if (counter < 10) {
					names[counter] = strTokenizer.nextToken();
					scores[counter] = Integer.parseInt(strTokenizer.nextToken());
				} else {
					String tempName = strTokenizer.nextToken();
					int tempScore = Integer.parseInt(strTokenizer.nextToken());
					int temp = 0;
					String temp2 = "";
					for (int i = 0; i < scores.length; i++) {
						if (tempScore > scores[i]) {
							for (int j = i; j < scores.length - 1; j++) {
								temp = scores[j];
								temp2 = names[j];
								scores[j] = tempScore;
								names[j] = tempName;
								scores[j + 1] = temp;
								names[j + 1] = temp2;
							}

						}
					}
				}
			}
			counter++;
		}
		inputFile.close();
	}
/**
 * This shows the top 10 scores in a JOptionPane window.
 */
	public void showTopTen() {
		JOptionPane.showMessageDialog(null,
				"1st Place:\t" + names[0] + "\t" + scores[0] + "\n" + "2nd Place:\t" + names[1] + "\t" + scores[1]
						+ "\n" + "3rd Place:\t" + names[2] + "\t" + scores[2] + "\n" + "4th Place:\t" + names[3] + "\t"
						+ scores[3] + "\n" + "5th Place:\t" + names[4] + "\t" + scores[4] + "\n" + "6th Place:\t"
						+ names[5] + "\t" + scores[5] + "\n" + "7th Place:\t" + names[6] + "\t" + scores[6] + "\n"
						+ "8th Place:\t" + names[7] + "\t" + scores[7] + "\n" + "9th Place:\t" + names[8] + "\t"
						+ scores[8] + "\n" + "10th Place:\t" + names[9] + "\t" + scores[9]);
	}
/**
 * 
 * @param namesTest An array of Strings containing the names of the people who have entered their scores into the game.
 * @param scoresTest An array of integers representing the scores entered by the corresponding person in namesTest.
 * This method starts by reading through the first 10 values of scores test and inserting the values into the score array.
 * Next these values are sorted in numerical order while also shifting the corresponding names accordingly.
 * Finally the remaining values in scoresTest are read and compared to each value currently in the scores field.
 * If the value is greater than any of the values in scores[] then the value is inserted at that index and the remaining scores are moved down
 * one position so that the scores are still in the correct order.
 */
	public void testScores(String[] namesTest, int[] scoresTest) {
		String tempName = "";
		int tempScore = 0;
		int temp = 0;
		String temp2 = "";
		int counter = 0;
		int counter2 = 0;
		boolean nextNull = false;
		while (counter < 10) {
			scores[counter] = scoresTest[counter];
			names[counter] = namesTest[counter];
			counter++;
		}
		for (int i = 0; i < scores.length; i++) {
			for (int j = 1; j < scores.length - i; j++) {
				if (scores[j - 1] > scores[j]) {
					temp = scores[j - 1];
					scores[j - 1] = scores[j];
					scores[j] = temp;
					tempName = names[j - 1];
					names[j - 1] = names[j];
					names[j] = tempName;
				}
			}
		}
		counter = 10;
		while (counter < scoresTest.length) {
			tempScore = scoresTest[counter];
			tempName = namesTest[counter];
			for (int i = 0; i < scores.length; i++) {
				if (tempScore > scores[i]) {
					for (int j = i; j < scores.length - 1; j++) {
						scores[j+1] = scores[j];
						scores[j] = tempScore;
						names[j+1] = names[j];
						names[j] = tempName;
						/*tempScore = scores[j];
						temp = names[j];
						scores[j] = tempScore;
						names[j] = tempName;
						scores[j + 1] = temp;
						names[j + 1] = temp2;*/
					}

				}
			}

			counter++;
		}
	

		
	}
}
