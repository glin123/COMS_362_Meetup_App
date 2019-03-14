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
		if(input.equals("y")) {
			return true;
		}
		if(input.equals("n")) {
			return false;
		}

		System.out.println("I'm sorry I didn't understand that.");
		System.out.println(output);

		return inputYesNoCheck(this.readInputString(), output);
	}
	
	 public String readInputString()
	 {
		 return scanner.nextLine();
	 }

	 public int readInputInt()
	 {
		 try {
			 return Integer.valueOf(scanner.nextLine());
		 }
		 catch(NumberFormatException e) {
			 System.out.println("You did not enter a number. Try again.");
			 return readInputInt();
		 }
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
