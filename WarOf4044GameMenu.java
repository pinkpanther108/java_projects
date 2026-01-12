// Parth Upadhyay
// WarOf4044GameMenu.java
// April 25,2022
// To Make My Game Project
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WarOf4044GameMenu {
    StartPanel wf = new StartPanel();
    public WarOf4044GameMenu()
    {
        JFrame frame = new JFrame();
        frame.setSize(900, 900);
        GamePanel gp = new GamePanel();
        frame.setContentPane(wf);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
       WarOf4044GameMenu war = new WarOf4044GameMenu();
    }


    class StartPanel extends JPanel {
        CardLayout cl = new CardLayout();
        public StartPanel()
        {
            gameMenu();
        }

        public void gameMenu()
        {
            mainPanel mp = new mainPanel();
            GamePanel gp = new GamePanel();
            JPanel settingsPanel = new JPanel();
            JPanel instructionPanel = new JPanel();


            setLayout(cl);

            add(mp , "Start Screen");
            add(gp, "Game Panel");
            add(settingsPanel, "Settings Panel");
            add(instructionPanel, "Instructions Panel");



        }

    }

    class mainPanel extends JPanel
    {
        mainPanel()
        {
            setLayout(null);
            JButton startButton = new JButton("Play");
            add(startButton);
            startButton.setBounds(0, 0, 150, 50);
            startButton.addActionListener(new sbuttonListener());



            JButton settingsButton = new JButton("Settings");
            add(settingsButton);
            settingsButton.setBounds(150, 0, 150, 50);

            JButton instructionsButton = new JButton("Instructions");
            add(instructionsButton);
            instructionsButton.setBounds(300, 0, 150, 50);
        }


        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Image stickman = new ImageIcon("stickman.jpg").getImage();
            g.drawImage(stickman, 0, 0, 900,900, null);

        }
    }

    class sbuttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String sbutton = e.getActionCommand();

            if(sbutton.equalsIgnoreCase("Play"))
            {
                wf.cl.show(wf, "Game Panel");
            }
        }
    }

}

