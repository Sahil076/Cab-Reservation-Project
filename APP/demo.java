import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class demo extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5;
	JTextField user,t1,t2,t3,t4,pass;
	JButton bcreate,bback;
	JComboBox comboBox;
	Choice c1;
	String commm,cu,cp,ct1,ct2,ct3; //pas
	int iu=0,ip=0,it1=0,it2=0,it3=0,ff=1,sr;
	JOptionPane pane;
	JDialog d;
	demo()
	{

		//font
		Font f=new Font("Tahoma",Font.BOLD,18);
		//header
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		
		heading.setBounds(0,0,900,80);
		JLabel name=new JLabel("WELCOME! NAMASTE! ");
		name.setFont(new Font("Tahoma",Font.BOLD,30));
		name.setForeground(Color.white);
		name.setBounds(200,50,400,50);
		heading.add(name);



		//login panel
		JPanel login=new JPanel();
		login.setLayout(null);
		login.setSize(400,300);
		login.setBounds(180,140,530,500);
		login.setBackground(Color.yellow);
		login.setBackground(new Color(0,0,0,60));



		
		l=new JLabel("UserName");
		l.setBounds(120,22,155,50);
		l.setFont(f);
		l.setForeground(Color.white);
		login.add(l);

		user=new JTextField(20);
		user.setBounds(250,30,155,30);
		user.setForeground(Color.white);	
		user.setBackground(new Color(210,180,140));	
		login.add(user);
		

		l1=new JLabel("Password");
		l1.setBounds(120,62,155,50);
		l1.setFont(f);
		l1.setForeground(Color.white);
		login.add(l1);

		pass=new JTextField(20);
		pass.setBounds(250,70,155,30);
		pass.setForeground(Color.white);
		pass.setBackground(new Color(210,180,140));	
		login.add(pass);
		

		l2=new JLabel("Security Qs.");
		l2.setBounds(100,102,150,50);
		l2.setFont(f);
		l2.setForeground(Color.white);
		login.add(l2);

		c1=new Choice();
		c1.add("Your NickName?");
		c1.add("Your Lucky Number?");
		c1.add("Your child SuperHero?");
		c1.add("Your childhood Name ?");
		c1.setBounds(245,115,160,60);
		login.add(c1);

		l3=new JLabel("Security Ans.");
		l3.setBounds(100,142,155,50);
		l3.setFont(f);
		l3.setForeground(Color.white);
		login.add(l3);


		t1=new JTextField(20);
		t1.setBounds(250,150,155,30);
		t1.setForeground(Color.white);	
		t1.setBackground(new Color(210,180,140));	
		login.add(t1);	
		

		l4=new JLabel("Contact No.(+91)");
		l4.setBounds(85,182,165,50);
		l4.setFont(f);
		l4.setForeground(Color.white);
		login.add(l4);

		t2=new JTextField(20);
		t2.setBounds(250,195,155,30);
		t2.setForeground(Color.white);	
		t2.setBackground(new Color(210,180,140));	
		login.add(t2);	
		
		l5=new JLabel("E - Mail ");
		l5.setBounds(120,232,165,50);
		l5.setFont(f);
		l5.setForeground(Color.white);
		login.add(l5);

		t3=new JTextField(20);
		t3.setBounds(250,240,155,30);
		t3.setForeground(Color.white);	
		t3.setBackground(new Color(210,180,140));	
		login.add(t3);	
		
		bcreate=new JButton("Create");
		bcreate.setFont(f);
		bcreate.setBounds(95,300,100,40);
		bcreate.setForeground(Color.white);
		bcreate.setBackground(new Color(160,182,45));
		bcreate.addActionListener(this);
		login.add(bcreate);

		bback=new JButton("Back");
		bback.setFont(f);
		bback.setBounds(305,300,100,40);
		bback.setForeground(Color.white);
		bback.setBackground(new Color(160,182,45));
		bback.addActionListener(this);
		login.add(bback);

			
		//frame
		setSize(900,600);
		setLayout(null);
		setTitle("Myapp");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//background
		ImageIcon bgimg=new ImageIcon("bgimage2.jpg");
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.add(heading);
		bg.add(login);
		bg.setBounds(0,0,900,600);
		add(bg);


		

	}
	public void actionPerformed(ActionEvent ar)
	{	
		


		
		if(ar.getSource() == bback){
        	this.setVisible(false);
        	new Car().setVisible(true);}
              
		if(ar.getSource() == bcreate)
		{
		
	 		cu=user.getText().toString().trim();
			System.out.println(cu);
			if(cu.length()==0||cu.contains(" ")) 
			{
				iu=1;	
			}
			cp=pass.getText().toString().trim();
			System.out.println(cp);
			if(cp.length()==0||cp.contains(" ")) 
			{
				ip=1;	
			}
			ct1=t1.getText().toString().trim();	
			System.out.println(ct1);
			if(ct1.length()==0||ct1.contains(" ")) 
			{
				it1=1;	
			}
			ct2=t2.getText().toString().trim();	
			System.out.println(ct2);
			if(ct2.length()==0||ct2.contains(" ")) 
			{
				it2=1;	
			}
			ct3=t3.getText().toString().trim();	
			System.out.println(ct3);
			if(ct3.length()==0||ct3.contains(" ")) 
			{
				it3=1;	
			}
			
			if (iu==0 && ip==0 && it1==0 && it2==0 && it3==0) 
			{
				ff=0;
			}
			else if (iu!=0 && ip==0 && it1==0 && it2==0 && it3==0) 
			{
				pane = new JOptionPane("Given Fields cannot be blank\n1.Username");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);	
	    			
			}
			else if(iu!=0 && ip!=0 && it1==0 && it2==0 && it3==0)
			{

				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);
	    			
			}
			else if (iu!=0 && ip!=0 && it1!=0 && it2==0 && it3==0) 
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.Security Ans.");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);		
			}
			else if(iu!=0 && ip!=0 && it1!=0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.Security Ans.\n4.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);		
			}
