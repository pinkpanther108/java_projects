/*
   Aditi Dantuluri
 * 3/12/22
 * KEY.java
 * Week one of game project*/

import javax.swing.*;
import java.awt.*;

public class KEY extends JFrame
{
  public KEY()
    //make start panel
  {
    super ("KEY");
    setSize( 600, 600);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocation(200,100);
    setResizable(true);
    Panel pan = new Panel();
    setContentPane(pan);
    setVisible(true);
  }

  public static void main (String [] args)
  {
    KEY JoeBobKim = new KEY();
  }
}

class Panel extends JPanel
{
  public Panel()
  {
    setBackground(new Color( 255, 179, 199));
  }
  public void paintComponent(Graphics g)
    //add in the start panels text introductions and colors
  {
    super.paintComponent(g);

    g.setColor(Color.RED);
    Font sericBold20 = new Font("Luminari",Font.PLAIN,35);
    g.setFont(sericBold20);
    g.drawString("WELCOME   TO...", 170, 40);


    Font PREDATOR = new Font("Luminari",Font.BOLD,50);
    g.setFont(PREDATOR);
    g.drawString("PREDATORS   KEY",87,130);




    /*
    //A
    g.drawLine(140,300,180,200);
    g.drawLine(180,200,220,300);
    g.drawLine(160,260,200,260);
    */

  }

  public void newframe() {
    //make instructions button to know how to play game
    JButton start1 = new JButton("intructions");
    start1.addActionListener(e -> cl.previous(panel));
    start1.setPreferredSize(new Dimension(600,120));
    start1.setFont(new Font("Luminari", Font.PLAIN, 30));
    start1.setOpaque(true);
    start1.setBackground(Color.RED);
    //this is the action listener
    start1.setBounds(110,380,400,100);
    add(start1);




    //make start button
    JButton start = new JButton("start");
    start.addActionListener(e -> cl.next(panel));

    start.setPreferredSize(new Dimension(600,120));
    start.setFont(new Font("Luminari", Font.PLAIN, 30));
    start.setOpaque(true);
    start.setBackground(Color.RED);
    //this is the action listener
    start.setBounds(110,210,400,100);
    add(start);

    JButton start1 = new JButton("intructions2");
    CardLayout cl = new CardLayout();
    panel.setLayout(cl);
    start1.addActionListener(e -> cl.previous(panel));
  }

  class startListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      sent = "Game";
      t1.setText("\n\n\n                     " + sent);
      repaint();
    }
  }
}
