import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Car extends JFrame implements ActionListener 
{
	JTextField user,pass;
	int i,j;
	JLabel k;
	String u,p,id,idd,ps,ree,srs;
	JButton login_but,signup;
	JOptionPane pane;
	JDialog d;
	int c=0,err=0,sr,srr;
	Car()
	{	
		//font
		Font f2=new Font("Georgia",Font.BOLD,16);
		Font f=new Font("Serif",Font.BOLD,30);
		//header
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		
		heading.setBounds(0,0,900,100);
		JLabel name=new JLabel("CAB BOOKING");
		name.setFont(f);
		name.setForeground(Color.white);
		name.setBounds(200,50,400,50);
		heading.add(name);
		
		//login panel
		JPanel login=new JPanel();
		login.setLayout(null);
		login.setSize(400,300);
		login.setBounds(250,175,400,435);
		login.setBackground(Color.yellow);
		login.setBackground(new Color(0,0,0,60));
		

		user=new JTextField("Enter Username");
		user.setFont(f2);
		
		user.addFocusListener(new FocusListener(){  
		
		@Override
       		public void focusGained(FocusEvent ei) {
		
		if(user.getText().trim().isEmpty()||user.getText().equals("Enter Username"))
		user.setText("");
        		}
		
		@Override
        		public void focusLost(FocusEvent ei) {
		if(user.getText().trim().isEmpty())
            		user.setText("Enter Username");
		}
		});

		

		user.setBounds(50,50,300,50);
		user.setForeground(Color.white);	
		user.setBackground(new Color(210,180,140));	
		login.add(user);
		
		
		

		pass=new JTextField("Enter Password");
		pass.setFont(f2);
		
		pass.addFocusListener(new FocusListener(){
		
		@Override
       		public void focusGained(FocusEvent eii) {
		if(pass.getText().trim().isEmpty()||pass.getText().equals("Enter Password"))
		pass.setText("");							//echoChar
        		}
		
		@Override
        		public void focusLost(FocusEvent eii) {
		if(pass.getText().trim().isEmpty())
            		pass.setText("Enter Password");
		}
		});
		
		pass.setBounds(50,150,300,50);
		pass.setForeground(Color.white);
		pass.setBackground(new Color(210,180,140));	
		login.add(pass);


		signup=new JButton("Sign Up");
		signup.setBounds(50,250,100,50);
		signup.setForeground(Color.white);
		signup.setBackground(new Color(160,182,45));
		signup.addActionListener(this);
		login.add(signup);	
		

		login_but=new JButton("Login");
		login_but.setBounds(250,250,100,50);
		login_but.setForeground(Color.white);
		login_but.setBackground(new Color(160,182,45));
		login_but.addActionListener(this);
		login.add(login_but);
		

		//frame
		setSize(899,599);
		setSize(900,600);
		setLayout(null);
		setTitle("Myapp");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//background
		ImageIcon bgimg=new ImageIcon("bgimage.jpg");
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.add(heading);
		bg.add(login);
		bg.setBounds(0,0,900,600);
		add(bg);	
		
			
		
	}
	public void actionPerformed(ActionEvent event)
	{	

		u=user.getText().trim();
		p=pass.getText().trim();
		user.setText("");
		pass.setText("");

		if(event.getSource() == signup)
		{
			this.setVisible(false);
			new demo().setVisible(true);	
		}
		if(event.getSource() == login_but)
		{	
			
	
			if(u.isEmpty()||u.equals("Enter Username")||u.contains("\0")||u.contains(" ") && (p.isEmpty()||p.equals("Enter Password")||p.contains("\0")||p.contains(" ")))
		{		 c=1;
			pane = new JOptionPane("Please Check Your Details\nTry Re-Entering your Username & Password !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);	
             
		}	
			else if(u.isEmpty()||u.equals("Enter Username")||u.contains("\0")||u.contains(" "))
		{		c=1;
			pane = new JOptionPane("Please Enter Your Username properly\nUsername cannot contain blank spaces !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);	
             
		}
		    else if(p.isEmpty()||p.equals("Enter Password")||p.contains("\0")||p.contains(" "))
		{		c=1;
			pane = new JOptionPane("Please Enter Your Password properly\nPassword cannot contain blank spaces !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);	
             
		}
			else if (!u.isEmpty()||!u.equals("Enter Username")||!u.contains("\0")||!u.contains(" ") && (!p.isEmpty()||!p.equals("Enter Password")||!p.contains("\0")||!p.contains(" "))) 
			{
				c=0;	
			}
if (c==0) {
		try
		{

			if (c==0) 
			Class.forName("com.mysql.jdbc.Driver");    
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sahil?characterEncoding=utf8","sahil","password");
			Statement st1 = con.createStatement();
			System.out.println("WORKING...	");
			String query = "SELECT name,password FROM account";
			ResultSet rs = st1.executeQuery(query);
			while(rs.next())
			{
			
			//Retrieve by column name
			 id = rs.getString("name");
			 ps = rs.getString("password");
			 if(id.equals(u) && ps.equals(p))
			 {
			 	err=1;
			 	break;
             }
			 else if(id.equals(u) && !ps.equals(p))
			 {
				err=2;
				
             }
             else if(ps.equals(p) && !id.equals(u)) 
             {
             	err=3;
             
			 }
			 else if(!id.equals(u) && !ps.equals(p))
			 {
			 	err=4;
			 
			 }

			}
			if(err==1) 
			{	

				String query1="SELECT SrNo FROM logined ORDER BY SrNo DESC LIMIT 1;";
					rs = st1.executeQuery(query1);  //ResultSet

					if(rs.next()){
     			   		sr = rs.getInt(1); //IDTable
					}
					sr++;
					System.out.println(sr);

				String query2="insert into logined values('" + sr + "','" + u + "');";
					int i1 = st1.executeUpdate(query2);
						if (i1 > 0)
						{
							System.out.println(u);
						}
				String query3="SELECT SrNo FROM account WHERE name='"+ u +"';";
					rs = st1.executeQuery(query3);	//ResultSet
					if(rs.next()){
						srs = rs.getString("SrNo");
					}
					srr=Integer.parseInt(srs);
				System.out.println(srs);


				this.setVisible(false);
				new bbook().setVisible(true);
				pane = new JOptionPane("successfull Login\n\nStart Your Booking !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);	
			}
			else if (err==2) 
			{
				pane = new JOptionPane("Please Enter Valid Password\nTry Re-Entering your Password !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);
			}
			else if (err==3) 
			{
				pane = new JOptionPane("Please Enter Valid Username\nTry Re-Entering your Username !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);
			}
			else if (err==4)
			{
				pane = new JOptionPane("Please Enter Valid Username & Password\nTry Re-Entering your Username & Password !!!");
             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
             	d.setLocation(450,180);
             	d.setVisible(true);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
	}
	}

	public int getValuee() {
				srr++;
    			return srr;}
    public String getvall(){
    			return u;
    }

	public static void main(String args[])
	{
		new Car();	
	}
			
}
