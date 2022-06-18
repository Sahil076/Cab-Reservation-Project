import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Bill extends JFrame implements ActionListener
{
	String username1,startloc1,droploc1,air_condn1,typecar1;
	JLabel username,startloc,droploc,air_condn,typecar,price,pricetag;
	JButton bback;
	Bill(){

		//font
		Font f=new Font("Tahoma",Font.BOLD,30);
		Font f2=new Font("Times New Roman",Font.BOLD,25);
		//header
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(255,0,255,80));
		heading.setBounds(0,0,900,80);

		JLabel name=new JLabel("THANK YOU FOR CHOOSING MY APP!!! ");
		name.setFont(f);
		name.setForeground(Color.black);
		name.setBounds(200,50,400,50);
		heading.add(name);



		//login panel
		JPanel login=new JPanel();
		login.setLayout(null);
		login.setSize(400,300);
		login.setBounds(180,140,430,400);
		login.setBackground(new Color(255,255,255,90));

		


		try{
			Class.forName("com.mysql.jdbc.Driver");    
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sahil?characterEncoding=utf8","sahil","password");
			Statement st = con.createStatement();
			System.out.println("WORKING...	");
			String query = "SELECT username,startloc,droploc,air_condn,typecar FROM recc where SrNo=(SELECT max(SrNo) from recc);";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
			
			//Retrieve by column name
			 username1 = rs.getString("username");
			 startloc1 = rs.getString("startloc");
			 droploc1 = rs.getString("droploc");
			 air_condn1 = rs.getString("air_condn");
			 typecar1 = rs.getString("typecar");
			}
		}
		catch (Exception e) {
		System.out.println(e);

		}

			System.out.println(username1);
			System.out.println(startloc1);
			System.out.println(droploc1);
			System.out.println(air_condn1);
			System.out.println(typecar1);

		username=new JLabel("Name : "+username1);
		username.setBounds(50,57,250,50);
		username.setFont(f2);
		username.setForeground(Color.black);
		login.add(username);

		startloc=new JLabel("Starting Point : "+startloc1);
		startloc.setBounds(50,97,250,50);
		startloc.setFont(f2);
		startloc.setForeground(Color.black);
		login.add(startloc);

		droploc=new JLabel("Drop Point : "+droploc1);
		droploc.setBounds(50,137,250,50);
		droploc.setFont(f2);
		droploc.setForeground(Color.black);
		login.add(droploc);

		air_condn=new JLabel("Air Conditioned : "+air_condn1);
		air_condn.setBounds(50,177,250,50);
		air_condn.setFont(f2);
		air_condn.setForeground(Color.black);
		login.add(air_condn);

		typecar=new JLabel("Car Type : "+typecar1);
		typecar.setBounds(50,217,250,50);
		typecar.setFont(f2);
		typecar.setForeground(Color.black);
		login.add(typecar);

		price=new JLabel("Total Charge(Rs.) : 1090");
		price.setBounds(50,257,300,50);
		price.setFont(f2);
		price.setForeground(Color.black);
		login.add(price);

		pricetag=new JLabel("(Inc. of all taxes)");
		pricetag.setBounds(50,297,250,50);
		pricetag.setFont(f2);
		pricetag.setForeground(Color.black);
		login.add(pricetag);

		bback=new JButton("OKAY");
		bback.setFont(f2);
		bback.setBounds(150,350,100,40);
		bback.setForeground(Color.white);
		bback.setBackground(new Color(160,182,45));
		bback.addActionListener(this);
		login.add(bback);


		//frame 
		setSize(899,599);
		setSize(900,600);
		setLayout(null);
		setTitle("Myapp");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//background
		ImageIcon bgimg=new ImageIcon("recep.png");
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.setBounds(0,0,900,600);
		add(bg);
		bg.add(login);
		bg.add(heading);
	}

	public void actionPerformed(ActionEvent aae)
	{
		if (aae.getSource()==bback) 
		{
			this.setVisible(false);
			new Bookk().setVisible(true);
			
		}
	}



	public static void main(String[] args) {
		new Bill();
	}
}