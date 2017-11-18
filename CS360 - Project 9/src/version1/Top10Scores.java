package version1;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.FlowLayout;

public class Top10Scores extends JFrame implements Observer{
	public Top10Scores() {
		setSize(800, 600);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel label = new JLabel("", new ImageIcon("starsmall.png"), JLabel.CENTER);
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
