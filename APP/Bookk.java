import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Bookk extends JFrame implements ItemListener,ActionListener
{
	Choice c1,c2,c3;
	JLabel start,dest,type,air;					
	String ss,dr,ac="No",ty,srs;
	JButton confirm,bback;
	JOptionPane pane;
	JDialog d;
	Checkbox ck1,ck2;
	CheckboxGroup gr;
	int sr;


	Bookk()
	{	

		//font
		Font f=new Font("Tahoma",Font.BOLD,30);
		Font f2=new Font("Tahoma",Font.BOLD,16);
		//header
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		
		heading.setBounds(0,0,900,80);
		JLabel name=new JLabel("WELCOME! NAMASTE!...BOOK YOUR TRIP! ");
		name.setFont(f);
		name.setForeground(Color.white);
		name.setBounds(200,50,400,50);
		heading.add(name);



		//login panel
		JPanel login=new JPanel();
		login.setLayout(null);
		login.setSize(400,300);
		login.setBounds(180,140,530,500);
		login.setBackground(new Color(255,255,255,90));

		start=new JLabel("Choose Pickup Point!");
		start.setBounds(50,87,180,50);
		start.setFont(f2);
		start.setForeground(new Color(0,51,0));
		login.add(start);


		c1=new Choice();
		c1.add("Airoli");
		c1.add("Thane");
		c1.add("Nerul");
		c1.add("Mumbra");
		c1.add("Vashi");
		c1.add("Andheri");
		c1.add("Santacruz");
		c1.add("Sion");
		c1.add("Marine Line");
		c1.add("Dadar");
		c1.add("Buyculla");
		c1.add("Mahim");
		c1.add("Bandra");
		c1.add("Lower Parel");
		c1.setBounds(250,100,180,150);
		c1.setFont(f2);
		
		login.add(c1);

		dest=new JLabel("Choose Drop Point!");
		dest.setBounds(50,137,180,50);
		dest.setFont(f2);
		dest.setForeground(new Color(0,51,0));
		login.add(dest);

		c2=new Choice();
		c2.add("Airoli");
		c2.add("Thane");
		c2.add("Nerul");
		c2.add("Mumbra");
		c2.add("Vashi");
		c2.add("Andheri");
		c2.add("Santacruz");
		c2.add("Sion");
		c2.add("Marine Line");
		c2.add("Dadar");
		c2.add("Buyculla");
		c2.add("Mahim");
		c2.add("Bandra");
		c2.add("Lower Parel");
		c2.setBounds(250,150,180,150);
		c2.setFont(f2);

		login.add(c2);

		air=new JLabel("Air Conditioned");
		air.setBounds(50,187,180,50);
		air.setFont(f2);
		air.setForeground(new Color(0,51,0));
		login.add(air);


		gr=new CheckboxGroup();

		ck1=new Checkbox("Yes",false,gr);
		ck1.setBounds(250,200,65,30);
		ck1.setForeground(Color.white);
		ck1.setBackground(Color.green);
		ck1.setFont(f2);
		login.add(ck1);
		ck1.addItemListener(this);

		ck2=new Checkbox("No",false,gr);
		ck2.setBounds(360,200,70,30);
		ck2.setForeground(Color.white);
		ck2.setBackground(Color.green);
		ck2.setFont(f2);
		login.add(ck2);
		ck2.addItemListener(this);

		type=new JLabel("Choose Car type!");
		type.setBounds(90,237,130,50);
		type.setFont(f2);
		type.setForeground(new Color(0,51,0));
		login.add(type);

		c3=new Choice();
		c3.add("Micro");
		c3.add("Mini");
		c3.add("Prime Play");
		c3.add("Prime Sedan");
		c3.add("SUV");
		c3.add("Prime Exclusive");
		c3.setBounds(250,250,180,150);
		c3.setFont(f2);

		login.add(c3);

		confirm = new JButton("Confirm");
		confirm.setFont(f2);
		confirm.setBounds(125,300,100,40);
		confirm.setForeground(Color.white);
		confirm.setBackground(new Color(160,182,45));
		confirm.addActionListener(this);
		login.add(confirm);

		bback=new JButton("Exit");
		bback.setFont(f2);
		bback.setBounds(300,300,100,40);
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
		ImageIcon bgimg=new ImageIcon("bgimage4.jpg");
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.setBounds(0,0,900,600);
		add(bg);
		bg.add(login);
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getItemSelectable()==ck1)
			{ac="Yes";}
		else if(e.getItemSelectable()==ck2)
			{ac="No";}
	}
	public void actionPerformed(ActionEvent aae)
	{
		if(aae.getSource()==confirm) 
		{

			ss = c1.getSelectedItem().toString();
			dr = c2.getSelectedItem().toString();
			ty = c3.getSelectedItem().toString();

			System.out.println(ss);
			System.out.println(dr);
			System.out.println(ac);
			System.out.println(ty);
			System.out.println("Working!🧡🧡🧡");
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sahil?characterEncoding=utf8","sahil","password");
			Statement st = con.createStatement();


			String query2="SELECT max(SrNo) from recc;";
					ResultSet rs = st.executeQuery(query2);  //ResultSet

					if(rs.next()){
     			   		sr = rs.getInt(1); //IDTable
					}
					sr++;
					System.out.println(sr);

			String query1="SELECT Username FROM logined where SrNo=(select max(SrNo) from logined);";
					rs = st.executeQuery(query1);

					if(rs.next()){
     			   		srs = rs.getString(1); //IDTable
					}
		

					System.out.println(srs);

			String query="insert into recc values('"+ sr +"','"+ srs +"','" + ss + "','" + dr + "','" + ac + "','" + ty + "');";
					int i = st.executeUpdate(query);
						if (i > 0)
						{
			
		             	pane = new JOptionPane("Successfully Booked");
		             	d = pane.createDialog((JFrame)null, "CAB BOOKING!");
		             	d.setLocation(450,180);
		    			d.setVisible(true);

		    			this.setVisible(false);
						new Bill().setVisible(true);
		    			// System.exit(0);
		    			}

		    			

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if (aae.getSource()==bback) 
		{
			System.exit(0);
		}
	}
	public static void main(String[] args) 
	{
		new Bookk();
	}	
}