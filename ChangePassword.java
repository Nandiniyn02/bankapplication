package com.RashmiBankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  HttpSession session=req.getSession();
   	int accno=(int) session.getAttribute("accno");
   	String newpassword = req.getParameter("newpassword");
   	Model m = new Model();
   	m.setAccno(accno);
   	m.setPassword(newpassword);
   	boolean temp = m.changepassword();
   	{
   		if(temp==true)
   		{
   			//int balance=m.getBalance();
   			//session.setAttribute("balance",m.getBalance());
   			resp.sendRedirect("successPassword.jsp");
   			
   		}
   		else
   		{
   			resp.sendRedirect("failurePassword.jsp");
   		}
   	}
}

}
