/*
1) Create a 2D array (7x7)
2)Randomly generate a 7x7 grid of integers(0-9)
3) Randomly choose which player goes first
4) Player 1 score is sum of Top 3 rows
5) Player 2 score is sum of Top 3 columns
6)Game ends when user types 0 0 0 0
7) Each player gets a chance to switch two numbers
that are touching(horizontal or vertical)
8)3 lines above/below(only first and last turn)

ex1:
display matrix
Player 1(row), it's your turn:
Column first and then row: 5 4 5 5
Player 1 score = 106
Player 2 score = 119

ex2:
display matrix
Player 1(row), it's your turn:
Column first and then row: 8 1 9 2
That's not a legal move. Try again: 0 0 0 0
Player 2 wins!
Thanks for playing.

*/
import java.util.Scanner;
public class MatrixGame {

  public class Task {
    private int areacode = 0;
    Scanner sc;
    int num[][];
    int rtotal[];
    int ctotal[];
    int top3rows[];
    int top3cols[];

    public Task() {
      areacode = 0;
      sc = new Scanner(System.in);
      num = new int [7][7];
      rtotal = new int [7];
      ctotal = new int [7];
      top3rows = new int [3];
      top3cols = new int [3];

      for (int i=0;i<7;i++) {
        rtotal[i] = 0;
        ctotal[i] = 0;
      }
      for (int i=0;i<3;i++) {
        top3rows[i] = 0;
        top3cols[i] = 0;
      }
    }

    public void getMatrix() {
      int rowsum=0;
      int ct=0;
      for (int r=0;r<7;r++) { //row
        rowsum=0;
        for (int c=0;c<7;c++) { //column
          num[r][c] = (int)(Math.random()*10);
          rtotal[r] += num[r][c];
          ctotal[c] += num[r][c];
        }
      }
      //find top 3 rows
      int tr = 0;
      for (int i=0;i<7;i++) {
        int r=0;
        for (int j=0;j<7;j++) {
          if (rtotal[i] < rtotal[j]) {
            r = j;
	  }
        }
	top3rows[tr] = r;
      }
      //find top 3 cols
      int tc = 0;
      for (int i=0;i<7;i++) {
        int c=0;
        for (int j=0;j<7;j++) {
          if (rtotal[i] < rtotal[j]) {
            c = j;
	  }
        }
	top3rows[tc] = c;
      }

    }

    public void printMatrix() {
      boolean flag = false;

      System.out.println("  1 2 3 4 5 6 7");
      for (int r=0;r<7;r++) { //row
        System.out.printf("%d ", r+1);
        for (int c=0;c<7;c++) { //column
          System.out.printf("%d ", num[r][c]);
        }
	flag = false;
	for(int tr=0; tr<3; tr++) {
	  if (r == top3rows[tr]) {
	    flag = true;
	  }
	}
        if (flag) {
          System.out.println("*");
        } else {
            System.out.println("");
	}
      }
      // print cols
      for (int c=0;c<7;c++) { //column
	flag = false;
	for(int tc=0; tc<3; tc++) {
	  if (c == top3cols[tc]) {
	    flag = true;
	  }
	}
        if (flag) {
          System.out.print("* ");
        } else {
            System.out.println("  ");
	}
      }
    }
    public int choosePlayer() {
      return (int)(1 + Math.random()*2);
    }
    public void processInput() {
      System.out.print("Column first and then row:");
      System.out.print("Player 1 score ");
      System.out.print("Player 2 score ");
      int rc = sc.nextInt();
    }
  }

  public static void main(String[] args) {
    MatrixGame a = new MatrixGame();
    a.run();
  }

  public void run() {
    int[][] a;
    Task t = new Task();
    t.getMatrix();
    t.printMatrix();
    boolean flag = true;
    do {
      int p = t.choosePlayer();
      if (p == 1) {
        System.out.println("Player 1(row), it's your turn:");
      } else {
        System.out.println("Player 2(col), it's your turn:");
      }
      t.processInput();
    } while (flag);
  }
}
