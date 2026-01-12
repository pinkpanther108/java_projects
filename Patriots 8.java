/*Sudipti Dantuluri
 * 4.12.2022
 * Patriots.java
 * Final game project.*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Patriots extends JFrame {
  //Main method
  Practice pc = new Practice();   
  public static void main(String[] args) {
    Patriots p = new Patriots();
  }  
  public Patriots() {
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
  class Practice extends JPanel {
    int key = 0;
    int key_pos = 0;
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

    public Practice() {
        mainMenu();
    }
    public void mainMenu() {
      //cardLayout1 = new CardLayout();
      //Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
     //ImageIcon startPageBackground = new ImageIcon("frontPageBackground.jpg");
      
      
            //ImageIcon sword = new ImageIcon("frontPageBackground.jpg");
     // Image swrdimg = sword.getImage();
     // Image nimg = swrdimg.getScaledInstance(900,900, Image.SCALE_SMOOTH);
     // sword = new ImageIcon(nimg);
   // JLabel swrdB = new JLabel(sword);
      
      
      
      mainPanel mp = new mainPanel();
      GamePanel gp = new GamePanel();
      gp.addKeyListener(new MKeyListener());
      gp.setFocusable(true);
      gp.requestFocusInWindow();
      Settings setting = new Settings();
      Instructions instruction = new Instructions();
      setLayout(cardLayout1);
      add(mp , "Start Screen");
      add(gp, "Game Panel");
      add(setting, "Settings Panel");
      add(instruction, "Instructions Panel");
    }

    class mainPanel extends JPanel {
      mainPanel() {
        setLayout(null);
        JButton startButton = new JButton("Play");
        startButton.setFont(new Font("Airacobra", Font.BOLD, 30));
        add(startButton);
        startButton.setBounds(300, 200, 300, 100);
        startButton.addActionListener(new sbuttonListener());

        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Airacobra", Font.BOLD, 30));
        add(settingsButton);
        settingsButton.setBounds(300, 350, 300, 100);
        settingsButton.addActionListener(new sbuttonListener());

        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(new Font("Airacobra", Font.BOLD, 30));
        add(instructionsButton);
        instructionsButton.setBounds(300, 500, 300, 100);
        instructionsButton.addActionListener(new sbuttonListener());
      }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Image stickman = new ImageIcon("stickman.jpg").getImage();
        Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
        g.drawImage(startPageBackground, 0, 0, 900,900, null);

      }
    }

    class GamePanel extends JPanel {
      GamePanel() {
      }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Image stickman = new ImageIcon("stickman.jpg").getImage();
        //Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
        //g.drawImage(startPageBackground, 0, 0, 900,900, null);
        Image back = new ImageIcon("firstGame.jpg").getImage();
        g.drawImage(back, 0, 0, 900,900, null);
        Image robot1 = new ImageIcon("robot.png").getImage();
        g.drawImage(robot1, 700, 430, 170,400, null);
        Image user = new ImageIcon("soldier1reg.png").getImage();
        g.drawImage(user, 100, 430, 160,400, null);

        System.out.println(key);
        if (key == 'w') {
          Image bullet = new ImageIcon("bullet.png").getImage();
          g.drawImage(bullet, key_pos/10, 530, 160,400, null);
          key_pos++;
          if (key_pos > 6000) {
            key_pos = 0;
          }
        }

        repaint();
      }
    }

    class Settings extends JPanel {
      Settings() { //how to play panel
        JLabel settingsHeader = new JLabel("<html>" + "How To Play" + "<br>" + "</html>");
        settingsHeader.setFont(new Font("Airacobra", Font.BOLD, 50));
        settingsHeader.setHorizontalAlignment(JLabel.CENTER);
        
        
        JTextArea settingsDescription = new JTextArea();
        settingsDescription.setText("\n\nFirst level:\nSpace bar = jump up\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot\n\nSecond level:\nSpace bar = rocket\n“w” key = shoot\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot "); 
      	settingsDescription.setFont(new Font("Airacobra", Font.PLAIN, 15));
      	//settingsDescription.setHorizontalAlignment(JLabel.CENTER);
      	settingsDescription.setPreferredSize(new Dimension (580, 450));
        settingsDescription.setBounds(50, 50, 250, 150);
    	settingsDescription.setBackground(new Color(51,204,255));
        add(settingsHeader, BorderLayout.NORTH);
      	add(settingsDescription, BorderLayout.SOUTH);

      setBackground(new Color(51,204,255));
      
      JButton previousButton = new JButton("Back");
      //previousButton.setFont(new Font("Airacobra", Font.BOLD, 30));
      add(previousButton, BorderLayout.SOUTH);
      previousButton.setBounds(80, 800, 80, 50);
      previousButton.addActionListener(new sbuttonListener());
      
      }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Image stickman = new ImageIcon("stickman.jpg").getImage();
        //Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
        //g.drawImage(startPageBackground, 0, 0, 900,900, null);

      }
    }

    class Instructions extends JPanel {
      Instructions() { //intro panel
        JLabel introHeader = new JLabel("<html>" + "Introduction" + "<br>" + "</html>");
        introHeader.setFont(new Font("Airacobra", Font.BOLD, 50));
        introHeader.setHorizontalAlignment(JLabel.CENTER);
        introDescription = new JLabel();
        introDescription.setText("<html>"+"The US has been invaded by bots and needs your help. You have been recruited by the military." + "<br>" + "Each level, your goal is to destroy the bots and then you will be promoted a new role." + "<br>" + "For the first level, you will have to defeat the bot with your given weapon and watch out for your health. When your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero." + "<br>" + "Once you win the first level, in the second level you will be able to access more weapons and equipment and have more bots to shoot. In the last level, you will be promoted to a navy SEAL officer, so you will have to be aware of health and oxygen levels. Swim up to the surface to regenerate your oxygen levels." + "</html>");
        introDescription.setFont(new Font("Airacobra", Font.PLAIN, 15));
        introDescription.setHorizontalAlignment(JLabel.CENTER);
        introDescription.setPreferredSize(new Dimension (580, 450));
        add (introHeader, BorderLayout.NORTH);
        add(introDescription, BorderLayout.NORTH);
		setBackground(new Color(255,102,102));
		
		//setLayout(null);
        JButton previousButton = new JButton("Back");
        //previousButton.setFont(new Font("Airacobra", Font.BOLD, 30));
        add(previousButton, BorderLayout.SOUTH);
        previousButton.setBounds(70, 800, 80, 50);
        previousButton.addActionListener(new sbuttonListener());
		
      }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Image stickman = new ImageIcon("stickman.jpg").getImage();
        //Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
        //g.drawImage(startPageBackground, 0, 0, 900,900, null);

      }
    }

    class sbuttonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        String sbutton = e.getActionCommand();
        System.out.println("we are in sbuttonListener");

        if(sbutton.equalsIgnoreCase("Play")) {
          pc.cardLayout1.show(pc, "Game Panel");
          System.out.println("play button");
        } else if(sbutton.equalsIgnoreCase("Settings")) {
          pc.cardLayout1.show(pc, "Settings Panel");
          System.out.println("Settings button");
        } else  if(sbutton.equalsIgnoreCase("Instructions")) {
          pc.cardLayout1.show(pc, "Instructions Panel");
          System.out.println("Instructions button");
        } else  if(sbutton.equalsIgnoreCase("Back")) {
          pc.cardLayout1.show(pc, "Start Screen");
          System.out.println("previous button");
        }
      }
    }

    class MKeyListener extends KeyAdapter {
      @Override
      public void keyPressed(KeyEvent event) {
        System.out.println("key pressed are in sbuttonListener " + event.getKeyChar());
        key = event.getKeyChar();
        char ch = event.getKeyChar();
        if (ch == 'a' ||ch == 'b'||ch == 'c' ) {
          System.out.println(event.getKeyChar());
        }
        if (event.getKeyCode() == KeyEvent.VK_HOME) {
          System.out.println("Key codes: " + event.getKeyCode());
        }
      }
    }
  }
}
