package version1;
//Small Window that determines game type
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;

public class P8Menu extends JFrame{
	//Constructor
	private BufferedImage kremlin;
	public P8Menu() {
		setSize(480, 260);
		getContentPane().setLayout(null);
		ImageIcon image = new ImageIcon("kremlin.jpg");
		JLabel label = new JLabel("", new ImageIcon("C:\\Users\\mjwol\\Pictures\\Photoshop Projects\\kremlin1.png"), JLabel.CENTER);
		JButton btnNewButton = new JButton("Normal Game");
		btnNewButton.setFont(new Font("Showcard Gothic", Font.BOLD, 14));
		btnNewButton.addActionListener(new NormalButtonListener());
		btnNewButton.setBounds(293, 11, 161, 34);
		getContentPane().add(btnNewButton);
		
		JButton btnStartAdvancedGame = new JButton("Advanced Game");
		btnStartAdvancedGame.setFont(new Font("Showcard Gothic", Font.BOLD, 14));
		btnStartAdvancedGame.addActionListener(new AdvancedButtonListener());
		btnStartAdvancedGame.setBounds(293, 46, 161, 32);
		btnStartAdvancedGame.setToolTipText("In Progress");
		getContentPane().add(btnStartAdvancedGame);
		
		JButton btnNewButton_1 = new JButton("Debug");
		btnNewButton_1.setBounds(0, 198, 63, 23);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.CENTER );
		panel.setBounds(0, 0, 464, 221);
		
		
		getContentPane().add(panel);
		
		setVisible(true);
		
	}
	private class NormalButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.print("working");
			P8NormalGameScreen game1 = new P8NormalGameScreen();
			setVisible(false);
			
		}
}

	private class AdvancedButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent f) {
			// TODO Auto-generated method stub
			System.out.print("working");
			TimedGameScreen game2 = new TimedGameScreen();
			setVisible(false);
			
		}
}
}
