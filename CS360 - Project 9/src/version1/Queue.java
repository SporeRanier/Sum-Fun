package version1;
import java.util.Random;

public class Queue {
	
	Random random = new Random();
	int queue[];
	//constructor for queue, with a length of 5 numbers randomly taken from 0 - 9
	public Queue()
	{
		queue = new int[5];
		for (int x = 0; x < queue.length; x++){
			queue[x] = random.nextInt(9);
		}
	}
	//returns a copy of the queue
	public int[] viewQueue()
	{
		int newQueue[] = new int[5];
		newQueue = queue.clone();
		return newQueue;
	}
	//removes the top value from the queue, replaces the value on the bottom, then returns the value of the old top of the queue
	public int useQueue()
	{	
		int top = queue[0];
		for (int x = 0; x < queue.length - 1; x++){
			queue[x] = queue[x+1];
		}
		queue[queue.length-1] = random.nextInt(10);
		return top;
	}
	//returns the first value in the queue.
	public int viewTop()
	{
		return queue[0];
	}
	

}
