// Parth Upadhyay
// 3/25/22
// ButtonsAndText.java
// To use CardLayout
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*; 

public class ButtonsAndText {
	public ButtonsAndText()
	{
	 JFrame frame = new JFrame();
      frame.setSize(600, 600);
      Practice pc = new Practice(); 
      frame.setContentPane(pc);  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
		
	}
   public static void main(String[] args) {
	   ButtonsAndText bat = new ButtonsAndText();
   }
   
   class Practice extends JPanel
{ 
	   
	   private JButton button1, button2, button3; 
		private JTextArea t1, t2;
		String sent = "Press A Button!";
		Font ft = new Font("Serif", Font.BOLD, 40);
		private JCheckBox checkBox1, checkBox2, checkBox3; 
		private JLabel name;

 public Practice() 
 {
  	runIt();
  }
 
 public void paintComponent(Graphics g) 
 {
  super.paintComponent(g);
 }
 
 public void runIt()
 {
      JPanel panel = new JPanel();   
      JPanel panel1 = new JPanel(new BorderLayout());
      JPanel panel2 = new JPanel(new BorderLayout());  
      JPanel panel3 = new JPanel();

      JPanel btnPanel = new JPanel(); 
      
      JPanel btnPanel2 = new JPanel(); 
      JPanel tPanel = new JPanel(); 
      
      JPanel check = new JPanel(new GridLayout(3,1,0,0)); 
      JPanel tPanel2 = new JPanel(); 
   
      JPanel boring = new JPanel(); 

      JButton btn1 = new JButton("NEXT");
      JButton btn2 = new JButton("PREVIOUS");
    

      CardLayout cardLayout = new CardLayout();
      panel.setLayout(cardLayout);
      
     
      
      button1 = new JButton("Button 1");
	  type1 b1 = new type1();
	  button1.addActionListener( b1 ); 
	  btnPanel2.add( button1);
	  
 button2 = new JButton("Button 2");
	  type2 b2 = new type2();
	  button2.addActionListener( b2 ); 
	  btnPanel2.add( button2);
	   
  button3 = new JButton("Button 3");
	  type3 b3 = new type3();
	  button3.addActionListener( b3 ); 
	  btnPanel2.add( button3);
	  
	  t1 = new JTextArea();
	  t1.setFont(ft);
	  t1.setText("\n\n\n              " + sent); 
	  t1.setOpaque(true);
	  t1.setBackground(Color.BLUE);
	  t1.setPreferredSize(new Dimension (580, 400));
	  tPanel.add( t1 );
	  
	 
	  
	  
		checkBox1 = new JCheckBox("red");
		CheckBoxListener cblistener = new CheckBoxListener();
		checkBox1.addActionListener(cblistener);
		checkBox1.setSelected(false);
		check.add(checkBox1);
		
		checkBox2 = new JCheckBox("orange");
		checkBox2.addActionListener(cblistener);
		checkBox2.setSelected(false);
		check.add(checkBox2);
		
		checkBox3 = new JCheckBox("yellow");
		checkBox3.addActionListener(cblistener);
		checkBox3.setSelected(false);
		check.add(checkBox3);
		
		 t2 = new JTextArea();
		  t2.setFont(ft);
		  t2.setText("J\tJ\nT\tT\nE\tE\nX\tX\nT\tT\nA\tA\nR\tR\nE\tE\nA\tA\n"); 
		  t2.setOpaque(true);
		  t2.setBackground(Color.BLUE);
		  t2.setPreferredSize(new Dimension (400, 450));
		  tPanel2.add( t2 );
		  
		  
		  name = new JLabel();
		  name.setFont(ft);
		  name.setText("Parth U.");
		  name.setOpaque(true);
		  name.setBackground(Color.ORANGE);
		  name.setPreferredSize(new Dimension (240, 50));
		  boring.add( name );
			

      panel.add(panel1, "link1");
      panel.add(panel2, "link2");
      panel.add(panel3, "link3");

      btn1.addActionListener(e -> cardLayout.next(panel));
      btn2.addActionListener(e -> cardLayout.previous(panel));
     
      btnPanel.add(btn1);
      btnPanel.add(btn2);
      
      add(btnPanel, BorderLayout.NORTH);
      

      panel1.add(tPanel, BorderLayout.SOUTH);
      panel1.add(btnPanel2, BorderLayout.CENTER);
      
      panel2.add(check, BorderLayout.WEST);
      panel2.add(tPanel2, BorderLayout.CENTER);
      
      panel3.add(name);
    
      add(panel);
  }
 
 class type1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
	  {
		  sent = "Button 1";
		  t1.setText("\n\n\n                     " + sent);
		  repaint();
	  }
	}
	
	class type2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
	  {
		  sent = "Button 2";
		  t1.setText("\n\n\n                     " + sent);
		  repaint();
	  }
	}
	
	class type3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
	  {
		  sent = "Button 3";
		    t1.setText("\n\n\n                     " + sent);
		  repaint();
	  }
	}
	
	class CheckBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String color = e.getActionCommand();
			
			if (color.equals("red")) {
				checkBox1.setSelected(true);
				checkBox2.setSelected(false);
				checkBox3.setSelected(false);
				t2.setBackground(Color.RED);
				repaint();
			}
			
			if (color.equals("orange")) {
				checkBox1.setSelected(false);
				checkBox2.setSelected(true);
				checkBox3.setSelected(false);
				t2.setBackground(Color.ORANGE);
				repaint();
			}
			if (color.equals("yellow"))  {
				checkBox1.setSelected(false);
				checkBox2.setSelected(false);
				checkBox3.setSelected(true);
				t2.setBackground(Color.YELLOW);
				repaint();
			}

		}
	}
 
}
}
