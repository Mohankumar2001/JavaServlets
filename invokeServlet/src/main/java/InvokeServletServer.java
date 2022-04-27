

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/InvokeServletServer")
public class InvokeServletServer extends GenericServlet {
	private static final long serialVersionUID = 1L;
       

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		  pw.print("<h3>Registration Successful</h3>");
		  Enumeration e=request.getParameterNames();
		  while(e.hasMoreElements())
		  {
		   String str1=(String)e.nextElement();
		   String str2=request.getParameter(str1);
		   pw.print(str1+"="+str2+"<br/>");
		  }
		  pw.close();
	}

}
