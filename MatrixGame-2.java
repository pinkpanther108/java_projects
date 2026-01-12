import java.util.Scanner;
public class MatrixGame {

  public class Task {
    private int areacode = 0;
    Scanner sc;

    public Task() {
      areacode = 0;
      sc = new Scanner(System.in);
    }

    public int[][] getMatrix() {
      int num[][] = new int [7][7];
      for (int i=0;i<7;i++) { //row
        for (int j=0;j<7;j++) { //column
          num[i][j] = (int)(Math.random()*10);
        }
      }
      return num;
    }

    public void printMatrix(int[][] a) {
      System.out.println("  1 2 3 4 5 6 7");
      for (int i=0;i<7;i++) { //row
        System.out.printf("%d ", i+1);
        for (int j=0;j<7;j++) { //column
          System.out.printf("%d ", a[i][j]);
        }
        System.out.println("");
      }
    }
    public int choosePlayer() {
      return (int)(1 + Math.random()*2);
    }
  }

  public static void main(String[] args) {
    MatrixGame a = new MatrixGame();
    a.run();
  }

  public void run() {
    int[][] a;
    Task t = new Task();
    a = t.getMatrix();
    t.printMatrix(a);
    for (int i=0;i<9;i++) {
      //System.out.println(t.choosePlayer());
    }
  }
}
