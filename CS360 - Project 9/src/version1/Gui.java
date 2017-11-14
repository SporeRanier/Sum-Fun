package version1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame
{
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 500;
	
	JButton spaces[][];
	JPanel board, queueG;
	JTextField queueT[];
	
	GameBoard gameBoard;
	Queue queue;
	int moves;
	int score;
	int testQueue[] = new int[5];
		
	public static void main(String[] args){
		new Gui();
	}
	
	public Gui()
	{
		gameBoard = GameBoard.getBoard();
		queue = Queue.getQueue();
		moves = 50;
		
		setTitle("Sum Fun");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createBoardGui();
		createQueueGui();
		
		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		add(queueG, BorderLayout.EAST);
		
		setVisible(true);
	}
	private void createQueueGui()
	{
		queueG = new JPanel();
		queueG.setLayout(new GridLayout(5,1));
		queueT = new JTextField[5];
		int queueI[] = queue.viewQueue();
		for (int x = 0; x <= 4; x++){
			queueT[x] = new JTextField(String.format("%d", queueI[x]));
			queueG.add(queueT[x]);
		}
		
	}
	private void createBoardGui()
	{
		board = new JPanel();
		board.setLayout(new GridLayout(9,9));
		board.setSize(500, 500);
		spaces = new JButton[9][9];
		
		int intBoard[][] = gameBoard.viewBoard();
		for (int x = 0; x <= 8; x++){
			for (int y = 0; y <= 8; y++){
				if (intBoard[x][y] != 11){
					spaces[x][y] = new JButton(String.format("%d", intBoard[x][y]));
					spaces[x][y].putClientProperty("row", x);
					spaces[x][y].putClientProperty("column", y);
					spaces[x][y].addActionListener(new SpaceListener());
					board.add(spaces[x][y]);
				}
				else {
					spaces[x][y] = new JButton(String.format(""));
					spaces[x][y].putClientProperty("row", x);
					spaces[x][y].putClientProperty("column", y);
					spaces[x][y].addActionListener(new SpaceListener());
					board.add(spaces[x][y]);
				}
			}
		}
	}
	
	private void updateQueue(int newQueue[])
	{
		for (int x = 0; x <= 4; x++){
			queueT[x].setText(String.format("%d", newQueue[x]));
		}
	}
	
	private void updateBoard(int newBoard[][])
	{
		for (int x = 0; x <= 8; x++){
			for (int y = 0; y <= 8; y++){
				if (newBoard[x][y] != 11){
					spaces[x][y].setText(String.format("%d", newBoard[x][y]));
				}
				else {
					spaces[x][y].setText(String.format(""));
				}
			}
		}
	}
	
	private class SpaceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Get the pressed button
			JButton pressed = (JButton) e.getSource();
			//change the text of the space with the top value from the queue
			(pressed).setText(String.format("%d", queue.viewTop()));
			int newScore;
			//send the new value to the GameBoard for processing, which returns a score			
			newScore = gameBoard.placeTile((int) pressed.getClientProperty("row"), (int) pressed.getClientProperty("column"), (int) queue.viewTop());
			if (newScore != 12)
			{
				score += newScore;
				queue.useQueue();
				moves --;
			}
			
			updateBoard(gameBoard.viewBoard());
			
			testQueue = queue.viewQueue();
			updateQueue(testQueue);	
		}
	}
}