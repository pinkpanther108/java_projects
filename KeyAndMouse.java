  // Parth Upadhyay
  // 3/9/2022
  // KeyAndMouse.java
  // To undertand and use keyboard and mouse listeners
  import java.awt.*;
  import java.awt.event.*;
  import javax.swing.*;
  import java.util.Scanner;

  public class KeyAndMouse 
  {
  int num = 0;
  JFrame frame;
  DrawingPanel canvas;
  MyPanel panel;
  public static void main (String[] args) 
  {
    KeyAndMouse kt = new KeyAndMouse();
    kt.question();
    kt.run();
  } // end main
  
  public void question()
  {
    Scanner in = new Scanner (System.in);
    System.out.println("Do you want to run mouse(1) or key(2)?");
    num = in.nextInt();
  }
  
  public void run()
  {
    frame = new JFrame("KeyAndMouse.java");
    

    
    if (num == 2)
    {
    DrawingPanel canvas = new DrawingPanel();  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize( 600, 600);    
  frame.setLocation(400,50);
  frame.setResizable(true);
  frame.setContentPane(canvas);
  frame.setVisible(true); 

    }
    
    if (num == 1)
    {
    MyPanel panel = new MyPanel();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize( 600, 600);    
    frame.setLocation(400,50);
    frame.setResizable(true);
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    frame.addMouseListener(panel);
    frame.addMouseMotionListener(panel);
    frame.setVisible(true); 
    }
  }
  }

  class MyPanel extends JPanel implements MouseListener, MouseMotionListener 
  {
  private int xloc, yloc; 
  private int width, height; 
  private boolean dragging;
  private int xMouse, yMouse; 
  private Rectangle rect;
  boolean entered = false; 
  
  public MyPanel() 
  {
    xloc = yloc = 100;
    dragging = false;
    xMouse = yMouse = 0;
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g); // execute the superclass method first
    width = getWidth();   // width of JPanel
    height = getHeight();  // height of JPanel
    setBackground(Color.white);
    g.setColor(Color.BLACK);
      
      g.setFont(new Font("Serif", Font.BOLD, 36));
      
      if (entered == true)
    g.setColor(Color.PINK);
    
    if (entered == false)
      g.setColor(Color.BLACK);
      
    if (dragging == true)
    g.drawString("Dragging", 100, 50);
    
    if (dragging == false)
    g.drawString("Not Dragging", 100, 50);
    
    g.fillRect(xloc, yloc, 150, 150);
    int yoffset = 24;
    rect = new Rectangle(xloc, yloc+yoffset, 150, 150);
    
  } // end paintComponent
  
  public void mousePressed (MouseEvent e) {
    xMouse = e.getX();
    yMouse = e.getY();
    // determine if mouse is pressed inside drawn rectangle
    if (rect.contains(e.getX(), e.getY())) dragging = true;
  }
  public void mouseReleased (MouseEvent e) {
    ////////////////////////////////////////
    // Stop dragging
    dragging = false;  // stop dragging
  }
  public void mouseClicked (MouseEvent e) {}
  public void mouseEntered (MouseEvent e) {}
  public void mouseExited (MouseEvent e) {}

  public void mouseMoved (MouseEvent e)
  {
    xMouse = e.getX();
    yMouse = e.getY();
    if (rect.contains(e.getX(), e.getY())) entered = true;
    if (!rect.contains(e.getX(), e.getY())) entered = false;
    repaint();
  }
  public void mouseDragged (MouseEvent e) {
    if (dragging) {
    xloc = xloc + (e.getX() - xMouse);
    yloc = yloc + (e.getY() - yMouse);
    xMouse = e.getX();  // reset mouse to new location
    yMouse = e.getY();
    repaint(); // repaint when dragging
    }
  }

  }

  

  
  class DrawingPanel extends JPanel implements KeyListener {
  private int ballX, ballY;
  private int carX, carY;
  private int car2X;
  private boolean ballMoveIt;  // starts and stops ball movement
  private boolean carMoveIt;  // starts and stops car movement
  private Timer balltimer, cartimer, cartimer2;
  boolean shift = false; 
  boolean up = false; 
  boolean down = false; 
  int speed = 0; 
  int speed2 = 0;
  int ballspeed = 0; 
  
  public DrawingPanel() {
    ballX = 200;
    ballY = 10;
    carX = 10;
    carY = 400;
    car2X = 400;
    
    ballMoveIt = carMoveIt = true;
    addKeyListener(this);
    
    // create timer for animation of ball
    BallMover ballmover = new BallMover();
    balltimer = new Timer(5, ballmover);
    balltimer.start();
    
    // Format --> timer = new Timer( millisDelay, listener );
    CarMover carmover = new CarMover();
    cartimer = new Timer(10, carmover);
    cartimer.start();
    
    CarMover carmover2 = new CarMover();
    cartimer2 = new Timer(10, carmover2);
    cartimer2.start();
  }
  
  class BallMover implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
    // ball XY location
    ballY++;
    ballY += ballspeed;
    if (ballspeed < 0)
      ballspeed = 0;
    if (ballY > 600) {
      ballY = 10;
      ballX = (int)(Math.random() * 600) + 1;
    }
    repaint();
    grabFocus();
    }
  } // end BallMover
  
  class CarMover implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
    // car XY location
    carX ++;
    car2X--;
    if (speed2 < 0)
      speed2 = 0;
    if (speed < 0)
      speed = 0;
    
    carX += speed;
    car2X -= speed2;
    if (carX > 560 || car2X < 0){ carX = 0; car2X = 600;}
    repaint();
    grabFocus();
    }
  } // end CarMover
  
  public void paintComponent(Graphics g) {
    
    super.paintComponent(g);
    setBackground(Color.gray);
    
    g.setColor(Color.red);
    g.setFont(new Font("Serif", Font.BOLD, 36));
    g.drawString("Press any number for ball", 100, 50);
    g.drawString("Press any vowel for car", 100, 100);
    g.drawString("Press shift to change ball color", 100, 150);
    g.drawString("Change speed of orange car by up/down", 100, 200);
    g.drawString("Change speed of ball by left/right", 100, 250);
    g.drawString("Press zxcvhnm for blue car", 100, 300);
    g.drawString("Change speed blue car by f/s", 100, 350);
    
    // paint ball
    g.setColor(Color.PINK);
    
    if (shift == true)
      g.setColor(Color.GREEN);
          
    if (shift == false)
      g.setColor(Color.PINK);
    
      g.fillOval(ballX, ballY, 30, 30);
    
    // paint car
    g.setColor(Color.orange);
    g.fillOval(carX+2, carY, 20, 20); // back wheel
    g.fillOval(carX+40, carY, 20, 20); // front wheel
    g.fillRect(carX, carY-20, 60, 20); // car body
    g.fillRect(carX+10, carY-35, 40, 15); // car top
    
    //car #2
    g.setColor(Color.BLUE);
    g.fillOval(car2X+2, carY, 20, 20); // back wheel
    g.fillOval(car2X+40, carY, 20, 20); // front wheel
    g.fillRect(car2X, carY-20, 60, 20); // car body
    g.fillRect(car2X+10, carY-35, 40, 15); // car top
    
  } // end paintComponent
  
  public void keyTyped(KeyEvent e) {
    
    char c = e.getKeyChar();
    switch (c) {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
      if (carMoveIt) cartimer.stop();
      else cartimer.start();
      carMoveIt = ! carMoveIt;
      break;
      
    case 'z':
    case 'x':
    case 'c':
    case 'v':
    case 'b':
    case 'n':
    case 'm':
      if (carMoveIt) cartimer2.stop();
      else cartimer2.start();
      carMoveIt = ! carMoveIt;
      break;
      
    case 'f':
    speed2 ++;
    break;
    
    case 's':
    speed2 --;
    break;
    
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
    case '8':
    case '9':
      if (ballMoveIt) balltimer.stop();
      else balltimer.start();
      ballMoveIt = ! ballMoveIt;
      break; 
    }
    

  } // end keyPressed
  
  public void keyPressed(KeyEvent e) 
  {
    int c = e.getKeyCode();
    
    switch(c) 
    {
      case KeyEvent.VK_SHIFT:
      shift = !shift; 
      break; 
      
      case KeyEvent.VK_UP:
      speed++; 
      break;
      
      case KeyEvent.VK_DOWN:
      speed--; 
      break; 
      
      case KeyEvent.VK_LEFT:
      ballspeed --;
      break; 
      
      case KeyEvent.VK_RIGHT:
      ballspeed ++;
      break; 
    }
    
  }
  public void keyReleased(KeyEvent e) {}
  
  }



