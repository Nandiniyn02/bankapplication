package com.RashmiBankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String amount=req.getParameter("amount");
    	HttpSession session = req.getSession();
    	int accno=(int) session.getAttribute("accno");
    	Model m = new Model();
    	m.setAccno(accno);
    	m.setAmount(amount);
    	boolean temp=m.transfer();
    	if(temp==true)
    	{
    		resp.sendRedirect("successtransfer.jsp");
    	}
    	else
    	{
    		resp.sendRedirect("failuretransfer.jsp");
    	}
    	
    }
	
	

}
