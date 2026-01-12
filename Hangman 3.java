/*Sudipti Dantuluri
 * 2.1.2022
 * Hangman.java
 * The program lets the user add a word to the dictionary text and lets the user guess the word.*/
 
import java.util.Scanner; import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException; import java.io.PrintWriter; import java.io.FileWriter;
public class Hangman {
  String value = "";
  Scanner input = null;
  File inFile = new File("dictionary.txt");
  public static void main(String[] args) {
    Hangman h = new Hangman();
    h.hMethod();
  }
  public void hMethod() {
    System.out.print("\n\n\n");
    Scanner sc = new Scanner(System.in);
    System.out.print("Would you like to add to the dictionary, yes(1),no(2)? ");
    int yesOrNo = sc.nextInt();
    String word;
    if (yesOrNo==1) {
      System.out.print("What is your new word? ");
      word = sc.next();
      PrintWriter pw = null;
      try {
       pw = new PrintWriter( new FileWriter(inFile, true) );
      } catch (IOException e) {
       System.err.println("Cannot append to outputfile.");
       System.exit(1);
      }
      pw.println(word);
      pw.close();
      System.out.print("Your word has been added.");
    }
    System.out.print("\n\n");
    int countLine = 0;
    tryCatchIt();
    while(input.hasNext()) {
      countLine++;
      value = input.nextLine();
    }

    int tries = 5;
    String rando = "";
    int randoLine = (int)(Math.random()*countLine + 1);
    countLine = 0;
    tryCatchIt();
    while(input.hasNext()) {
     countLine++;
     if(countLine == randoLine) rando = input.nextLine();
     else value = input.nextLine();
    }
    String[] result = new String[rando.length()];
    for(int i =0; i<result.length; i++) {
      result[i] = "- ";
    } 
    System.out.print("Here is your random word:\n\n");
    for(int i =0; i<result.length; i++) System.out.print(result[i]);

    boolean flag = false;
    while(tries > 0) {
     flag = false;
     System.out.print("\n\nPlease guess a letter: ");
     String lett = sc.next();
     for (int i =0; i<result.length; i++) {
       if(lett.equals(rando.charAt(i)+"")) {
         result[i] = lett+ " ";
         flag = true;
         //System.out.printf("%s ", result[i]);
       }
     }
     System.out.println("");
     boolean all_matched = true;
     if(flag == true) {
       flag = false;
       for (int i =0; i<result.length; i++) {
         System.out.printf("%s ", result[i]);
         if(result[i].equals("- "))
           all_matched = false;
       }
       System.out.println("");
       System.out.printf("These are the letters you guessed so far: ");
       String s = "";
       for (int i=0; i<result.length; i++) {
         if (s.indexOf(result[i]) ==-1) {
           s += result[i];
         }
       }
       System.out.printf("%s\n", s);
       if (all_matched == true) {
          System.out.println("That is correct, you win!");
          tries=-1;
       }
     } else {
       tries--;
       System.out.printf("That is incorrect. You have %d guess(es) left.\n",tries);
     }
      if (tries == 0) System.out.println("This is oncorrect. Your are out of turns. You lose.");
    }
    System.out.printf(rando);
    System.out.print("\n\n\n\n");
  }

  public void tryCatchIt() {
    String inFileName = "dictionary.txt";
    value = "";
    input = null;
    try {
      input = new Scanner( inFile );
    } catch ( FileNotFoundException e ) {
       System.err.println("Cannot find " + inFileName + " file.");
       System.exit(1);
    }
  }
}
