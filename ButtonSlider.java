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
      Practice pc = new Practice();
      setContentPane( pc );  // OR frame.getContentPane().add(p_in);
      setVisible(true);
    }
    frame.setVisible(true);
  }
}

class PillsburyLayoutP2 extends JPanel {
  private boolean pressed1, pressed2;
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
    if (pressed1)
    {
      Font f2 = new Font("Serif", Font.PLAIN, 25);
      g.setFont( f2 );
      g.drawString("Hee-Hee", 100, 150);
      Image pillsbury = new ImageIcon("Pillbury-Doughboy1.jpg").getImage();
      g.drawImage(pillsbury, 10, 300, 150, 160, null);
      g.drawString("You're wonderful!",160,460);
      pressed1 = false;
    }
    if (pressed2)
    {
      g.setFont( font );
      g.drawString("You say", 200, 150);
      pressed2 = false;
    }
  }
  class Button1Handler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String command = e.getActionCommand();
      if ( command.equals ("Press my belly.") )
      {
        pressed1 = true;
        button1.setText ("reset");
      }
      else
        button1.setText("Press my belly.");
      repaint();
    }
  } // end class Button1Handler
  class Button2Handler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      int countCommand2 = 0;
      String command2 = e.getActionCommand();
      if ( command2.equals ("Hello") )
      {
        pressed2 = true;
        countCommand2++;
        button2.setText ("Goodbye");
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

/* class BorderLayoutExample2 {
  JFrame frame;   // JFrame and JPanel must be global object instances
  // Practice panel;
  public BorderLayoutExample2()
  { 
  }
  public static void main(String[] args)
  {
    BorderLayoutExample2 ble = new BorderLayoutExample2();
    ble.Run();
  }
  public void Run() {
    super("BorderLayout Example2");
    setSize( 800, 500);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocation(400,50);
    setResizable(true);
    // Practice pc = new Practice();
    // setContentPane( pc );  // OR frame.getContentPane().add(p_in);
    setVisible(true);
  }
} */
class Practice extends JPanel
{
  public Practice()
  {
    setBackground( Color.YELLOW );
    runIt();
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent (g);
    g.drawString("JoeBob",50,400);
  }
  public void runIt()
  {
    int num = 0;
    JButton ba1 = new JButton("<html>" + "North" + "<br>" +num+ "</html>");
    ba1.setPreferredSize(new Dimension(600,100));
    JButton ba2=new JButton("South");
    JButton ba3=new JButton("East");
    JButton ba4=new JButton("West");
    //JButton ba5=new JButton("Center");
    JLabel jl1 = new JLabel("Joe Label");
    jl1.setHorizontalAlignment(JLabel.CENTER);
    JPanel pa = new JPanel();
    add(pa);
    pa.setLayout(new BorderLayout());
    pa.add(ba1, BorderLayout.NORTH);
    pa.add(ba2, BorderLayout.SOUTH);
    pa.add(ba3, BorderLayout.EAST);
    pa.add(ba4, BorderLayout.WEST);
    pa.add(jl1, BorderLayout.CENTER);
  }
}
