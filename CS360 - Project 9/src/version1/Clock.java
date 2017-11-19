package version1;
//Author David Bell
/* A method which acts as a clock 
 Is meant to be run in a separate, parallel thread
 */
import java.util.*;

public class Clock extends Observable implements Runnable
{
	int seconds;
	//constructor, that uses the integer given as the number of seconds
	public Clock(int inputSeconds)
	{
		seconds = inputSeconds;
	}
	@Override
	public void run() 
	{
		//iterates through the input number of seconds
		for (int x = seconds; x >= 0; x--)
		{
			try {
				//wait one second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("There is an InterruptedException in the class which runs the Clock");
				e.printStackTrace();
			}
			seconds = x;
			//notify observers
			setChanged();
			notifyObservers();
		}
		
		
	}
	//Returns the number of seconds remaining
	public int getSeconds()
	{
		return seconds;
	}
	
	
}
