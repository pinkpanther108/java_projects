/*Sudipti Dantuluri
 * 4.1.2022
 * RadioAndScroll.java
 * The program uses radio buttons, Jbuttons, scroll bars, and layouts.*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*; 
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class RadioAndScroll extends JFrame
{ 


    public RadioAndScroll()
    {
        super("RadioAndScroll.java");
        setSize( 600, 600); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setLocation(400,50);
        setResizable(true);
        Practice2 pc = new Practice2(); 
        setContentPane( pc );
        setVisible(true); 
    }


    public static void main(String args[])
    { 
        RadioAndScroll rbe = new RadioAndScroll(); 
    }

} 

class Practice2 extends JPanel implements ActionListener
{ 
    JRadioButton rb1,rb2,rb3, rb4,rb5,rb6, rb7,rb8,rb9; 
    JButton b; 
    JPanel pa, pa2;
    JLabel label1, label2; //vertical/horizontal slider output
    JLabel label, label3, label4; //output radio button chosen


    public Practice2() 
    {
        //setBackground( Color.YELLOW );
        runIt();
        // runScrollBar();
        //label.setBackground(Color.YELLOW);
    }
    public void paintComponent(Graphics g) 
    {
        super.paintComponent (g);
    }

    public void runIt()
    {
        label = new JLabel("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nJRadio");
        label3 = new JLabel("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nJRadio2");
        label4 = new JLabel("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nJRadio3");


        setLayout(new BorderLayout());
        pa= new JPanel();
        pa.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        pa.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(pa);
        pa.setLayout(new GridLayout(3,3, -1, -1)); //5=rows, 2=columns
        pa.setBorder(BorderFactory.createLineBorder(Color.blue));
        Border border = new LineBorder(Color.BLACK, 1, true);
        pa.setBorder(border);

        //add(rb3, BorderLayout.NORTH); html for centering

        //A
        JPanel pa2a= new JPanel(new GridLayout(3,1));
        pa2a.setBorder(new LineBorder(Color.BLACK, 2, true));
        rb1=new JRadioButton("One"); 
        rb1.setBackground(Color.WHITE);
        rb1.setBounds(100,50,100,30); 
        rb2=new JRadioButton("Two"); 
        rb2.setBackground(Color.WHITE); 
        rb2.setBounds(100,100,100,30); 
        rb3=new JRadioButton("Three"); 
        rb3.setBackground(Color.WHITE); 
        rb3.setBounds(100,100,100,30);
        ButtonGroup bg = new ButtonGroup(); 
        bg.add(rb1);
        bg.add(rb2); 
        bg.add(rb3);

        //B
        JPanel pa2b= new JPanel(new GridLayout(3,1));
        pa2b.setBorder(new LineBorder(Color.BLACK, 2, true));
        pa2b.add(label);
        pa2b.setBackground(Color.YELLOW);

        //C
        JPanel pa2c= new JPanel(new GridLayout(1,1));
        pa2c.setBorder(new LineBorder(Color.BLACK, 2, true));

        label2 = new JLabel("\t\t\t\t\t\t\t\n\n\n\n\n\n\n\nVertical: 0");
        JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 0, 0, 0, 100);

        pa2c.add(vbar);
        //pa2c.add(label2);
        vbar.addAdjustmentListener(new MyAdjustmentListenerv( ));

        //D
        JPanel pa2d= new JPanel(new GridLayout(3,1));
        pa2d.setBorder(new LineBorder(Color.BLACK, 2, true));
        rb4=new JRadioButton("One"); 
        rb4.setBackground(Color.WHITE);
        rb4.setBounds(100,50,100,30); 
        rb5=new JRadioButton("Two"); 
        rb5.setBackground(Color.WHITE); 
        rb5.setBounds(100,100,100,30); 
        rb6=new JRadioButton("Three"); 
        rb6.setBackground(Color.WHITE);
        rb6.setBounds(100,100,100,30); 
        ButtonGroup bg1 = new ButtonGroup(); 
        bg1.add(rb4);
        bg1.add(rb5); 
        bg1.add(rb6);

        //E
        JPanel pa2e= new JPanel(new GridLayout(3,1));
        pa2e.setBorder(new LineBorder(Color.BLACK, 2, true));
        pa2e.add(label3);
        pa2e.setBackground(Color.RED);

        //F
        JPanel pa2f= new JPanel(new GridLayout(1,1));
        pa2f.setBorder(new LineBorder(Color.BLACK, 2, true));

        //label1 = new JLabel( );
        label1 = new JLabel("\t\t\t\t\t\t\t\n\n\n\n\n\n\nHorizontal: 0");
        JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
        hbar.addAdjustmentListener(new MyAdjustmentListenerh( ));
        //pa2f.add(label1);
        pa2f.add(hbar);



        //G
        JPanel pa2g= new JPanel(new GridLayout(3,1));
        pa2g.setBorder(new LineBorder(Color.BLACK, 2, true));
        rb7=new JRadioButton("One"); 
        rb7.setBackground(Color.WHITE); 
        rb7.setBounds(100,50,100,30); 
        rb8=new JRadioButton("Two"); 
        rb8.setBackground(Color.WHITE);
        rb8.setBounds(100,100,100,30); 
        rb9=new JRadioButton("Three"); 
        rb9.setBackground(Color.WHITE); 
        rb9.setBounds(100,100,100,30);
        ButtonGroup bg2 = new ButtonGroup(); 
        bg2.add(rb7);
        bg2.add(rb8); 
        bg2.add(rb9);

        //H
        JPanel pa2h= new JPanel(new GridLayout(3,1));
        pa2h.setBorder(new LineBorder(Color.BLACK, 2, true));
        pa2h.add(label4);
        pa2h.setBackground(Color.GREEN);

        //I
        JPanel pa2i= new JPanel(new GridLayout(3,1));
        pa2i.setBorder(new LineBorder(Color.BLACK, 2, true));
        pa2i.add(label2);
        pa2i.add(label1);


        //adds radio buttons to group to ButtonGroup bg();






        rb1.addActionListener(this); 
        rb2.addActionListener(this); 
        rb3.addActionListener(this);
        rb4.addActionListener(this); 
        rb5.addActionListener(this); 
        rb6.addActionListener(this);
        rb7.addActionListener(this); 
        rb8.addActionListener(this); 
        rb9.addActionListener(this);

        pa2a.add(rb1); 
        pa2a.add(rb2); 
        pa2a.add(rb3);

        pa2d.add(rb4); 
        pa2d.add(rb5); 
        pa2d.add(rb6);

        pa2g.add(rb7); 
        pa2g.add(rb8); 
        pa2g.add(rb9);

        pa.add(pa2a);
        pa.add(pa2b);
        pa.add(pa2c);
        pa.add(pa2d);
        pa.add(pa2e);
        pa.add(pa2f);
        pa.add(pa2g);
        pa.add(pa2h);
        pa.add(pa2i);

    }

    public void actionPerformed(ActionEvent e)
    { 
        if(rb1.isSelected())
        { 
            label.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nOne"); 
            //label.setOpaque(true);
        } 
        if(rb2.isSelected())
        { 
            label.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nTwo");
        } 
        if(rb3.isSelected()) {
            label.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nThree");
        }
        if(rb4.isSelected())
        { 
            label3.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nOne"); 
        } 
        if(rb5.isSelected())
        { 
            label3.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nTwo");
        } 
        if(rb6.isSelected()) {
            label3.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nThree");
        }
        if(rb7.isSelected())
        { 
            label4.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nOne"); 
        } 
        if(rb8.isSelected())
        { 
            label4.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nTwo");
        } 
        if(rb9.isSelected()) {
            label4.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\nThree");
        }

    } 



    public void runScrollBar()
    {
        /*
           pa2 = new JPanel();
           pa2.setLayout(new GridLayout(3,3));
           label1 = new JLabel( );
           label2 = new JLabel( );
           JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
           JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);

           hbar.addAdjustmentListener(new MyAdjustmentListenerh( ));
           vbar.addAdjustmentListener(new MyAdjustmentListenerv( ));

           pa2.add(label1);
           pa2.add(hbar);
           pa2.add(vbar);
           pa2.add(label2);
        //pa2.add(new JRadioButton("yes27"));
        add(pa2, BorderLayout.SOUTH); */


    }

    class MyAdjustmentListenerh implements AdjustmentListener {
        public void adjustmentValueChanged(AdjustmentEvent e) {
            label1.setText("\t\t\t\t\t\t\t\n\n\n\n\n\n\n\nHorizontal: " + e.getValue()); //horizontal slider's position

        }
    }
    class MyAdjustmentListenerv implements AdjustmentListener {
        public void adjustmentValueChanged(AdjustmentEvent e) {
            //label2.setText("Vertical Slider's position is " + e.getValue());
            label2.setText("\t\t\t\t\t\t\t\n\n\n\n\n\n\n\nVertical: " + e.getValue()); //vertical slider's position
        }
    }
}
