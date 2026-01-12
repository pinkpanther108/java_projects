import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GameMenu {
    public GameMenu()
    {
        JFrame frame = new JFrame();
        frame.setSize(900, 900);
        Practice pc = new Practice();
        frame.setContentPane(pc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
    }

    class Practice extends JPanel
    {

        private JButton button1, button2, button3;
        private JTextArea t1, t2;
        String sent = "Press A Button!";
        Font ft = new Font("Serif", Font.BOLD, 40);
        private JCheckBox checkBox1, checkBox2, checkBox3;
        private JLabel name;

        public Practice()
        {
            runIt();
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            menuBackground(g);
        }

        public void menuBackground(Graphics g){
            Image stickmen = new ImageIcon("Downloads/JavaGameProject/src/stickmen.png").getImage();
            g.drawImage(stickmen, 0, 0, 900, 900, null);
        }

        public void runIt()
        {
            JPanel panel = new JPanel();
            JPanel panel1 = new JPanel(new BorderLayout());
            JPanel panel2 = new JPanel(new BorderLayout());
            JPanel panel3 = new JPanel();

            JPanel btnPanel = new JPanel();

            JPanel btnPanel2 = new JPanel();
            JPanel tPanel = new JPanel();

            JPanel tPanel2 = new JPanel();

            JButton btn1 = new JButton("NEXT");
            JButton btn2 = new JButton("PREVIOUS");

            CardLayout cardLayout = new CardLayout();
            panel.setLayout(cardLayout);

            button1 = new JButton("Button 1");
            type1 b1 = new type1();
            button1.addActionListener( b1 );
            btnPanel2.add(button1);

            button2 = new JButton("Button 2");
            type2 b2 = new type2();
            button2.addActionListener( b2 );
            btnPanel2.add(button2);

            button3 = new JButton("Button 3");
            type3 b3 = new type3();
            button3.addActionListener( b3 );
            btnPanel2.add(button3);

            t1 = new JTextArea();
            t1.setFont(ft);
            t1.setText("\n\n\n              " + sent);
            t1.setOpaque(true);
            t1.setBackground(Color.BLUE);
            t1.setPreferredSize(new Dimension (580, 400));
            tPanel.add( t1 );

            t2 = new JTextArea();
            t2.setFont(ft);
            t2.setText("J\tJ\nT\tT\nE\tE\nX\tX\nT\tT\nA\tA\nR\tR\nE\tE\nA\tA\n");
            t2.setOpaque(true);
            t2.setBackground(Color.BLUE);
            t2.setPreferredSize(new Dimension (400, 450));
            tPanel2.add( t2 );

            panel.add(panel1, "link1");
            panel.add(panel2, "link2");
            panel.add(panel3, "link3");

            btn1.addActionListener(e -> cardLayout.next(panel));
            btn2.addActionListener(e -> cardLayout.previous(panel));

            btnPanel.add(btn1);
            btnPanel.add(btn2);

            add(btnPanel, BorderLayout.NORTH);

            panel1.add(tPanel, BorderLayout.SOUTH);
            panel1.add(btnPanel2, BorderLayout.CENTER);

            panel2.add(tPanel2, BorderLayout.CENTER);

            add(panel);
        }

        class type1 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                sent = "Button 1";
                t1.setText("\n\n\n                     " + sent);
                repaint();
            }
        }

        class type2 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                sent = "Button 2";
                t1.setText("\n\n\n                     " + sent);
                repaint();
            }
        }

        class type3 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                sent = "Button 3";
                t1.setText("\n\n\n                     " + sent);
                repaint();
            }
        }
    }
}