package com.RashmiBankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class checkBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	int accno=(int) session.getAttribute("accno");
    	Model m = new Model();
    	m.setAccno(accno);
    	boolean temp = m.checkBalance();
    	{
    		if(temp==true)
    		{
    			//int balance=m.getBalance();
    			session.setAttribute("balance",m.getBalance());
    			resp.sendRedirect("successBalance.jsp");
    		}
    		else
    		{
    			resp.sendRedirect("failureBalance.jsp");
    		}
    	}
    }

}
