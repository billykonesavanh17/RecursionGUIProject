package ctec.view;

import ctec.controller.RecursionController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecursionPanel extends JPanel
{
	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea resultsArea;
	private SpringLayout baseLayout;
	private JLabel timingLabel;
	
	public RecursionPanel(RecursionController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		fibonacciButton= new JButton("Get the Fibonacci sequence for this number");
		factorialButton = new JButton("Get n!");
		inputField = new JTextField(20);
		resultsArea = new JTextArea(10, 20);
		timingLabel = new JLabel("Time executed");
		baseLayout.putConstraint(SpringLayout.NORTH, timingLabel, 5, SpringLayout.NORTH, factorialButton);
		baseLayout.putConstraint(SpringLayout.EAST, timingLabel, 0, SpringLayout.EAST, fibonacciButton);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(fibonacciButton);
		this.add(factorialButton);
		this.add(inputField);
		this.add(resultsArea);
		this.add(timingLabel);
		this.setBackground(Color.CYAN);
		resultsArea.setWrapStyleWord(true);
		resultsArea.setLineWrap(true);
		resultsArea.setText(baseController.getCalculatedValue());
		
	}
	
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, fibonacciButton, 54, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, factorialButton, 173, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -6, SpringLayout.NORTH, fibonacciButton);baseLayout.putConstraint(SpringLayout.SOUTH, fibonacciButton, -8, SpringLayout.NORTH, resultsArea);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -11, SpringLayout.NORTH, fibonacciButton);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, fibonacciButton, -8, SpringLayout.NORTH, resultsArea);
		baseLayout.putConstraint(SpringLayout.NORTH, factorialButton, 6, SpringLayout.SOUTH, resultsArea);
		baseLayout.putConstraint(SpringLayout.WEST, resultsArea, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, resultsArea, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsArea, 100, SpringLayout.NORTH, this);
	}
	
	private void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					resultsArea.setText(baseController.doFibonacci(userInput));
				}
			}
		});
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					resultsArea.append(baseController.doFactorial(userInput));
				}
			}

		});
	}

	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Integer.parseInt(input);
			isNumber = true;
		}
		catch(Exception numberException)
		{
			resultsArea.setText("type in a number");
		}
		return isNumber;
	}
}
