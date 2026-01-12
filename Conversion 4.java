/*Sudipti Dantuluri
  * 3.1.2022
  * Conversion.java
  * The program uses the user's input to output pictures of basketball players to form the number conversion between decimal or binary.*/
  
import java.awt.*;   // for classes Graphics, Color, Font, Image
import java.awt.event.* ; // for classes KeyListener, MouseListener
import javax.swing.* ; // for classes JFrame, JPanel, JLabel
import java.io.*  ; // for classes File, IOException, ImageIO
import java.util.Scanner; 

public class Conversion extends JFrame {
Scanner sc = new Scanner(System.in);
int num; int decimal = 0; int binary = 0;
//String 
  public Conversion () {
    super ("Conversion.java");
    setSize( 900, 600);    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
    setLocation(200,100);
    setResizable(true);
    Panel pan = new Panel();   
    setContentPane(pan);  
    setVisible(true); 
  }
    
    public static void main(String args[]) {
      Conversion obj = new Conversion();
      obj.binary();
    }
    public void binary() {
      /*System.out.println("Decimal to Binary");
      System.out.println("\nEnter the number: ");
      num = Integer.parseInt(sc.nextLine(),10);
      String binary = Integer.toBinaryString(num);
      System.out.println("Binary Value is: " + binary);
      int decimal = Integer.parseInt(binary,2);
      System.out.println("\nDecimal value is: " + decimal);
      */
      
      /*if (inputChoice==1) { //ask for binary values
        System.out.print("Please enter your binary: "); //output decimal
        int num = sc.nextInt();
        int decimal = Integer.parseInt(num + "", 2); //bin base 2
        System.out.println("The decimal for " +num+ " is " + decimal);
      }
      if (inputChoice==2) { //ask for decimal values
        System.out.print("Please enter your decimal: "); //output binary
        int num = sc.nextInt();
        String bin = Integer.toBinaryString(num);
        System.out.println("The binary for " +num+ " is " + bin);
      }
      num = Integer.parseInt(sc.nextLine(),10);
      String binary = Integer.toBinaryString(num);
      int decimal = Integer.parseInt(binary,2);
      //int choice = sc.nextInt();
      */
    }
}

class Panel extends JPanel {
  int posterType; int backgroundType;
  Scanner sc = new Scanner(System.in);
  String answer = "";
  public Panel() {
    setBackground(Color.PINK);
    System.out.print("\n\n\n");
    System.out.print("Would you like to enter binary(1), decimal(2), hex(3)? ");
    int inputChoice = sc.nextInt();
    String [] choice = {"binary", "decimal", "hex"};
    System.out.print("Please enter your " + choice[inputChoice-1] + ": ");
    int input = sc.nextInt();
    if (inputChoice == 1) {
      input = Integer.parseInt(input + "", 2);
    } else if (inputChoice == 2) {
        //input = Integer.parseInt(input + "", 10);
    } else if (inputChoice == 3) {
        input = Integer.parseInt(input + "", 16);
    }
    // now input is in decimal value

    System.out.print("Would you like to output binary(1), decimal(2), or hex(3)? ");
    int outputChoice = sc.nextInt();
    if (outputChoice == 1) {
      answer = Integer.toBinaryString(input);
    } else if (outputChoice == 2) {
        answer = Integer.toString(input);
    } else if (outputChoice == 3) {
        answer = Integer.toHexString(input).toUpperCase();
    }
    String [] choice2 = {"binary", "decimal", "hex"};
    System.out.println("The " + choice2[outputChoice-1] + " for " + input + " is " + answer);
  }

  public void paintComponent(Graphics g)
  {  
    super.paintComponent(g);
    for(int i = 0; i<900;i+=30) 
    {
     g.setColor(Color.BLACK);    //lines will be black
     g.drawLine(i, 0, i, 900);   //draws vertical lines
     g.drawLine(0, i, 900, i);   //draws horizontal lines
    }
    draw(g, answer);
  }
    public void draw(Graphics g, String answer) {
      int x = 0;
      for (int i=0; i<answer.length();i++) {
        x = i*60;
        if (answer.charAt(i)=='0') zero(g, x);
        if (answer.charAt(i)=='1') one(g, x);
        if (answer.charAt(i)=='2') two(g, x);
        if (answer.charAt(i)=='3') three(g, x);
        if (answer.charAt(i)=='4') four(g, x);
        if (answer.charAt(i)=='5') five(g, x);
        if (answer.charAt(i)=='6') six(g, x);
        if (answer.charAt(i)=='7') seven(g, x);
        if (answer.charAt(i)=='8') eight(g, x);
        if (answer.charAt(i)=='9') nine(g, x);
        if (answer.charAt(i)=='A') charA(g, x);
        if (answer.charAt(i)=='B') charB(g, x);
        if (answer.charAt(i)=='C') charC(g, x);
        if (answer.charAt(i)=='D') charD(g, x);
        if (answer.charAt(i)=='E') charE(g, x);
        if (answer.charAt(i)=='F') charF(g, x);
      }
    }
  

 public void one(Graphics g2, int x) {
   System.out.println("ONE");
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g2.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g2.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g2.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g2.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g2.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void zero(Graphics g3, int x) {
   System.out.println("zero");
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic1, 1+x, 120, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic2, 1+x, 150, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic3, 1+x, 180, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic4, 31+x, 210, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic5, 31+x, 90, 25, 25, null);
  Image onePic6 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic6, 31+x, 210, 25, 25, null);
  Image onePic7 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic7, 61+x, 120, 25, 25, null);
  Image onePic8 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic8, 61+x, 150, 25, 25, null);
  Image onePic9 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic9, 61+x, 180, 25, 25, null);
  
 }
 public void two(Graphics g4, int x) {
   System.out.println("two");
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g4.drawImage(onePic1, 1+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g4.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g4.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g4.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g4.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void three(Graphics g5, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g5.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g5.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g5.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g5.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g5.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void four(Graphics g6, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g6.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g6.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g6.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g6.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g6.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void five(Graphics g7, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g7.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g7.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g7.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g7.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g7.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void six(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void seven(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void eight(Graphics g, int x) {
  Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void nine(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charA(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charB(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charC(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charD(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charE(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charF(Graphics g, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
}
