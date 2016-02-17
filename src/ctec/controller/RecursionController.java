package ctec.controller;

import ctec.model.RecursionTool;
import ctec.model.CodeTimer;
import ctec.view.RecursionFrame;

public class RecursionController
{
	private RecursionFrame baseFrame;
	private RecursionTool mathTool;
	private String calculatedValue;
	private String timeValue;
	private CodeTimer timeTool;
	private long executionTime;
	
	public  RecursionController()
	{
		baseFrame = new RecursionFrame(this);
		mathTool = new RecursionTool();
		timeTool = new CodeTimer();
	}
	
	public void start()
	{
		calculatedValue = Integer.toString(mathTool.getFibNumber(0));
	}
	
	public String getCalculatedValue()
	{
		return calculatedValue;
	}
	
	public String doFibonacci(String inputValue)
	{
		calculatedValue = "The Fibonacci sequence number of " + inputValue + " is " + Integer.toString(mathTool.getFibNumber(Integer.parseInt(inputValue)));
		timeValue = timeTool.toString();
		return calculatedValue;
	}
	
	public String doFactorial(String inputValue)
	{
		calculatedValue = "The Factorial sequence number of " + inputValue + " is " + Integer.toString(mathTool.getFactorialNumber(Integer.parseInt(inputValue)));
		timeValue = timeTool.toString();
		return calculatedValue;
	}
	
	public String doTime(String executionTime )
	{
		String timerDescription = "Current execution time is: " + this.executionTime + " in nanoseconds.";
		return timerDescription;
	}
}
