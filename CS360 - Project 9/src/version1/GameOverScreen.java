package version1;

import javax.swing.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;
import java.awt.Color;

public class GameOverScreen extends JFrame{
	AudioStream audioStream;
	public GameOverScreen() throws IOException {
		setTitle("Game Over");
		setSize(283, 267);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		InputStream in = new FileInputStream("gameover.wav");

	    // create an audiostream from the inputstream
		audioStream = new AudioStream(in);

	    // play the audio clip with the audioplayer class
		AudioPlayer.player.start(audioStream);
		
		JButton newGame = new JButton("New Game");
		newGame.setForeground(Color.YELLOW);
		newGame.setBounds(10, 156, 89, 23);
		getContentPane().add(newGame);
		newGame.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		
		JButton highScores = new JButton("High Scores");
		highScores.setForeground(Color.YELLOW);
		highScores.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		highScores.setBounds(79, 194, 118, 23);
		getContentPane().add(highScores);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.setForeground(Color.YELLOW);
		btnQuitGame.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnQuitGame.setBounds(168, 155, 89, 23);
		getContentPane().add(btnQuitGame);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel gameoveryeah = new JLabel(" ");
		gameoveryeah.setIcon(new ImageIcon("porkygameover.png"));
		panel.add(gameoveryeah);
		
		getContentPane().add(panel);
		setVisible(true);
	}
}
