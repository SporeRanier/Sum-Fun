package version1;
import java.util.Observable;
//Author David Bell
//Creates and interacts with a queue of 5 numbers (0-9)
import java.util.Random;

public class Queue extends Observable
{
	
	private static Queue queueInstance = new Queue();
	
	Random random = new Random();
	int queue[];
	private boolean refreshLeft = true;
	//constructor for queue, with a length of 5 numbers randomly taken from 0 - 9
	private Queue()
	{
		generateQueue();
	}
	
	private void generateQueue()
	{
		queue = new int[5];
		for (int x = 0; x < queue.length; x++){
			queue[x] = random.nextInt(9);
		}
	}
	
	public static Queue getQueue()
	{
		return queueInstance;
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
		//save the top of the queue
		int top = queue[0];
		//move the queue up 1 space
		for (int x = 0; x < queue.length - 1; x++){
			queue[x] = queue[x+1];
		}
		//generate a new value at the bottom of the queue
		queue[queue.length-1] = random.nextInt(10);
		//notify observers
		setChanged();
		notifyObservers();
		return top;
	}
	//returns the first value in the queue.
	public int viewTop()
	{
		return queue[0];
	}
	
	public boolean refreshLeft()
	{
		return refreshLeft;
	}
	public boolean refreshQueue()
	{
		if (refreshLeft == true){
			generateQueue();
			refreshLeft = false;
			//notify observers
			setChanged();
			notifyObservers();
			return true;
		}
		return refreshLeft;
	}
	

}
