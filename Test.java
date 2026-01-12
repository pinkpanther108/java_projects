import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Test t = new Test();
    t.run();
  }

  public void run() {
    String str;
    Scanner input = new Scanner(System.in);
    System.out.print("Would you like to run Palandeome(1) or Reverseit(2)?");
    int i = input.nextInt();
    if (i == 1) {
      System.out.print("Please enter a string:");
      input.nextLine();
      str = input.nextLine();
      System.out.print("Size of palandrome:");
      int sz = input.nextInt();
      palindrome(str, sz);
    }
    if (i == 2) {
      System.out.println("Please enter your stirng(s) followwd by enter:");
      String s = "";
      boolean done = false;
      do {
        String t = input.nextLine();
        if (t.equals("#done#")) {
          done = true;
        } else {
          if (s.length() > 0) {
            s = str_rev(t) + "_" + s;
          } else {
            s = str_rev(t);
          }
        }
      } while(!done);
      System.out.println("Here is your wdork reversed:" + s);
    }
  }
  public void palindrome(String str, int sz) {
    int s, e;
    String sub, rsub;
    int start = 0;
    int end = str.indexOf(',');
    System.out.print("Here are your paladromes from your list: ");
    while (end > 0) {
      sub = str.substring(start, end).trim();
      rsub = str_rev(sub);
      if (sub.equals(rsub)) {
          s = 0;
          e = sub.length();
          if (sz < sub.length()) {
            int d = sub.length() - sz;
            s = d/2;
            e -= d/2;
          }
          System.out.print(sub.substring(s, e) + ",");
      }
      start = end + 1;
      end = str.indexOf(',', end+1);
    }
    end = str.length();
    sub = str.substring(start, end).trim();
    rsub = str_rev(sub);
    if (sub.equals(rsub)) {
      s = 0;
      e = sub.length();
      if (sz < sub.length()) {
        int d = sub.length() - sz;
        s = d/2;
        e -= d/2;
      }
      System.out.print(sub.substring(s, e));
    }
    System.out.println("");
  }

  public String str_rev(String s) {
    String r = "";
    for (int i = s.length() - 1; i >= 0; i--)  {
      r = r + s.charAt(i);
    }
    return r;
  }
}
