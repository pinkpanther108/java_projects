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
  Practice pc = new Practice();   
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

    setContentPane( pc );  // OR frame.getContentPane().add(p_in);
    setVisible(true);  
  }


  //Practice class 
  class Practice extends JPanel
  {
    JTextArea jtext;
    JLabel jlabel1;
    JLabel jlabel2;
    JLabel jlabel3, jlabel4, jlabel5, jlabel6, jlabel7, jlabel8;
    JLabel jlabelImg;
    JButton btn3,btn4;
    JPanel tPanel;
    int team1Num = 0;
    int team2Num = 0;
    private JButton startButton, buttonPlay, introButton; 
    private JTextArea t1, howToPlayDescription;
    String sent = "\t\t              Press Start";
    Font headerFont = new Font("Serif", Font.BOLD, 35);
    Font descriptionFont = new Font("Serif", Font.PLAIN, 20);
    Font introDescriptionFont = new Font("Arial", Font.PLAIN, 5);
    private JCheckBox checkBox1, checkBox2, checkBox3; 
    private JLabel introDescription;
    CardLayout cardLayout1 = new CardLayout();

    public Practice() 
    {
        mainMenu();
    }
    public void mainMenu()
    {
      //cardLayout1 = new CardLayout();
      //Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
      ImageIcon startPageBackground = new ImageIcon("frontPageBackground.jpg");
      mainPanel mp = new mainPanel();
      GamePanel gp = new GamePanel();
      setLayout(cardLayout1);
      add(mp , "Start Screen");
      add(gp, "Game Panel");
      //frontPage();
    }

    class mainPanel extends JPanel
    {
      mainPanel()
      {
        setLayout(null);
        JButton startButton = new JButton("Play");
        add(startButton);
        startButton.setBounds(0, 0, 150, 50);
        startButton.addActionListener(new sbuttonListener());

        JButton settingsButton = new JButton("Settings");
        add(settingsButton);
        settingsButton.setBounds(150, 0, 150, 50);

        JButton instructionsButton = new JButton("Instructions");
        add(instructionsButton);
        instructionsButton.setBounds(300, 0, 150, 50);
        setBackground(Color.PINK);
      }

      public void paintComponent(Graphics g)
      {
        super.paintComponent(g);
        //Image stickman = new ImageIcon("stickman.jpg").getImage();
        Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
        g.drawImage(startPageBackground, 0, 0, 900,900, null);

      }
    }

    class GamePanel extends JPanel
    {
      GamePanel()
      {
        setLayout(null);
        JButton startButton = new JButton("ready to play!");
        add(startButton);
        startButton.setBounds(50, 50, 150, 50);
        startButton.addActionListener(new sbuttonListener());

        introDescription = new JLabel();
        JLabel introHeader = new JLabel("<html>" + "Introduction" + "<br>" + "</html>");
        introHeader.setHorizontalAlignment(JLabel.CENTER);
      introDescription.setText("<html>"+"<body>"+ "<h1>" + "Introduction" + "</h1>" + "<p>" + "The US has been invaded by bots and needs your help. You have been recruited by the military." + "<br>" + "Each level, your goal is to destroy the bots and then you will be promoted a new role." + "<br>" + "For the first level, you will have to defeat the bot with your given weapon and watch out for" + "<br>" + "your health. When your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero." + "<br>" + "Once you win the first level, in the second level you will be able to access more weapons" + "<br>" + "and equipment and have more bots to shoot. In the last level, you will be promoted to a navy SEAL officer, so" + "<br>" + "you will have to be aware of health and oxygen levels. Swim up to the surface to regenerate your oxygen levels." + "</p>" + "</body>" + "</html>");
      introDescription.setHorizontalAlignment(JLabel.CENTER);
      introDescription.setPreferredSize(new Dimension (580, 450));
        add(introDescription);

        setBackground(Color.PINK);
      }

      public void paintComponent(Graphics g)
      {
        super.paintComponent(g);
        //Image stickman = new ImageIcon("stickman.jpg").getImage();
        Image startPageBackground = new ImageIcon("firstGame.jpg").getImage();
        g.drawImage(startPageBackground, 0, 0, 900,900, null);

      }
    }


    class sbuttonListener implements ActionListener
    {
      public void actionPerformed(ActionEvent e) {
        String sbutton = e.getActionCommand();

        if(sbutton.equalsIgnoreCase("Play"))
        {
          pc.cardLayout1.show(pc, "Game Panel");
          System.out.println("play button");
        }
      }
    }


    //Method for front page
    public void frontPage()
    {

      JPanel panel = new JPanel();   
      JPanel panel1 = new JPanel(new BorderLayout());
      JPanel panel2 = new JPanel(new BorderLayout());  
      JPanel panel3 = new JPanel();
      JPanel btnPanel = new JPanel(); 
      tPanel = new JPanel(); 
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
      //tPanel.add( jlabelImg );

      howToPlayDescription= new JTextArea();
      howToPlayDescription.setFont(headerFont);
      JLabel howToPlayHeader = new JLabel("<html>" + "How To Play" + "<br>" + "</html>");
      howToPlayHeader.setHorizontalAlignment(JLabel.CENTER);
      //Description for what keys to use
      howToPlayDescription.setFont(headerFont);
      howToPlayDescription.setText("First level:\nSpace bar = jump up\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot\n\nSecond level:\nSpace bar = rocket\n“w” key = shoot\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot "); 
      howToPlayDescription.setPreferredSize(new Dimension (400, 450));
      tPanel2.add( howToPlayDescription );   
      tPanel2.add( howToPlayHeader );  
      tPanel2.add(howToPlayHeader, BorderLayout.NORTH);

      introDescription = new JLabel();
      //introHeader.setFont(headerFont);
      JLabel introHeader = new JLabel("<html>" + "Introduction" + "<br>" + "</html>");
      introHeader.setHorizontalAlignment(JLabel.CENTER);
      //Introduction
      introDescription.setFont(introDescriptionFont);

      introDescription.setText("<html>"+"<body>"+ "<h1>" + "Introduction" + "</h1>" + "<p>" + "The US has been invaded by bots and needs your help. You have been recruited by the military." + "<br>" + "Each level, your goal is to destroy the bots and then you will be promoted a new role." + "<br>" + "For the first level, you will have to defeat the bot with your given weapon and watch out for" + "<br>" + "your health. When your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero." + "<br>" + "Once you win the first level, in the second level you will be able to access more weapons" + "<br>" + "and equipment and have more bots to shoot. In the last level, you will be promoted to a navy SEAL officer, so" + "<br>" + "you will have to be aware of health and oxygen levels. Swim up to the surface to regenerate your oxygen levels." + "</p>" + "</body>" + "</html>");
      introDescription.setHorizontalAlignment(JLabel.CENTER);
      introDescription.setPreferredSize(new Dimension (580, 450));
      bruh.add( introDescription );
      bruh.add( introHeader );  
      //bruh.add(introHeader, BorderLayout.NORTH);


      //Buttons and adding their action listeners
      startButton = new JButton("Start");
      //startListener b1 = new startListener();
      //startButton.addActionListener( b1 );
      //startButton.addActionListener(e -> cardLayout.next(panel));

      buttonPlay = new JButton("How To Play");
      //instructionListener b2 = new instructionListener();
      //buttonPlay.addActionListener( b2 );
      //buttonPlay.addActionListener(e -> cardLayout.next(panel));
      //playListener pl = new playListener();
      //buttonPlay.addActionListener( pl );

      introButton = new JButton("Introduction");
      //introListener b3 = new introListener();
      //introButton.addActionListener( b3 );

      btnPanel.add(startButton);
      btnPanel.add(buttonPlay);
      btnPanel.add(introButton);

      panel.add(panel1, "link1");
      panel.add(panel2, "link2");
      panel.add(panel3, "link3");

      startButton.addActionListener(e -> cardLayout.show(panel, "link2"));
      buttonPlay.addActionListener(e -> cardLayout.show(panel, "link2"));
      introButton.addActionListener(e -> cardLayout.show(panel, "link3"));

      //add(btn3);
      //add(btn4);
      //add(btn5);

      panel1.add(tPanel, BorderLayout.SOUTH);
      add(btnPanel, BorderLayout.NORTH); //panel1.add(btnPanel, BorderLayout.CENTER);
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
        //frontPageBackground(g);
        //frame.getContentPane().add(kDimLightLabel);
        tPanel.remove(t1);//remove component
        tPanel.add( jlabelImg );
        repaint();
      }
    }
    //Listener for "how to play"
    class playListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        //sent = "How to play listner";
        //t1.setText("\n\n\n                     " + sent);
        sent = "First level:\nSpace bar = jump up\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot\n\nSecond level:\nSpace bar = rocket\n“w” key = shoot\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot ";

        tPanel.remove(jlabelImg);//remove component
        tPanel.add( t1 );

        t1.setText(sent);
        repaint();
      }
    }
    //Listener for "introduction"
    class introListener implements ActionListener
    {
      public void actionPerformed(ActionEvent e) 
      {
        sent = "The US has been invaded by bots and needs your help. You have been recruited by the military.\nEach level, your goal is to destroy the bots and then you will be promoted a new role.\nFor the first level, you will have to defeat the bot with your given weapon and watch out for\nyour health. When your health bar reaches zero, you lose; so shoot the bot until it’s health bar\nis zero. Once you win the first level, in the second level you will be able to access more\nweapons and equipment and have more bots to shoot. In the last level, you will be promoted\nto a navy SEAL officer, so you will have to be aware of health and oxygen levels. Swim up to\nthe surface to regenerate your oxygen levels.";
        tPanel.remove(jlabelImg);//remove component
        tPanel.add( t1 );

        t1.setText(sent);
        repaint();
      }
    }
  }
}
