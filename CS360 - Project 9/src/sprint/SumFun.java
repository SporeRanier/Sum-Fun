package sprint;


public class SumFun {

	public static void main(String[] args) {
		GameBoard board = GameBoard.getBoard();
		Queue queue = Queue.getQueue();
		
		int testQueue[] = queue.viewQueue();
		System.out.printf("Queue: %d %d %d %d %d \n", testQueue[0],testQueue[1],testQueue[2],testQueue[3],testQueue[4]);

		int testBoard[][] = board.viewBoard();
		System.out.printf("GameBoard\n");
		for (int y = 0; y < testBoard.length; y++)
		{
			for (int x = 0; x <= 8; x++)
			{
				System.out.printf(" %2d |", testBoard[x][y]);
			}
			System.out.printf("\n");
		}
		
		board.placeTile(8,8, queue.useQueue());
		
		testQueue = queue.viewQueue();
		System.out.printf("Queue: %d %d %d %d %d \n", testQueue[0],testQueue[1],testQueue[2],testQueue[3],testQueue[4]);

		testBoard = board.viewBoard();
		System.out.printf("GameBoard\n");
		for (int y = 0; y < testBoard.length; y++)
		{
			for (int x = 0; x <= 8; x++)
			{
				System.out.printf(" %2d |", testBoard[x][y]);
			}
			System.out.printf("\n");
		}
	}
}