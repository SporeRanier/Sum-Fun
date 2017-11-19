package version1;

import java.util.*;

public class Clock extends Observable implements Runnable
{
	Timer timer;
	int seconds;
	int minutesDis;
	int secondsDis;
	
	public Clock(int inpSeconds)
	{
		
		seconds = inpSeconds;
		minutesDis = seconds % 60;
		secondsDis = seconds & 60;
		
	}
	public void start()
	{
		
	}
	@Override
	public void run() 
	{
		for (int x = 180; x >= 0; x--)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seconds = x;
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
