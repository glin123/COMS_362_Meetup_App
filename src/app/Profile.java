package app;

import app.interfaces.ProfileInterface;

public class Profile implements ProfileInterface
{
	private String aboutMe;
	private int age = 0;
	private String genderId;
	private String sexualPref;
	private String major;
	private String spiritAnimal;
	private String zodiacSign;
	private final String[] options = {"aboutme", "age", "genderid", "sexualpref", "major", "spiritanimal", "zodiacsign", "done"};

	@Override
	public void createProfile()
	{

		System.out.println("Time to create your profile!");

		boolean editProf = true;
		while(editProf){
			editProfileFields();

			boolean confirm = InputReader.requestConfirmation(this);
			if(confirm){
				//TODO push changes to database
				System.out.println("Profile confirmed.");
				editProf = false;
			}
		}
		System.out.println("Profile creation complete.");
	}

	public static void main(String[] args){
		Profile p = new Profile();
		p.createProfile();
	}

	public void editProfileFields(){
		boolean edit = true;
		while(edit) {
			String option = InputReader.readFromOptions("Which field would you like to edit?", options);

			switch(option) {
				case "done":
					edit = false;
					break;
				case "aboutMe":
					editAboutMe();
					break;
				case "age":
					editAge();
					break;
				case "genderId":
					editGenderId();
					break;
				case "sexualPref":
					editSexPref();
					break;
				case "major":
					editMajor();
					break;
				case "spiritAnimal":
					editSpiritAnimal();
					break;
				case "zodiacSign":
					editZodiacSign();
					break;
			}
		}
	}
	private void editZodiacSign(){
		System.out.print("Your current zodiac sign is:\t");
		System.out.println(sexualPref);

		String input = (InputReader.collectInput("Please enter a new zodiac sign:"));

		boolean  confirm = InputReader.requestConfirmation(input);
		if(confirm){
			setZodiac(input);
		}else{
			boolean cancel = InputReader.requestCancel();
			if(cancel){
				return;
			}else{
				editZodiacSign();
			}
		}
	}

	private void editSpiritAnimal(){
		System.out.print("Your current spirit animal is:\t");
		System.out.println(sexualPref);

		String input = (InputReader.collectInput("Please enter a new spirit animal:"));

		boolean  confirm = InputReader.requestConfirmation(input);
		if(confirm){
			setSpiritAnimal(input);
		}else{
			boolean cancel = InputReader.requestCancel();
			if(cancel){
				return;
			}else{
				editSpiritAnimal();
			}
		}
	}

	private void editMajor(){
		System.out.print("Your current major is:\t");
		System.out.println(sexualPref);

		String input = (InputReader.collectInput("Please enter a new major:"));

		boolean  confirm = InputReader.requestConfirmation(input);
		if(confirm){
			setMajor(input);
		}else{
			boolean cancel = InputReader.requestCancel();
			if(cancel){
				return;
			}else{
				editMajor();
			}
		}
	}

	private void editSexPref(){
		System.out.print("Your current sexual preference is:\t");
		System.out.println(sexualPref);
		String input = (InputReader.collectInput("Please enter a new sexual preference:"));

		boolean  confirm = InputReader.requestConfirmation(input);
		if(confirm){
			setSexualPref(input);
		}else{
			boolean cancel = InputReader.requestCancel();
			if(cancel){
				return;
			}else{
				editSexPref();
			}
		}
	}

	private void editAboutMe() {
		System.out.println("Your current 'About Me' section is:");
		System.out.println(aboutMe);
		String input = (InputReader.collectInput("Please describe yourself."));

		boolean confirm = InputReader.requestConfirmation(input);
		if(confirm) {
			setAboutMe(input);
		}
		else {
			boolean cancel = InputReader.requestCancel();
			if(cancel) {
				return;
			}
			else {
				editAboutMe();
			}
		}
	}

	private void editGenderId() {
		System.out.print("Your current gender identity is:\t");
		System.out.println(genderId);
		String input = (InputReader.collectInput("Please enter a new gender identity:"));

		boolean confirm = InputReader.requestConfirmation(input);
		if(confirm) {
			setGenderId(input);
		}
		else {
			boolean cancel = InputReader.requestCancel();
			if(cancel) {
				return;
			}
			else {
				editGenderId();
			}
		}
	}

	private void editAge() {
		System.out.print("Your current age is:\t");
		System.out.println(genderId);
		int input = (InputReader.readInputInt("Please enter a age:"));

		boolean confirm = InputReader.requestConfirmation(input);
		if(confirm) {
			setAge(input);
		}
		else {
			boolean cancel = InputReader.requestCancel();
			if(cancel) {
				return;
			}
			else {
				editAge();
			}
		}
	}



