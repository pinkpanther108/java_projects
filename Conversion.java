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
    String answer = "";
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
    //binOne(g, 0);
    //binOne(g, 60);
    draw(g, answer);
  }
    /*for (int i=0;i<answer.length();i++) {
      char c = answer.charAt(i);
      if(c==0) {
        zero(g,i*60);
      } else if (c==1) {
          one(g2,x);
      } else if (c==2) {
          two();
      } else if (c==3) {
          three();
      } else if (c==4) {
          four();
      } else if (c==5) {
          five();
      } else if (c==6) {
          six();
      } else if (c==7) {
          seven();
      } else if (c==8) {
          eight();
      } else if (c==9) {
          nine();
      } else if (c=='A') {
          charA();
      } else if (c=='B') {
          charB();
      } else if (c=='C') {
          charC();
      } else if (c=='D') {
          charD();
      } else if (c=='E') {
          charE();
      } else if (c=='F') {
          charF();
      }
    } */

    public void zero(Graphics g,  int i) {
      Image allen = new ImageIcon("Allen_Iverson.png").getImage();
    }
    public void one(Graphics g,  int i) {
      Image allen = new ImageIcon("Allen_Iverson.png").getImage();
    }

    public void draw(Graphics g,  String answer) {
      for (int i=0; i<answer.length();i++) {
        if (answer.charAt(i)=='0') zero(g, i);
        if (answer.charAt(i)=='1') one(g, i);
      }
    }
    /* public void draw(Graphics gS, Image allen, String answer) {
      Image allen = new ImageIcon("Allen_Iverson.png").getImage();
      for (int i=0; i<answer.length();i++) {
        if ((int)answer.charAt(i)==48) zero(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==49) one(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) two(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) three(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) four(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) five(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) six(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) seven(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) eight(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) nine(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) A(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) B(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) C(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) D(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) E(gS, allen, 4*grid*i);
        if ((int)answer.charAt(i)==48) F(gS, allen, 4*grid*i);
      }
    } */
  }
  

 /*public void one(Graphics g2, int x) {
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
  Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic1, 61+x, 120, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic2, 61+x, 150, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g3.drawImage(onePic3, 61+x, 180, 25, 25, null);
  
 }
 public void two(Graphics g4, int x) {
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
 public void six(Graphics g8, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g8.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g8.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g8.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g8.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g8.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void seven(Graphics g9, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g9.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g9.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g9.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g9.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g9.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void eight(Graphics g10, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g10.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g10.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g10.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g10.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g10.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void nine(Graphics g11, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g11.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g11.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g11.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g11.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g11.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charA(Graphics g12, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g12.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g12.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g12.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g12.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g12.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charB(Graphics g13, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g13.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g13.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g13.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g13.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g13.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charC(Graphics g14, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g14.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g14.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g14.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g14.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g14.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charD(Graphics g15, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g15.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g15.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g15.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g15.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g15.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charE(Graphics g16, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g16.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g16.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g16.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g16.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g16.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
 public void charF(Graphics g17, int x) {
   Image onePic1 = new ImageIcon("Allen_Iverson.png").getImage();
  g17.drawImage(onePic1, 31+x, 90, 25, 25, null);
  Image onePic2 = new ImageIcon("Allen_Iverson.png").getImage();
  g17.drawImage(onePic2, 31+x, 120, 25, 25, null);
  Image onePic3 = new ImageIcon("Allen_Iverson.png").getImage();
  g17.drawImage(onePic3, 31+x, 150, 25, 25, null);
  Image onePic4 = new ImageIcon("Allen_Iverson.png").getImage();
  g17.drawImage(onePic4, 31+x, 180, 25, 25, null);
  Image onePic5 = new ImageIcon("Allen_Iverson.png").getImage();
  g17.drawImage(onePic5, 31+x, 210, 25, 25, null);
 }
*/
