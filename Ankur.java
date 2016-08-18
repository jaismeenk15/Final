package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ankur {
	private static MessageDigest md;
	Connection conn = null;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	PreparedStatement st = null;
	ResultSet rs = null;
	public int username;
	
	boolean valid()
	{
	try
	{
	Class.forName("oracle.jdbc.OracleDriver");
	conn=DriverManager.getConnection(url,"nidhi","password");
	String query="select Pswd from customer where Cust_Id=?";
	st.setInt(1,username);
	st=conn.prepareStatement(query);
	rs = st.executeQuery(query);
	}
	catch(Exception e)
	{
	
	}
	return true;
}
	
	public static String encrypt(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(Ankur.class.getName()).log(Level.SEVERE, null, ex);
	    }
		return null;
	   }
}

