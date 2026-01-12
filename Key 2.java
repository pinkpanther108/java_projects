/*
   Aditi Dantuluri
 * 3/12/22
 * Key.java
 * Week one of game project*/

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

public class Key extends JFrame {
  Start st = new Start();
  public static void main (String [] args) {
    Key JoeBobKim = new Key();
  }
  public Key() {
    //make start panel
    super ("Key");
    setSize( 600, 600);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocation(200,100);
    setResizable(true);

    JPanel pan = new JPanel();
    CardLayout cl = new CardLayout();
    pan.setLayout(cl);

    //Start enter = new Start();
    pan.add(st, "one");
    cl.show(pan, "one");
    setContentPane(pan);
    setVisible(true);
  }

  class Instruction extends JPanel {
    public Instruction() {
      setLayout(null);
      setBackground(new Color( 155, 279, 199));
      //runit();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //Image stickman = new ImageIcon("stickman.jpg").getImage();
      Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
    }
  }

  class Play extends JPanel {
    public Play() {
      setLayout(null);
      setBackground(new Color( 255, 179, 199));
      //runit();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //Image stickman = new ImageIcon("stickman.jpg").getImage();
      Image startPageBackground = new ImageIcon("frontPageBackground.jpg").getImage();
    }
  }



  class Start extends JPanel {
    public Start() {
      setLayout(null);
      setBackground(new Color( 255, 179, 199));
      runit();
    }

    public void paintComponent(Graphics g) {
      //add in the start panels text introductions and colors
      super.paintComponent(g);

      g.setColor(Color.RED);
      Font sericBold20 = new Font("Luminari",Font.PLAIN,35);
      g.setFont(sericBold20);
      Listener l = new Listener();
      //button.addActionListener(l);
      Play playclass = new Play();
      g.drawString("WELCOME   TO...", 170, 40);
      Font predator = new Font("Luminari",Font.BOLD,50);
      g.setFont(predator);
      g.drawString("Predators   Key",87,130);
    }

    class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
      }
    }

    public void runit() {
      //make start button
      Instruction instr = new Instruction();
      Play play = new Play();
      add(instr, "instructions");
      add(play, "play");

      JPanel panel = new JPanel();
      CardLayout cl = new CardLayout();
      panel.setLayout(cl);

      JButton first = new JButton("start");

      first.addActionListener(e -> cl.next(panel));

      first.setPreferredSize(new Dimension(600,120));
      first.setFont(new Font("Luminari", Font.PLAIN, 30));
      first.setOpaque(true);
      first.setBackground(Color.RED);
      //this is the action listener
      first.setBounds(110,180,400,100);
      //make instructions button to know how to play game
      JButton instructions = new JButton("instructions");
      //listner
      //start1.addActionListener(this);
      instructions.setPreferredSize(new Dimension(600,120));
      instructions.setFont(new Font("Luminari", Font.PLAIN, 30));
      instructions.setOpaque(true);
      instructions.setBackground(Color.RED);
      instructions.setBounds(110,380,400,100);
      add(first);
      add(instructions);

      //JButton start = new JButton("instructions");
      //start.addActionListener(e -> cl.next(panel));

      //draw main road obstacles
      /*  g.setColor(Color.BLUE);
          g.fillOval(carX+2, carY, 20, 20); // back wheel
          g.fillOval(carX+40, carY, 40, 40); // front wheel
          g.fillRect(carX, carY-20, 60, 20); // main body
          g.fillRect(carX+10, carY-35, 40, 15); // top
          g.setColor(Color.RED); //truck
          g.fillOval(carX+2, carY, 20, 20); // back wheel
          g.fillOval(carX+40, carY, 40, 40); // front wheel
          g.fillRect(carX, carY-20, 60, 20); // main body
          g.fillRect(carX+10, carY-35, 40, 15); // top
          g.setColor(Color.YELLOW);
          g.fillOval(carX+2, carY, 20, 20); // back wheel
          g.fillOval(carX+40, carY, 40, 40); // front wheel
          g.fillRect(carX, carY-20, 60, 20); // main body
          g.fillRect(carX+10, carY-35, 40, 15); // top

          g.setColor(Color.PINK);
          g.fillOval(carX+2, carY, 20, 20); // back wheel
          g.fillOval(carX+40, carY, 40, 40); // front wheel
          g.fillRect(carX, carY-20, 60, 20); // main body
          g.fillRect(carX+10, carY-35, 40, 15); // top

          g.setColor(Color.GREEN);
          g.fillOval(carX+2, carY, 20, 20); // back wheel
          g.fillOval(carX+40, carY, 40, 40); // front wheel
          g.fillRect(carX, carY-20, 60, 20); // main body
          */  //g.fillRect(carX+10, carY-35, 40, 15);//top of car
    }


  }
}
