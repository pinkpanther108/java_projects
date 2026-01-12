/*Sudipti Dantuluri
9.15.2021
InputTypes.java
The program uses Scanner and input types to print a few sentences using the user's answers */

import java.util.Scanner; //Import library

public class InputTypes
{
	public static void main (String [] args)
	{
		InputTypes msp = new InputTypes();
		msp.types();
		//System.in is types
	}
	public void types()
	{
		Scanner types = new Scanner(System.in); //Opens the Scanner
		System.out.print("\n\n\n");
		System.out.print("When is your birthday? "); //Prompt user for next()
		String birthday = types.next(); //Read next__() input 

		System.out.print("What is your weight in pounds? ");
		double weight = types.nextDouble();
		double weight_kg = weight * 0.453592;

		System.out.print("What is your height in inches? ");
		double height = types.nextDouble();
        int feet = (int)(height/12.0);
        double inches = height - feet*12;

		types.nextLine();
		System.out.printf("What is your name? ");
		String name = types.nextLine();

		System.out.print("Where were you born? ");
		String city = types.nextLine();

		System.out.print("What college did you attend? ");
		String college = types.nextLine();

		System.out.print("What was your GPA in college? ");
		double gpa = types.nextDouble();

		types.nextLine();
		System.out.print("What is your favorite movie? ");
		String movie = types.nextLine();

        System.out.printf("Your name is %s and you were born in %s. You were born on %s, weigh %.1f Kgs, and %d’%.2f”. You attended %s with a %.2f GPA. Your favorite movie is %s.\n", name, city, birthday, weight_kg, feet, inches, college, gpa, movie);
	}
}
