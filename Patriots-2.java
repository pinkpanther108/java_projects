/*Sudipti Dantuluri
 * 4.12.2022
 * Patriots.java
 * Final game project.*/

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
  //Main method
  public static void main(String[] args) 
  {
    Patriots p = new Patriots();
  }  
  public Patriots()
  {
    super("Patriots");
    setSize( 900, 900);    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
    setLocation(400,50);
    setResizable(true);
    JMenuBar menubar = new JMenuBar();
    setJMenuBar(menubar); 
    JMenu file = new JMenu("File");
    menubar.add(file);
    JMenuItem exit = new JMenuItem("Exit");
    file.add(exit);
	//JMenu "exit" button
    class exitAction implements ActionListener {
      public void actionPerformed (ActionEvent e) {
        System.exit(0);
      }
    }
    exit.addActionListener(new exitAction());

    Practice pc = new Practice();   
    setContentPane( pc );  // OR frame.getContentPane().add(p_in);
    setVisible(true);  
  }
}
//Practice class 
class Practice extends JPanel
{ 
  JTextArea jtext;
  JLabel jlabel1;
  JLabel jlabel2;
  JLabel jlabel3, jlabel4, jlabel5, jlabel6, jlabel7, jlabel8;
  JButton btn3,btn4;
  int team1Num = 0;
  int team2Num = 0;
  private JButton startButton, buttonPlay, button3; 
  private JTextArea t1, howToPlayDescription;
  String sent = "   Play";
  Font headerFont = new Font("Serif", Font.BOLD, 35);
  Font descriptionFont = new Font("Serif", Font.PLAIN, 20);
  Font introDescriptionFont = new Font("Arial", Font.PLAIN, 5);
  private JCheckBox checkBox1, checkBox2, checkBox3; 
  private JTextArea introDescription;

  public Practice() 
  {
    frontPage();
  }
  public void paintComponent(Graphics g) 
  {
    super.paintComponent (g);
    frontPageBackground(g);
  }
  //Any graphics/images
  public void frontPageBackground(Graphics g) {
    //Image frontPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
    //g.drawImage(frontPageBackground, 0, 0, 900, 500, null);
    java.net.URL imgUrl = getClass().getResource("frontPageBackground.jpg");
    ImageIcon icon = new ImageIcon(imgUrl);
  }
  //Method for front page
  public void frontPage()
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
    JPanel bruh = new JPanel();

    //JButton btn3 = new JButton("Play");
    //JButton btn4 = new JButton("How To Play");
    //JButton btn5 = new JButton("Introduction");

    CardLayout cardLayout = new CardLayout();
    panel.setLayout(cardLayout);

	//Front page panel
    t1 = new JTextArea();
    //t1.setFont(headerFont);
    t1.setText("\n\n\n              " + sent); 
    t1.setOpaque(true);
    //t1.setBackground(Color.MAGENTA);
    t1.setPreferredSize(new Dimension (600, 600));
    tPanel.add( t1 );
	
    howToPlayDescription= new JTextArea();
    howToPlayDescription.setFont(headerFont);
    JLabel howToPlayHeader = new JLabel("<html>" + "How To Play" + "<br>" + "</html>");
    howToPlayHeader.setHorizontalAlignment(JLabel.CENTER);
	//Description for what keys to use
    howToPlayDescription.setFont(headerFont);
    howToPlayDescription.setText("First level:\nSpace bar = jump up\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot\n\nSecond level:\nSpace bar = rocket\n“w” key = shoot\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot "); 
    //t2.setOpaque(true);
    //t2.setBackground(Color.BLUE);
    howToPlayDescription.setPreferredSize(new Dimension (400, 450));
    tPanel2.add( howToPlayDescription );   
    tPanel2.add( howToPlayHeader );  
    tPanel2.add(howToPlayHeader, BorderLayout.NORTH);

    introDescription = new JTextArea();
    //introHeader.setFont(headerFont);
    JLabel introHeader = new JLabel("<html>" + "Introduction" + "<br>" + "</html>");
    introHeader.setHorizontalAlignment(JLabel.CENTER);
	//Introduction
    introDescription.setFont(introDescriptionFont);
    introDescription.setText("The US has been invaded by bots and needs your help. You have been recruited by the military.\nEach level, your goal is to destroy the bots and then you will be promoted a new role.\nFor the first level, you will have to defeat the bot with your given weapon and watch out\nfor your health. When your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero.\nOnce you win the first level, in the second level you will be able to access more weapons\nand equipment and have more bots to shoot. In the last level, you will be promoted to a navy SEAL officer, so\nyou will have to be aware of health and oxygen levels. Swim up to the surface to regenerate your oxygen levels.");
    //introDescription.setHorizontalAlignment(JTextArea.CENTER);
    //introDescription.setOpaque(true);
    //introDescription.setBackground(Color.GREEN);
    introDescription.setPreferredSize(new Dimension (580, 450));
    bruh.add( introDescription );
    bruh.add( introHeader );  
    bruh.add(introHeader, BorderLayout.NORTH);

    panel.add(panel1, "link1");
    panel.add(panel2, "link2");
    panel.add(panel3, "link3");

    //Buttons and adding their action listeners
    startButton = new JButton("Start");
    startListener b1 = new startListener();
    startButton.addActionListener( b1 );
    btnPanel2.add(startButton);

    buttonPlay = new JButton("How To Play");
    //instructionListener b2 = new instructionListener();
    //buttonPlay.addActionListener( b2 );
    //buttonPlay.addActionListener(e -> cardLayout.next(panel));
    playListener pl = new playListener();
    buttonPlay.addActionListener( pl );
    btnPanel2.add(buttonPlay);

    button3 = new JButton("Introduction");
    introListener b3 = new introListener();
    button3.addActionListener( b3 );
    btnPanel2.add(button3);


    //add(btn3);
    //add(btn4);
    //add(btn5);

    //button.setBackground(Color.CYAN);
    panel1.add(tPanel, BorderLayout.SOUTH);
    panel1.add(btnPanel2, BorderLayout.CENTER);
    panel2.add(check, BorderLayout.WEST);
    panel2.add(tPanel2, BorderLayout.CENTER);
    panel3.add(introDescription, BorderLayout.CENTER);
    add(panel);
  }
  //Listener for "start"
  class startListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      sent = "Game";
      t1.setText("\n\n\n                     " + sent);
      repaint();
    }
  }
  //Listener for "how to play"
  class playListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      //sent = "How to play listner";
      //t1.setText("\n\n\n                     " + sent);
      sent = "First level:\nSpace bar = jump up\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot\n\nSecond level:\nSpace bar = rocket\n“w” key = shoot\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot ";
      t1.setText(sent);
      repaint();
    }
  }
  //Listener for "how to play"
  class instructionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) 
    {
      sent = "First level:\nSpace bar = jump up\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot\n\nSecond level:\nSpace bar = rocket\n“w” key = shoot\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot ";
      t1.setText(sent);
      repaint();
    }
  }
  //Listener for "introduction"
  class introListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      sent = "The US has been invaded by bots and needs your help. You have been recruited by the military.\nEach level, your goal is to destroy the bots and then you will be promoted a new role.\nFor the first level, you will have to defeat the bot with your given weapon and watch out for your health.\nWhen your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero.\nOnce you win the first level, in the second level you will be able to access more weapons and equipment and have more bots to shoot.\nIn the last level, you will be promoted to a navy SEAL officer, so you will have to be aware of health and oxygen levels.\nSwim up to the surface to regenerate your oxygen levels.";
      t1.setText(sent);
      repaint();
    }
  }
}
