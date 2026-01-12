import java.util.Scanner;
public class PhoneBook {

  public class Pbook {
    private String name, city, phone;
    private int areacode = 0;
    Scanner sc;

    public Pbook() {
      name = new String("Thomas Jefferson");
      city = new String("New York");
      phone = new String("123-4567");
      areacode = 0;
      sc = new Scanner(System.in);
    }
    public void getInput() {
      System.out.print("\n\n\nEnter name as first last: ");
      name = sc.nextLine(); 
      System.out.print("\nEnter city of residence: ");
      city = sc.nextLine();
      if (city.equals("Mountain View") || city.equals("Palo Alto") ) {
        areacode = 650;
      } else if (city.equals("Cupertino") || city.equals("San Jose") ) {
        areacode = 408;
      }
      System.out.print("\nEnter phone number (without area code): ");
      phone = sc.nextLine();
    }
    public void processInputAndPrint() {
      int lastname_pos = name.indexOf(" ");
      String first = name.substring(0, lastname_pos).trim();
      String last = name.substring(lastname_pos, name.length()).trim();
      System.out.printf("This phone number will be alphabetized under %s, under %s %s at (%d) %s", last.substring(0, 1), last, first, areacode, phone);
    }
  }

  public static void main(String[] args) {
    PhoneBook book = new PhoneBook();
    book.run();
  }

  public void run() {
    Pbook book = new Pbook();
    book.getInput();
    book.processInputAndPrint();
  }
}

