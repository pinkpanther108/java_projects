/*Sudipti Dantuluri
 * 4.5.2022
 * TicTacJoe.java
 * The program uses border and grid layouts to output a 3x3 panel.*/

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*; 

public class TicTacJoe extends JFrame
{
    public static void main(String[] args) 
    {
        TicTacJoe ttj = new TicTacJoe();
    } 
    public TicTacJoe()
    {
        super("TicTacJoe.java");
        setSize( 600, 600); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setLocation(400,50);
        setResizable(true);
        Practice pc = new Practice(); 
        setContentPane( pc );
        setVisible(true); 
    }
}

class Practice extends JPanel
{ 
    JPanel pa;
    JLabel jl1, jl1b, jl1c, jl1e;
    public Practice() 
    {
        runIt();
        jl1.setBackground(Color.GREEN);
        jl1b.setBackground(Color.RED);
        jl1c.setBackground(Color.GRAY);
        jl1e.setBackground(Color.ORANGE);
    }
    public void paintComponent(Graphics g) 
    {
        super.paintComponent (g);
    }
    public void runIt()
    {
        String num = "";

        setLayout(new GridLayout(3,3));
        //pa = new JPanel();
        //add(pa);
        //pa.setLayout(new GridLayout(3,3));

        //panel 1
        JPanel pa1= new JPanel(new GridLayout(3,1));
        JLabel la1 = new JLabel("<html>" + "Top 1" + "<br>" +num+ "</html>");
        la1.setHorizontalAlignment(JLabel.CENTER);
        la1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //ba1.setPreferredSize(new Dimension(200,100));
        JLabel la2=new JLabel("Bottom 1");
        la2.setHorizontalAlignment(JLabel.CENTER);
        la2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String right1HTML = "<html>";
        String right1 = "RIGHT1";
        for(int i=0;i<right1.length();i++) {
            right1HTML+= right1.charAt(i) + "<br>";
        }
        right1HTML += "</html>";
        JLabel la3 = new JLabel(right1HTML);
        la3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String left1HTML = "<html>";
        String left1 = "LEFT1";
        for(int i=0;i<left1.length();i++) {
            left1HTML+= left1.charAt(i) + "<br>";
        }
        left1HTML += "</html>";
        JLabel la4=new JLabel(left1HTML);
        la4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1 = new JLabel("TIC");
        jl1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1.setOpaque(true);
        jl1.setHorizontalAlignment(JLabel.CENTER);
        pa1.setLayout(new BorderLayout());
        pa1.add(la1, BorderLayout.NORTH);
        pa1.add(la2, BorderLayout.SOUTH);
        pa1.add(la3, BorderLayout.EAST);
        pa1.add(la4, BorderLayout.WEST);
        pa1.add(jl1, BorderLayout.CENTER); 

        //panel 2
        JPanel pa2 = new JPanel(new GridLayout(3,3));
        JLabel [] tac = new JLabel[9];
        tac = gridLabels("TAC");
        for(int i = 0; i<9;i++) {
            tac[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tac[i].setHorizontalAlignment(JLabel.CENTER);
            pa2.add(tac[i]); 
        }
        pa2.setBackground(Color.YELLOW);

        //panel 3
        JPanel pa3 = new JPanel(new GridLayout(3,1));
        JLabel la1b = new JLabel("<html>" + "Top 2" + "<br>" +num+ "</html>");
        la1b.setHorizontalAlignment(JLabel.CENTER);
        la1b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //ba1b.setPreferredSize(new Dimension(600,100));
        JLabel la2b=new JLabel("Bottom 2");
        la2b.setHorizontalAlignment(JLabel.CENTER);
        la2b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String right2HTML = "<html>";
        String right2 = "RIGHT2";
        for(int i=0;i<right2.length();i++) {
            right2HTML+= right2.charAt(i) + "<br>";
        }
        right2HTML += "</html>";
        JLabel la3b = new JLabel(right2HTML);
        la3b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String left2HTML = "<html>";
        String left2 = "LEFT2";
        for(int i=0;i<left2.length();i++) {
            left2HTML+= left2.charAt(i) + "<br>";
        }
        left2HTML += "</html>";
        JLabel la4b=new JLabel(left2HTML);
        la4b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1b = new JLabel("TOE");
        jl1b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1b.setOpaque(true);
        jl1b.setHorizontalAlignment(JLabel.CENTER);
        pa3.setLayout(new BorderLayout());
        pa3.add(la1b, BorderLayout.NORTH);
        pa3.add(la2b, BorderLayout.SOUTH);
        pa3.add(la3b, BorderLayout.EAST);
        pa3.add(la4b, BorderLayout.WEST);
        pa3.add(jl1b, BorderLayout.CENTER); 

        //panel 4
        JPanel pa4= new JPanel(new GridLayout(3,1));
        JLabel [] tic = new JLabel[9];
        tic = gridLabels("TIC");
        for(int i = 0; i<9;i++) {
            tic[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tic[i].setHorizontalAlignment(JLabel.CENTER);
            //tic[i].setForeground(Color.BLACK);
            pa4.add(tic[i]);
        }
        pa4.setBackground(Color.BLUE);

        //panel 5
        JPanel pa5= new JPanel(new GridLayout(3,1));
        JLabel la1c = new JLabel("<html>" + "Top 3" + "<br>" +num+ "</html>");
        la1c.setHorizontalAlignment(JLabel.CENTER);
        la1c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la2c=new JLabel("Bottom 3");
        la2c.setHorizontalAlignment(JLabel.CENTER);
        la2c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String right3HTML = "<html>";
        String right3 = "RIGHT3";
        for(int i=0;i<right3.length();i++) {
            right3HTML+= right3.charAt(i) + "<br>";
        }
        right3HTML += "</html>";
        JLabel la3c = new JLabel(right3HTML);
        la3c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String left3HTML = "<html>";
        String left3 = "LEFT3";
        for(int i=0;i<left3.length();i++) {
            left3HTML+= left3.charAt(i) + "<br>";
        }
        left3HTML += "</html>";
        JLabel la4c=new JLabel(left3HTML);
        la4c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1c = new JLabel("TIC");
        jl1c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1c.setHorizontalAlignment(JLabel.CENTER);
        jl1c.setOpaque(true);
        pa5.setLayout(new BorderLayout());
        pa5.add(la1c, BorderLayout.NORTH);
        pa5.add(la2c, BorderLayout.SOUTH);
        pa5.add(la3c, BorderLayout.EAST);
        pa5.add(la4c, BorderLayout.WEST);
        pa5.add(jl1c, BorderLayout.CENTER); 

        //panel 6 
        JPanel pa6= new JPanel(new GridLayout(3,1));
        JLabel [] toe = new JLabel[9];
        toe = gridLabels("TOE");
        for(int i = 0; i<9;i++) {
            toe[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            toe[i].setHorizontalAlignment(JLabel.CENTER);
            //toe[i].setForeground(Color.BLACK);
            pa6.add(toe[i]);
        }
        pa6.setBackground(Color.MAGENTA);

        //panel 7
        JPanel pa7= new JPanel(new GridLayout(3,1));
        JLabel la1d = new JLabel("<html>" + "Top 4" + "<br>" +num+ "</html>");
        la1d.setHorizontalAlignment(JLabel.CENTER);
        la1d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la2d=new JLabel("Bottom 4");
        la2d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        la2d.setHorizontalAlignment(JLabel.CENTER);
        String right4HTML = "<html>";
        String right4 = "RIGHT4";
        for(int i=0;i<right4.length();i++) {
            right4HTML+= right4.charAt(i) + "<br>";
        }
        right4HTML += "</html>";
        JLabel la3d = new JLabel(right4HTML);
        la3d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String left4HTML = "<html>";
        String left4 = "LEFT4";
        for(int i=0;i<left4.length();i++) {
            left4HTML+= left4.charAt(i) + "<br>";
        }
        left4HTML += "</html>";
        JLabel la4d=new JLabel(left4HTML);
        la4d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel jl1d = new JLabel("TOE");
        jl1d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1d.setHorizontalAlignment(JLabel.CENTER);
        pa7.setLayout(new BorderLayout());
        pa7.add(la1d, BorderLayout.NORTH);
        pa7.add(la2d, BorderLayout.SOUTH);
        pa7.add(la3d, BorderLayout.EAST);
        pa7.add(la4d, BorderLayout.WEST);
        pa7.add(jl1d, BorderLayout.CENTER); 

        //panel 8 
        JPanel pa8= new JPanel(new GridLayout(3,1));
        JLabel [] joe = new JLabel[9];
        joe = gridLabels("JOE");
        for(int i = 0; i<9;i++) 
        {
            joe[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            joe[i].setHorizontalAlignment(JLabel.CENTER);
            joe[i].setForeground(Color.WHITE);
            pa8.add(joe[i]);
        }
        //add(pa8);
        pa8.setBackground(Color.BLACK);

        //panel 9
        JPanel pa9= new JPanel(new GridLayout(3,1));
        JLabel la1e = new JLabel("<html>" + "Top 5" + "<br>" +num+ "</html>");
        la1e.setHorizontalAlignment(JLabel.CENTER);
        la1e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la2e=new JLabel("Bottom 5");
        la2e.setHorizontalAlignment(JLabel.CENTER);
        la2e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String right5HTML = "<html>";
        String right5 = "RIGHT5";
        for(int i=0;i<right5.length();i++) {
            right5HTML+= right5.charAt(i) + "<br>";
        }
        right5HTML += "</html>";
        JLabel la3e = new JLabel(right5HTML);
        la3e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String left5HTML = "<html>";
        String left5 = "LEFT5";
        for(int i=0;i<left5.length();i++) {
            left5HTML+= left5.charAt(i) + "<br>";
        }
        left5HTML += "</html>";
        JLabel la4e=new JLabel(left5HTML);
        la4e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1e = new JLabel("TIC");
        jl1e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl1e.setOpaque(true);
        jl1e.setHorizontalAlignment(JLabel.CENTER);
        pa9.setLayout(new BorderLayout());
        pa9.add(la1e, BorderLayout.NORTH);
        pa9.add(la2e, BorderLayout.SOUTH);
        pa9.add(la3e, BorderLayout.EAST);
        pa9.add(la4e, BorderLayout.WEST);
        pa9.add(jl1e, BorderLayout.CENTER); 


        add(pa1);
        add(pa2);
        add(pa3);
        add(pa4);
        add(pa5);
        add(pa6);
        add(pa7);
        add(pa8);
        add(pa9);

    }

    public JLabel[] gridLabels(String word)
    {
        JLabel labels [] = new JLabel[9];
        for(int i = 0; i<9;i++) labels[i] = new JLabel(word);
        return labels; 
    }
}
