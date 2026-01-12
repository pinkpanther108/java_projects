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
import java.time.*;
import java.time.temporal.ChronoUnit;
import javax.swing.Timer;
//Main class 
public class Patriots extends JFrame {
  //Main method
  Practice pc = new Practice();   
  public static void main(String[] args) {
    Patriots p = new Patriots();
  }  
  //Main constructor
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
    //Class for the Menu button includes the "exit" button
    class exitAction implements ActionListener {
      //Closes the frame when performed
      public void actionPerformed (ActionEvent e) {
        System.exit(0);
      }
    }
    exit.addActionListener(new exitAction());

    setContentPane( pc );  // OR frame.getContentPane().add(p_in);
    setVisible(true);  
  }


  //Practice class contains all the panels, cardlayout, and declared variables
  class Practice extends JPanel {
    int[] xp = {0,0,0,0,0,0,0,0,0,0};
    int[] yp = {0,0,0,0,0,0,0,0,0,0};
    int[] xp2 = {0,0,0,0,0,0,0,0,0,0};
    int[] yp2 = {0,0,0,0,0,0,0,0,0,0};
    int key = 0;
    boolean key_flag = false;
    boolean spacebar_key_flag = false;
    JPanel tPanel;
    int team1Num = 0;
    int team2Num = 0;
    private JButton startButton, buttonPlay, introButton; 
    private JTextArea t1, howToPlayDescription;
    private JCheckBox checkBox1, checkBox2, checkBox3; 
    private JLabel introDescription;
    CardLayout cardLayout1 = new CardLayout();
    Instant time_now = Instant.now();
    Instant start_time = Instant.now();
    Instant timesoldier_on_ground = Instant.now();
    Instant robot_on_move = Instant.now();
    Instant timerobot_on_ground = Instant.now();
    int robot_top_level = 250;
    int soldier_top_level = 50;
    int ground_level = 430;
    int robot_height = ground_level;
    int soldier_height = ground_level;
    boolean robot_goup = true;
    boolean solddier_goup = true;
    int robot_bullets = 10;
    int soldier_bullets = 10;
    Instant robot_bullets_time = Instant.now();
    Instant soldier_bullets_time = Instant.now();
    boolean gameove = false;
    int tm = 0;
    Instant equip_time = Instant.now();
    int equip_count = 0;
    int equip_points = 30;
    int points = 0;
	//Practice constructor calls mainMenu method 
    public Practice() {
      mainMenu();
    }
    //Method has the JButtons and set Listeners and added panels
    public void mainMenu() {
      mainPanel mp = new mainPanel();
      GamePanel gp = new GamePanel();
      gp.addKeyListener(new MKeyListener());
      gp.setFocusable(true);
      gp.requestFocusInWindow();
      JButton shield = new JButton("Equip");
      shield.addActionListener(new sbuttonListener());
      setLayout(null);
      gp.add(shield);
      shield.setBounds(0, 100, 50, 100);
      Settings setting = new Settings();
      Instructions instruction = new Instructions();
      setLayout(cardLayout1);
      add(mp , "Start Screen");
      add(gp, "Game Panel");
      add(setting, "Settings Panel");
      add(instruction, "Instructions Panel");
    }
	//Class for the main page containing all the grpahics and content
    class mainPanel extends JPanel {
      //The main panel method's constructor containing the main JButtons and their set listeners 
      mainPanel() {
        setLayout(null);
        JButton startButton = new JButton("Play");
        startButton.setFont(new Font("Anklepants", Font.BOLD, 30)); //Airacobra Alt
        add(startButton);
        startButton.setBounds(300, 200, 300, 100);
        startButton.addActionListener(new sbuttonListener());

        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Anklepants", Font.BOLD, 30));
        add(settingsButton);
        settingsButton.setBounds(300, 350, 300, 100);
        settingsButton.addActionListener(new sbuttonListener());

        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(new Font("Anklepants", Font.BOLD, 30));
        add(instructionsButton);
        instructionsButton.setBounds(300, 500, 300, 100);
        instructionsButton.addActionListener(new sbuttonListener());

      }
	  //Graphics method for the main panel has the background image
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image startPageBackground = new ImageIcon("galaxy.gif").getImage(); //Source: //Source: https://giphy.com/gifs/trippy-weird-psychedelic-3ov9k1173PdfJWRsoE
        g.drawImage(startPageBackground, 0, 0, 900,900, null);
		repaint();
      }
    }
	//Class for the game panel includes all the content for the game
    class GamePanel extends JPanel {
      int speed = 3;
      //Constructor for the game panel class includes time and actions
      GamePanel() {
      }

      /*
         secondLevel sl = new secondLevel();
         sl.addKeyListener(new MKeyListener());
         sl.setFocusable(true);
         sl.requestFocusInWindow();
         Cardlayout cardlayout2 = new CardLayout();
         setLayout(cardLayout2);
         add(sl , "Second Level Panel");
         */

      public int get_robot_height(int h) {
        long delta = Duration.between(timerobot_on_ground, Instant.now()).toMillis();
        if (h > 430 && delta < 5000 + (int)(Math.random()*10000)) {
          robot_on_move = Instant.now();
          return h;
        }
        long delta2 = Duration.between(robot_on_move, Instant.now()).toNanos();
        if (delta2 > 5000) {
          robot_on_move = Instant.now();
          if (robot_goup == true) {
            if (h-- < robot_top_level) {
              robot_goup = false;
            }
          } else {
            if (h++ >= ground_level) {
              robot_goup = true;
              timerobot_on_ground = Instant.now();
            }
          }
        }
        return h;
      }

      public int get_soldier_height(int h) {

        if (spacebar_key_flag == false) {
          timesoldier_on_ground = Instant.now();
          return h;
        }
        long delta = Duration.between(timesoldier_on_ground, Instant.now()).toNanos();
        if (delta > 5000) {
          timesoldier_on_ground = Instant.now();
          if (solddier_goup == true) {
            if (h-- <= soldier_top_level) {
              solddier_goup = false;
            }
          } else {
            if (h++ >= ground_level) {
              solddier_goup = true;
              spacebar_key_flag = false;
            }
          }
        }
        return h;
      }
	  //Game panel's graphic method includes the background, characters, additional images, and sets the key's listeners and movement for the characters
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameove) {
          tm = (int)Duration.between(start_time, Instant.now()).getSeconds();
        }
        Image back = new ImageIcon("firstGame.jpg").getImage();
        g.drawImage(back, 0, 0, 900,900, null);

        robot_height = get_robot_height(robot_height);
        Image robot1 = new ImageIcon("robot.png").getImage();
        g.drawImage(robot1, 700, robot_height, 170,400, null);

        soldier_height = get_soldier_height(soldier_height);
        long delta = Duration.between(time_now, Instant.now()).toMillis();
        if (key == 'w' && delta < 2000) {
          Image user2 = new ImageIcon("soldier1og.png").getImage();
          g.drawImage(user2, 100, soldier_height, 250,400, null);
        } else {
          Image user = new ImageIcon("soldier1reg.png").getImage();
          g.drawImage(user, 100, soldier_height, 160,400, null);
        }
        Image coin = new ImageIcon("token4.gif").getImage(); //Source: https://pt.picmix.com/stamp/gold-coin-gif-1456107
        g.drawImage(coin, 15, 20, 50,50, null);
        Image userLife = new ImageIcon("heart.png").getImage(); //Source: https://pluspng.com/heart-png-hd-transparent-background-7155.html
        g.drawImage(userLife, 200, soldier_height-71, 50,50, null);
        Image botLife = new ImageIcon("heart.png").getImage();  //Source: https://pluspng.com/heart-png-hd-transparent-background-7155.html
        g.drawImage(botLife, 800, robot_height-75, 50,50, null);
        setFont(new Font("Airacobra", Font.BOLD, 30));

        if (tm >=  equip_count*equip_points) {
          points = tm - equip_count * equip_points;
        }
        g.drawString(String.valueOf(points),70,57);

        if (soldier_bullets > 0) {
          if ((int)Duration.between(soldier_bullets_time, Instant.now()).toMillis() > 900) {
            g.drawString(String.valueOf(soldier_bullets),750,robot_height-40);
          }
        } else {
          g.drawString("You win the game",750,robot_height-40);
          if (!gameove) {
            gameove = true;
            g.setColor(Color.RED);
            for (int i=0; i<10000; i++) {
              Toolkit.getDefaultToolkit().beep();
            }
          }
        }

        if (robot_bullets > 0) {
          if ((int)Duration.between(robot_bullets_time, Instant.now()).toMillis() > 900) {
            g.drawString(String.valueOf(robot_bullets),150,soldier_height-36);
          }
        } else {
          g.drawString("You lost the game",150,soldier_height-36);
          if (!gameove) {
            gameove = true;
            g.setColor(Color.RED);
            for (int i=0; i<10000; i++) {
              Toolkit.getDefaultToolkit().beep();
            }
          }
        }

        grabFocus();

        for(int i=0; i<xp.length; i++) {
          if (xp[i] != 0) {
            // add one position for every refresh
            if (xp[i]++ > 60000) {
              xp[i] = 0;
            }
          }
          if (xp2[i] != 0) {
            // add one position for every refresh
            if (xp2[i]++ > 60000) {
              xp2[i] = 0;
            }
          }
        }

        if (key == 'w') {
          if (key_flag == true) {
            key_flag = false;
            for(int i=0; i<xp.length; i++) {
              if (xp[i] == 0) {
                xp[i] = 900;
                yp[i] = soldier_height + 50;
                if (Math.abs(soldier_height - robot_height) < 100) {
                  soldier_bullets--;
                  soldier_bullets_time = Instant.now();
                  break;
                }
              }
            }
          }
        }

        for(int i=0; i<xp2.length; i++) {
          int r = (int)(Math.random()*100000);
          if (r == 1) {
            if (xp2[i] == 0) {
              xp2[i] = 5100;
              yp2[i] = robot_height;
              if (Math.abs(soldier_height - robot_height) < 5) {
                if ((int)Duration.between(equip_time, Instant.now()).getSeconds() > 5) {
                  if (Math.abs(soldier_height - robot_height) < 100) {
                    robot_bullets--;
                    robot_bullets_time = Instant.now();
                  }
                }
              }
              break;
            }
          }
        }	
        //if (equip_time>30) {
        if (tm > 30) {
          if ((int)Duration.between(equip_time, Instant.now()).getSeconds() <5) {
            Image shields = new ImageIcon("shield.png").getImage(); //Source: https://www.etsy.com/listing/827669417/medieval-knight-black-heater-shield
            g.drawImage(shields, 240, 440, 100,200, null);
          }
        }
        //}


        for (int w=0; w<xp.length; w++) {
          if (xp[w] !=0) {
            Image bullet = new ImageIcon("bullet.png").getImage();
            g.drawImage(bullet, xp[w]/speed, yp[w], 35,25, null);
          }
        }

        // try from the enemy
        for (int w=0; w<xp2.length; w++) {
          if (xp2[w] !=0) {
            Image bullet = new ImageIcon("bullet2.png").getImage();
            //g.drawImage(bullet, (20000-xp2[w])/speed, 440, 35,25, null);
            g.drawImage(bullet, (7200-xp2[w])/speed, yp2[w], 35,25, null);
          }
        }

        repaint();
        //The second level 
        /*if (gameove==false) {
          CardLayout cl2 = new CardLayout();
          setLayout(cl2);
          JLabel nextLevel = new JLabel("Level 2");
          add(nextLevel);
          nextLevel.setFont(new Font("Airacobra", Font.BOLD, 30));
          nextLevel.setBounds(50, 50, 50, 50);
        //nextLevel.addActionListener(new sbuttonListener2());
        } 
        if (gameove==true){
        CardLayout cl2 = new CardLayout();
        setLayout(cl2);
        JButton nextLevel = new JButton("Level 2");
        add(nextLevel);
        nextLevel.setFont(new Font("Airacobra", Font.BOLD, 30));
        nextLevel.setBounds(50, 50, 50, 50);
        //nextLevel.addActionListener(new sbuttonListener2());
        }*/

      }
    }


	//Class for the second level's panel
    class secondLevel extends JPanel {
      secondLevel() {
        setLayout(null);

      }
	  //Graphics for the second level's panel
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.MAGENTA);

      }
    }

	//Class for the settings panel includes the text and content and text on how to play
    class Settings extends JPanel {
      //how to play panel's constructor
      Settings() { 
        JLabel settingsHeader = new JLabel("<html>" + "How To Play" + "<br>" + "</html>");
        settingsHeader.setFont(new Font("Osake", Font.BOLD, 55)); //Aspastic
        settingsHeader.setHorizontalAlignment(JLabel.CENTER);

        JTextArea settingsDescription = new JTextArea();
        settingsDescription.setText("\n\nFirst level:\nSpace bar = jump up\n“w” key = shoot\n\"q\" key = quit\n\nSecond level:\nSpace bar = jump up\n“w” key = shoot\n\"q\" key = quit\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot "); 
        settingsDescription.setFont(new Font("BaccaratUpright", Font.PLAIN, 26));
        //settingsDescription.setHorizontalAlignment(JLabel.CENTER);
        settingsDescription.setPreferredSize(new Dimension (700, 700));
        settingsDescription.setBounds(50, 50, 250, 150);
        settingsDescription.setBackground(new Color(51,204,255));
        add(settingsHeader, BorderLayout.NORTH);
        add(settingsDescription, BorderLayout.SOUTH);

        setBackground(new Color(51,204,255));

        JButton previousButton = new JButton("Back");
        previousButton.setBounds(80, 400, 80, 50);
        previousButton.setFont(new Font("Aspastic", Font.BOLD, 30));
        add(previousButton);
        previousButton.addActionListener(new sbuttonListener());

      }
	  //Graphics for the setting's panel
      public void paintComponent(Graphics g) {
        super.paintComponent(g);

      }
    }
	//Class for the instructions panel includes the text and content for introducing the game
    class Instructions extends JPanel {
      //Instruction panel constructor
      Instructions() { 
        JLabel introHeader = new JLabel("<html>" + "Introduction" + "<br>" + "</html>");
        introHeader.setFont(new Font("Osake", Font.BOLD, 50));
        introHeader.setHorizontalAlignment(JLabel.CENTER);
        
        introDescription = new JTextArea();
        introDescription.setText("\n\nThe US has been invaded by bots and needs your help.\nYou have been recruited by the military. Each level,\nyour goal is to destroy the bots and then you will be\npromoted a new role. For the first level, you will\nhave to defeat the bot with your given weapon and\nwatch out for your health. When your health bar\nreaches zero, you lose; so shoot the bot until it’s\nhealth bar zero.Once you win the first level, in the\nsecond level you will be able to access more\nweapons and equipment and have more bots to shoot.\nIn the last level, you will be promoted to a navy SEAL officer, so you will have to be aware of\nhealth and oxygen levels. Swim up to the surface to\nregenerate your oxygen levels.");
        introDescription.setFont(new Font("BaccaratUpright", Font.PLAIN, 26));
        //introDescription.setHorizontalAlignment(JLabel.CENTER);
        introDescription.setPreferredSize(new Dimension (700, 700));
        introDescription.setBounds(50, 50, 700, 700);
        introDescription.setBackground(new Color(255,102,102));
        introDescription.setPreferredSize(new Dimension (700, 700));
        //add (introHeader, BorderLayout.NORTH);
        //add(introDescription, BorderLayout.NORTH);
        add (introHeader);
        add(introDescription);
        setBackground(new Color(255,102,102));

        //setLayout(null);
        JButton previousButton = new JButton("Back");
        previousButton.setFont(new Font("Aspastic", Font.BOLD, 30));
        add(previousButton);
        previousButton.setBounds(70, 800, 80, 50);
        previousButton.addActionListener(new sbuttonListener());

      }
	  //Graphics for the instruction's panel
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
      }
    }
	//Class for JButton listener. It listens to what JButton is clicked and what panel to display afterwards.
    class sbuttonListener implements ActionListener {
      //Action performed for JButtons method
      public void actionPerformed(ActionEvent e) {
        String sbutton = e.getActionCommand();
        if(sbutton.equalsIgnoreCase("Play")) {
          pc.cardLayout1.show(pc, "Game Panel");
        } else if(sbutton.equalsIgnoreCase("Settings")) {
          pc.cardLayout1.show(pc, "Settings Panel");
        } else  if(sbutton.equalsIgnoreCase("Instructions")) {
          pc.cardLayout1.show(pc, "Instructions Panel");
        } else  if(sbutton.equalsIgnoreCase("Back")) {
          pc.cardLayout1.show(pc, "Start Screen");
        } else  if(sbutton.equalsIgnoreCase("Equip")) {
          if ((int)Duration.between(equip_time, Instant.now()).getSeconds() > 30) {
            equip_time = Instant.now();
            equip_count++;
          }
        }
      }
    }

    /*class sbuttonListener2 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
      String sbutton2 = e.getActionCommand();
      System.out.println("we are in sbuttonListener2");

      if(sbutton2.equalsIgnoreCase("Level2")) {
      pc.cardLayout1.show(pc, "Second Level Panel");
      System.out.println("second level button");
      }  
      }
      }*/

	//Class for the key listeners. Listens to which key is clicked by the user and performs the appropriate actions for that key.
    class MKeyListener extends KeyAdapter {
      @Override
      //Method for key actions
      public void keyPressed(KeyEvent event) {
        key = event.getKeyChar();
        if (key == 'q') {
          System.out.println("game ends");
          System.exit(0);
        }
        if (key == 'w') {
          key_flag = true;
          time_now = Instant.now();
        }
        if (key == ' ') {
          spacebar_key_flag = true;
        }
      }
    }
  }
}
