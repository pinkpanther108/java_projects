/*Sudipti Dantuluri
 * 10.15.2021
 * YoMamma.java
 * The program uses scanner, field variables, and constructors to create a description for son and daughter*/
 
 import java.util.Scanner;
 public class YoMamma {
	public static void main(String [] args) {
		YoMamma ym = new YoMamma();
		ym.runner();
	}
	public YoMamma(){
	}
	Scanner types = new Scanner(System.in);
	
	public void runner() {
		Son son1 = new Son();
		System.out.println("\n\n\nPlease provide the following info about your son: ");
		System.out.println("Height(inches): ");
		son1.height = types.nextDouble();
		System.out.println("Weight(lbs): ");
		son1.weight = types.nextDouble();
		System.out.println("Age: ");
		son1.age = types.nextInt();
		System.out.println("School: ");
		son1.school = types.nextLine();
		System.out.println("Initials: ");
		son1.initials = types.next();
		types.nextLine();
		System.out.println("Food preference: ");
		//types.nextLine();
		son1.food_preference = types.nextLine();
	
		Daughter daughter1 = new Daughter();
		System.out.println("\n\n\nPlease provide the following info about your daughter: ");
		System.out.println("Height(inches): ");
		daughter1.height = types.nextDouble();
		System.out.println("Weight(lbs): ");
		daughter1.weight = types.nextDouble();
		System.out.println("Age: ");
		daughter1.age = types.nextInt();
		
		types.nextLine();
		System.out.println("School: ");
		daughter1.school = types.nextLine();
		System.out.println("Initials: ");
		daughter1.initials = types.next();
		System.out.println("Food preference: ");
		//types.nextLine();
		daughter1.food_preference = types.nextLine();
		
		printKids(son1, daughter1);
		
		
	}
	public void printKids(Son s2, Daughter d2) {
		System.out.printf("\nHe attends %s and eats %s. His height is %.2f inches. He weighs %.2f and is %d years old\n",s2.school,s2.food_preference,s2.height,s2.weight,s2.age);
		System.out.printf("\nShe attends %s and eats %s. Her height is %.2f inches. She weighs %.2f and is %d years old\n",d2.school,d2.food_preference,d2.height,d2.weight,d2.age);
	}
}

	class Son 
	{
		double height;
		double weight;
		int age;
		String school;
		String initials;
		String food_preference;
		
		
		public Son()
		{
			height = 0.0;
			weight = 0.0;
			age = 0;
			school = "";
			initials = "";
			food_preference = "";
		
	
		}
	}
	class Daughter
	{
		double height;
		double weight;
		int age;
		String school;
		String initials;
		String food_preference;
		public Daughter()
		{
			height = 0.0;
			weight = 0.0;
			age = 0;
			school = "";
			initials = "";
			food_preference = "";
		
		}
	}	

