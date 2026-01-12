// Parth Upadhyay
// GameMenu.java
// April 25,2022
// To Make My Game Project

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private JPanel adb = new JPanel(new BorderLayout());
    Timer updater;
    ArrayList<Stickman> left, right;
    int cameraPos = 400;
    int range = 900;
   public GamePanel()
   {
      JPanel cbp = new JPanel();
      JPanel units = new JPanel();

      ImageIcon backtoFort = new ImageIcon("btf.jpg");
      Image btfImage = backtoFort.getImage();
      Image nbtfImage = btfImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
      backtoFort = new ImageIcon(nbtfImage);
      JButton btf = new JButton(backtoFort);


      ImageIcon def = new ImageIcon("defend.jpg");
      Image defImage = def.getImage();
      Image ndefimg = defImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
      def = new ImageIcon(ndefimg);
      JButton defend = new JButton(def);

      ImageIcon att = new ImageIcon("attack.jpg");
      Image attimg = att.getImage();
      Image natimg = attimg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
      att = new ImageIcon(natimg);
      JButton attack = new JButton(att);



      ImageIcon sword = new ImageIcon("sword.jpg");
      Image swrdimg = sword.getImage();
      Image nimg = swrdimg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
      sword = new ImageIcon(nimg);
      JButton swrdB = new JButton(sword);

       ImageIcon smg = new ImageIcon("smg.jpg");
       Image smgimg = smg.getImage();
       Image nsmg = smgimg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
       smg = new ImageIcon(nsmg);
       JButton smgB = new JButton(smg);


      cbp.add(attack);
      cbp.add(defend);
      cbp.add(btf);

      units.add(swrdB);
      units.add(smgB);

      adb.add(units, BorderLayout.WEST);
      adb.add(cbp, BorderLayout.EAST);

//     adb.setBackground(Color.CYAN);
      adb.setSize(new Dimension(300, 300));
      setLayout(new BorderLayout());
      this.add(adb , BorderLayout.SOUTH);
      left = new ArrayList<Stickman>();
      right = new ArrayList<Stickman>();
      updater = new Timer(10, this);
      //updater.start();
      for(int i = 0; i < 10; i++)
      {
          int x = 250 * i;
          int y = 20*i;
          left.add(new Stickman(x,y,10,new Color(25*i, 0, 0)));
      }
   }

   public void actionPerformed(ActionEvent e)
   {
     updateMove();
     repaint();
   }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Image desert = new ImageIcon("desert.jpg").getImage();
        g.drawImage(desert, 0, 0, 900,900, null);


        for(int i = 0; i < left.size(); i++) {
            int relativePos = left.get(i).x - cameraPos;
            if(relativePos > 0 && relativePos < range) {
                g.setColor(left.get(i).color);
                g.fillRect(relativePos, left.get(i).y, 10, 10);
            }
        }

    }

    public void updateMove()
    {
        for(int i = 0; i < left.size(); i++)
        {

            left.get(i).x += left.get(i).moveSpeed;
        }
    }

    public void checkCollide()
    {
        for(int i = 0; i < left.size(); i++)
        {
//            for(int j = 0; j < right.size(); j++) {
////
//            }
        }
    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }
}
