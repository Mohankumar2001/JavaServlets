

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

@WebServlet("/getHiddenFieldServlet")
public class getHiddenFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public getHiddenFieldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
    	PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName").trim();
    	String password = request.getParameter("password").trim();
     	out.println("Username: " + userName + "<br/><br/>");
    	out.println("Password: " + password);
     	out.close();

	}

}
