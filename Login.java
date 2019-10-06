package com.RashmiBankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String customerid = req.getParameter("customerid");
    	String password = req.getParameter("password");
    	Model m = new Model();
     m.setCustomerid(customerid);
     m.setPassword(password);
     
     boolean temp = m.login();
     if(temp==true)
     {
    	 HttpSession session = req.getSession(true);
    	 session.setAttribute("name",m.getName());
    	 session.setAttribute("accno",m.getAccno());
    	 resp.sendRedirect("home.jsp");
     }
     else
     {
    	 resp.sendRedirect("failureLogin.jsp");
     }
    }
    

}