	private void editProfileHelper(String option, InputReader inputReader)
	{
		switch (option)
		{
			case "aboutme":
				System.out.println("What would you like your 'About Me' to be? Currently it is: " + getAboutMe()
						+ "\n Type it below and hit enter when finished.");
				setAboutMe(inputReader.readInputString());
				System.out.println("You entered: " + getAboutMe() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getAboutMe() + "\n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "age":
				System.out.println("What would you like your 'Age' to be? Currently it is: " + getAge()
						+ "\n Type it below and hit enter when finished.");
				setAge(inputReader.readInputInt());
				System.out.println("You entered: " + getAge() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getAge() + " \n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "genderid":
				System.out.println("What would you like your 'Gender Identity' to be? Currently it is: " + getGenderId()
						+ "\n Type it below and hit enter when finished.");
				setGenderId(inputReader.readInputString());
				System.out.println("You entered: " + getGenderId() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getGenderId() + "\n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "sexualpref":
				System.out.println("What would you like your 'Sexual Preference' to be? Currently it is: "
						+ getSexualPref() + "\n Type it below and hit enter when finished.");
				setSexualPref(inputReader.readInputString());
				System.out.println("You entered: " + getSexualPref() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getSexualPref() + "\n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "major":
				System.out.println("What would you like your 'Major' to be? Currently it is: " + getMajor()
						+ "\n Type it below and hit enter when finished.");
				setMajor(inputReader.readInputString());
				System.out.println("You entered: " + getMajor() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getMajor() + "\n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "spiritanimal":
				System.out.println("What would you like your 'Spirit Animal' to be? Currently it is: "
						+ getSpiritAnimal() + "\n Type it below and hit enter when finished.");
				setSpiritAnimal(inputReader.readInputString());
				System.out.println("You entered: " + getSpiritAnimal() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getSpiritAnimal() + "\n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "zodiacsign":
				System.out.println("What would you like your 'Zodiac Sign' to be? Currently it is: " + getZodiac()
						+ "\n Type it below and hit enter when finished.");
				setZodiac(inputReader.readInputString());
				System.out.println("You entered: " + getZodiac() + "\n Is that okay? (y/n)");
				if (inputReader.inputYesNoCheck(inputReader.readInputString(),
						"You entered: " + getZodiac() + "\n Is that okay? (y/n)"))
				{
					System.out.println("Current profile: \n" + getProfileDetails() + "\n");
					System.out.println("What else would you like to change? ");
					printOptions();
					editProfileHelper(inputReader.readInputString(), inputReader);
				}
				else
				{
					editProfileHelper(option, inputReader);
				}
				break;
			case "done":
				System.out.println(getProfileDetails());
				System.out.println("\nProfile saved.\n");
				break;

			default:
				System.out.println("I'm sorry, that wasn't one of the options. Please try again.");
				System.out.println("What would you like to edit? To edit, type one of the following options: ");
				printOptions();
				System.out.println("the 'done' selection will finish profile creation.");
				editProfileHelper(inputReader.readInputString(), inputReader);
				break;
		}
	}

	private void printOptions() {
		for(String option : options) {
			System.out.println(option);
		}
	}

	@Override
	public void removeProfile(Account myAccount)
	{
		// myAccount.setProfile(null);
	}

	@Override
	public String getProfileDetails()
	{
		return "About Me: " + getAboutMe() +
				"\nAge: " + getAge() +
				"\nGender Identity: " + getGenderId() +
				"\nSexual Preference: " + getSexualPref() +
				"\nMajor: " + getMajor() +
				"\nSpirit Animal: " + getSpiritAnimal() +
				"\nZodiac Sign: " + getZodiac();
	}

	@Override
	public void setAboutMe(String input)
	{
		aboutMe = input;
	}

	@Override
	public String getAboutMe()
	{
		return aboutMe;
	}

	@Override
	public void setAge(int input)
	{
		age = input;
	}

	@Override
	public int getAge()
	{
		return age;
	}

	@Override
	public void setSexualPref(String input)
	{
		sexualPref = input;
	}

	@Override
	public String getSexualPref()
	{
		return sexualPref;
	}

	@Override
	public void setGenderId(String input)
	{
		genderId = input;
	}

	@Override
	public String getGenderId()
	{
		return genderId;
	}

	@Override
	public void setSpiritAnimal(String input)
	{
		spiritAnimal = input;
	}

	@Override
	public String getSpiritAnimal()
	{
		return spiritAnimal;
	}

	@Override
	public void setMajor(String input)
	{
		major = input;
	}

	@Override
	public String getMajor()
	{
		return major;
	}

	@Override
	public void setZodiac(String input)
	{
		zodiacSign = input;
	}

	@Override
	public String getZodiac()
	{
		return zodiacSign;
	}

	@Override
	public String toString(){
		String profileDetails = "About Me: " + getAboutMe() +
				"\nAge: " + getAge() +
				"\nGender Identity: " + getGenderId() +
				"\nSexual Preference: " + getSexualPref() +
				"\nMajor: " + getMajor() +
				"\nSpirit Animal: " + getSpiritAnimal() +
				"\nZodiac Sign: " + getZodiac();

		return profileDetails;
	}
}
