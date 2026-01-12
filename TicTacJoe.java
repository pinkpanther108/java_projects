/*Sudipti Dantuluri
 * 4.1.2022
 * TicTacJoe.java
 * The program uses layouts.*/

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
        String s = "<html>";
        String right = "RIGHT";
        for(int i=0;i<right.length();i++) {
            s+= right.charAt(i) + "<br>";
        }
        s += "</html>";
        JLabel la3 = new JLabel(s);
        la3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la4=new JLabel("LEFT");
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
        JLabel la3b=new JLabel("RIGHT");
        la3b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la4b=new JLabel("LEFT");
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
        JLabel la3c=new JLabel("RIGHT");
        la3c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la4c=new JLabel("LEFT");
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
        JLabel la3d=new JLabel("RIGHT");
        la3d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la4d=new JLabel("LEFT");
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
        JLabel la3e=new JLabel("RIGHT");
        la3e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel la4e=new JLabel("LEFT");
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
