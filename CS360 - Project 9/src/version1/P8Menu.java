package version1;
//Small Window that determines game type
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class P8Menu extends JFrame{
	//Constructor
	
	public P8Menu() {
		setSize(1024, 768);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start Normal Game");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new NormalButtonListener());
		btnNewButton.setBounds(191, 288, 260, 105);
		getContentPane().add(btnNewButton);
		
		JButton btnStartAdvancedGame = new JButton("Start Advanced Game");
		btnStartAdvancedGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStartAdvancedGame.addActionListener(new AdvancedButtonListener());
		btnStartAdvancedGame.setBounds(575, 288, 260, 105);
		btnStartAdvancedGame.setToolTipText("In Progress");
		getContentPane().add(btnStartAdvancedGame);
		setVisible(true);
		
	}
	private class NormalButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//TODO:System.out.print("working");
			P8NormalGameScreen game1 = new P8NormalGameScreen();
			setVisible(false);
			
		}
}

	private class AdvancedButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent f) {
			// TODO Auto-generated method stub
			//TODO:System.out.print("working");
			TimedGameScreen game2 = new TimedGameScreen();
			setVisible(false);
			
		}
}
}
