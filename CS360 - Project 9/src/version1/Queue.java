package version1;
//Author David Bell
//Class representing a queue of 5 integers (0-9)
//Also includes logic for a single refresh of the queue
import java.util.Observable;
import java.util.Random;

public class Queue extends Observable
{
	private static Queue queueInstance = new Queue();
	
	private Random random = new Random();
	private int queue[];

	private boolean refreshLeft = true;
	//constructor for queue, with a length of 5 numbers randomly taken from 0 - 9
	private Queue()
	{
		generateQueue();
	}

	//as Queue is a singleton (I hope anyway), this method is the manner in which it is accessed
	public static Queue getQueue()
	{
		return queueInstance;
	}
	//method which generates a queue of 5 random integers(0-9)
	private void generateQueue()
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
	//returns if there is a refresh left (true), or if it has already been used (false)
	public boolean refreshLeft()
	{
		return refreshLeft;
	}
	//if a refresh is remaining, the queue is newly generated, and true is returned. Otherwise, false is returned
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
