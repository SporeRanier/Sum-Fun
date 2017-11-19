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

	public void addScore(String name, int score) throws IOException {
		FileWriter fwriter = new FileWriter("HighScores.txt", true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		outputFile.println(name + " " + score);
		fillTopTen();
		fwriter.close();
		outputFile.close();
	}

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

	public void showTopTen() {
		JOptionPane.showMessageDialog(null,
				"1st Place:\t" + names[0] + "\t" + scores[0] + "\n" + "2nd Place:\t" + names[1] + "\t" + scores[1]
						+ "\n" + "3rd Place:\t" + names[2] + "\t" + scores[2] + "\n" + "4th Place:\t" + names[3] + "\t"
						+ scores[3] + "\n" + "5th Place:\t" + names[4] + "\t" + scores[4] + "\n" + "6th Place:\t"
						+ names[5] + "\t" + scores[5] + "\n" + "7th Place:\t" + names[6] + "\t" + scores[6] + "\n"
						+ "8th Place:\t" + names[7] + "\t" + scores[7] + "\n" + "9th Place:\t" + names[8] + "\t"
						+ scores[8] + "\n" + "10th Place:\t" + names[9] + "\t" + scores[9]);
	}

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
