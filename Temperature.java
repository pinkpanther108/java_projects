/*Sudipti Dantuluri
 * 9.14.2021
 * MyName.java
 * The program uses scanner to print Celsius, Fahrenheit, and Kelvin temperatures of what the user inputs*/
 
 import java.util.Scanner; //Import library
 
 public class Temperature
 {
	public static void main (String [] args)
	{
		Temperature msp = new Temperature();
		msp.keyboard();
		
		
		//System.in is the keyboard
	}
	public void keyboard()
	{
		Scanner keyboard = new Scanner(System.in); //Opens the Scanner
		System.out.print("\n\n\n");
		/*System.out.print("Input an integer\t-> "); //Prompt user for int
		int input = keyboard.nextInt(); //Read integer input
		System.out.println("Your integer is " + input); //print out input
		//There is also: nextLong, nextFloat, nextDouble (See API's) */
		System.out.print("Would you like to enter Celsius(1), Fahrenheit(2), or Kelvin(3)? ");
		int input = keyboard.nextInt(); 
		System.out.print("Please enter the temperature (nearest 10th): ");
		double input2 = keyboard.nextDouble(); 
		
		double fa = 0;
		double cel = 0;
		double kel = 0;
		
		if (input==1)
		{	System.out.println("\nHere are the conversions: ");
		cel = input2;
		fa = (cel * 9/5)+32;
		kel = cel + 273.15;
		System.out.println("Celsius = "+cel);
		System.out.println("\nFahrenheit = "+fa);
		System.out.println("\nKelvin = "+kel);
		}
		if (input==2)
		{	System.out.println("\nHere are the conversions: ");
		fa = input2;
		cel = (fa-32)*5/9;
		kel = cel + 273.15;
		System.out.printf("Celsius = %.2f",cel);
		System.out.printf("\nFahrenheit = %.2f",fa);
		System.out.printf("\nKelvin = %.2f",kel);
		}
		if (input==3)
		{	System.out.println("\nHere are the conversions: ");
		kel = input2;
		cel = (fa-32)*5/9;
		fa = (cel*9/5)+32;
		System.out.printf("Celsius = %.2f",cel);
		System.out.printf("\nFahrenheit = %.2f",fa);
		System.out.printf("\nKelvin = %.2f",kel);
		}
		/*double power1 = Math.pow(input,3);
		System.out.println("\nInput number cubed = " +power1); */
		
		System.out.print("\n\n\n");

	
	}
}