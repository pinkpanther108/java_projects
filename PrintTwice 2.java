import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class PrintTwice {

  public class Task {
    private int areacode = 0;
    Scanner input;
    String value = "";
    String [] fileData;

    public Task() {
      areacode = 0;
      input = new Scanner(System.in);
      fileData = new String[10];
    }

    public void runIt() {
      tryCatchIt();
      int i = 0;
      while (input.hasNext () ) {
        //use an array of String
        value = input. nextLine () ;
        System.out.println(value) ;
        fileData[i++] = value;
      }
      input.close () ;
      //print out array using a loop
      System.out.println("== print file data in reverse order ====");
      for (int j=i-1;j>=0; j--) {
        String[] splited = fileData[j].split(" ");
        for (int k=splited.length-1; k>=0 ; k--) {
          System.out.printf("%s ", splited[k]);
        }
        System.out.println("");
      }
    }

    public void tryCatchIt() {
      File inFile = new File("input.txt");
      String inFileName = "input.txt";
      value = ""; //field variable
      input = null; //field variable
      try {
        input = new Scanner(inFile);
      }
      catch (FileNotFoundException e) {
        System.err.println ("Cannot find " + inFileName + " file.");
        System.exit(1); 
      }
    }
    public void method2() {
      int i = 11;
      System.out.printf("This is method2 i: %d value\n", i);
    }
  }

  public static void main(String[] args) {
    PrintTwice a = new PrintTwice();
    a.run();
  }

  public void run() {
    Task t = new Task();
    t.runIt();
  }
}
