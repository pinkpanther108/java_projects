/*Sudipti Dantuluri
 * 10.1.2021
 * PlayGame.java
 * The program uses scanner and Math.random() to finish playing the games*/
 
 import java.util.Scanner; //Import library
 import java.util.concurrent.ThreadLocalRandom;
 public class PlayGame
 {
  public static void main (String [] args)
  {
    PlayGame msp = new PlayGame();
    msp.runner();
  }
 
  int dice;
  int cards = 0;
  public PlayGame()
  {
  }
  public PlayGame(int num)
  {
    dice = num;
  }
  public PlayGame(boolean bool)
  {
    cards = 2; //black jack(2 cards)
  }
  public PlayGame(boolean bool, boolean pk)
  {
    cards = 5; //poker (5 cards)
  }
  
  
  public void runner()
  { 
    Scanner runner = new Scanner(System.in); //Opens the Scanner
    System.out.print("\n\n\n");
    System.out.print("Would you like to play Dice(1), Black Jack(2), or Poker(3)? ");
    int gameSelected = runner.nextInt();
    
    if (gameSelected==1)
    {
      System.out.print("How many dice? (max:6): ");
      int numberofDice = runner.nextInt();
      PlayGame pg2 = new PlayGame(numberofDice);
      pg2.diceGame();
    }
    else if (gameSelected==2)
    {
      PlayGame pg3 = new PlayGame(true);
      pg3.blackJack(); //what if pg3.poker?
    }
    else 
    {
      PlayGame pg4 = new PlayGame(true,true);
      pg4.poker();
    }
  }
  public void diceGame()
  { 
    for(int i=0; i<dice; i++)
    {
        System.out.printf("%d ", (int)(Math.random()*dice)+1);
    }
    System.out.printf("\n");
  }

  public void blackJack()
  { 
    int card = 0;
    int your_total = 0;
    int dealer_total = 0;

    System.out.printf("Here are your 2 cards: ");
    for(int i=0; i<cards; i++)
    {
      card = (int)(Math.random()*13)+1;
      your_total += card;
      if (card==1)
      {
        System.out.printf("A ");
      }
      else if (card==11)
      {
        System.out.printf("J ");
      }
      else if (card==12)
      {
        System.out.printf("Q ");
      }
      else if (card==13)
      {
        System.out.printf("K ");
      }
      else
      {
        System.out.printf("%d ", card);
      }
    }
    System.out.printf("\n");

    System.out.printf("Dealers: ");
    for(int i=0; i<cards; i++)
    {
      card = (int)(Math.random()*13)+1;
      dealer_total += card;
      if (card==1)
      {
        System.out.printf("A ");
      }
      else if (card==11)
      {
        System.out.printf("J ");
      }
      else if (card==12)
      {
        System.out.printf("Q ");
      }
      else if (card==13)
      {
        System.out.printf("K ");
      }
      else
      {
        System.out.printf("%d ", card);
      }
    }
    System.out.printf("\n");

    if (your_total > dealer_total)
    {
        System.out.printf("You win!\n");
    }
    else if (your_total < dealer_total)
    {
        System.out.printf("Dealer wins!\n");
    }
    else
    {
        System.out.printf("Standoff\n");
    }
  }

  public void poker()
  { 
    int card = 0;
    System.out.printf("Here are your 5 cards: ");
    for(int i=0; i<cards; i++)
    {
      card = (int)(Math.random()*13)+1;
      if (card==1)
      {
        System.out.printf("A ");
      }
      else if (card==11)
      {
        System.out.printf("J ");
      }
      else if (card==12)
      {
        System.out.printf("Q ");
      }
      else if (card==13)
      {
        System.out.printf("K ");
      }
      else
      {
        System.out.printf("%d ", card);
      }
    }
    System.out.printf("\n");
  }
}
