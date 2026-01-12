/*Sudipti Dantuluri
 * 10.8.2021
 * Roulette.java
 * The program uses scanner and array to finish playing the game*/
 
 import java.util.Scanner; //Import library
 public class Roulette
 {
	public static void main (String [] args)
	{
		Roulette msp = new Roulette();
		msp.runMethod();
	}
		Scanner types = new Scanner(System.in); 
	public void runMethod()
	{
		System.out.print("\n\n\n");
		
		System.out.print("How much money would you like to bet? ");
		double amtMoney_bet = types.nextDouble();
		System.out.print("Would you like to pick a number(1), color(2), range(3)? ");
		int pick = types.nextInt();
	
		if (pick==1)
		{
			System.out.print("What number would you like to choose(00=-1)? ");
			int numberChosen = types.nextInt();
	
		}
		if (pick==2)
		{
			System.out.print("Would you like to pick red(1), black(2), or green(3)? ");
			int color = types.nextInt();
	
		
		
		}
		if (pick==3)
		{
			System.out.print("Would you like to pick[1-12](1),[13-24](2), or [25-36](3)? ");
			int num = types.nextInt();
	
		}
	
	
	}
	public int returnColor(int num) //returns the color of the number, returns 1 for red, 2 for black
	{
		int [] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		int [] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
		for(int i=0;i<18;i++)
		{
			if(red[i]==num) return 1;
			if(black[i]==num) return 2;
		}
		return 0; //this opens for green
		int P2 = (int)Math.random();
		
		System.out.printf("The ball landed on %d. You win $%f!",P2,amtMoney_bet);
		System.out.print("\n\n\n");
	}
}
		