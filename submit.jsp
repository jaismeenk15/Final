<%@page import="test.ItemsCart"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement" import="test.Ankur" import="test.Distance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Ankur ld=new Ankur();
int cust_id=ld.username;
double clon,clat;
ItemsCart ic=new ItemsCart();
String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "nidhi", "password");
		PreparedStatement st = conn.prepareStatement("Select lat,longt from Customer where Cust_Id=? ") ;
		st.setInt(1, cust_id);
	    ResultSet rs = 
	        st.executeQuery() ;
		clat=rs.getDouble(1);
		clon=rs.getDouble(2);
	   
	Distance d=new Distance();
	int store=d.shortest(clon,clat);

		
	PreparedStatement pst = conn.prepareStatement("insert into order_details values(?,?,?,?,?)") ;
	pst.setInt(1,cust_id);
	pst.setInt(2,store);
	pst.setInt(3,ic.pid);
	 //   ResultSet rs =pst.executeQuery() ;
	%>	    
		
</body>
</html>


