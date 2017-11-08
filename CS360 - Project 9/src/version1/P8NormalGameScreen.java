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
	JPanel panelE;
	JPanel panelW;
	JLabel movesLabel;
	JLabel scoreLabel;
	JLabel msLabel;
	JLabel ms;
	JLabel queueN;
	JLabel queueT[];
	int moveScore;
	
	public P8NormalGameScreen() {
		moveScore = 0;
		gameBoard = new GameBoard();
		queue = new Queue();
		tiles = new JButton[9][9];
		moves = 50;
		setSize(1024, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelC = new JPanel();
		getContentPane().add(panelC, BorderLayout.CENTER);
		
		panelN = new JPanel();
		getContentPane().add(panelN, BorderLayout.NORTH);
		panelN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnMusic = new JButton("Music 1");
		panelN.add(btnMusic);
		
		JButton btnMusic_1 = new JButton("Music 2");
		panelN.add(btnMusic_1);
		
		JButton btnNewButton = new JButton("Mute");
		panelN.add(btnNewButton);
		
		JLabel label = new JLabel("                                                                                                                                                                                                                          ");
		panelN.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Queue");
		panelN.add(lblNewLabel_2);
		
		panelS = new JPanel();
		getContentPane().add(panelS, BorderLayout.SOUTH);
		
		JButton btnQuit = new JButton("Quit");
		panelS.add(btnQuit);
		
		panelE = new JPanel();
		getContentPane().add(panelE, BorderLayout.EAST);
		panelE.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelW = new JPanel();
		getContentPane().add(panelW, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Turn Count:   ");
		
		movesLabel = new JLabel(String.format("%d", moves));
		ms = new JLabel("Move Score"); 
		msLabel = new JLabel(String.format("%d", moveScore));
		panelW.setLayout(new GridLayout(0, 2, 0, 0));
		panelW.add(lblNewLabel);
		panelW.add(movesLabel);
		queueN = new JLabel("Queue");
		JLabel lblNewLabel_1 = new JLabel("Score");
		panelW.add(lblNewLabel_1);
		panelW.add(ms);
		panelW.add(msLabel);
		
		scoreLabel = new JLabel("0");
		panelW.add(scoreLabel);
		
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
	private void createQueueGui()
	//Creates the queue
	{
		
		panelE.setLayout(new GridLayout(5,1));
		
		queueT = new JLabel[5];
		int queueI[] = queue.viewQueue();
		for (int x = 0; x <= 4; x++){
			queueT[x] = new JLabel(String.format("      %d      ", queueI[x]));
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
					tiles[x][y].putClientProperty("row", x);
					tiles[x][y].putClientProperty("column", y);
					tiles[x][y].addActionListener(new SpaceListener());
					panelC.add(tiles[x][y]);
				}
				else {
					tiles[x][y] = new JButton(String.format(""));
					tiles[x][y].putClientProperty("row", x);
					tiles[x][y].putClientProperty("column", y);
					tiles[x][y].addActionListener(new SpaceListener());
					panelC.add(tiles[x][y]);
				}
			}
		}
	}
	private void updateQueue(int newQueue[])
	//Updates queue
	{
		for (int x = 0; x <= 4; x++){
			queueT[x].setText(String.format("%d", newQueue[x]));
		}
	}
	
	private void updateBoard(int newBoard[][])
	//Updates board
	{
		for (int x = 0; x <= 8; x++){
			for (int y = 0; y <= 8; y++){
				if (newBoard[x][y] != 11){
					tiles[x][y].setText(String.format("%d", newBoard[x][y]));
				}
				else {
					tiles[x][y].setText(String.format(""));
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
				movesLabel.setText(String.format("%d", moves));
				msLabel.setText(String.format("%d", moveScore));
				
			}
			
			updateBoard(gameBoard.viewBoard());
			
			testQueue = queue.viewQueue();
			updateQueue(testQueue);	
		}
	}
}
