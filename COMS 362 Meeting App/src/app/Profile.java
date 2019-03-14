package app;

public class Profile implements ProfileInterface
{
	String aboutMe = "none";
	int age = 0;
	String genderId = "none";
	String sexualPref = "none";
	String major = "none";
	String spiritAnimal = "none";
	String zodiac = "none";
	String[] options = { "aboutme", "age", "genderid", "sexualpref", "major", "spiritanimal", "zodiacsign", "done" };

	@Override
	public void createProfile()
	{
		InputReader inputReader = new InputReader();

		System.out.println("Time to create your profile!");
		System.out.println("What would you like to edit? To edit, type one of the following options: ");

		printOptions();
		System.out.println("the 'done' selection will finish profile creation.");
		editProfileHelper(inputReader.readInputString(), inputReader);
		System.out.println("Profile creation complete.");
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
				System.out.println("\nProfile created! \n Congratulations!");
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

	private void printOptions()
	{
		for (int i = 0; i < options.length; i++)
		{
			System.out.println(options[i]);
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
		String profileDetails = "About Me: " + getAboutMe() +
								"\nAge: " + getAge() +
								"\nGender Identity: " + getGenderId() +
								"\nSexual Preference: " + getSexualPref() +
								"\nMajor: " + getMajor() +
								"\nSpirit Animal: " + getSpiritAnimal() +
								"\nZodiac Sign: " + getZodiac();

		return profileDetails;
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
		zodiac = input;
	}

	@Override
	public String getZodiac()
	{
		return zodiac;
	}
}
