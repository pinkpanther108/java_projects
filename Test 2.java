import java.util.Scanner;
public class Test {

  public class Task {
    private int areacode = 0;
    Scanner sc;

    public Task() {
      areacode = 0;
      sc = new Scanner(System.in);
    }

    public void method1() {
      int i = 10;
      System.out.printf("This is method1 i: %d value\n", i);
      String[] cars = {"mazda", "tesls"};
      for (i=0; i< cars.length; i++) {
	      System.out.println( cars[i] );
      }
    }
    public void method2() {
      int i = 11;
      System.out.printf("This is method2 i: %d value\n", i);
    }
  }

  public static void main(String[] args) {
    Test a = new Test();
    a.run();
  }

  public void run() {
    Task t = new Task();
    t.method1();
    t.method2();
  }
}
