/*Sudipti Dantuluri
 * 9.25.2021
 * MetricSystem.java
 * The program uses scanner*/
 
 import java.util.Scanner; //Import library
 public class MetricSystem
 {
	public static void main (String [] args)
	{
		MetricSystem msp = new MetricSystem();
		msp.runner();
	}
	
	public void runner()
	{
		Scanner types = new Scanner(System.in); //Opens the Scanner
		System.out.print("\n\n\n");
		System.out.print("Would you like to convert weight(1), distance(2), temperature(3), speed(4)? ");
		int convert = types.nextInt();
		
		if (convert==1) //weight lbs to Kg
		{
		
			System.out.print("Enter your weight (in lbs): ");
			double weight = types.nextDouble();
			double output = lbsToKg(weight);
			System.out.printf("Your weight converted is %1.2f kilograms.\n",output);
		}
	
		if (convert==2)//distance miles to Km, feet to meters, inches to cm
		{
			System.out.print("Enter your distance in miles(1), feet(2), or inches(3): ");
			int distance_measurement = types.nextInt();
		
		if (distance_measurement==1) //miles to Km
			{
			System.out.print("Enter your distance: ");
			double miles = types.nextDouble();
			double output = milestoKm(miles);
			System.out.printf("Your distance converted (from miles) is %1.2f km. \n",output);
			}
		if (distance_measurement==2) //feet to meters
			{
				System.out.print("Enter your distance: ");
				double feet = types.nextDouble();
				double output = feetToMeters(feet);
				System.out.printf("Your distance converted (from feet) is %1.2f meters. \n",output);
			}
		if (distance_measurement==3) //inches to cm
			{
				System.out.print("Enter your distance: ");
				double inches = types.nextDouble();
				double output = inchesToCm(inches);
				System.out.printf("Your distance converted (from inches) is %1.2f centimeters. \n",output);
			}
		}
	
		if (convert==3)//temperature Fahrenheit to Celsius
		{
			System.out.print("Enter your temperature (in F): ");
			double temperature = types.nextDouble();
			double output = farToCelsius(temperature);
			System.out.printf("Your temperature converted is %1.2f Celsius. \n",output);

		}
	
		if (convert==4)//speed mi/h to km/h
		{
			System.out.print("Enter your speed (in mi/h): ");
			double speed = types.nextDouble();
			double output = SpeedmiTokm(speed);
			System.out.printf("Your speed converted is %1.2f km/h. \n",output);
		}
		
	}

	public double lbsToKg (double num1)
	{
		double newNum = num1*0.45359237;
		return newNum;
	}
	
	
	
	public double milestoKm (double num2_0)
	{
		double newNum = num2_0*1.609344;
		return newNum;
	} 
	public double feetToMeters (double num2_1)
	{
		double newNum = num2_1*0.3048;
		return newNum;
	}
	public double inchesToCm (double num2_2)
	{
		double newNum = num2_2*2.54;
		return newNum;
	} 
	
	
	public double farToCelsius (double num3)
	{
		double newNum = (num3-32)*5.0/9.0;
		return newNum;
	}
	
	public double SpeedmiTokm (double num4)
	{
		double newNum = num4*1.6093427125258;
		return newNum;
	}
	
}