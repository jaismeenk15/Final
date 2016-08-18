package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import javax.servlet.RequestDispatcher;

public class LoginDAO {
	private int username;
	private String password;
	
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDAO(int username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public boolean valid(){
		try
		{
			
			Connection conn = null;
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			PreparedStatement st = null;
			ResultSet rs = null;
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url,"nidhi","password");
			System.out.println("ankur");
			String query="select Pswd from customer where Cust_Id=?";
			st.setInt(1,username);
			st=conn.prepareStatement(query);
			
			
			rs = st.executeQuery(query);
				
			while (rs.next())
			{
				if(rs.getString(1).equals(password)){
						return true;
					}
				 else
				{
					System.out.println("Invalid user");
					return false;
				}
				//System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			//rs.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
			/*
			System.out.println(ex.getMessage());*/
			System.out.println("Unable to connect to database");

		}
		return false;

	}
/*public static void main(String args[]){
	LoginDAO ld=new LoginDAO(1001,"abc@123");
	System.out.println(ld.valid());*/}