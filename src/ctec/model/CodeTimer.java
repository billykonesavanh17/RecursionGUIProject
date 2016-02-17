package ctec.model;

/**
 * 
 * @author Billy Konesavanh
 * @version 0.1 Feb 17, 2016 Added basic methods and constructor.
 */
public class CodeTimer
{
	private long executionTime;
	
	public CodeTimer()
	{
		this.executionTime = 0;
	}
	
	public void startTimer()
	{
		this.executionTime = System.nanoTime();
	}
	
	public void stopTimer()
	{
		this.executionTime = System.nanoTime() - executionTime;
	}
	
	public void resetTimer()
	{
		this.executionTime = 0;
	}

	/**
	 * @return The executionTime value for the CodeTimer object
	 */
	public long getExecutionTime()
	{
		return executionTime;
	}
	
	public String toString()
	{
		String timerDescription = "Current execution time is: " + this.executionTime + " in nanoseconds.";
		return timerDescription;
	}
}
