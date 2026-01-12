/*Sudipti Dantuluri
  * 3.8.2022
  * KeyAndMouse.java
  * The program uses listeners to output moving cars and balls.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; import java.util.Scanner; 

public class KeyAndMouse 
{
 JFrame frame;
 int choice;
 MyPanel panel;
 DrawingPanel canvas;
 public static void main (String[] args) 
 {
  KeyAndMouse kam = new KeyAndMouse();
  kam.kamMethod();
 } // end main
 
 public void kamMethod() {
  Scanner sc = new Scanner(System.in);
  System.out.print("Would you like to run mouse(1) or key(2)? ");
  choice = sc.nextInt();

  frame = new JFrame("KeyAndMouse.java");
  frame.setSize(600, 600);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  if (choice==1) {
    panel = new MyPanel();
    frame.addMouseListener(panel);
    frame.addMouseMotionListener(panel);
    frame.getContentPane().add(panel);
  } else if (choice==2) {
    frame.addMouseListener(panel);
    frame.addMouseMotionListener(panel);
    canvas = new DrawingPanel();
    frame.getContentPane().add(canvas);
  }
  frame.setVisible(true);
 }
}
 
class DrawingPanel extends JPanel implements KeyListener {
 private int ballX, ballY;
 private int car2X;
 private int carX, carY;
 private boolean ballMoveIt;  // starts and stops ball movement
 private boolean carMoveIt;  // starts and stops car movement
 private boolean car2MoveIt;  // starts and stops car movement
 private Timer balltimer, car2timer; 
 private Timer cartimer;
 boolean shift = true;
 int speed = 0; 
 int speed2 = 0;
 int ballspeed = 0;
 boolean up = false; 
 boolean down = false;  
 
 public DrawingPanel() {
  car2X = 400;
  ballX = 200;
  ballY = 10;
  carX = 10;
  carY = 400;

  ballMoveIt = carMoveIt = true;
  ballMoveIt = car2MoveIt = true;
  addKeyListener(this);
  // create timer for animation of ball
  BallMover ballmover = new BallMover();
  balltimer = new Timer(5, ballmover);
  balltimer.start();
  // Format --> timer = new Timer( millisDelay, listener );
  CarMover carmover = new CarMover();
  cartimer = new Timer(10, carmover);
  cartimer.start();

  CarMover car2mover = new CarMover();
  car2timer = new Timer(10, car2mover);
  car2timer.start();

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
  public boolean shiftKeyPressed;
  public int clicked;
  public void actionPerformed(ActionEvent e) {
   // car XY location
    car2X--;
    carX ++;
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
  g.setFont(new Font("Serif", Font.BOLD, 20));
  g.drawString("Press any digit to stop/start the ball (right/left alters speed)", 23, 50);
  g.drawString("Press any vowel to stop/start the orange car (up/down alters speed)", 10, 90);
  g.drawString("Press any key directly above space bar to stop/start the blue car ('f' & 's' alter speed)", 10, 130);
  // paint ball
  if (shift) {
      g.setColor(Color.pink);
  } else {
      g.setColor(Color.green);
  }
  g.fillOval(ballX, ballY, 30, 30);
  
  // paint car 1
  g.setColor(Color.orange);
  g.fillOval(carX+2, carY, 20, 20); // back wheel
  g.fillOval(carX+40, carY, 20, 20); // front wheel
  g.fillRect(carX, carY-20, 60, 20); // car body
  g.fillRect(carX+10, carY-35, 40, 15); // car top
  
  //paint car 2
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
    //a,e,i,o,u wil stop/start car1
   case 'z':
   case 'x':
   case 'c':
   case 'v':
   case 'b':
   case 'n':
   case 'm':
    if (carMoveIt) car2timer.stop();
    else car2timer.start();
    car2MoveIt = ! car2MoveIt;
    break; 
   case '1':
   case '2':
   case '3':
   case '4':
   case '5':
   case '6':
   case '7':
   case '8':
   case '9':
   case '0':
    if (ballMoveIt) balltimer.stop();
    else balltimer.start();
    ballMoveIt = ! ballMoveIt;
    break;
    //any digit will stop/start ball
   /*default:
    if (ballMoveIt) balltimer.stop();
    else balltimer.start();
    ballMoveIt = ! ballMoveIt;*/
  case 'f':
    speed2 ++;
    break;
    
  case 's':
    speed2 --;
    break;
    
  }
 } // end keyPressed
 
 public void keyPressed(KeyEvent e) {
  //up and down only work in keyPressed not Typed
   int value = e.getKeyCode();
    if (value == 16 ) {
        shift = !shift;
    }

  int n = e.getKeyCode();
    
    switch(n) 
    {    
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










class SimpleJFrame {

 JFrame frame;   // JFrame and JPanel must be global object instances
 MyPanel panel;
 
 public SimpleJFrame () 
 {  }
 
 public static void main(String[] args) 
 {
  SimpleJFrame sjf = new SimpleJFrame();
  sjf.Run();
 }

 public void Run() {
  frame = new JFrame("KeyAndMouse.java");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  panel = new MyPanel();
  frame.getContentPane().add(panel, BorderLayout.CENTER); 
  frame.addMouseListener(panel);
  frame.addMouseMotionListener(panel);
  
  frame.setSize(500, 500);
  frame.setVisible(true);
 }
} 

class MyPanel extends JPanel implements MouseListener, MouseMotionListener 
{
 private int xloc, yloc; 
 boolean entered = false; 
 private int width, height; 
 private boolean dragging;
 private int xMouse, yMouse; 
 private Rectangle rect;
 
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
  g.setColor(Color.black);
  g.setFont(new Font("Serif", Font.BOLD, 30));
  if (entered == true)
    g.setColor(Color.pink);
  if (entered == false)
    g.setColor(Color.black);
  if (dragging == false)
    g.drawString("Not Dragging", 100, 50);
  if (dragging == true)
    g.drawString("Dragging", 100, 50);
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
 // mouseDragged (MouseEvent e)
 // mouseMoved (MouseEvent e)
 public void mouseDragged (MouseEvent e) {
  if (dragging) {
   xloc = xloc + (e.getX() - xMouse);
   yloc = yloc + (e.getY() - yMouse);
   xMouse = e.getX();  // reset mouse to new location
   yMouse = e.getY();
   repaint(); // repaint when dragging
  }
 }
 public void mouseMoved (MouseEvent e) {
  xMouse = e.getX();
  yMouse = e.getY();
  if (rect.contains(e.getX(), e.getY())) entered = true;
  if (!rect.contains(e.getX(), e.getY())) entered = false;
  repaint();
 }
} 
