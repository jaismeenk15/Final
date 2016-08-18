<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Details</title>
</head>
<body background="images\background.png">
	<%
	String nm= request.getParameter("q");
	String hint=" ";
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "nidhi", "password");
	Statement statement = conn.createStatement() ;
    ResultSet resultset = 
        statement.executeQuery("select * from store_product") ;
	%>
	<br>
	<br>
	<br>
<TABLE BORDER="1">
    <TR>
        <TH>Store ID</TH>
        <TH>Product ID</TH>
        <TH>Quantity</TH>
        <TH>Approve/Disapprove</TH>
    </TR>
    <% while(resultset.next()){ %>
    <TR>
        <TD> <%= resultset.getInt(1) %></td>
        <TD> <%= resultset.getInt(2) %></TD>
        <TD> <%= resultset.getInt(3) %></TD>
        <TD><INPUT type=radio name=approved></INPUT> </TD>
    </TR>
    <% } %>
</TABLE>
	<input type="submit" value="submit" onclick="clicked()">
	<script type="text/javascript">
	function clicked() {
	       alert("Order Approved");    
	   
	}

	</script>
	<br>
	<a href="Admin1.html">Logout</a><br>
</body>
</html>
