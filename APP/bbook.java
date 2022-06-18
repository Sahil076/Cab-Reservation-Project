import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class bbook extends JFrame implements ActionListener
{
	JButton book,later;
	JOptionPane pane;
	JDialog d;
	bbook()
	{
		//font
		Font f=new Font("Georgia",Font.BOLD,28);
		book=new JButton("Start Booking");
		
		book.setBounds(385,170,240,100);
		book.setFont(f);
		book.setBackground(new Color(154,205,50,50)); 
		book.addActionListener(this);


		later=new JButton("Later!");
		later.setBounds(380,450,150,70);
		later.setFont(f);
		later.setBackground(new Color(154,205,50)); 
		later.addActionListener(this);

		//frame
		setSize(900,600);
		setLayout(null);
		setTitle("Myapp");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//background
		ImageIcon bgimg=new ImageIcon("bgimage3.png");
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.setBounds(0,0,900,600);
		add(bg);
		bg.add(book);
		bg.add(later);	
	}
	public void actionPerformed(ActionEvent qq)
	{
		if(qq.getSource()==book)
		{
			this.setVisible(false);
			new Bookk().setVisible(true);
		}	
		if (qq.getSource()==later) 
		{
			System.exit(0);	
		}
	}
	public static void main(String[] args) 
	{
		new bbook();	
	}
}
