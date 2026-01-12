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
    private JTextArea introDescription;
    CardLayout cardLayout1 = new CardLayout();
    Instant time_now = Instant.now();
    Instant start_time = Instant.now();
    Instant timesoldier_on_ground = Instant.now();
    Instant robot_on_move = Instant.now();
    Instant timerobot_on_ground = Instant.now();
    int robot_top_level = 50;
    int soldier_top_level = 50;
    int ground_level = 500;
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
    Instant robot_shield_time = Instant.now();
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
      GamePanel2 gp2 = new GamePanel2();
      GamePanel3 gp3 = new GamePanel3();
      GamePanelLevel2 level2 = new GamePanelLevel2();
      //antecedentIntroPanel beforePanel = new antecedentIntroPanel();
      gp.addKeyListener(new MKeyListener());
      level2.addKeyListener(new MKeyListener_level2());
      gp.setFocusable(true);
      level2.setFocusable(true);
      mp.setFocusable(true);
      gp.requestFocusInWindow();
      level2.requestFocusInWindow();
      JButton shield = new JButton("Equip");
      shield.addActionListener(new sbuttonListener());
      gp.add(shield);
      shield.setBounds(0, 100, 50, 100);     




      JButton btn = new JButton("button");
      btn.addActionListener(new sbuttonListener());
      gp.add(btn);
      btn.setBounds(0, 100, 50, 100);
      JButton btn2 = new JButton("button2");
      btn2.addActionListener(new sbuttonListener());
      gp.add(btn2);
      btn2.setBounds(0, 100, 50, 100);






      Settings setting = new Settings();
      Instructions instruction = new Instructions();
      setLayout(cardLayout1);
      add(mp , "Start Screen");
      add(gp, "Game Panel");
      add(setting, "Settings Panel");
      add(instruction, "Instructions Panel");
      add(gp2, "Game Panel 2");
      add(gp3, "Game Panel 3");
      add(level2, "Level2");
      //add(beforePanel, "beforePlay");


      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Image image = toolkit.getImage("cursor2.png"); //Source: https://www.pngmart.com/image/26832
      Cursor c = toolkit.createCustomCursor(image , new Point(mp.getX(), 
            mp.getY()), "cursor2.png");
      mp.setCursor (c);

    }

    //Class for the main page containing all the graphics and content
    class mainPanel extends JPanel {
      Image startPageBackground;
      Icon design2;
      //The main panel method's constructor containing the main JButtons and their set listeners 
      mainPanel() {
        startPageBackground = new ImageIcon("galaxy.gif").getImage(); //Source: https://giphy.com/gifs/trippy-weird-psychedelic-3ov9k1173PdfJWRsoE
        setLayout(null);

        JLabel header = new JLabel("<html>" + "Patriots" + "<br>" + "</html>");
        header.setFont(new Font("Osake", Font.BOLD, 50));
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setForeground(Color.WHITE);
        add(header);

        JButton startButton = new JButton("Play");
        startButton.setLayout(null);
        //startButton.setOpaque(false);
        startButton.setFont(new Font("Anklepants", Font.BOLD, 30)); //Airacobra Alt
        startButton.setBounds(300, 200, 300, 100);
        startButton.setForeground(Color.GRAY);
        startButton.addActionListener(new sbuttonListener());
        //Mouse listener for the start button; gets the foreground color
        startButton.addMouseListener(new MouseAdapter() {
          Color color = startButton.getForeground();
          //When mouse enters, the button changes color
          public void mouseEntered(MouseEvent me) {
            //startButton.setOpaque(true);
            color = startButton.getForeground();
            startButton.setForeground(new Color(204,0,0)); 
            startButton.setBounds(279, 180, 340, 135);
            //startButton.setBackground(new Color(217,217,214));
          }
          //When the mouse exits, the mouse returns to the original color
          public void mouseExited(MouseEvent me) {
            startButton.setForeground(color);
            startButton.setBounds(300, 200, 300, 100);
            //startButton.setOpaque(false);
          }
        });
        add(startButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Anklepants", Font.BOLD, 30));
        settingsButton.setForeground(Color.GRAY);
        add(settingsButton);
        settingsButton.setBounds(300, 350, 300, 100);
        settingsButton.addActionListener(new sbuttonListener());
        //Mouse listener for the settings button; gets the foreground color
        settingsButton.addMouseListener(new MouseAdapter() {
          Color color = settingsButton.getForeground();
          //When mouse enters, the button changes color
          public void mouseEntered(MouseEvent me) {
            color = settingsButton.getForeground();
            settingsButton.setForeground(new Color(204,0,0)); 
            settingsButton.setBounds(279, 330, 340, 135);
          }
          //When the mouse exits, the mouse returns to the original color
          public void mouseExited(MouseEvent me) {
            settingsButton.setForeground(color);
            settingsButton.setBounds(300, 350, 300, 100);
          }
        });
        add(settingsButton);

        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(new Font("Anklepants", Font.BOLD, 30));
        instructionsButton.setForeground(Color.GRAY);
        add(instructionsButton);
        instructionsButton.setBounds(300, 500, 300, 100);
        instructionsButton.addActionListener(new sbuttonListener());
        //Mouse listener for the instructions button; gets the foreground color
        instructionsButton.addMouseListener(new MouseAdapter() {
          Color color = instructionsButton.getForeground();
          //When mouse enters, the button changes color
          public void mouseEntered(MouseEvent me) {
            color = instructionsButton.getForeground();
            instructionsButton.setForeground(new Color(204,0,0)); 
            instructionsButton.setBounds(279, 480, 340, 135);
          }
          //When the mouse exits, the mouse returns to the original color
          public void mouseExited(MouseEvent me) {
            instructionsButton.setForeground(color);
            instructionsButton.setBounds(300, 500, 300, 100);
          }
        });
        add(instructionsButton);

      }
      //Graphics method for the main panel has the background image
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(startPageBackground, 0, 0, 900,900, null);
        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.setIcon(design2);
        repaint();
      }
    }
    //Class for the game panel includes all the content for the game
    class GamePanel extends JPanel {
      int speed = 3;
      Image soldier1reg;
      Image soldier1reg_flat;
      Image back;
      Image robot1;
      Image soldier1og;
      Image coin;
      Image userLife;
      Image botLife;
      Image shields;
      Image shields2;
      Image bullet;
      Image bullet2;
      Image blood4;
      //Constructor for the game panel class includes time and actions
      GamePanel() {
        soldier1reg = new ImageIcon("soldier1reg.png").getImage();
        soldier1reg_flat = new ImageIcon("soldier1reg_flat.png").getImage();
        back = new ImageIcon("firstGame.jpg").getImage();
        robot1 = new ImageIcon("robot.png").getImage();
        soldier1og = new ImageIcon("soldier1og.png").getImage();
        coin = new ImageIcon("token4.gif").getImage(); //Source: https://pt.picmix.com/stamp/gold-coin-gif-1456107
        userLife = new ImageIcon("heart.png").getImage(); //Source: https://pluspng.com/heart-png-hd-transparent-background-7155.html
        botLife = new ImageIcon("heart.png").getImage();  //Source: https://pluspng.com/heart-png-hd-transparent-background-7155.html
        shields = new ImageIcon("shield.png").getImage(); //Source: https://www.etsy.com/listing/827669417/medieval-knight-black-heater-shield
        shields2 = new ImageIcon("shield2.png").getImage(); //Source: https://www.etsy.com/listing/827669417/medieval-knight-black-heater-shield
        bullet = new ImageIcon("bullet.png").getImage();
        bullet2 = new ImageIcon("bullet2.png").getImage();
        blood4 = new ImageIcon("blood4.png").getImage(); //Source: https://tenor.com/view/naruto-run-peepo-pepe-frog-runners-fast-gif-17319616
      }
      //Get robot height
      public int get_robot_height(int height) {
        //for (int i=0; i<100000; i++) System.nanoTime();
        long delta = Duration.between(timerobot_on_ground, Instant.now()).toMillis();
        if (height >= ground_level && delta < 5000 + (int)(Math.random()*10000)) {
          robot_on_move = Instant.now();
          return height;
        }
        long delta2 = Duration.between(robot_on_move, Instant.now()).toNanos();
        if (delta2 > 5000) {
          robot_on_move = Instant.now();
          if (robot_goup == true) {
            if (height-- < robot_top_level) {
              robot_goup = false;
            }
          } else {
            if (height++ >= ground_level) {
              robot_goup = true;
              timerobot_on_ground = Instant.now();
            }
          }
        }
        return height;
      }
      //Get soldier height
      public int get_soldier_height(int height) {
        if (spacebar_key_flag == false) {
          timesoldier_on_ground = Instant.now();
          return height;
        }
        long delta = Duration.between(timesoldier_on_ground, Instant.now()).toNanos();
        if (delta > 5000) {
          timesoldier_on_ground = Instant.now();
          if (solddier_goup == true) {
            if (height-- <= soldier_top_level) {
              solddier_goup = false;
            }
          } else {
            if (height++ >= ground_level) {
              solddier_goup = true;
              spacebar_key_flag = false;
            }
          }
        }
        return height;
      }
      //Get shield
      public boolean turn_on_robot_shield() {
        if ((int)Duration.between(robot_shield_time, Instant.now()).getSeconds() > 5) {
          if ((int)Duration.between(robot_shield_time, Instant.now()).getSeconds() > 9) {
            robot_shield_time = Instant.now();
          }
          return true;
        } else {
          return false;
        }
      }
      //Game panel's graphic method includes the background, characters, additional images, and sets the key's listeners and movement for the characters
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameove) {
          tm = (int)Duration.between(start_time, Instant.now()).getSeconds();
        }
        //for (int i=0; i<50000; i++) System.nanoTime();
        g.drawImage(back, 0, 0, 900,900, null);

        robot_height = get_robot_height(robot_height);
        g.drawImage(robot1, 700, robot_height, 120,330, null);

        soldier_height = get_soldier_height(soldier_height);
        long delta = Duration.between(time_now, Instant.now()).toMillis();
        if (key == 'w' && delta < 2000) {
          g.drawImage(soldier1og, 100, soldier_height, 205,350, null);
        } else {
          g.drawImage(soldier1reg, 100, soldier_height, 130,350, null);
        }
        g.drawImage(coin, 15, 20, 50,50, null);
        g.drawImage(userLife, 200, soldier_height-71, 50,50, null);
        g.drawImage(botLife, 800, robot_height-75, 50,50, null);
        setFont(new Font("Airacobra", Font.BOLD, 30));

        if (tm >=  equip_count*equip_points) {
          points = tm - equip_count * equip_points;
        }
        g.drawString(String.valueOf(points),70,57);

        if (soldier_bullets > 0) {
          if ((int)Duration.between(soldier_bullets_time, Instant.now()).toMillis() > 4000) {
            g.drawString(String.valueOf(soldier_bullets),750,robot_height-40);
          } else {
            g.drawImage(blood4, 700, 500, 100,100, null);
          }
        } else {
          g.drawString("You win the game",750,robot_height-40);
          pc.cardLayout1.show(pc, "Game Panel 2");
          //add(secondlevel, "Game Panel 2");
          if (!gameove) {
            gameove = true;
            g.setColor(Color.RED);
            for (int i=0; i<10000; i++) {
              Toolkit.getDefaultToolkit().beep();
            }
            JButton continues = new JButton("Continue");
            add(continues);
            continues.addActionListener(new sbuttonListener());
          }
        }

        if (robot_bullets > 0) {
          if ((int)Duration.between(robot_bullets_time, Instant.now()).toMillis() > 900) {
            g.drawString(String.valueOf(robot_bullets),150,soldier_height-36);
          } else {
            g.drawImage(blood4, 100, 500, 100,100, null);
          }
        } else {
          g.drawString("You lost the game",150,soldier_height-36);
          pc.cardLayout1.show(pc, "Game Panel 3");
          //add(secondlevel, "Game Panel 2");
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

        for(int i=0; i<xp.length; i++) {
          if (xp[i] == 5000 ) {
            soldier_bullets--;
            System.out.println("soldier_bullets " + soldier_bullets);
          }
        }

        for(int i=0; i<xp2.length; i++) {
          if (xp2[i] == 7000 ) {
            robot_bullets--;
            System.out.println("robot_bullets " + robot_bullets);
          }
        }


        boolean rsflag = turn_on_robot_shield();

        if (rsflag == false) {
          if (key == 'w') {
            if (key_flag == true) {
              key_flag = false;
              for(int i=0; i<xp.length; i++) {
                if (xp[i] == 0) {
                  xp[i] = 900;
                  yp[i] = soldier_height + 50;
                  if (Math.abs(soldier_height - robot_height) < 100) {
                    //soldier_bullets--;
                    soldier_bullets_time = Instant.now();
                    System.out.println("soldier_bullets " + soldier_bullets);
                  }
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
              //if (Math.abs(soldier_height - robot_height) < 100) {
              if ((int)Duration.between(equip_time, Instant.now()).getSeconds() > 5) {
                if (Math.abs(soldier_height - robot_height) < 100) {
                  //robot_bullets--;
                  robot_bullets_time = Instant.now();
                  System.out.println("robot_bullets " + robot_bullets);
                }
                //}
              }
            break;
            }
          }
        }	

        if (tm > 30) {
          if ((int)Duration.between(equip_time, Instant.now()).getSeconds() <5) {
            g.drawImage(shields, 240, 440, 100,200, null);
          }
        }

        if (rsflag == true) {
          g.drawImage(shields2, 540, 440, 100,200, null);
        }

        for (int w=0; w<xp.length; w++) {
          if (xp[w] !=0) {
            g.drawImage(bullet, xp[w]/speed, yp[w], 35,25, null);
          }
        }

        // try from the enemy
        for (int w=0; w<xp2.length; w++) {
          if (xp2[w] !=0) {
            g.drawImage(bullet2, (7200-xp2[w])/speed, yp2[w], 35,25, null);
          }
        }

        repaint();
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


    //Class for the panel leading to the second level
    class GamePanel2 extends JPanel {
      Image peep;
      //Constructor for class contains text and buttons in the panel
      GamePanel2() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("cursor2.png"); //Source: https://www.pngmart.com/image/26832
        Cursor c = toolkit.createCustomCursor(image , new Point(getX(), 
              getY()), "cursor2.png");
        setCursor (c);

        setLayout(new BorderLayout(50,50)); 
        JButton secondlevelBtn = new JButton("Second level");
        secondlevelBtn.setForeground(new Color(152,29,151));
        secondlevelBtn.setFont(new Font("Anklepants", Font.BOLD, 30)); 
        secondlevelBtn.setBounds(300, 350, 300, 100);
        secondlevelBtn.addActionListener(new sbuttonListener());
        add(secondlevelBtn, BorderLayout.SOUTH);

        JLabel winHeader = new JLabel("<html>" + "You won" + "<br>" + "</html>");
        winHeader.setFont(new Font("BaccaratUprightWide", Font.BOLD, 55)); 
        winHeader.setHorizontalAlignment(JLabel.CENTER);
        add(winHeader, BorderLayout.NORTH);
        peep = new ImageIcon("peep.png").getImage(); //Source: https://stickers.cloud/en/pack/pepe-29
      }
      //Graphics for the second level's panel include the happy peepo image and draw string
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(peep, 270, 330, 300,300, null);
        setFont(new Font("BaccaratUpright", Font.BOLD, 55)); 
        setForeground(new Color(63,42,20));
        g.drawString("Level 2: Peepo",270,240);
        setBackground(Color.GRAY);
      }
    }


    //Class for the panel saying user lost
    class GamePanel3 extends JPanel {
      //Constructor for class contains text and buttons in the panel
      GamePanel3() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("cursor2.png"); //Source: https://www.pngmart.com/image/26832
        Cursor c = toolkit.createCustomCursor(image , new Point(getX(), 
              getY()), "cursor2.png");
        setCursor (c);

        setLayout(new BorderLayout(50,50)); 
        JLabel winHeader = new JLabel("<html>" + "Game over" + "<br>" + "</html>");
        winHeader.setFont(new Font("BaccaratUprightWide", Font.BOLD, 55)); 
        winHeader.setHorizontalAlignment(JLabel.CENTER);
        add(winHeader, BorderLayout.NORTH);   

        JButton home = new JButton("Home");
        home.setFont(new Font("Anklepants", Font.BOLD, 30));
        home.setForeground(Color.MAGENTA);
        home.setBounds(300, 200, 300, 100);
        home.addActionListener(new sbuttonListener());
        //Mouse listener for the settings button; gets the foreground color
        home.addMouseListener(new MouseAdapter() {
          Color color = home.getForeground();
          //When mouse enters, the button changes color
          public void mouseEntered(MouseEvent me) {
            color = home.getForeground();
            home.setForeground(Color.ORANGE); 
            home.setBounds(279, 180, 340, 135);
          }
          //When the mouse exits, the mouse returns to the original color
          public void mouseExited(MouseEvent me) {
            home.setForeground(color);
            home.setBounds(300, 200, 300, 100);
          }
        });
        add(home, BorderLayout.SOUTH);

        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Anklepants", Font.BOLD, 30));
        quit.setForeground(Color.MAGENTA);
        quit.setBounds(300, 500, 300, 100);
        quit.addActionListener(new sbuttonListener());
        //Mouse listener for the instructions button; gets the foreground color
        quit.addMouseListener(new MouseAdapter() {
          Color color = quit.getForeground();
          //When mouse enters, the button changes color
          public void mouseEntered(MouseEvent me) {
            color = quit.getForeground();
            quit.setForeground(Color.ORANGE); 
            quit.setBounds(279, 480, 340, 135);
          }
          //When the mouse exits, the mouse returns to the original color
          public void mouseExited(MouseEvent me) {
            quit.setForeground(color);
            quit.setBounds(300, 500, 300, 100);
          }
        });
        add(quit, BorderLayout.SOUTH);

      }
      //Graphics for the panel include the sad peepo image
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image sadPeep = new ImageIcon("sadPeepo.png").getImage(); //Source: https://www.pngmart.com/image/160807
        g.drawImage(sadPeep, 300, 400, 300,300, null);
        setFont(new Font("BaccaratUpright", Font.BOLD, 55)); 
        setBackground(Color.GRAY);
      }
    }


    //Class for the second level's panel
    class GamePanelLevel2 extends JPanel {
      int x=0;
      int x2=0;
      int enemy_x1=0;
      int enemy_x2=0;
      int enemy_d=1;
      int enemy_d2=1;
      Instant  enemy_x_time = Instant.now();
      Instant  enemy_x_time2 = Instant.now();
      Image enemy;
      Image blood3;
      Image blood4;
      Image ufo;
      Image ufo2;
      Image level2Background;
      Instant start_time = Instant.now();
      Instant start_time2 = Instant.now();
      Instant start_time3 = Instant.now();
      Instant start_time4 = Instant.now();
      Image soldier1reg;
      Image soldier1reg_flat;
      Image soldier1og;
      Image soldier1ogLeft;
      Image lazerball_bullet;
      Image bullet2;
      Image ground, groundpart;
      Image lazer2;
      Image clockTime;
      int speed = 4;
      int laserx = (int)(Math.random()*600);
      int lasery=0;
      boolean enemy_hurt = false;
      boolean enemy_hurt2 = false;
      int enemy_killed = 0;

      //Constructor contains defining the images
      GamePanelLevel2() {
        soldier1reg = new ImageIcon("soldier1reg.png").getImage();
        soldier1reg_flat = new ImageIcon("soldier1reg_flat.png").getImage();
        enemy = new ImageIcon("peepo.gif").getImage(); //Source: https://tenor.com/view/naruto-run-peepo-pepe-frog-runners-fast-gif-17319616
        blood3 = new ImageIcon("blood3.gif").getImage(); //Source: https://tenor.com/view/naruto-run-peepo-pepe-frog-runners-fast-gif-17319616
        blood4 = new ImageIcon("blood4.png").getImage(); //Source: https://tenor.com/view/naruto-run-peepo-pepe-frog-runners-fast-gif-17319616
        ufo = new ImageIcon("UFO.png").getImage(); //Source: https://gameznet.com.au/alien-and-ufos/ufo-transparent-background/
        ufo2 = new ImageIcon("UFO2.png").getImage(); //Source: https://gameznet.com.au/alien-and-ufos/ufo-transparent-background/
        level2Background = new ImageIcon("twinkle.gif").getImage(); //Source: https://gifimage.net/twinkling-stars-gif-6/
        soldier1og = new ImageIcon("soldier1og.png").getImage();
        soldier1ogLeft = new ImageIcon("soldier1ogLeft.png").getImage();
        //bullet = new ImageIcon("bullet.png").getImage();
        lazerball_bullet = new ImageIcon("lazerball.png").getImage(); 
        bullet2 = new ImageIcon("bullet2.png").getImage();
        ground = new ImageIcon("terrain.png").getImage();
        Image clockTime = new ImageIcon("clock.gif").getImage();
        groundpart = new ImageIcon("groundpart.png").getImage();
        lazer2 = new ImageIcon("UFOlazer.gif").getImage();
      }

      public int enemy_x() {
        long delta = Duration.between(enemy_x_time, Instant.now()).toMillis();
        if (delta > 100) {
          enemy_x_time = Instant.now();
          if ((int)(Math.random()*10) == 0) {
            enemy_d *= 2;
          }
          if (enemy_d>200) {
            enemy_d = 1;
          }
          enemy_x1 += enemy_d;
          if (enemy_x1 > 800) {
            enemy_x1 = 0;
          }
        }
        //System.out.println(enemy_x1);
        return enemy_x1;
      }

      public int enemy_2x() {
        long delta = Duration.between(enemy_x_time2, Instant.now()).toMillis();
        if (delta > 100) {
          enemy_x_time2 = Instant.now();
          if ((int)(Math.random()*10) == 0) {
            enemy_d2 *= 2;
          }
          if (enemy_d2>200) {
            enemy_d2 = 1;
          }
          enemy_x2 += enemy_d2;
          if (enemy_x2 > 800) {
            enemy_x2 = 0;
          }
        }
        //System.out.println(enemy_x1);
        return enemy_x2;
      }

      //Graphics for the second level's panel include the actions and characters
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(level2Background, 0, 0, 900,900, null);
        g.drawImage(groundpart, 720,740,400,200, null);
        g.drawImage(ground, 0, 670, 900, 200, null);
        grabFocus();
        g.drawImage(clockTime, 15, 20, 50,50, null);
        setFont(new Font("Airacobra", Font.BOLD, 30));

        for (int i=50;i<=0;i--) {
          g.drawString(String.valueOf(i),70,57);
        }

        long delta = Duration.between(time_now, Instant.now()).toMillis();
        if (key == 'a' && delta < 2000) {
          g.drawImage(soldier1ogLeft, 300, soldier_height+130, 120,220, null);
        } else if (key == 's' && delta < 2000) {
          g.drawImage(soldier1og, 300, soldier_height+130, 120,220, null);
        } else {
          g.drawImage(soldier1reg, 300, soldier_height+130, 80,220, null);
        }

        if (x++ > 800) {
          x = 0;
        }
        if (x % 4 == 0) {
          x2++;
          if (x2 == 300) {
            start_time = Instant.now();
          }
        }
        if ((int)Duration.between(start_time, Instant.now()).getSeconds() <1) {
          x2 = 301;
        }

        if (x2 > 800) {
          x2 = 0;
        }
        setForeground(new Color(153,123,88));
        if (x2 < 300) {
          g.drawImage(ufo, x2, 100, 100,100, null);
        } else {
          g.drawImage(ufo2, x2, 100, 100,100, null);
        }

        int ex = enemy_x();
        int ey = ex > 600 ? ex/20 : 0;
        enemy_hurt = false;

        for (int w=0; w<yp.length; w++) {
          if (Math.abs(yp[w] - (soldier_height+240-ey)) < 10) {
            start_time2 = Instant.now();
            //g.drawImage(blood3, ex, soldier_height+240-ey, 80,80, null);
            enemy_hurt = true;
            //enemy_x1 = 0;
            //yp[w] = soldier_height + 160;
            yp[w] += 10;
            //for (int i=0; i<10000000; i++) System.nanoTime();
            break;
          }
        }
        if ((int)Duration.between(start_time2, Instant.now()).getSeconds() <1) {
          g.drawImage(blood4, ex, soldier_height+240-ey, 80,80, null);
        } else if ((int)Duration.between(start_time2, Instant.now()).getSeconds() <2) {
          g.drawImage(blood3, ex, soldier_height+240-ey, 80,80, null);
        } else {
          g.drawImage(enemy, ex, soldier_height+240-ey, 80,80, null);
        }
        //if (enemy_hurt == false) g.drawImage(enemy, ex, soldier_height+240-ey, 80,80, null);

        enemy_hurt2 = false;
        for (int w=0; w<yp2.length; w++) {
          if (Math.abs(yp2[w] - (soldier_height+250-ey)) < 10) {
            g.drawImage(blood3, ex, soldier_height+240-ey, 80,80, null);
            start_time3 = Instant.now();
            enemy_hurt2 = true;
            //enemy_x2 = 0;
            //yp2[w]++;
            //yp2[w] = soldier_height + 160;
            //for (int i=0; i<10000000; i++) System.nanoTime();
            break;
          }
        }
        //if (enemy_hurt2 == false) g.drawImage(enemy, enemy_2x(), soldier_height+250, 80,80, null);
        if ((int)Duration.between(start_time3, Instant.now()).getSeconds() <1) {
          g.drawImage(blood4, enemy_2x(), soldier_height+250, 80,80, null);
        } else if ((int)Duration.between(start_time3, Instant.now()).getSeconds() <2) {
          g.drawImage(blood3, enemy_2x(), soldier_height+250, 80,80, null);
        } else {
          g.drawImage(enemy, enemy_2x(), soldier_height+250, 80,80, null);
        }
        if (enemy_hurt == true || enemy_hurt2 == true) {
          if ((int)Duration.between(start_time4, Instant.now()).getSeconds() > 1) {
            start_time4 = Instant.now();
            enemy_killed++;
          }
        }

        g.drawString(String.valueOf(enemy_killed),800, 50);

        if (enemy_killed >= 10) {
          //g.drawString("Game Over", 700, 100);
          pc.cardLayout1.show(pc, "Game Panel 3");
        }

        repaint();

        /* if (enemy_hurt == true || enemy_hurt2 == true) {
           for (int i=0; i<100000000; i++) System.nanoTime();
           } */

        for (int w=0; w<xp.length; w++) {
          if (xp[w] !=0) {
            g.drawImage(lazerball_bullet, xp[w]/(speed), yp[w], 35,25, null);
            //System.out.printf("%d ", xp[w]);
          }
        }

        // try from the enemy
        for (int w=0; w<xp2.length; w++) {
          if (xp2[w] !=0) {
            g.drawImage(lazerball_bullet, (72000-xp2[w])/(speed), yp2[w], 35,25, null);
            //System.out.printf("(%d %d)", (72000-xp2[w])/speed, yp2[w]);
            //if (Math.abs(yp2[w] - ey) < 100) {
            //g.drawImage(blood3, ex, soldier_height+240-ey, 80,80, null);
            //}
          }
        }


        if ((int)(Math.random()*100) == 0) {
          int ii = (int)(Math.random()*10);
          if (ii % 2 == 0) {
            laserx += 4*ii;
          } else {
            laserx -= 4*ii;
          }
          lasery += ii;
          if (laserx < 0) laserx = 0;
          if (laserx > 800) laserx = 700;
          if (lasery > 600) {
            lasery = 0;
            laserx = (int)(Math.random()*800);
          }
        }


        //Plot: ufos release lazers down and soldier has to dodge while also shooting peepos
        g.drawImage(lazer2, 100+laserx, 100+lasery, 50,70, null);


        for(int i=0; i<xp.length; i++) {
          if (xp[i] != 0) {
            // add one position for every refresh
            if (xp[i]++ > 4000) {
              xp[i] = 0;
            }
            if (xp[i] % 800 == 0) yp[i]++;
          }
          if (xp2[i] != 0) {
            // add one position for every refresh
            if (xp2[i]++ > 4000) {
              xp2[i] = 0;
            }
            if (xp2[i] % 800 == 0) yp2[i]++;
          }
        }

        if (key == 's') {
          if (key_flag == true) {
            key_flag = false;
            for(int i=0; i<xp.length; i++) {
              if (xp[i] == 0) {
                xp[i] = 1600;  //Height of ball (original: 900)
                yp[i] = soldier_height + 160; //Controls where ball first hit originally (original: 50)
                if (Math.abs(soldier_height - robot_height) < 100) {
                  //soldier_bullets--;
                  soldier_bullets_time = Instant.now();
                }
                break;
              }
            }
          }
        }

        if (key == 'a') {
          if (key_flag == true) {
            key_flag = false;
            for(int i=0; i<xp2.length; i++) {
              if (xp2[i] == 0) {
                xp2[i] = 2000;  //Height of ball (original: 900)
                yp2[i] = soldier_height + 160; //Controls where ball first hit originally (original: 50)
                if (Math.abs(soldier_height - robot_height) < 100) {
                  //soldier_bullets--;
                  soldier_bullets_time = Instant.now();
                }
                break;
              }
            }
          }
        }



      }
    }

    //Class for the settings panel includes the text and content and text on how to play
    class Settings extends JPanel {
      //how to play panel's constructor
      Settings() { 
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("cursor2.png"); //Source: https://www.pngmart.com/image/26832
        Cursor c = toolkit.createCustomCursor(image , new Point(getX(), 
              getY()), "cursor2.png");
        setCursor (c);

        JLabel settingsHeader = new JLabel("<html>" + "How To Play" + "<br>" + "</html>");
        settingsHeader.setFont(new Font("Osake", Font.BOLD, 55)); //Aspastic
        settingsHeader.setForeground(new Color(153,0,0));
        settingsHeader.setHorizontalAlignment(JLabel.CENTER);

        JTextArea settingsDescription = new JTextArea();
        settingsDescription.setText("\n\nFirst level:\nSpace bar = jump up\n“w” key = shoot\n\"q\" key = quit\n\nSecond level:\nSpace bar = jump up\n“w” key = shoot\n\"q\" key = quit\n\nThird level:\n“Up” arrow = up\n“Down” arrow = down\n“Left” arrow = left\n“Right” arrow = right\n“w” key = shoot "); 
        settingsDescription.setFont(new Font("BaccaratUpright", Font.PLAIN, 26));
        settingsDescription.setForeground(new Color(153,0,0));
        settingsDescription.setPreferredSize(new Dimension (700, 700));
        settingsDescription.setBounds(50, 50, 250, 150);
        settingsDescription.setBackground(Color.GRAY);
        settingsDescription.setEditable(false);
        add(settingsHeader, BorderLayout.NORTH);
        add(settingsDescription, BorderLayout.SOUTH);
        setBackground(Color.GRAY);

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
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("cursor2.png"); //Source: https://www.pngmart.com/image/26832
        Cursor c = toolkit.createCustomCursor(image , new Point(getX(), 
              getY()), "cursor2.png");
        setCursor (c);

        JLabel introHeader = new JLabel("<html>" + "Introduction" + "<br>" + "</html>");
        introHeader.setFont(new Font("Osake", Font.BOLD, 50));
        introHeader.setHorizontalAlignment(JLabel.CENTER);
        introDescription = new JTextArea();
        introDescription.setText("\n\nThe US has been invaded by bots and needs your help.\nYou have been recruited by the military. Each level,\nyour goal is to destroy the bots and then you will be promoted a new role.\nFor the first level, you will have to defeat the bot with your given weapon and watch out for your health.\nWhen your health bar reaches zero, you lose; so shoot the bot until it’s health bar zero.\nOnce you win the first level, in the\nsecond level you will be able to access more\nweapons and equipment and have more bots to shoot.\nIn the last level, you will be promoted to a navy SEAL officer, so you will have to be aware of\nhealth and oxygen levels. Swim up to the surface to\nregenerate your oxygen levels.");
        introDescription.setFont(new Font("BaccaratUpright", Font.PLAIN, 26));
        introDescription.setEditable(false);
        introDescription.setLineWrap(true);
        introDescription.setWrapStyleWord(true);
        introDescription.setPreferredSize(new Dimension (700, 700));
        introDescription.setBounds(50, 50, 700, 700);
        introDescription.setBackground(new Color(255,102,102));
        introDescription.setPreferredSize(new Dimension (700, 700));
        add(introHeader);
        add(introDescription);
        setBackground(new Color(255,102,102));

        JButton previousButton = new JButton("Back");
        //previousButton.setLayout(null);
        //previousButton.setOpaque(false);
        previousButton.setFont(new Font("Aspastic", Font.BOLD, 30));
        previousButton.setBounds(80, 400, 80, 50);
        previousButton.setForeground(Color.BLACK);
        previousButton.addActionListener(new sbuttonListener());
        add(previousButton);

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
        if(sbutton.equalsIgnoreCase("Start")) {
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
        } else if(sbutton.equalsIgnoreCase("Continue")) {
          pc.cardLayout1.show(pc, "Game Panel 2");
        } else if(sbutton.equalsIgnoreCase("Second level")) {
          pc.cardLayout1.show(pc, "Level2");
        } else if(sbutton.equalsIgnoreCase("Quit")) {
          System.exit(0);
        } else if(sbutton.equalsIgnoreCase("Home")) {
          pc.cardLayout1.show(pc, "Start Screen");
        } else if(sbutton.equalsIgnoreCase("button")) {
          pc.cardLayout1.show(pc, "Game Panel 3");
        } else if(sbutton.equalsIgnoreCase("button2")) {
          pc.cardLayout1.show(pc, "Level2");
        } else if(sbutton.equalsIgnoreCase("Play")) {
          pc.cardLayout1.show(pc, "Game Panel");
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

    //(First level): Class for the key listeners. Listens to which key is clicked by the user and performs the appropriate actions for that key.
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
    //(Second level): Class for the key listeners. Listens to which key is clicked by the user and performs the appropriate actions for that key.
    class MKeyListener_level2 extends KeyAdapter {
      @Override
      //Method for key actions
      public void keyPressed(KeyEvent event) {
        key = event.getKeyChar();
        //System.out.println("MKeyListener_level2");
        if (key == 'q') {
          System.out.println("game ends");
          System.exit(0);
        }
        if (key == 'a') {
          key_flag = true;
          time_now = Instant.now();
        }
        if (key == 's') {
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
