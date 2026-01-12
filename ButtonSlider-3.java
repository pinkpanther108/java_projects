/*Sudipti Dantuluri
 * 3.16.2022
 * ButtonSlider.java
 * The program uses layouts to output pillsbury slider or border layouts.*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Scanner;

public class ButtonSlider extends JFrame {
  PillsburyLayoutP2 panel;
  Practice canvas;
  JFrame frame;
  public ButtonSlider() {
    super("ButtonSlider.java");
    setSize( 900, 500);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocation(80,50);
    setResizable(true);
    //PillsburyLayoutP2 pillsPanel2 = new PillsburyLayoutP2();
    //setContentPane(pillsPanel2);  // OR frame.getContentPane().add(p_in);
    //setVisible(true);
  }
  public static void main(String[] args) {
    ButtonSlider sl = new ButtonSlider();
    sl.slider();
  }
  public void slider() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Would you like to run Pillsbury(1) or BorderLayout(2)? ");
    int choice = sc.nextInt();
    System.out.print("Here you go!");
    /*if (choice==1) {
      ButtonSlider pL2 = new ButtonSlider();
    }
    if (choice==2) {
    //BorderLayoutExample2 BLE = new BorderLayoutExample2();
    }*/
    if (choice==1) {
      PillsburyLayoutP2 pillsPanel2 = new PillsburyLayoutP2();
      setContentPane( pillsPanel2 );  // OR frame.getContentPane().add(p_in);
      setVisible(true);
    } else if (choice==2) {
      setSize( 600, 600);
      Practice pc = new Practice();
      setContentPane( pc );  // OR frame.getContentPane().add(p_in);
      setVisible(true);
    }
    frame.setVisible(true);
  }
}

class PillsburyLayoutP2 extends JPanel {
  private boolean pressed1, pressed2, pressed3;
  int countCommand2 = 0;
  int countCommand = 0;
  private JButton button1, button2, button3, button4;
  private Font font;
  private int counter;
  private JSlider slider;
  private int sliderValue;
  public PillsburyLayoutP2()
  {
    pressed1 = pressed2 = false;
    font = new Font ("Serif", Font.BOLD, 30);
    setBackground( Color.BLUE );
    //setLayout( new FlowLayout( FlowLayout.RIGHT, 0, 0) );
    setLayout( new FlowLayout( FlowLayout.LEFT, 0, 0) );
    button1 = new JButton("Press my belly.");  // construct button
    Button1Handler b1handler = new Button1Handler(); // this is so the actionPerformed is dedicated to this button only
    button1.addActionListener( b1handler );   // add listener to button
    add( button1 );  // add button to panel (Pillsbury2)
    button1.setPreferredSize(new Dimension(140,50)); //original height = 25
    button2 = new JButton("Hello");
    Button2Handler b2handler = new Button2Handler();
    button2.addActionListener( b2handler );
    add( button2 );
    button2.setPreferredSize(new Dimension(70,50)); //original height = 25
    button3 = new JButton("Press my belly.");
    Button1Handler b3handler = new Button1Handler();
    button3.addActionListener( b1handler );
    add( button3 );
    button3.setPreferredSize(new Dimension(140,50)); //original height = 25
    button4 = new JButton("Hello");
    Button2Handler b4handler = new Button2Handler();
    button4.addActionListener( b2handler );
    add( button4 );
    button4.setPreferredSize(new Dimension(70,50)); //original height = 25
    JPanel jp = new JPanel();
    add ( jp );
    slider = new JSlider (JSlider.HORIZONTAL, 10, 125, 12);  // construct slider bar
    slider.setMajorTickSpacing(67); // create tick marks on slider every 40 units
    slider.setMinorTickSpacing(10);
    slider.setForeground(Color.BLUE);
    slider.setPaintTicks(true);
    slider.setLabelTable( slider.createStandardLabels(50) ); // create labels on tick marks
    slider.setPaintLabels(true);
    SliderHandler sHandler = new SliderHandler();
    add(slider);  // add button to panel
    slider.addChangeListener( sHandler );   // add listener to slider
    sliderValue = 12;
    slider.setInverted(true);
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent (g);
    Font f = new Font("Serif", Font.BOLD, sliderValue);
    g.setFont(f);
    g.drawString ("Move the slider to see",100, 250 ); //length 43 total
    g.drawString ("the font size change",100,285); //length 22
    if (pressed1 && countCommand%5!=0)
    {
      Font f2 = new Font("Serif", Font.PLAIN, 25);
      g.setFont( f2 );
      g.drawString("Hee-Hee", 100, 150);
      Image pillsbury = new ImageIcon("Pillbury-Doughboy1.jpg").getImage();
      g.drawImage(pillsbury, 10, 320, 150, 140, null);
      g.drawString("You're wonderful!",160,460);
      pressed1 = false;
    }
    if (pressed2 && countCommand%5!=0)
    {
      Font f2 = new Font("Serif", Font.PLAIN, 25);
      g.setFont( f2 );
      g.drawString("Hee-Hee", 100, 150);
      Image pillsbury = new ImageIcon("Pillbury-Doughboy1.jpg").getImage();
      g.drawImage(pillsbury, 10, 320, 150, 140, null);
      g.drawString("You're wonderful!",160,460);
      pressed2 = false;
    }
    if (pressed3 && countCommand2%4==0) {
      Font f2 = new Font("Serif", Font.PLAIN, 25);
      g.setFont( f2 );
      g.drawString("Stop saying Hello", 100, 150);
      pressed3 = false;
    }
    if (pressed3) {
      Font f2 = new Font("Serif", Font.PLAIN, 25);
      g.setFont( f2 );
      g.drawString("Goodbye", 100, 150);
      pressed3 = false;
    }
    if (pressed1 || pressed2 && countCommand%5==0) {
      if (pressed1) {
        Font f2 = new Font("Serif", Font.PLAIN, 25);
        g.setFont( f2 );
        g.drawString("Stop pressing my belly", 100, 150);
        pressed1 = false;
      }
      if (pressed2) {
        Font f2 = new Font("Serif", Font.PLAIN, 25);
        g.setFont( f2 );
        g.drawString("Stop pressing my belly", 100, 150);
        pressed2 = false;
      }
    }
  }
  class Button1Handler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String command = e.getActionCommand();
      System.out.println("line164: " + command);
      if ( command.equals ("Press my belly.") )
      {
        pressed1 = true;
        countCommand++;
        button1.setText ("reset");
      }
      else {
        button1.setText("Press my belly.");
      }
      if ( command.equals ("Press my belly") )
      {
        pressed2 = true;
        countCommand++;
        button3.setText("reset");
      }
      else {
        button3.setText("Press my belly");
      }

