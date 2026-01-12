/*Sudipti Dantuluri
 * 8.27.21
 * TwoPrintMethods.java
 * The program calls classes and creates objects and prints supplies needed*/
 
public class TwoPrintMethods
{
	public static void main (String [] args)
	{
		TwoPrintMethods msp = new TwoPrintMethods();
		msp.printSchoolSupplies();
		msp.printMyClasses();
		
	}
	
	public void printSchoolSupplies()
	{
		System.out.println("\n\n\nI need the following school supplies:");
		System.out.println("  \t-Backpack, notebooks, pencils, pencil pouch, pens, and erasers.");
		System.out.println("  \t-Scientific calculator, extra led, highlighters.");
		System.out.println("  \t-Water bottle, laptop, sunscreen, and a binder");
	}
	
	public void printMyClasses()
	{
		System.out.println("These are my classes:");
		System.out.println("  \t-Biology, Literature, Orchestra, Java, P.E., Japanese 2, and Math");
		System.out.println("\n\n\n");
	}
}
 