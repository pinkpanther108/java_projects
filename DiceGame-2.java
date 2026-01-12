/*Sudipti Dantuluri
 * 10.5.2021
 * DiceGame.java
 * The program uses scanner and constructors to finish playing the game*/
 
 import java.util.Scanner; //Import library
 public class DiceGame
 {
   double cash;
   int dice;
   int sides;
   Scanner inputdata;

   public DiceGame()
   {
     cash = 0;
     dice = 0;
     sides = 0;
   }
   public DiceGame(double cash2, int sides2, int dice2)
   {
     cash = cash2;
     dice = dice2;
     sides = sides2;
   }

   public static void main (String [] args)
   {
     DiceGame dg = new DiceGame();
     dg.runMethods();
   }

  public void runMethods()
  {
    inputdata = new Scanner(System.in);
    System.out.print("\n\n\n");
    DiceGame dg2 = new DiceGame( askMoney(), askSides(), askDice() );
    dg2.runGame();
  }
  
  public double askMoney()
  {
    System.out.print("How much money would you like to start with? ");
    cash = inputdata.nextDouble();
    return cash;
  }
  public int askDice()
  {
    System.out.print("How many dice would you like(1-4)? ");
    dice = inputdata.nextInt();
    return dice;
  }
  public int askSides()
  {
    System.out.print("How many sides on each die? ");
    sides = inputdata.nextInt();
    return sides;
  }
  
  public void runGame()
  {
    Scanner inputdata = new Scanner(System.in);
    //System.out.println("cash " + cash + " sides " + sides + " dice " + dice );
    rolled("You");
    System.out.println("");
    System.out.printf("Would you like to re-roll your lowest for $1 yes(1), no(2)");
    int choice = inputdata.nextInt();
    if (choice == 1 || choice == 2)
    {
      int your_total = rolled("You");
      int you_win = 10;
      System.out.println(" = " + your_total);
      int dealer_total = rolled("Dealer");
      System.out.println(" = " + dealer_total);
      if (choice == 1)
      {
        you_win = 9;
      }
      if (your_total >= dealer_total)
      {
        System.out.printf("You win $%d!\n", you_win);
        cash += you_win;
      }
      else
      {
        System.out.println("Dealder win!");
        cash -= 10;
      }
      System.out.printf("Your have a total of %.2f\n", cash);
    }
    else
    {
      System.out.printf("wrong choice\n");
    }
  }
  public int rolled(String s)
  {
    int total = 0;
    System.out.printf(s + " rolled ");
    for (int i=0; i<dice; i++)
    {
      int t = 1 + (int)(Math.random()*sides);
      System.out.printf(" %d", t);
      total += t;
    }
    return total;
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
