package version1;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class Top10Scores extends JFrame implements Observer{
	public Top10Scores() {
		setTitle("High Scores!");
		getContentPane().setBackground(new Color(178, 34, 34));
		setSize(800, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel highScorePanel = new JPanel();
		highScorePanel.setBackground(new Color(178, 34, 34));
		getContentPane().add(highScorePanel, BorderLayout.CENTER);
		highScorePanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblAaa = new JLabel();
		lblAaa.setText("Player 1");
		lblAaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa);
		
		JLabel lblAaa_1 = new JLabel("Gil 100");
		lblAaa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_1);
		
		
		JLabel lblAaa_2 = new JLabel("Francesca 94");
		lblAaa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_2);
		
		JLabel lblAaa_3 = new JLabel("Olivia 86");
		lblAaa_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_3.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_3);
		
		JLabel lblAaa_4 = new JLabel("Evan 80");
		lblAaa_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_4.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_4);
		
		JLabel lblAaa_5 = new JLabel("Daniel 67");
		lblAaa_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_5.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_5);
		
		JLabel lblAaa_6 = new JLabel("Alex 55");
		lblAaa_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_6.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_6);
		
		JLabel lblAaa_7 = new JLabel("Julie 47");
		lblAaa_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_7.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_7);
		
		JLabel lblAaa_8 = new JLabel("Cindy 41");
		lblAaa_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_8.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_8);
		
		JLabel lblAaa_9 = new JLabel("Brittney 23");
		lblAaa_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaa_9.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
		highScorePanel.add(lblAaa_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel highScoreLabel = new JLabel("High Scores");
		highScoreLabel.setForeground(Color.YELLOW);
		highScoreLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 36));
		panel.add(highScoreLabel);
		
		JLabel label = new JLabel("", new ImageIcon("starsmall.png"), JLabel.CENTER);
		setVisible(true);
		
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
