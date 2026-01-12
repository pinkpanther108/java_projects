// Parth Upadhyay 
// 3/1/22 
// Conversion.java 
// To Convert binary and decimal and hex 
// img 48 , Dominique Wilkins  
import java.util.Scanner; 
import java.awt.*; 
import javax.swing.*;
import java.util.*;
public class Conversion extends JFrame
{      

  public Conversion()
  {  
    super ("Conversion");
    setSize( 900, 600);    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
    setLocation(200,100);
    setResizable(true);
    Panel pan = new Panel();   
    setContentPane(pan);  
    setVisible(true);   
  } 
  
  public static void main (String [] args)   
  {  
    Conversion c = new Conversion();
  }
  
  

}
class Panel extends JPanel
{  
	Image player = new ImageIcon("48_Dominique_wilkins.png").getImage();
	String Draw = "";
	int in;
	int out;
    Scanner sc = new Scanner(System.in);
	int num;
	String hex;
	String binary = "";
	int decimal;
	int x = 0;
	int y = 90;
  public Panel()
  {  
   	  System.out.println("Would you like to enter binary(1), decimal(2), or hex(3)? ");
	  int in = sc.nextInt();
	  System.out.println("Would you like to output binary(1), decimal(2), or hex(3)? ");
	  int out = sc.nextInt();
	  
	  if (in == 1)
	  {
		  if (in == 2)
		  {
			  binaryToDecimal();
			  Draw = decimal + "";
		  }
		  else 
		  {
			  binaryToHex();
			  Draw = hex;
		  }
	  }
	  else if (in == 2)
	  {
		 if (out == 1)
		 {
			 decimalToBinary();
			 Draw = binary;
		 }
		 else
		 {
			 decimalToHex();
			 Draw = hex;
		 }
	  }
	  else 
	  {
		  if (out == 1)
		  {
			  hexToBinary();
			  Draw = binary;
		  }
		  else if (out == 2)
		  {
			  hexToDecimal();
			  Draw = decimal + "";
		  }
	  }
  }
  
  public void binaryToDecimal()
  {
	  System.out.println("Please enter the binary: ");
	  binary = sc.next();
	  decimal = Integer.parseInt(binary, 2);
	  System.out.println("The decimal for " + binary + " is " + decimal);
  }
  
  public void binaryToHex()
  {
	  System.out.println("Please enter the binary: ");
	  binary = sc.next();
	  decimal = Integer.parseInt(binary, 2);
	  hex = Integer.toHexString(decimal);
	  System.out.println("Hex value is: " + hex);
  }
  
  public void decimalToHex()
  {
	  System.out.println("Please enter the decimal: ");
	  decimal = sc.nextInt();
	  hex = Integer.toHexString(decimal);
	  System.out.println("Hex value is: " + hex);
  }
 
  
  public void decimalToBinary()
  {
	  System.out.println("Please enter the decimal:");
	  decimal = sc.nextInt();
	  decimal = Integer.parseInt(sc.nextLine(), 10);
	  binary = Integer.toBinaryString(decimal);
	  System.out.println("Binary Value is : " + binary);
  }
  
  public void hexToBinary()
  {
	  System.out.println("Please enter the hex: ");
	  hex = sc.next();
	  decimal = Integer.parseInt(hex, 16);
	  binary = Integer.toBinaryString(decimal);
	  System.out.println("Binary Value is: " + binary);
  }
  
