

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

@WebServlet("/setHiddenFieldServlet")
public class setHiddenFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public setHiddenFieldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
    	String userName = request.getParameter("userName").trim();
	String password = request.getParameter("password").trim();
	if(userName == null || userName.equals("") || 
			password == null || password.equals("")){
		out.print("Please enter both username " +
				"and password. <br/><br/>");
		RequestDispatcher requestDispatcher = 
			request.getRequestDispatcher("/sessionTracking.html");
		requestDispatcher.include(request, response);
	}
	else if(userName.equals("mohan") && password.equals("1234")){
	    out.println("Logged in successfully.<br/>"); 
	    out.println("Click on the below button to see " +
			"the values of Username and Password.<br/>");
	    out.print("<form action='getHiddenFieldServlet'" +
	    		" method='POST'>");
	    out.print("<input type='hidden' name='userName'" +
	    		" value='" + userName + "'>");
	    out.print("<input type='hidden' name='password'" +
	    		" value='" + password + "'>");
	    out.print("<input type='submit' value='See Values'>");  
	    out.print("</form>");
	    out.close();
	}else{
		out.print("Wrong username or password. <br/><br/>");
		RequestDispatcher requestDispatcher = 
			request.getRequestDispatcher("/sessionTracking.html");
		requestDispatcher.include(request, response);
	}

	}

}