      repaint();
    }
  } // end class Button1Handler
  class Button2Handler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String command2 = e.getActionCommand();
      System.out.println("line 192: " + command2);
      if ( command2.equals ("Hello") )
      {
        pressed3 = true;
        countCommand2++;
        //button2.setText ("Goodbye");
      }
      else
        button2.setText("Hello"); //4 times stop saying hello
      repaint();
    }
  } // end class Button2Handler
  class SliderHandler implements ChangeListener
  {
    public void stateChanged(ChangeEvent e)
    {    //  event handler for JSliderBar (stateChanged)
      sliderValue = slider.getValue();
      repaint();
    }
  }
}

class Practice extends JPanel
{
  private boolean pressedMath, pressedScience, pressedJava;
  int countCommand1 = 0;
  //int countCommand = 0;
  int mathcount = 0;
  int sciencecount = 0;
  int javacount = 0;
  int totalNum = 0;

  public Practice()
  {
    setBackground( Color.YELLOW );
    runIt();
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent (g);
    //g.drawString("JoeBob",50,400);
    /*if (ba1) {
      num1 = 0;
      num2 = 0;
      num3 = 0;
      totalNum = 0;
    }
    if (ba2) {
    pressedScience = true;
    num2++;
    }*/

  }
  public void runIt()
  {

    JButton ba1 = new JButton("Reset");
    ba1.setPreferredSize(new Dimension(600,20));
    JLabel jl1 = new JLabel("<html>" + "Total Time: " + "<br>" +totalNum+ " hrs" + "</html>");
    //JButton ba2=new JButton("Total Time: " + num + " hrs");
    //ba2.setPreferredSize(new Dimension(600,20));
    clickHandle resethandler = new clickHandle();
    ba1.addActionListener(resethandler);;

    JButton ba3 = new JButton("<html>" + "Java" + "<br>" +javacount+ "</html>");
    ba3.setPreferredSize(new Dimension(200,50));
    clickHandle javahandler = new clickHandle();
    ba3.addActionListener(javahandler);;

    JButton ba4=new JButton("<html>" + "Math" + "<br>" +mathcount+ "</html>");
    ba4.setPreferredSize(new Dimension(200,50));
    clickHandle mathhandler = new clickHandle();
    ba4.addActionListener(mathhandler);;

    //JButton ba5=new JButton("Center");
    //JLabel jl1 = new JLabel("<html>" + "Science" + "<br>" +num+ "</html>");

    JButton ba2 = new JButton("<html>" + "Science" + "<br>" +sciencecount+ "</html>");
    ba2.setPreferredSize(new Dimension(200,50));
    clickHandle sciencehandler = new clickHandle();
    ba2.addActionListener(sciencehandler);;



    //jl1.setPreferredSize(new Dimension(600,50));
    jl1.setHorizontalAlignment(JLabel.CENTER);
    JPanel pa = new JPanel();
    add(pa);
    pa.setLayout(new BorderLayout());
    pa.add(ba1, BorderLayout.NORTH);
    pa.add(jl1, BorderLayout.SOUTH);
    pa.add(ba3, BorderLayout.EAST);
    pa.add(ba4, BorderLayout.WEST);
    pa.add(ba2, BorderLayout.CENTER);
  }

  class clickHandle implements ActionListener
  {
    private boolean pressedMath, pressedScience, pressedJava;
    public void actionPerformed(ActionEvent e)
    {
      String commandClick = e.getActionCommand();
      System.out.println(commandClick);
      if (commandClick.indexOf("Math") != -1) {
        mathcount++;
        System.out.println("MATH matched");
      }
      if (commandClick.indexOf("Java") != -1) {
        javacount++;
        System.out.println("java matched");
      }
      if (commandClick.indexOf("Reset") != -1) {
        totalNum++;
        System.out.println("Reset matched");
      }
      if (commandClick.indexOf("Science") != -1) {
        sciencecount++;
        System.out.println("Science matched");
      }
      repaint();
      //ba2= JButton("<html>" + "Science" + "<br>" +num2+ "</html>");
      //ba2.setPreferredSize(new Dimension(200,50));
    }
  } // end class Button2Handler
}
