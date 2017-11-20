package version1;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

public class Top10Scores extends JFrame implements Observer{
	public Top10Scores() {
		setTitle("High Scores!");
		getContentPane().setBackground(new Color(178, 34, 34));
		setSize(800, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel highScorePanel = new JPanel();
		highScorePanel.setBackground(new Color(178, 34, 34));
		getContentPane().add(highScorePanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel highScoreLabel = new JLabel("High Scores");
		highScoreLabel.setForeground(Color.YELLOW);
		highScoreLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 36));
		panel.add(highScoreLabel);
		
		JLabel label = new JLabel("", new ImageIcon("starsmall.png"), JLabel.CENTER);
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
