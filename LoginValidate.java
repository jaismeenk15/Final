package test;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginValidate
 */
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		session.setAttribute("status","1");
		String username=request.getParameter("uname");
		String pwd=request.getParameter("pswd");
		RequestDispatcher rd;
		if(username.equals("admin") && pwd.equals("admin")){
			rd=request.getRequestDispatcher("Admin.html");
			rd.forward(request, response);
		}
		else if(username.equals(null) || pwd.equals(null)){
			out.println("Username & password do not match");
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		else{
			rd=request.getRequestDispatcher("User.html");
			rd.forward(request, response);
		}
	}

}
