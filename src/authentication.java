import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
 
class User
{
	String fname;
	String lname;
	String ifsc;
	String phno;
	String balance;
	String account;
	Connection con=null;
	public void register()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter fname");
		fname=sc.next();
		System.out.println("Enter lname");
		 lname=sc.next();
		System.out.println("Enter ifsc");
		ifsc=sc.next();
		System.out.println("Enter phone");
		phno=sc.next();
		System.out.println("Enter account no");
		account=sc.next();
		
		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zee","root","Pass@123");
	PreparedStatement pstmt=con.prepareStatement("insert into user values(?,?,?,?,?)");
	pstmt.setString(1, fname);
	pstmt.setString(2, lname);
	pstmt.setString(3, ifsc);
	pstmt.setString(4, phno);
	pstmt.setString(5,account);
	pstmt.execute();
	System.out.println("Registered successfully");
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	public void login()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter account no");
		account=sc.next();
		System.out.println("Enter phno no");
		phno=sc.next();
		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zee","root","Pass@123");
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("Select * from user");
	while(rs.next()){
	     if((account.equals(rs.getString(5))) && (phno.equals(rs.getString(4))))
	     {
	    	 System.out.println("Successfully logged in");
	     }
	     else
	     {
	    	 System.out.println("Invalid Credentials");
	     }
	}
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
	public void create()
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter account");
		 String accountt=sc.next();
		
		System.out.println("Enter ifsc");
		ifsc=sc.next();
		System.out.println("Enter phone");
		phno=sc.next();
		System.out.println("Enter balance");
		String balance=sc.next();
		
		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zee","root","Pass@123");
	PreparedStatement pstmt=con.prepareStatement("insert into account values(?,?,?,?)");
	pstmt.setString(1, accountt);
	pstmt.setString(2, ifsc);
	pstmt.setString(3, phno);
	pstmt.setString(4, balance);
	pstmt.execute();
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
}
public class authentication {

	public static void main(String[] args)
	{
		User u=new User();
		//u.login();
		int c1;
		int c2;
		do {
			System.out.println("------PHONEPAY-------");
			System.out.println("1.REGISTER");
			System.out.println("2.LOGIN");
			System.out.println("Enter your choice");
			Scanner sc=new Scanner(System.in);
			c1=sc.nextInt();
			if(c1==1)
			{
				u.register();
			}
			else
			{
				u.login();
				do {
					System.out.println("1 for create account");
					System.out.println("2 for check balance");
					System.out.println("3 for Transfer balance");
					System.out.println("4 for exit");
					Scanner sce=new Scanner(System.in);
					c2=sce.nextInt();
					if(c2==1)
					{
						//u.create();
					}
					else if(c2==2)
					{
						//u.check();
					}
					else if(c2==3)
					{
						//u.transfer();
					}
					
						
					
				}while(c2!=4);
			}
			
			
		}while(c1!=3);
		
}
}
