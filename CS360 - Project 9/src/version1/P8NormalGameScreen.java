package version1;
//GUI File, everything will be implemented in future
import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.GroupLayout.Alignment;


public class P8NormalGameScreen extends JFrame{
	private JButton tiles[][];
	private JButton offButton;
	private JButton BGM1;
	private JButton BGM2;
	private File Music1;
	private File Music2;
	private URI uri1;
	private URI uri2;
	private URL url1;
	private URL url2;
	private AudioClip sound1;
	private AudioClip sound2;
	GameBoard gameBoard;
	Queue queue;
	int score;
	int moves;
	int testQueue[] = new int[5];
	JPanel panelC;
	JPanel panelN;
	JPanel panelS;
	JPanel panelB;
	JPanel panelW;
	JLabel timeLabel;
	JLabel queueN;
	JLabel queueT[];
	int moveScore;
	JLabel scoreLabel;
	JLabel movesLabel;
	JLabel msLabel;
	
	public P8NormalGameScreen() {
		setTitle("Sum Fun 0.9");
		moveScore = 0;
		gameBoard = GameBoard.getBoard();
		queue = Queue.getQueue();
		tiles = new JButton[9][9];
		moves = 50;
		setSize(1024, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelC = new JPanel();
		panelC.setBackground(new Color(178, 34, 34));
		getContentPane().add(panelC, BorderLayout.CENTER);
		
		panelN = new JPanel();
		panelN.setBackground(Color.BLACK);
		getContentPane().add(panelN, BorderLayout.NORTH);
		panelN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnMusic = new JButton("Music 1");
		btnMusic.setForeground(new Color(255, 255, 0));
		btnMusic.setBackground(new Color(178, 34, 34));
		btnMusic.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panelN.add(btnMusic);
		
		JButton btnMusic_1 = new JButton("Music 2");
		btnMusic_1.setBackground(new Color(178, 34, 34));
		btnMusic_1.setForeground(Color.YELLOW);
		btnMusic_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panelN.add(btnMusic_1);
		
		JButton btnNewButton = new JButton("Mute");
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panelN.add(btnNewButton);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setForeground(Color.YELLOW);
		btnQuit.setBackground(new Color(178, 34, 34));
		btnQuit.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panelN.add(btnQuit);
		
		JLabel label = new JLabel("                                                                                                                                                                                                                  ");
		panelN.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Queue");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panelN.add(lblNewLabel_2);
		
		panelS = new JPanel();
		getContentPane().add(panelS, BorderLayout.SOUTH);
		
		panelB = new JPanel();
		panelB.setBackground(Color.BLACK);
		getContentPane().add(panelB, BorderLayout.EAST);
		queueN = new JLabel("Queue");
		
		buildPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createBoardGui();
		createQueueGui();
		
		setVisible(true);
		
		
	}
	public void buildPanel(){
		
		
		BGM1 = new JButton("Music 1");
		BGM1.setToolTipText("Starts playing song 1");
		BGM2 = new JButton("Music 2");
		BGM2.setToolTipText("Starts playing song 2");
		BGM1.addActionListener(new MusicButtonListener());
		BGM2.addActionListener(new MusicButtonListener());
		
		Music1 = new File("katyusha.wav");
		Music2 = new File("koro.wav");
		
		URI uri1 = Music1.toURI();
		URI uri2 = Music2.toURI();
		URL url1;
		try {
			url1 = uri1.toURL();
			sound1 = Applet.newAudioClip(url1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		try {			
			url2 = uri2.toURL();
			sound2 = Applet.newAudioClip(url2);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Operates Music
		private class MusicButtonListener implements ActionListener {

			
			public void actionPerformed(ActionEvent RCA) {
				if(RCA.getSource() == BGM1){
					sound2.stop();
					sound1.loop();
				}
				if(RCA.getSource() == BGM2){
					sound1.stop();
					sound2.loop();
					
				}
				if(RCA.getSource() == offButton){
					sound1.stop();
					sound2.stop();
				}
				
			}
			
		}
	private void createQueueGui()
	//Creates the queue
	{
		panelB.setLayout(null);
		GridBagLayout gbl_panelB = new GridBagLayout();
		gbl_panelB.columnWidths = new int[]{202, 0};
		gbl_panelB.rowHeights = new int[] {202, 0, 180, 70, 202};
		gbl_panelB.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelB.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panelB.setLayout(gbl_panelB);
		
		JPanel panelE = new JPanel();
		panelE.setBounds(0, 0, 202, 137);
		panelE.setForeground(Color.YELLOW);
		panelE.setBackground(Color.BLACK);
		GridBagConstraints gbc_panelE = new GridBagConstraints();
		gbc_panelE.fill = GridBagConstraints.BOTH;
		gbc_panelE.insets = new Insets(0, 0, 5, 0);
		gbc_panelE.gridx = 0;
		gbc_panelE.gridy = 0;
		panelB.add(panelE, gbc_panelE);
		panelE.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 494, 202, 54);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panelB.add(panel, gbc_panel);
		
		JButton btnReset = new JButton("Reset Queue!");
		panel.add(btnReset);
		btnReset.setForeground(Color.YELLOW);
		btnReset.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnReset.setBackground(new Color(178, 34, 34));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 137, 202, 137);
		panel2.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 2;
		panelB.add(panel2, gbc_panel2);
		panel2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("Turn Count:   ");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panel2.add(label);
		
		msLabel = new JLabel("50");
		msLabel.setForeground(Color.YELLOW);
		msLabel.setHorizontalAlignment(SwingConstants.CENTER);
		msLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panel2.add(msLabel);
		
		JLabel label_2 = new JLabel("Score:");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panel2.add(label_2);
		
		scoreLabel = new JLabel("0");
		scoreLabel.setForeground(Color.YELLOW);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panel2.add(scoreLabel);
		
		JLabel moves_1 = new JLabel("Move Score:");
		moves_1.setForeground(Color.YELLOW);
		moves_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panel2.add(moves_1);
		
		movesLabel = new JLabel("0");
		movesLabel.setForeground(Color.YELLOW);
		movesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movesLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panel2.add(movesLabel);
		
		JLabel reset = new JLabel("Resets:");
		reset.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		reset.setForeground(Color.YELLOW);
		panel2.add(reset);
		
		JLabel resetLabel = new JLabel("1");
		resetLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		resetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resetLabel.setForeground(Color.YELLOW);
		panel2.add(resetLabel);
		
		JPanel panelSU = new JPanel();
		panelSU.setBounds(0, 274, 202, 202);
		panelSU.setBackground(Color.BLACK);
		GridBagConstraints gbc_panelSU = new GridBagConstraints();
		gbc_panelSU.fill = GridBagConstraints.BOTH;
		gbc_panelSU.gridx = 0;
		gbc_panelSU.gridy = 4;
		panelB.add(panelSU, gbc_panelSU);
		
		JLabel stalin = new JLabel("");
		stalin.setBackground(Color.BLACK);
		stalin.setIcon(new ImageIcon("C:\\Users\\mjwol\\Pictures\\nid8.gif"));
		panelSU.add(stalin);
		
		queueT = new JLabel[5];
		int queueI[] = queue.viewQueue();
		for (int x = 0; x <= 4; x++){
			queueT[x] = new JLabel(String.format("%d            ", queueI[x]));
			queueT[x].setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
			queueT[x].setForeground(Color.YELLOW);
			queueT[x].setHorizontalAlignment(SwingConstants.RIGHT);
			panelE.add(queueT[x]);
		}
		
	}
	private void createBoardGui()
	//Creates the board
	{
		
		panelC.setLayout(new GridLayout(9,9));
		panelC.setSize(500, 500);
		tiles = new JButton[9][9];
		
		int intBoard[][] = new int[9][9];
				
				intBoard = gameBoard.viewBoard();
		for (int x = 0; x <= 8; x++){
			for (int y = 0; y <= 8; y++){
				if (intBoard[x][y] != 11){
					tiles[x][y] = new JButton(String.format("%d", intBoard[x][y]));
					tiles[x][y].setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
					tiles[x][y].putClientProperty("row", x);
					tiles[x][y].putClientProperty("column", y);
					tiles[x][y].addActionListener(new SpaceListener());
					tiles[x][y].setForeground(Color.YELLOW);
					tiles[x][y].setBackground(new Color(178, 34, 34));
					panelC.add(tiles[x][y]);
				}
				else {
					tiles[x][y] = new JButton(String.format(""));
					tiles[x][y].setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
					tiles[x][y].putClientProperty("row", x);
					tiles[x][y].putClientProperty("column", y);
					tiles[x][y].addActionListener(new SpaceListener());
					tiles[x][y].setForeground(Color.YELLOW);
					tiles[x][y].setBackground(new Color(178, 34, 34));
					panelC.add(tiles[x][y]);
				}
			}
		}
	}
	private void updateQueue(int newQueue[])
	//Updates queue
	{
		for (int x = 0; x <= 4; x++){
			queueT[x].setText(String.format("%d            ", newQueue[x]));
		}
	}
	
	private void updateBoard(int newBoard[][])
	//Updates board
	{
		for (int x = 0; x <= 8; x++){
			for (int y = 0; y <= 8; y++){
				if (newBoard[x][y] != 11){
					tiles[x][y].setText(String.format("%d", newBoard[x][y]));
					tiles[x][y].setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
					tiles[x][y].setForeground(Color.YELLOW);
					tiles[x][y].setBackground(new Color(178, 34, 34));
				}
				else {
					tiles[x][y].setText(String.format(""));
					tiles[x][y].setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
					tiles[x][y].setForeground(Color.YELLOW);
					tiles[x][y].setBackground(new Color(178, 34, 34));
				}
			}
		}
	}
	private class SpaceListener implements ActionListener
	//Listener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Get the pressed button
			JButton pressed = (JButton) e.getSource();
			//change the text of the space with the top value from the queue
			(pressed).setText(String.format("%d", queue.viewTop()));
			//TODO: move up? 
			
			//send the new value to the GameBoard for processing, which returns a score			
			moveScore = gameBoard.placeTile((int) pressed.getClientProperty("row"), (int) pressed.getClientProperty("column"), (int) queue.viewTop());
			//a value of 12 means the space is previously occupied
			if (moveScore != 12)
			{
				score += moveScore;
				scoreLabel.setText(String.format("%d", score));
				queue.useQueue();
				moves --;
				msLabel.setText(String.format("%d", moves));
				movesLabel.setText(String.format("%d", moveScore));
				
			}
			
			updateBoard(gameBoard.viewBoard());
			
			testQueue = queue.viewQueue();
			updateQueue(testQueue);	
		}
	}
}