  public void hexToDecimal()
  {
	  System.out.println("Please enter the hex: ");
	  hex = sc.next();
	  decimal = Integer.parseInt(hex, 16);
	  System.out.println("Decimal is " + decimal);
  }
  
  
  public void paintComponent(Graphics g)
  {  
    super.paintComponent(g);
    for(int i = 0; i<1000;i+=30) 
    {
      g.setColor(Color.BLACK);   
      g.drawLine(i, 0, i, 1000);
      g.drawLine(0, i, 1000, i); 
    }
    
   
	char cChar = 'a';
	for (int i = 0; i< Draw.length(); i++)
	{
		cChar = Draw.charAt(i);
		
		if (cChar == '1')
		{
			One(g);
		}
		else if (cChar == '2')
		{
			Two(g);
		}
		else if (cChar == '3')
		{
			Three(g);
		}
		else if (cChar == '4')
		{
			Four(g);
		}
		else if (cChar == '5')
		{
			Five(g);
		}
		else if (cChar == '6')
		{
			Six(g);
		}
		else if (cChar == '7')
		{
			Seven(g);
		}
		else if (cChar == '8')
		{
			Eight(g);
		}
		else if (cChar == '9')
		{
			Nine(g);
		}
		else if (cChar == '0')
		{
			Zero(g);
		}
		else if (cChar == 'a'||cChar == 'A')
		{
			A(g);
		}
		else if (cChar == 'b'||cChar == 'B')
		{
			B(g);
		}
		else if (cChar == 'c'||cChar == 'C')
		{
			C(g);
		}
		else if (cChar == 'd'||cChar == 'D')
		{
			D(g);
		}
		else if (cChar == 'e'||cChar == 'F')
		{
			E(g);
		}
		else if (cChar == 'f'||cChar == 'F')
		{
			F(g);
		}
		
		x = x + 120;
	}
	
	
  } 

  public void One(Graphics g)
  {
	  g.drawImage(player, x + 30, y, 30, 30, null);
	  g.drawImage(player, x + 30, y + 30, 30, 30, null);
	  g.drawImage(player, x + 30, y + 60, 30, 30, null);
	  g.drawImage(player, x + 30, y + 90, 30, 30, null);
	  g.drawImage(player, x + 30, y + 120, 30, 30, null);
  }
  
  public void Two(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x + 30,y, 30, 30, null);
	  g.drawImage(player, x + 60, y + 30, 30, 30, null);
	  g.drawImage(player, x + 30, y + 60, 30, 30, null);
	  g.drawImage(player, x, y + 90, 30, 30, null);
	  g.drawImage(player, x, y + 120, 30, 30, null);
	  g.drawImage(player, x+30, y + 120, 30, 30, null);
	  g.drawImage(player, x+60, y + 120, 30, 30, null);
	  
  }
  
  public void Three(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60,y+30, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  
  public void Four(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x+60, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+120, 30, 30, null);
	  
  }
  
  public void Five(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  
  public void Six(Graphics g)
  {
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  
  public void Seven(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+90, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  
  public void Eight(Graphics g)
  {
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  public void Nine(Graphics g)
  {
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  
  public void Zero(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
	  g.drawImage(player, x+60, y+120, 30, 30, null);
  }
  public void A(Graphics g)
  {
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x,y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+60, y+120, 30, 30, null);
  }
  public void B(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  public void C(Graphics g)
  {
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
	  g.drawImage(player, x+60, y+120, 30, 30, null);
  }
  public void D(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x+60, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+60, y+60, 30, 30, null);
	  g.drawImage(player, x, y+90, 30, 30, null);
	  g.drawImage(player, x+60, y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
  }
  public void E(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x, y +90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);
	  g.drawImage(player, x+30, y+120, 30, 30, null);
	  g.drawImage(player, x+60, y+120, 30, 30, null);
  }
  public void F(Graphics g)
  {
	  g.drawImage(player, x, y, 30, 30, null);
	  g.drawImage(player, x+30, y, 30, 30, null);
	  g.drawImage(player, x+60, y, 30, 30, null);
	  g.drawImage(player, x, y+30, 30, 30, null);
	  g.drawImage(player, x, y+60, 30, 30, null);
	  g.drawImage(player, x+30, y+60, 30, 30, null);
	  g.drawImage(player, x,y+90, 30, 30, null);
	  g.drawImage(player, x, y+120, 30, 30, null);

  }
}
