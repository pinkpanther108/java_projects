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
    Font headerFont = new Font("Serif", Font.BOLD, 35);
    Font descriptionFont = new Font("Serif", Font.PLAIN, 20);
    Font introDescriptionFont = new Font("Arial", Font.PLAIN, 5);
    private JCheckBox checkBox1, checkBox2, checkBox3; 
    private JLabel introDescription;
    CardLayout cardLayout1 = new CardLayout();
    Instant time_now = Instant.now();
    Instant start_time = Instant.now();
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
    boolean gameove = false;
    int tm = 0;
    Instant equip_time = Instant.now();
    int equip_count = 0;
    int equip_points = 30;
    int points = 0;

    public Practice() {
      mainMenu();
    }
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

    class mainPanel extends JPanel {
      mainPanel() {
        //pan p = new pan();

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
        Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage(); //Source: https://coolvibe.com/2010/last-fight/
        g.drawImage(startPageBackground, 0, 0, 900,900, null);



        /*  
            ImageIcon startPageBackground = new ImageIcon("frontPageBackground.jpg");
            Image defImage = startPageBackground.getImage();
            Image ndefimg = defImage.getScaledInstance(900,900, Image.SCALE_SMOOTH);
            startPageBackground = new ImageIcon(ndefimg);
            JLabel defend = new JLabel(startPageBackground);
        //mp.add(p);
        add(defend);
        */    


      }
    }

    class GamePanel extends JPanel {
      int speed = 3;
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
          return h;
        }
        int r = (int)(Math.random()*5);
        if (r == 1) {
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
          return h;
        }
        int r = (int)(Math.random()*5);
        if (r == 1) {
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
        Image userLife = new ImageIcon("heart.png").getImage();         //Source: https://pluspng.com/heart-png-hd-transparent-background-7155.html
        g.drawImage(userLife, 200, soldier_height-71, 50,50, null);
        Image botLife = new ImageIcon("heart.png").getImage();  //Source: https://pluspng.com/heart-png-hd-transparent-background-7155.html
        g.drawImage(botLife, 800, robot_height-75, 50,50, null);
        setFont(new Font("Airacobra", Font.BOLD, 30));

        if (tm >=  equip_count*equip_points) {
          points = tm - equip_count * equip_points;
        }
        g.drawString(String.valueOf(points),70,57);

        if (soldier_bullets > 0) {
          g.drawString(String.valueOf(soldier_bullets),750,robot_height-40);
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
          g.drawString(String.valueOf(robot_bullets),150,soldier_height-36);
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
                soldier_bullets--;
                break;
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
                  robot_bullets--;
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



    class secondLevel extends JPanel {
      secondLevel() {
        setLayout(null);

      }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.MAGENTA);

      }
    }


    class Settings extends JPanel {
      Settings() { //how to play panel
        JLabel settingsHeader = new JLabel("<html>" + "How To Play" + "<br>" + "</html>");
        settingsHeader.setFont(new Font("Airacobra", Font.BOLD, 50));
        settingsHeader.setHorizontalAlignment(JLabel.CENTER);


        JTextArea settingsDescription = new JTextArea();
        settingsDescription.setText("\n\nFirst level:\nSpace bar = jump up\n“w” key = shoot\n\"q\" key = quit\n\nSecond level:\nSpace bar = jump up\n“w” key = shoot\n\"q\" key = quit\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot "); 
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
        introDescription.setText("<html>"+"The US has been invaded by bots and needs your help. You have been recruited by the military." + "<br>" + "Each level, your goal is to destroy the bots and then you will be promoted a new role." + "<br>" + "For the first level, you will have to defeat the bot with your given weapon and watch out for your health. When your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero." + "<br>" + "Once you win the first level, in the second level you will be able to access more weapons and equipment and have more bots to shoot." + "<br>" + " In the last level, you will be promoted to a navy SEAL officer, so you will have to be aware of health and oxygen levels. Swim up to the surface to regenerate your oxygen levels." + "</html>");
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
        //System.out.println("we are in sbuttonListener");

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


    class MKeyListener extends KeyAdapter {
      @Override
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
