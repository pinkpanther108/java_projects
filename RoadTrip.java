/*Sudipti Dantuluri
 * 9.16.2021
 * RoadTrip.java
 * The program uses scanner*/
 
 import java.util.Scanner; //Import library
 
 public class RoadTrip
 {
	public static void main (String [] args)
	{
		RoadTrip msp = new RoadTrip();
		msp.types();
		
		
		//System.in is the keyboard
	}
	public void types()
	{
		Scanner types = new Scanner(System.in); //Opens the Scanner
		System.out.print("\n\n\n");
		
		System.out.print("How many people on the trip? ");
		int people_num = types.nextInt();
		System.out.print("How many miles on your trip? "); //Prompt user for next()
		double mileage = types.nextDouble();
		System.out.print("What is your mileage per gallon? ");
		double mileage_gallon = types.nextDouble();
		System.out.print("Price per gallon? ");
		double per_gallon = types.nextDouble();
		System.out.print("Snacks per passenger? "); //cost of snacks
		double snacks = types.nextDouble();
		System.out.print("Toll(s)? "); //cost
		double toll = types.nextDouble();
		System.out.print("Hotel(s)? "); //cost
		double hotel = types.nextDouble();
		System.out.print("Meals per person? "); //cost per
		double meal = types.nextDouble();
		System.out.print("Anything else? Yes(1) No(2)? ");
		int extra = types.nextInt();
		
	if (extra==1) 
	{
		System.out.print/*ln*/("\nWhat is the item? ");
		String item = types.next();
		System.out.print("How much? ");
		double price = types.nextDouble();	
	}	
	
	
		double calc_snacks = 0;
		int calc_people = 0;
		double snack_cost = 0;
		calc_snacks = snacks;
		calc_people = people_num;
		snack_cost = snacks*people_num;
		
		double calc_meals = 0;
		
		
		int calc_peoples = 0;
		calc_meals = meal;
		calc_peoples = people_num;
		double meal_cost;
		meal_cost = meal*people_num;
		
		//(miles/mileage) *price per gallon
		double calc_miles = mileage;
		double calc_mileage = mileage_gallon;
		double calc_priceg = per_gallon;
		double gas_cost;
		gas_cost = (calc_miles*calc_mileage)/calc_priceg;
		
		System.out.print("Here are your totals: ");
		System.out.printf("\n%-25s=%9d","Number of passenger(s)",people_num);
		System.out.printf("\n%-25s=%9.2f","Gas cost",gas_cost);
		System.out.printf("\n%-25s=%.4s%9.2f","Total snacks","$",snack_cost);
		System.out.printf("\n%-25s=%9.2f","Total for tolls",toll);
		System.out.printf("\n%-25s=%9.2f","Total for hotels",hotel);
		System.out.printf("\n%-25s=%9.2f","Total for meals",meal_cost);

		//25 spaces for gas cost = then 3 spaces between $ then (4) spaces betwen price and maybe 5 spaces
		
		System.out.print("\n\n\n");
	}
}