/*6*/			else if (iu!=0 && ip!=0 && it1!=0 && it2!=0 && it3!=0) 
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.Security Ans.\n4.Contact No.(+91)\n5.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);		
			}
			else if(iu==0 && ip!=0 && it1==0 && it2==0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Password");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);
			}
			else if(iu==0 && ip!=0 && it1!=0 && it2==0 && it3==0) 
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Password\n2.Security Ans.");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);
			}
			else if(iu==0 && ip!=0 && it1!=0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Password\n2.Security Ans.\n3.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);
			}

/*10*/			else if(iu==0 && ip!=0 && it1!=0 && it2!=0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Password\n2.Security Ans.\n3.Contact No.(+91)\n4.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);				
			}
/*17*/			else if(iu!=0 && ip==0 && it1!=0 && it2==0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Security Ans.");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu!=0 && ip==0 && it1!=0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Security Ans.\n3.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
/*19*/		else if(iu!=0 && ip==0 && it1!=0 && it2!=0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Security Ans.\n3.Contact No.(+91)\n4.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);		
			}
/*20*/			else if(iu!=0 && ip==0 && it1==0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
/*26*/			else if(iu!=0 && ip!=0 && it1==0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
/*23*/			else if(iu!=0 && ip==0 && it1==0 && it2==0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);		
			}
			else if(iu!=0 && ip!=0 && it1==0 && it2==0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);		
			}
/*25*/			else if(iu!=0 && ip!=0 && it1!=0 && it2==0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.Security Ans.\n4.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
/*22*/			else if(iu!=0 && ip!=0 && it1==0 && it2!=0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Password\n3.Contact No.(+91)\n4.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
/*11*/			else if(iu==0 && ip==0 && it1!=0 && it2==0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Security Ans.");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
				else if(iu==0 && ip==0 && it1!=0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Security Ans.\n2.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu==0 && ip==0 && it1!=0 && it2!=0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Security Ans.\n2.Contact No.(+91)\n3.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu==0 && ip==0 && it1==0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu==0 && ip==0 && it1==0 && it2!=0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Contact No.(+91)\n2.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu==0 && ip==0 && it1==0 && it2==0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu!=0 && ip==0 && it1==0 && it2!=0 && it3==0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Contact No.(+91)");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
			else if(iu!=0 && ip==0 && it1==0 && it2!=0 && it3!=0)
			{
				pane = new JOptionPane("Given Fields cannot be blank \n1.Username\n2.Contact No.(+91)\n3.E - Mail");
	             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
	             	d.setLocation(450,180);
	    			d.setVisible(true);			
			}
		
			commm = c1.getSelectedItem().toString();
			if(ff==0)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sahil?characterEncoding=utf8","sahil","password");
					Statement st = con.createStatement();
					System.out.println("WORKING	");
						
					String query="SELECT SrNo FROM account ORDER BY SrNo DESC LIMIT 1;";
					ResultSet rs = st.executeQuery(query);

					if(rs.next()){
     			   		sr = rs.getInt(1); //IDTable
					}
					sr++;

					String query1="insert into account values('" + sr + "','" + user.getText() + "','" + pass.getText() + "','" + commm + "','" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "');";
					int i = st.executeUpdate(query1);
						if (i > 0)
						{
							this.setVisible(false);
							new Car().setVisible(true);
		             	pane = new JOptionPane("successfully Created");
		             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
		             	d.setLocation(450,180);
		    			d.setVisible(true);
		    			user.setText("");
		    			pass.setText("");
		    			t1.setText("");
		    			t2.setText("");
		    			t3.setText("");
		    			}

				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		} //if but_close
	} 


	public static void main(String args[])
	{
		new demo();	
 	}
}