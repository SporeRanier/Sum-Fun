package sprint;
//GUI File, everything will be implemented in future
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;




public class P8NormalGameScreen extends JFrame implements Observer{
	private JButton[][] tiles;
	private JButton offButton;
	private JButton backGround1;
	private JButton backGround2;
	private JButton backGround3;
	private JButton quitButton;
	private JButton resetButton;
	private File music1;
	private File music2;
	private File music3;
	private File music4;
	private URI uri1;
	private URI uri2;
	private URI uri3;
	private URI uri4;
	private URL url1;
	private URL url2;
	private URL url3;
	private URL url4;
	private AudioClip sound1;
	private AudioClip sound2;
	private AudioClip sound3;
	private AudioClip sound4;
	private JLabel resetLabel;
	UntimedGame gameDriver;
	JPanel panelC;
	JPanel panelN;
	JPanel panelS;
	JPanel panelB;
	JPanel panelW;
	JLabel timeLabel;
	JLabel queueN;
	JLabel[] queueT;
	int moveScore;
	JLabel scoreLabel;
	JLabel movesLabel;
	JLabel msLabel;
	
	public P8NormalGameScreen() {
		setTitle("Sum Fun 0.97");
		moveScore = 0;
		gameDriver = UntimedGame.getUntimedGame();
		gameDriver.addObserver(this);
		tiles = new JButton[9][9];
		
		setSize(1024, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelC = new JPanel();
		panelC.setBackground(new Color(178, 34, 34));
		getContentPane().add(panelC, BorderLayout.CENTER);
		
		panelN = new JPanel();
		panelN.setBackground(Color.BLACK);
		getContentPane().add(panelN, BorderLayout.NORTH);
		panelN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		backGround1 = new JButton("Music 1");
		backGround1.setForeground(new Color(255, 255, 0));
		backGround1.setBackground(new Color(178, 34, 34));
		backGround1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		backGround1.setToolTipText("Starts playing song 1");
		panelN.add(backGround1);
		
		backGround2 = new JButton("Music 2");
		backGround2.setBackground(new Color(178, 34, 34));
		backGround2.setForeground(Color.YELLOW);
		backGround2.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		backGround2.setToolTipText("Starts playing song 2");
		panelN.add(backGround2);
		
		backGround3 = new JButton("Music 3");
		backGround3.setBackground(new Color(178, 34, 34));
		backGround3.setForeground(Color.YELLOW);
		backGround3.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		backGround3.setToolTipText("Starts playing song 2");
		panelN.add(backGround3);
		
		offButton = new JButton("Mute");
		offButton.setBackground(new Color(178, 34, 34));
		offButton.setForeground(Color.YELLOW);
		offButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panelN.add(offButton);
		backGround1.addActionListener(new ButtonListener());
		backGround2.addActionListener(new ButtonListener());
		backGround3.addActionListener(new ButtonListener());
		offButton.addActionListener(new ButtonListener());
		quitButton = new JButton("Quit");
		quitButton.setForeground(Color.YELLOW);
		quitButton.setBackground(new Color(178, 34, 34));
		quitButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		quitButton.addActionListener(new ButtonListener());
		panelN.add(quitButton);
		
		JLabel label = new JLabel("                                                                                                                                                                                        ");
		panelN.add(label);
		
		JLabel queueLabel = new JLabel("Queue");
		queueLabel.setForeground(Color.YELLOW);
		queueLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panelN.add(queueLabel);
		
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
		
		
		
		
		
		
		music1 = new File("katyusha.wav");
		music2 = new File("rasputin.wav");
		music3 = new File("sacred.wav");
		
		URI uri1 = music1.toURI();
		URI uri2 = music2.toURI();
		URI uri3 = music3.toURI();
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
		try {			
			url3 = uri3.toURL();
			sound3 = Applet.newAudioClip(url3);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void createQueueGui(){
		//Creates the queue and related GUI elements
		panelB.setLayout(null);
		GridBagLayout gridBag = new GridBagLayout();
		gridBag.columnWidths = new int[]{202, 0};
		gridBag.rowHeights = new int[] {202, 0, 180, 70, 202};
		gridBag.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBag.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panelB.setLayout(gridBag);
		
		JPanel panelE = new JPanel();
		panelE.setBounds(0, 0, 202, 137);
		panelE.setForeground(Color.YELLOW);
		panelE.setBackground(Color.BLACK);
		GridBagConstraints gridBagCon = new GridBagConstraints();
		gridBagCon.fill = GridBagConstraints.BOTH;
		gridBagCon.insets = new Insets(0, 0, 5, 0);
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 0;
		panelB.add(panelE, gridBagCon);
		panelE.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 494, 202, 54);
		GridBagConstraints gridBagCon2 = new GridBagConstraints();
		gridBagCon2.insets = new Insets(0, 0, 5, 0);
		gridBagCon2.fill = GridBagConstraints.BOTH;
		gridBagCon2.gridx = 0;
		gridBagCon2.gridy = 1;
		panelB.add(panel, gridBagCon2);
		
		resetButton = new JButton("Reset Queue!");
		panel.add(resetButton);
		resetButton.setForeground(Color.YELLOW);
		resetButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		resetButton.setBackground(new Color(178, 34, 34));
		resetButton.addActionListener(new ButtonListener());
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 137, 202, 137);
		panel2.setBackground(Color.BLACK);
		GridBagConstraints gridBagCon3 = new GridBagConstraints();
		gridBagCon3.fill = GridBagConstraints.BOTH;
		gridBagCon3.insets = new Insets(0, 0, 5, 0);
		gridBagCon3.gridx = 0;
		gridBagCon3.gridy = 2;
		panelB.add(panel2, gridBagCon3);
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
		
		JLabel scoreDesc = new JLabel("Score:");
		scoreDesc.setForeground(Color.YELLOW);
		scoreDesc.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panel2.add(scoreDesc);
		
		scoreLabel = new JLabel("0");
		scoreLabel.setForeground(Color.YELLOW);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panel2.add(scoreLabel);
		
		JLabel movesDesc = new JLabel("Move Score:");
		movesDesc.setForeground(Color.YELLOW);
		movesDesc.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		panel2.add(movesDesc);
		
		movesLabel = new JLabel("0");
		movesLabel.setForeground(Color.YELLOW);
		movesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movesLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		panel2.add(movesLabel);
		
		JLabel reset = new JLabel("Resets:");
		reset.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		reset.setForeground(Color.YELLOW);
		panel2.add(reset);
		
		resetLabel = new JLabel("1");
		resetLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		resetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resetLabel.setForeground(Color.YELLOW);
		panel2.add(resetLabel);
		
		JPanel lenin = new JPanel();
		lenin.setBounds(0, 274, 202, 202);
		lenin.setBackground(Color.BLACK);
		GridBagConstraints leninCon = new GridBagConstraints();
		leninCon.fill = GridBagConstraints.BOTH;
		leninCon.gridx = 0;
		leninCon.gridy = 4;
		panelB.add(lenin, leninCon);
		
		JLabel stalin = new JLabel("");
		stalin.setBackground(Color.BLACK);
		stalin.setIcon(new ImageIcon("nid8.gif"));
		lenin.add(stalin);
		
		queueT = new JLabel[5];
		int[] queueI = gameDriver.viewQueue();
		for (int x = 0; x <= 4; x++){
			queueT[x] = new JLabel(String.format("%d            ", queueI[x]));
			queueT[x].setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
			queueT[x].setForeground(Color.YELLOW);
			queueT[x].setHorizontalAlignment(SwingConstants.RIGHT);
			panelE.add(queueT[x]);
		}
		
	}
	private void createBoardGui() {
		//Creates the board
		panelC.setLayout(new GridLayout(9,9));
		panelC.setSize(500, 500);
		tiles = new JButton[9][9];
		
		int[][] intBoard = new int[9][9];
				
				intBoard = gameDriver.viewBoard();
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
				}else {
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
	private void updateQueue(int[] newQueue){
		//Updates queue
		for (int x = 0; x <= 4; x++){
			queueT[x].setText(String.format("%d            ", newQueue[x]));
		}
	}
	
	private void updateBoard(int[][] newBoard){
		//Updates board
		for (int x = 0; x <= 8; x++){
			for (int y = 0; y <= 8; y++){
				if (newBoard[x][y] != 11){
					tiles[x][y].setText(String.format("%d", newBoard[x][y]));
					tiles[x][y].setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
					tiles[x][y].setForeground(Color.YELLOW);
					tiles[x][y].setBackground(new Color(178, 34, 34));
				}else {
					tiles[x][y].setText(String.format(""));
					tiles[x][y].setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
					tiles[x][y].setForeground(Color.YELLOW);
					tiles[x][y].setBackground(new Color(178, 34, 34));
				}
			}
		}
	}
	// Operates Music
	private class ButtonListener implements ActionListener {

		
				public void actionPerformed(ActionEvent actionRca) {
					if(actionRca.getSource() == backGround1){
						sound2.stop();
						sound1.loop();
						sound3.stop();
					}
					if(actionRca.getSource() == backGround2){
						sound1.stop();
						sound2.loop();
						sound3.stop();
						
					}
					if(actionRca.getSource() == backGround3){
						sound1.stop();
						sound2.stop();
						sound3.loop();
						
					}
					if(actionRca.getSource() == offButton){
						sound1.stop();
						sound2.stop();
						sound3.stop();
					}
					if(actionRca.getSource() == quitButton){
						sound1.stop();
						sound2.stop();
						sound3.stop();
						try {
							GameOverScreen gameoverquit = new GameOverScreen();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setVisible(false);
						
					}else{
						
					}
					if(actionRca.getSource() == resetButton){
						gameDriver.refreshQueue();
						resetLabel.setText("0");
						
					}
					
				}
				
			}
	private class SpaceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Listener
			//Get the pressed button
			JButton pressed = (JButton) e.getSource();
			//change the text of the space with the top value from the queue
	
			//send the new value to the GameBoard for processing, which returns a score			
			moveScore = gameDriver.placeTile((int) pressed.getClientProperty("row"), (int) pressed.getClientProperty("column"));
			if(gameDriver.getMoves() == 0){
				try {
					GameOverScreen gameoverquit = new GameOverScreen();
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			else if((gameDriver.getBoardStatus() == 84)){
				try {
					GameOverScreen gameoverquit = new GameOverScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
			
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		if (gameDriver.getMoveScore() != -1){
			
			scoreLabel.setText(String.format("%d", gameDriver.getScore()));
			
			
			msLabel.setText(String.format("%d", gameDriver.getMoves()));
			movesLabel.setText(String.format("%d", gameDriver.getMoveScore()));
			
		}
		if(gameDriver.refreshLeft()){
			resetButton.setEnabled(true);
		}else{
			resetButton.setEnabled(false);
		}
		
		updateBoard(gameDriver.viewBoard());
		updateQueue(gameDriver.viewQueue());
	}
	
}
