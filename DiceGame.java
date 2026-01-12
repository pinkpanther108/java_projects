/*Sudipti Dantuluri
 * 10.5.2021
 * DiceGame.java
 * The program uses scanner and constructors to finish playing the game*/
 
 import java.util.Scanner; //Import library
 public class DiceGame
 {
	public static void main (String [] args)
	{
		DiceGame dg = new DiceGame();
		dg.runMethods();
	}
	 double cash;
	 int dice;
	 int sides;
	 Scanner runMethods = new Scanner(System.in);
	 public DiceGame()
	 {
		
	 }
	 public DiceGame(double cash2, int dice2, int sides2)
	 {
		 cash = cash2;
		 dice = dice2;
		 sides = sides2;
	 }
	public void runMethods()
	{
		System.out.print("\n\n\n");
		DiceGame dg2 = new DiceGame( askMoney(), askSides(), askDice() );
		dg2.runGame();
		
	}
	
	public double askMoney()
	{
		System.out.print("How much money would you like to start with? ");
		double startingMoney = runMethods.nextDouble();
		return startingMoney;
	}
	public int askSides()
	{
		System.out.print("How many sides on each die? ");
		int numSides = runMethods.nextInt();
		return numSides;
	}
	public int askDice()
	{
		System.out.print("How many dice would you like(1-4)? ");
		int numDice = runMethods.nextInt();
		return numDice;
	}
	
	public void runGame()
	{
		//dice2 = (Math.random()*(numSides-1)+1);
		String output = "";
		if (dice>=1) output+= dice1;
		if (dice>=2) output+="\t"+dice2;
		if (dice>=3) output+="\t"+dice3;
		if (dice>=4) output+="\t"+dice4;
		System.out.println("You rolled "+output);
		System.out.print("\n\n\n");
	}
	
	/*public int findMin(int x1, int x2, int x3, int x4)
	{
		
		if (dice==1)
		{
			//System.out.printf("You rolled %d",x1);
			return x1;
		}
		else if (dice==2)
		{
			//System.out.printf("You rolled %d %d",x1,x2);
			return Math.min(x1,x2);
		}
		else if (dice==3)
		{
			//System.out.printf("You rolled %d %d %d",x1,x2,x3);
			return Math.min(x1,Math.min(x2,x3));
		}
		else if (dice==4)
		{
			//System.out.printf("You rolled %d %d %d %d",x1,x2,x3,x4);
			return Math.min(Math.min(x1,x2),Math.min(x3,x4));
		}
		
		return 0;
	}
	*/
	
}