package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate2
 */
public class Validate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate2() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//String message=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("admin") && password.equals("admin")){
		RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);	
		}
		else
			out.println("not authorized");
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);	
	}


		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		}

}
