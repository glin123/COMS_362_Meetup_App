package app;

public class App 
{
	//TODO create account here or in Account.java

	public static void main(String[] args) 
	{
		InputReader inputReader = new InputReader();
		
		System.out.println("Welcome! Would you like to create an account? (y/n)");
		
		if(inputReader.inputYesNoCheck(inputReader.readInputString(), "Would you like to create an account? (y/n)"))
		{
			//createAccout();
		}
		else
		{
			System.out.println("No? Okay then. Have a good day!");
			System.exit(0);
		}
		
		System.out.println("Would you like to create your profile? (y/n)");
		
		if(inputReader.inputYesNoCheck(inputReader.readInputString(), "Would you like to create your profile? (y/n)"))
		{
			Profile myProfile = new Profile();
			myProfile.createProfile();
		}
		else
		{
			System.out.println("No? That's okay! You can always create it later.");
		}
		inputReader.closeInputReader();
	}

}
