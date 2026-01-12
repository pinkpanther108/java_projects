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
      int num[][] = new int [9][9];
      for (int i=0;i<9;i++) { //row
        for (int j=0;j<9;j++) { //column
          num[i][j] = (int)(Math.random()*10);
        }
      }
      return num;
    }

    public void printMatrix(int[][] a) {
      for (int i=0;i<9;i++) { //row
        for (int j=0;j<9;j++) { //column
          System.out.printf("%d ", a[i][j]);
        }
        System.out.println("");
      }
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
  }
}
