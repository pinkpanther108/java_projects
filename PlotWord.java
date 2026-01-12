/*Sudipti Dantuluri
* 1.7.2022
* PlotWord.java
* The program plots the word on the coordinate grid with the given points.*/

import java.util.Scanner;
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

    for (int i = 0; i<= 40; i++) {
      /* if (i==10) {
        for(int j = 0;  j<32; j++) {
          if(j == coordinateX && coordinateY == 0) {
          System.out.print(word);
          j+=word.length();
            } else System.out.print("-");
          }
          System.out.print("\n");
      } else System.out.printf("%21s\n", "|" ); */
      System.out.printf("i:%20d\n", i);
    }
  } // end of pwMethod()
} // end of PlotWord()
