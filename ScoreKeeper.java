/*Sudipti Dantuluri
 * 3.22.2022
 * ScoreKeeper.java
 * The program uses grid layouts to output score of Team 1 and Team 2 using commands from events.*/
import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*; 

public class ScoreKeeper extends JFrame
{
    public static void main(String[] args) {
        ScoreKeeper sk = new ScoreKeeper();
    } 
    public ScoreKeeper() {
        super("ScoreKeeper");
        setSize( 600, 600); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setLocation(400,50);
        setResizable(true);
        Practice pc = new Practice(); 
        setContentPane( pc ); // OR frame.getContentPane().add(p_in);
        setVisible(true); 
    }
}

class Practice extends JPanel { 
    JTextArea jtext;
    JLabel jlabel1, jlabel2, jlabel3;
    JButton ba3, ba4, ba5, ba6, ba7, ba8;
    int team1Num = 0;
    int team2Num = 0;
    public Practice() {
        runIt();
        jlabel1.setBackground(Color.YELLOW);
        jlabel2.setBackground(Color.GREEN);
        jlabel3.setBackground(Color.BLUE);
        jtext.setBackground(Color.BLUE);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent (g);
        //g.drawString("JoeBob",50,400);
    }
    public void runIt() {
        jlabel1=new JLabel("\n\n\t\t\t                         Team 1");
        jlabel1.setOpaque(true);
        jlabel1.setPreferredSize(new Dimension(300,115));
        jlabel2=new JLabel("\n\n\t\t\t                         Team 2");
        jlabel2.setOpaque(true);
        jlabel2.setPreferredSize(new Dimension(300,115));
        ba3=new JButton("Plus 1");
        ba3.setPreferredSize(new Dimension(300,115));
        ba3.addActionListener(new clickHandle1());
        ba4=new JButton("Plus 1");
        ba4.setPreferredSize(new Dimension(300,115));
        ba4.addActionListener(new clickHandle2());
        ba5=new JButton("Plus 2");
        ba5.setPreferredSize(new Dimension(300,115));
        ba5.addActionListener(new clickHandle1());
        ba6=new JButton("Plus 2");
        ba6.setPreferredSize(new Dimension(300,115));
        ba6.addActionListener(new clickHandle2());
        ba7=new JButton("Plus 3");
        ba7.setPreferredSize(new Dimension(300,115));
        ba7.addActionListener(new clickHandle1());
        ba8=new JButton("Plus 3");
        ba8.setPreferredSize(new Dimension(300,115));
        ba8.addActionListener(new clickHandle2());
        jlabel3 = new JLabel("\t\t\t                          Score ->");
        jlabel3.setOpaque(true);
        jlabel3.setPreferredSize(new Dimension(300,115));
        jtext = new JTextArea("\n\n\t   Team 1: " + team1Num + "\n\t   Team 2: " + team2Num);
        jtext.setPreferredSize(new Dimension(300,115));
        //JTextArea jt1= new JTextArea("JTextArea");
        //JLabel
        JPanel pa = new JPanel();
        add(pa);
        pa.setLayout(new GridLayout(5,2,0,0));
        pa.add(jlabel1);
        pa.add(jlabel2);
        pa.add(ba3);
        pa.add(ba4);
        pa.add(ba5);
        pa.add(ba6);
        pa.add(ba7);
        pa.add(ba8);
        pa.add(jlabel3); 
        pa.add(jtext);

    }

    class clickHandle1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            System.out.println("clickHandle1: " + actionCommand);
            if (actionCommand.equals("Plus 1")) {
                team1Num++;
                System.out.print(actionCommand);
                System.out.print(team1Num);
                JPanel pa = new JPanel();
                add(pa);
                jtext.setText("\n\n\t Team 1: " + team1Num + "\n\t Team 2: " + team2Num);
                repaint();
            }
            if (actionCommand.equals("Plus 2")) {
                team1Num = team1Num+2;
                System.out.print(actionCommand);
                System.out.print(team2Num);
                JPanel pa = new JPanel();
                add(pa);
                jtext.setText("\n\n\t Team 1: " + team1Num + "\n\t Team 2: " + team2Num);
                repaint();
            }
            if (actionCommand.equals("Plus 3")) {
                team1Num = team1Num+3;
                System.out.print(actionCommand);
                System.out.print(team2Num);
                JPanel pa = new JPanel();
                add(pa);
                jtext.setText("\n\n\t Team 1: " + team1Num + "\n\t Team 2: " + team2Num);
                repaint();
            }
        }
    }
    class clickHandle2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            System.out.println("clickHandle2: " + actionCommand);
            if (actionCommand.equals("Plus 1")) {
                team2Num++;
                System.out.print(actionCommand);
                System.out.print(team2Num);
                JPanel pa = new JPanel();
                add(pa);
                jtext.setText("\n\n\t Team 1: " + team1Num + "\n\t Team 2: " + team2Num);
                repaint();
            }
            if (actionCommand.equals("Plus 2")) {
                team2Num = team2Num+2;
                System.out.print(actionCommand);
                System.out.print(team2Num);
                JPanel pa = new JPanel();
                add(pa);
                jtext.setText("\n\n\t Team 1: " + team1Num + "\n\t Team 2: " + team2Num);
                repaint();
            }
            if (actionCommand.equals("Plus 3")) {
                team2Num = team2Num+3;
                System.out.print(actionCommand);
                System.out.print(team2Num);
                JPanel pa = new JPanel();
                add(pa);
                jtext.setText("\n\n\t Team 1: " + team1Num + "\n\t Team 2: " + team2Num);
                repaint();
            }


        }
    }
}
    


