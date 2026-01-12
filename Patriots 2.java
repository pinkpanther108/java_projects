/*Sudipti Dantuluri
 * 4.12.2022
 * Patriots.java
 * This is the final game project.*/

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;  import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*; 

public class Patriots extends JFrame
{
  //This is the main method
  public static void main(String[] args) 
  {
    Patriots p = new Patriots();
  }  
  public Patriots()
  {
    super("Patriots");
    setSize( 900, 500);    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
    setLocation(400,50);
    setResizable(true);
    Practice pc = new Practice();   
    setContentPane( pc );  // OR frame.getContentPane().add(p_in);
    setVisible(true);  
  }
}

class Practice extends JPanel
{ 
  JTextArea jtext;
  JLabel jlabel1;
  JLabel jlabel2;
  JLabel jlabel3, jlabel4, jlabel5, jlabel6, jlabel7, jlabel8;
  JButton btn1,btn2, btn3,btn4;
  int team1Num = 0;
  int team2Num = 0;
  public Practice() 
  {
    frontPage();
  }
  public void paintComponent(Graphics g) 
  {
    super.paintComponent (g);
    frontPageBackground(g);
  }
  public void frontPageBackground(Graphics g) {
    Image frontPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
    g.drawImage(frontPageBackground, 0, 0, 900, 500, null);
  }
  public void frontPage()
  {

    /*jlabel1=new JLabel(".");
      jlabel1.setPreferredSize(new Dimension(200,200));
      JButton ba1=new JButton("Patriots");
      ba1.setPreferredSize(new Dimension(200,200));
      jlabel3=new JLabel(".");
      jlabel3.setPreferredSize(new Dimension(200,200));
      JButton ba5=new JButton("Play");
      ba5.setPreferredSize(new Dimension(200,200));
      jlabel5=new JLabel(".");
      jlabel5.setPreferredSize(new Dimension(200,200));
      jlabel6=new JLabel(".");
      jlabel6.setPreferredSize(new Dimension(200,200));
      JButton ba8=new JButton("Instruction");
      ba8.setPreferredSize(new Dimension(200,200));
      jlabel2 = new JLabel(".");
      jlabel2.setPreferredSize(new Dimension(200,200));
      jlabel7=new JLabel(".");
      jlabel7.setPreferredSize(new Dimension(200,200));
      JButton ba4=new JButton("Introduction");
      jlabel8=new JLabel(".");
      jlabel8.setPreferredSize(new Dimension(200,200));
      JPanel pa = new JPanel();
      add(pa);
      pa.setLayout(new GridLayout(3,3,0,0));
      pa.add(jlabel1);
      pa.add(ba1);
      pa.add(jlabel3);
    //pa.add(jlabel4);
    pa.add(ba5);
    pa.add(jlabel5);
    pa.add(jlabel6);
    pa.add(ba8);
    pa.add(jlabel2);
    pa.add(jlabel7); 
    pa.add(ba4);
    pa.add(jlabel8);
    */
    JPanel panel = new JPanel();
    JPanel howToPlayPanel = new JPanel(new BorderLayout());
    JPanel btnPanel0 = new JPanel(new BorderLayout());
    JPanel btnPane2 = new JPanel(new BorderLayout());
    JPanel btnPanel = new JPanel();

    CardLayout cardLayout = new CardLayout();
    panel.setLayout(cardLayout);

    JLabel label1 = new JLabel("Content of Card 1 is visible now!");
    //JButton btn4 = new JButton("NEXT");
    howToPlayPanel.add(label1);

    //panel3.add(new JButton("Button 1 on Panel 5"));

    JPanel p2 = new JPanel(new BorderLayout());
    p2.add(new JTextArea("text area"));

    JButton btnnext = new JButton("NEXT");
    JButton btnprev = new JButton("PREVIOUS");

    btnnext.addActionListener(e -> cardLayout.next(panel));
    btnprev.addActionListener(e -> cardLayout.previous(panel));

    btnPanel.add(btnnext);
    btnPanel.add(btnprev);
    add(btnPanel, BorderLayout.NORTH);

    btn1 = new JButton("Button 1");
    btn2 = new JButton("Button 2");
    btn3 = new JButton("Button 3");
    btn4 = new JButton("Button 4");

    btn1.addActionListener(e -> cardLayout.show(panel, "link1"));
    btn2.addActionListener(e -> cardLayout.next(panel));
    btn3.addActionListener(e -> cardLayout.next(panel));
    btn4.addActionListener(e -> cardLayout.next(panel));

    btnPanel0.add(btn1, BorderLayout.SOUTH);
    btnPanel0.add(btn2, BorderLayout.CENTER);

    btnPane2.add(btn3, BorderLayout.WEST);
    btnPane2.add(btn4, BorderLayout.CENTER);

    panel.add(howToPlayPanel, "howtolink");
    panel.add(btnPanel0, "btnPanel1");
    panel.add(btnPane2, "btnPanel2");

    System.out.print("Hello");
    add(panel);
  }
}
