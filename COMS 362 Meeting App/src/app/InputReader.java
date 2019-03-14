package app;

import java.util.Scanner;

public class InputReader 
{
	private Scanner scanner;

	public InputReader() 
	{
		scanner = new Scanner(System.in);
	}

	
	public boolean inputYesNoCheck(String input, String output)
	{
		if(input.equals("y"))
		{
			return true;
		}
		else if(input.equals("n"))
		{
			return false;
		}
		else
		{
			System.out.println("I'm sorry I didn't understand that.");
			System.out.println(output);
			inputYesNoCheck(this.readInputString(), output);
		}
		return false;
	}
	
	 public String readInputString()
	 {
		 return scanner.next();
	 }
	
	 public int readInputInt()
	 {
		 return scanner.nextInt();
	 }
	 
	 public void closeInputReader()
	 {
		 scanner.close();
	 }
	 
	 public void openInputReader()
	 {
		 scanner = new Scanner(System.in);
	 }
}
