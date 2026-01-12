import java.util.Scanner;
public class WordSearch {

  public class Task {
    private int areacode = 0;
    Scanner sc;
    char [][] grid;
    char [][] transposegrid;
    String userWords;

    public Task() {
      areacode = 0;
      sc = new Scanner(System.in);
      grid = new char[8][8];
      transposegrid = new char[8][8];
      userWords = "";
    }
    public void getGrid() {
      for (int r=0; r<grid.length; r++) {
        for (int c=0; c<grid[r].length; c++) {
          grid[r][c] = (char)(Math.random()*25 + 'A');
        }
      }
    }
    public void gettransposeGrid() {
      for (int r=0; r<grid.length; r++) {
        for (int c=0; c<grid[r].length; c++) {
          transposegrid[r][c] = grid[c][r];
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
    public boolean forwardSearch(String str) {
      char[] s = str.toUpperCase().toCharArray();
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
      return flag;
    }
    public boolean forwardSearchTranspose(String str) {
      char[] s = str.toUpperCase().toCharArray();
      boolean flag = false;
      for (int r=0; r<transposegrid.length; r++) {
        for (int c=0; c<transposegrid[r].length - s.length; c++) {
          boolean f = true;
          for (int i=0; i<s.length; i++) {
            if (transposegrid[r][c+i] != s[i]) f = false;
          }
          if (f == true) flag = true;
        }
      }
      return flag;
    }


    public boolean backwardSearch(String str) {
      //reverse the search string
      boolean flag = false;
      char[] s = str.toUpperCase().toCharArray();
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
       return flag;
    }
    public boolean backwardSearchTranspose(String str) {
      //reverse the search string
      boolean flag = false;
      char[] s = str.toUpperCase().toCharArray();
      int sz = s.length;
      for (int i=0; i<sz/2; i++) {
         char t = s[i];
         s[i] = s[sz-1-i];
         s[sz-1-i] = t;
      }
      for (int r=0; r<transposegrid.length; r++) {
        for (int c=0; c<transposegrid[r].length - s.length; c++) {
          boolean f = true;
          for (int i=0; i<s.length; i++) {
            if (transposegrid[r][c+i] != s[i]) f = false;
          }
          if (f == true) flag = true;
        }
      }
      return flag;
    }

    public boolean searchGrid(String str) {
      boolean flag = false;
      flag = forwardSearch(str);
      if (flag == false) {
        flag = backwardSearch(str);
      }
      if (flag == false) {
        gettransposeGrid();
        flag = forwardSearchTranspose(str);
      }
      if (flag == false) {
        gettransposeGrid();
        flag = backwardSearchTranspose(str);
      }
      return flag;
    }

    public String getUserInput() {
      String s = "";
      boolean flag = true;
      while(flag) {
        s = sc.nextLine();
        if (userWords.contains(s) == false) {
          userWords += s;
          flag = false;
        } else {
          System.out.println("That word has already been used. Please try again");
        }
      }
      return s;
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
    t.getGrid();
    do { 
      t.printGrid();
      // choose a player
      System.out.printf("Player %d,\nPlease enter a word you found in the puzzle(at least 2 chars\n", player);
      String userInput = t.getUserInput();
      if (userInput.equals("Dunzo!") == true) {
        flag = false;
        System.out.printf("Player %d wins!\n", (score1>score2) ? 1 : 2);
      } else {
        if (t.searchGrid(userInput)) {
          if (player == 1) score1 += userInput.length();
          if (player == 2) score2 += userInput.length();
        } else {
            System.out.printf("no match forgo %s points\n", userInput);
        }
        System.out.printf("Player 1 score = %d\n", score1);
        System.out.printf("Player 2 score = %d\n\n", score2);
        player = (player == 1) ? 2 : 1;
      }
    } while(flag);
  }
}
