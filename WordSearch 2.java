import java.util.Scanner;
public class WordSearch {

  public class Task {
    private int areacode = 0;
    Scanner sc;
    char [][] grid;

    public Task() {
      areacode = 0;
      sc = new Scanner(System.in);
      grid = new char[8][8];
    }
    public void getGrid() {
      for (int r=0; r<grid.length; r++) {
        for (int c=0; c<grid[r].length; c++) {
          grid[r][c] = (char)(Math.random()*25 + 'A');
        }
      }
    }
    public void printGrid() {
      for (int r=0; r<grid.length; r++) {
        for (int c=0; c<grid[r].length; c++) {
          System.out.printf("%c ", grid[r][c]);
        }
        System.out.println("");
      }
    }
    public boolean searchGrid(String str) {
      // forward search
      char[] s = str.toCharArray();
      boolean flag = false;
      for (int r=0; r<grid.length; r++) {
        for (int c=0; c<grid[r].length - s.length; c++) {
          boolean f = true;
          for (int i=0; i<s.length; i++) {
            if (grid[r][c+i] != s[i]) f = false;
          }
          if (f == true) flag = true;
        }
      }

      //search backwards
      if (flag == false) {
        //reverse the search string
        int sz = s.length;
        for (int i=0; i<sz/2; i++) {
          char t = s[i];
          s[i] = s[sz-1-i];
          s[sz-1-i] = t;
        }
        for (int r=0; r<grid.length; r++) {
          for (int c=0; c<grid[r].length - s.length; c++) {
            boolean f = true;
            for (int i=0; i<s.length; i++) {
              if (grid[r][c+i] != s[i]) f = false;
            }
            if (f == true) flag = true;
          }
        }
      }
      return flag;
    }

    public String getUserInput() {
      return sc.nextLine();
    }
  }

  public static void main(String[] args) {
    WordSearch a = new WordSearch();
    a.run();
  }

  public void run() {
    Task t = new Task();
    boolean flag = true;
    int score1 = 0;
    int score2 = 0;
    int player = 1 + (int)(Math.random()*2);
    do { 
      t.getGrid();
      t.printGrid();
      // choose a player
      System.out.printf("Player %d,\nPlease enter a word you found in the puzzle(at least 2 chars\n", player);
      String userInput = t.getUserInput();
      if (userInput.equals("Dunzo!") == true) {
        flag = false;
      } else {
        if (t.searchGrid(userInput)) {
          if (player == 1) score1 += userInput.length();
          if (player == 2) score2 += userInput.length();
        } else {
            System.out.printf("no match forgo %s points\n", userInput);
        }
        System.out.printf("Player 1 score = %d\n", score1);
        System.out.printf("Player 2 score = %d\n\n", score2);
        if (player == 1) {
          player = 2;
        } else {
          player = 1;
        }
      }
    } while(flag);
  }
}
