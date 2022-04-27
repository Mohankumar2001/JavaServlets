

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/SessionTracker")
public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionTracker() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    HttpSession session = request.getSession();

	    Integer count = (Integer)session.getAttribute("tracker.count");
	    if (count == null)
	      count = new Integer(1);
	    else
	      count = new Integer(count.intValue() + 1);
	    session.setAttribute("tracker.count", count);


	    out.println("<HTML><HEAD><TITLE>SessionTracker</TITLE></HEAD>");
	    out.println("<BODY bgcolor=\"tomato\"><H1>Session Tracking using Hit Count</H1>");

	    out.println("You've visited this page " + count +
	      ((count.intValue() == 1) ? " time." : " times."));

	    out.println("<P>");

	    out.println("<H2>Your session data:</H2>");
	    Enumeration e = session.getAttributeNames();
	    while (e.hasMoreElements()) {
	      String name = (String) e.nextElement();
	      out.println(name + ": " + session.getAttribute(name) + "<BR>");
	    }
	    out.println("</BODY></HTML>");
	}


}
