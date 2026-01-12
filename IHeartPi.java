/*Sudipti Dantuluri
 * 9.3.2021
 * IHeartPi.java
 * The program uses printf and assigned data types to print about pi*/
 
 public class IHeartPi
 {
	public static void main (String [] args)
	{
		IHeartPi hello = new IHeartPi();
		hello.PiMethod();
	}
	public void PiMethod()
	{
		int years = 4000;
		String pi = "mathematic";
		float first = 3.125f;
		float second = 3.16f;
		String shape1 = "polygon";
		String shape2 = "circle";
		int digit = 223;
		
	System.out.println("\n\n");
	
	
	System.out.printf("Pi has interested people around the world for over %d years. Many \n",years); 
	System.out.printf("%sians – from famous ones such as Fibonacci, Newton, Leibniz, and Gauss, \n", pi);
	System.out.printf("to lesser well-known %sal minds – have toiled over pi, calculated its digits, \n", pi);
	System.out.printf("and applied it in numerous areas of %ss.  Some spent the better parts of \n", pi);
	System.out.printf("their lives calculating just a few digits. Here is a sampling of the many milestones in \n");
	System.out.printf("the life of pi. \n");
	System.out.printf("Early decimal approximations for pi were obtained in a number of different \n");
	System.out.printf("ways.  For example, in ancient Babylon, rope stretchers marking the locations of \n");
	System.out.printf("buildings and boundaries estimated pi to be 25/8 = %1.3f.  The ancient Egyptians \n", first);
	System.out.printf("determined the ratio to be (16/9)^2 ≈ %1.2f. The earliest calculations of pi were \n", second);
	System.out.printf("largely based on measurement. \n");
	System.out.printf("Archimedes, a Greek %sian, was the first to use an algorithmic approach \n", pi);
	System.out.printf("to calculate pi.  He drew a %s inside a %s and drew a second %s \n", shape1,shape2,shape1);
	System.out.printf("outside of the %s. Then he continuously added more and more sides of both \n", shape2);
	System.out.printf("%ss, getting closer and closer to the shape of the %s.  Having reached 96- \n", shape1,shape2);
	System.out.printf("sided %ss, he proved that %d/71 < pi < 22/7.", shape1,digit);
	System.out.println("\n\n\n");
	
	}
}