/*Sudipti Dantuluri
  * 2.15.2022
  * BirthdayCake.java
  * The program uses images to print a chocolate, strawberry, or blueberry cake with candles and pictures correlating with the user's input.*/


import java.awt.*;   // for classes Graphics, Color, Font, Image
import java.awt.event.* ; // for classes KeyListener, MouseListener
import javax.swing.* ; // for classes JFrame, JPanel, JLabel
import java.io.*  ; // for classes File, IOException, ImageIO
import java.util.Scanner; 

public class BirthdayCake extends JFrame
{
 public BirthdayCake ( )   
 {
    super ("Sudipti Dantuluri");
    setSize( 600, 600);    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
    setLocation(200,100);
    setResizable(true);
    Panel pan = new Panel();   
    setContentPane(pan);  
    setVisible(true); 
 }

 public static void main (String[] args) {
  BirthdayCake bc = new BirthdayCake();
 }
}
  
class Panel extends JPanel {  
  String name;
  int age;
  int cakeType;
  int theme_option;
  public Panel() {
    //setBackground(Color.PINK);
    Scanner sc = new Scanner(System.in);
    System.out.print("\n\n\n");
	System.out.print("What is your name? ");
	name = sc.nextLine();
	System.out.print("How old are you? ");
	age = sc.nextInt();
	System.out.print("Would you like chocolate(1), strawberry(2), or blueberry(3)? ");
	cakeType = sc.nextInt();
	System.out.print("Which theme would you like?\nMale(1), Female(2), Random(3)? ");
	int theme_option = sc.nextInt();
	
	System.out.print("\n\n\n");
	//backgroundColor = backgroundColor.toLowerCase();
  }
  public void paintComponent(Graphics g)
  {  
    super.paintComponent(g);
    for(int i = 0; i<600;i+=40) 
    {
     g.setColor(Color.BLACK);    //lines will be black
     g.drawLine(i, 0, i, 600);   //draws vertical lines
     g.drawLine(0, i, 600, i);   //draws horizontal lines
    }
    g.setFont(new Font("Arial", Font.PLAIN, 15));
	  g.drawString("Happy Birthday " + name + ", " + age + " years!", 170,120);
	  theme(g);
  }

	public void male(Graphics g2) {
		Image cake = new ImageIcon("cake.png").getImage();
    g2.drawImage(cake, 20, 40, 550, 500, null);

		Image pic_1B = new ImageIcon("genie.png").getImage();
		g2.drawImage(pic_1B, 20, 40, 50, 50, null);
		Image pic_2B = new ImageIcon("goofy.png").getImage();
		g2.drawImage(pic_2B, 30, 40, 50, 50, null);
		Image pic_3B = new ImageIcon("cogsworth.png").getImage();
		g2.drawImage(pic_3B, 40, 40, 50, 50, null);
		Image pic_4B = new ImageIcon("mowgli.png").getImage();
		g2.drawImage(pic_4B, 50, 40, 50, 50, null);
		Image pic_5B = new ImageIcon("tigger.png").getImage();
		g2.drawImage(pic_5B, 20, 50, 50, 50, null);
		Image pic_6B = new ImageIcon("mickey.jpg").getImage();
		g2.drawImage(pic_6B, 20, 60, 50, 50, null);
		Image pic_7B = new ImageIcon("scrooge.jpg").getImage();
		g2.drawImage(pic_7B, 20, 70, 50, 50, null);
		Image pic_8B = new ImageIcon("simba.jpg").getImage();
		g2.drawImage(pic_8B, 20, 80, 50, 50, null);
	}
	public void female(Graphics g3) {
		Image cake = new ImageIcon("cake.png").getImage();
    g3.drawImage(cake, 20, 40, 550, 500, null);

		Image pic_1G = new ImageIcon("alice.jpg").getImage();
		g3.drawImage(pic_1G, 20, 40, 50, 50, null);
		Image pic_2G = new ImageIcon("belle.jpg").getImage();
		g3.drawImage(pic_2G, 30, 40, 50, 50, null);
		Image pic_3G = new ImageIcon("flower.jpg").getImage();
		g3.drawImage(pic_3G, 40, 40, 50, 50, null);
		Image pic_4G = new ImageIcon("belle.jpg").getImage();
		g3.drawImage(pic_4G, 50, 40, 50, 50, null);
		Image pic_5G = new ImageIcon("minnie.jpg").getImage();
		g3.drawImage(pic_5G, 20, 50, 50, 50, null);
		Image pic_6G = new ImageIcon("snow_white.jpg").getImage();
		g3.drawImage(pic_6G, 20, 60, 50, 50, null);
		Image pic_7G = new ImageIcon("tinker_bell.jpg").getImage();
		g3.drawImage(pic_7G, 20, 70, 50, 50, null);
		Image pic_8G = new ImageIcon("wendy.jpg").getImage();
		g3.drawImage(pic_8G, 20, 80, 50, 50, null);
	}
	
	public void cake(Graphics g5) {
	    if (cakeType==1) {
		   Image cake = new ImageIcon("chocolate.png").getImage();
		   g5.drawImage(cake, 20, 40, 550, 500, null);
		}
		if (cakeType==2) {
		   Image cake = new ImageIcon("strawberry.png").getImage();
		   g5.drawImage(cake, 20, 40, 550, 500, null);
		}
		if (cakeType==3) {
		   Image cake = new ImageIcon("blueberry.png").getImage();
		   g5.drawImage(cake, 20, 40, 550, 500, null);
		}
 }
	public void theme(Graphics g) {
 		if (theme_option==1) {
		    male(g);
		}
		if (theme_option==2) {
		    female(g);
		}
		if (theme_option==3) {
		    //random(g4);
		}
	}
}
//transparent background for each picture
