//Parth Upadhyay
//3/11/22
//AllHandlers.java
//To print out all handlers and see their functions, the words go red once the function is done
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;


    public class AllHandlers 
    {
    int choice = 0;
    JFrame frame;
    DrawingPanel canvas;

    
    public static void main (String[] args) 
    {
    AllHandlers kt = new AllHandlers();
    kt.run2();
    } // end main

    public void run2()
    {
        frame = new JFrame("AllHandlers.java");
        DrawingPanel panel = new DrawingPanel();
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

    class DrawingPanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
    private int triX, triY;
    private Timer trimover;
    private boolean [] check = {false, false, false, false, false, false, false, false, false, false, false, false,false};
    boolean reset = false;
    //boolean control = false; 
    /*
    boolean enter = false; 
    boolean exit = false; 
    boolean move = false; 
    boolean drag = false; 
    boolean click = false;
    boolean press = false; 
    boolean release = false; 
    boolean letter = false; 
    boolean number = false; 
    boolean character = false;
    boolean keycode = false;
    */


    
    public DrawingPanel() {
    triX = 0;
    triY = 0;

    addKeyListener(this);
    
    // create timer for animation of ball
    
    TriMover tritimer = new TriMover();
    trimover = new Timer(5, tritimer);
    trimover.start();
    }
    
    class TriMover implements ActionListener {
        
    public void actionPerformed(ActionEvent e) {
        if (check[12] == false)
        {
        triX++;
        if (triX > 600)
            triX = 40;
        }
        
        else
        {
            triX--;
            if (triX < 0)
            triX = 550;
        }
        
    repaint();
    grabFocus();
    }
    // end BallMover
    }
    
    public void paintComponent(Graphics g) {
        
    super.paintComponent(g);
    setBackground(Color.WHITE);
    
    g.setColor(Color.BLACK);
    g.setFont(new Font("Serif", Font.PLAIN, 20));
    
    //titles
    g.drawString("Mouse", 100, 80);
    g.drawString("Keyboard", 100, 230);
    
    g.setFont(new Font("Serif", Font.PLAIN, 18));
    //others
    
    g.drawRect(100, 100, 100, 25);
    g.drawRect(200, 100, 100, 25);
    g.drawRect(300, 100, 100, 25);
    g.drawRect(400, 100, 100, 25);
    
    g.drawRect(100, 150, 100, 25);
    g.drawRect(200, 150, 100, 25);
    g.drawRect(300, 150, 100, 25); 
    
    g.drawRect(100, 250, 100, 25);
    g.drawRect(200, 250, 100, 25);
    g.drawRect(300, 250, 100, 25);
    g.drawRect(400, 250, 100, 25);
    
    String[] str = {"Moved", "Dragged", "Entered", "Exited", "Clicked", "Pressed", "Released", "Letter", "Number", "Character", "KeyCode"};
    int[] arrx = {125, 225, 325, 425, 125, 225, 325, 125, 225, 325, 425};
    int[] arry = {120, 120, 120, 120, 170, 170, 170, 270, 270, 270, 270};
   
    if ( reset == true)
    {
        for (int i = 0; i < 11; i ++)
        {
            check[i] = false;
            g.setColor(Color.BLACK);
            g.drawString(str[i], arrx[i], arry[i]);
        }
        reset = false;
    }

        for (int i = 0; i < 11; i ++)
        {
            if (check[i])
            g.setColor(Color.RED);
            g.drawString(str[i], arrx[i], arry[i]);
            g.setColor(Color.BLACK);
        }
    
        
    
    int [] arrx2 = {50, 0, 100};
    int [] arry2 = {500, 550, 550};
    g.setColor(Color.YELLOW);
    for (int i = 0; i < 3; i ++)
    {
        arrx2[i] += triX;
        arry2[i] += triY;
    }
    g.fillPolygon(arrx2, arry2, 3);


    
    } // end paintComponent
    
    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) 
    {
        char c = e.getKeyChar();
    
        

        switch (c)
        {
        case 'r':
                reset = true;
                break;

        
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                check[7] = true; 
                check[9] = true; 
                check[10] = true;
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
                check[8] = true; 
                check[9] = true; 
                check[10] = true;
                break; 
                  
        }
        
        switch(c) 
        {
            case KeyEvent.VK_CONTROL:
            check[12] = false; 
            check[10] = true;
            break; 
            
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_SHIFT:
            case KeyEvent.VK_TAB:
            case KeyEvent.VK_DELETE:
            check[10] = true;
            break;
                
        }

        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    
    
    public void mousePressed (MouseEvent e) {check[5] = true; repaint();}


    public void mouseReleased (MouseEvent e) {check[6] = true; repaint();}


    public void mouseClicked (MouseEvent e) {check[4] = true; repaint();}


    public void mouseEntered (MouseEvent e) {check[2] = true; repaint();}


    public void mouseExited (MouseEvent e) {check[3] = true; repaint();}

    public void mouseMoved (MouseEvent e) {check[0] = true; repaint();}


    public void mouseDragged (MouseEvent e) {check[1] = true; repaint();}
    
    
    
    } 
