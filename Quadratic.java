/*Sudipti Dantuluri
 * 9.28.2021
 * Quadratic.java (Part 1&2)
 * The program uses scanner and Math.random() to compute the quadratic formula*/
 
 import java.util.Scanner; //Import library
 public class Quadratic
 {
	public static void main (String [] args)
	{
		Quadratic msp = new Quadratic();
		msp.lool();
	}
	
	public void lool()
	{
		Scanner lool = new Scanner(System.in); //Opens the Scanner
		System.out.print("\n\n\n");
		System.out.print("Would you like random numbers(1) or self entered(2)? ");
		int randomOrSelfentered = lool.nextInt();
		
		if (randomOrSelfentered==1)
		{
			double A = Math.random()*30-15;
			System.out.printf("A = %.2f \n",A);
			double B = Math.random()*30-15;
			System.out.printf("B = %.2f \n",B);
			double C = Math.random()*30-15;
			System.out.printf("C = %.2f \n",C);
			double X1 = -1*B+Math.sqrt(B*B-4*A*C)/(2*A);
			/*System.out.println("\n");
			System.out.println(B*B-4*A*C);
			System.out.println(2*A);
			System.out.println("\n"); */
			double X2 = -1*B-Math.sqrt(B*B-4*A*C)/(2*A);
			System.out.printf("x = %.2f \n",X1);
			System.out.printf("x = %.2f",X2);
			System.out.print("\n\n");
		}
		if (randomOrSelfentered==2)
		{
			System.out.print("A = ");
			double SelfenteredA = lool.nextDouble();	
			System.out.print("B = ");
			double SelfenteredB = lool.nextDouble();
			System.out.print("C = ");
			double SelfenteredC = lool.nextDouble();
			
			double SelfenteredX1 = -1*SelfenteredB+Math.sqrt(SelfenteredB*SelfenteredB-4*SelfenteredA*SelfenteredC)/(2*SelfenteredA);
			double SelfenteredX2 = -1*SelfenteredB-Math.sqrt(SelfenteredB*SelfenteredB-4*SelfenteredA*SelfenteredC)/(2*SelfenteredA);
			System.out.printf("x = %.2f \n",SelfenteredX1);
			System.out.printf("x = %.2f",SelfenteredX2);
			
		if (SelfenteredX1<0)
		{
			
			
			System.out.print("\n\n");
		}
		
		
	}
}