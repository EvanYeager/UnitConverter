import java.util.Scanner;

public class Converter 
{
	final static int QUIT_OPTION = 5;
	
	public static void main(String[] args) 
	{
		int menuSelection = -1;
		double amount = 0.0f;
		while (menuSelection != QUIT_OPTION)
		{
			System.out.println("\n\nPlease select an option:\n" + 
								"1. Fahrenheit to Celsius\n" + 
								"2. Miles to Feet\n" + 
								"3. Cups to MiliLiters\n" +
								"4. KiloWatt hours to KiloJoules\n" + 
								"5. Quit");
			
			menuSelection = getMenuSelection();

			if (menuSelection == -1) // if input is invalid, loop through again
			{
				continue;
			}
			else if (menuSelection == QUIT_OPTION)
			{
				break;
			}
			
			// try to get amount user entered
			amount = getAmount();

			if (amount == -1)
			{
				continue; // i know degrees in fahrenheit can be negative, but i can't think of another way to signify invalid entry in the main method 
			}
			
			double newAmount = 0.0;
			String outString = "";
			switch (menuSelection)
			{
			case 1:
				newAmount = fToC(amount);
				outString = String.format("%f degrees fahrenheit is equivalent to %.5f degrees celsius.", amount, newAmount);
				break;
			case 2:
				newAmount = mToFt(amount);
				outString = String.format("%f miles is equivalent to %.2f feet.", amount, newAmount);
				break;
			case 3:
				newAmount = cToMl(amount);
				outString = String.format("%f cups is equivalent to %.2f mililiters.", amount, newAmount);
				break;
			case 4:
				newAmount = kwhToKj(amount);
				outString = String.format("%f kilowatt hours is equivalent to %.2f kilojoules.", amount, newAmount);
				break;
			default:
				System.out.println("Incorrect number entered. ");
				continue; // invalid entry, loop through again
			}
			
			System.out.println("\n" + outString);
		}
	}
	
	// gets menu selection from user via scanner. if the input cannot be parsed into an integer, a -1 is returned
	private static int getMenuSelection()
	{
		Scanner inputScanner = new Scanner(System.in);
		try
		{
			return inputScanner.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Did not correctly select an option. Try again. ");
			return -1;
		}
	}

	// gets amount from user via scanner. if the input cannot be parsed into a double, a -1 is returned
	private static double getAmount()
	{
		System.out.println("\nEnter the amount to convert:");
		try
		{
			return inputScanner.nextDouble();
		}
		catch(Exception e)
		{
			System.out.println("Did not correctly enter an amount. Try again. ");
			return -1;
		}
	}
	
	private static double fToC(double amount)
	{
		return (amount - 32) * (5.0 / 9.0);
	}
	
	private static double mToFt(double amount)
	{
		return amount * 5280;
	}
	
	private static double cToMl(double amount)
	{
		return amount * 250;
	}
	
	private static double kwhToKj(double amount)
	{
		return amount * 3600;
	}
	
}
