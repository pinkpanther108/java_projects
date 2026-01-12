import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JMenuBarExample2 extends JFrame  {
    

    public JMenuBarExample2()
    {
	  super("JMenuBarExample");
	  setSize( 600, 600);    
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
	  setLocation(400,50);
	  setResizable(true);
	  Practice2 pc = new Practice2();   
	  setContentPane( pc );
	  setVisible(true);  
	}
    public static void main(String[] args)
    {
        // create an object of the class
        JMenuBarExample2 jmbe2 = new JMenuBarExample2();
    }
}

class Practice2 extends JPanel 
{ 
	JMenuBar mb;	// menubar
    JMenu x, x1;	// JMenu
    JMenuItem m1, m2, m3, s1, s2;	// Menu items
    JFrame f; 		// create a frame
    JLabel l;		// a label
    JPanel pa;
	public Practice2() 
	{
		setBackground( Color.WHITE );
		runIt2();
	}
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
	}
	public void runIt2()
	{
		pa = new JPanel();
		l = new JLabel("no task ");
        mb = new JMenuBar();
        // create a menu
        x = new JMenu("March");
        x1 = new JMenu("2022");

		Monthclass mclass = new Monthclass();
		Yearclass yclass = new Yearclass();
		
		
        // create menuitems
        String months[] = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"}; 
        String nums[] = {"2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032"};
        JMenuItem[] items = new JMenuItem[12];
        JMenuItem[] years = new JMenuItem[21];
        
        for (int i = 0; i < 12; i++)
        {
			items[i] = new JMenuItem(months[i]);
			items[i].addActionListener(mclass);
		}
		
		for (int k = 0; k < 21; k++)
		{
			years[k] = new JMenuItem(nums[k]);
			years[k].addActionListener(yclass);
		}
		
		for (int j = 0; j < 12; j++)
		{
			x.add(items[j]);
		}
		
		for (int l = 0; l < 21; l++)
		{
			x1.add(years[l]);
		}
        mb.add(x);       
        mb.add(x1);
        pa.setLayout(new BorderLayout());
        pa.setLayout(new GridLayout(5,7));
		pa.add(mb, BorderLayout.NORTH);
        pa.add(l, BorderLayout.SOUTH);
        add(pa);
	}
    
    class Monthclass implements ActionListener
    {	
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			x.setText(command);			
		}
	}
	
	class Yearclass implements ActionListener
    {	
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			x1.setText(command);			
		}
	}
}