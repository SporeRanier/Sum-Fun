package sprint;

import java.util.Observable;

/**
* This class acts as a clock, which is meant to be run in a parallel thread.
* The clock runs for the number of seconds input in the constructor.
* Is an observable class, so that when a second is used, the observer updates.
* @author  David Bell
* @version 1.0
* @since   2017-17-18 
*/
public class Clock extends Observable implements Runnable{

	private int seconds;

	//constructor for clock, using PARA int as seconds to count down
	public Clock(int inputSeconds){
    	seconds = inputSeconds;
	}
    
    /** Does the work of waiting 1 second and subtracting 1.
     *  The method then notifies its observers.
     */
    @Override
    public void run(){
    	//iterates through the input number of seconds
    	for (int x = seconds; x >= 0; x--){
    		try {
    			//wait one second
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			System.out.println("There is an InterruptedException"
                    + " in the class which runs the Clock");
                e.printStackTrace();
            }
            seconds = x;
            //notify observers
            setChanged();
            notifyObservers();
        }
    }
    
    /** Used by observers to obtain the remaining time.
     * @return int Returns the number of remaining seconds.
     */
    public int getSeconds(){
        return seconds;
    }
}
