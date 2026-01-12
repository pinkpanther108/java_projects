/*Sudipti Dantuluri
* 1.7.2022
* PlotWord.java
* The program plots the word on the coordinate grid with the given points.*/

import java.util.Scanner;
import java.util.Formatter;
public class PlotWord {
  Scanner sc = new Scanner(System.in);

  public static void main (String[]args) {
    PlotWord pw = new PlotWord();
    pw.pwMethod();
  }

  public void pwMethod() {
    System.out.println("\n\n\n");
     
    System.out.print("Please enter a coordinate: ");
    int coordinateX = sc.nextInt();
    int coordinateY = sc.nextInt();
    System.out.print("What word would you like to plot? ");
    String word = sc.next();

    //coordinateX += 19;
    coordinateY *= -1;
    coordinateY += 10;
    System.out.println("X:" + coordinateX);
    System.out.println("Y:" + coordinateY);
    String vbar = "|";
    for (int y = 0; y<= 20; y++) {
      if (y == coordinateY) {
        //System.out.println(String.format("%"+coordinateX+"s"," ") + word);
        if (coordinateX > 0) {
          System.out.print(String.format("%"+19+"s"," ") + vbar);
          System.out.println(String.format("%"+coordinateX+"s"," ") + word);
          //System.out.printf("%21s\n", vbar);
          //coordinateX -= 18;
          //System.out.println(String.format("%"+coordinateX+"s"," ") + word);
        } else if (coordinateX < 0) {
          System.out.println(String.format("%"+(19+coordinateX)+"s"," ") + word);
          //System.out.println(String.format("%"+(19-coordinateX-word.length())+"s"," ") + vbar);
        } else { // x-axis
      	  for (int x=0;x<=19+coordinateX;x++) {
      	    System.out.print("-");
      	  } 
          System.out.print(word);
      	  for (int x=0;x<=41-(19+coordinateX+(word.length()));x++) {
      	    System.out.print("-");
      	  } 
          System.out.println("");
          //System.out.println(String.format("%"+(19-coordinateX-word.length())+"s"," ") + vbar);
        }
      } else {
        if (y==10) {
      	  for (int x=0;x<=41;x++) {
      	    System.out.print("-");
      	  } 
      	  System.out.println("");
        } else System.out.printf("%20s\n", vbar);
      }
    }
  } // end of pwMethod()
} // end of PlotWord()
