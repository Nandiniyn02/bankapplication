package com.RashmiBankApp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class changepasswordFilter
 */
public class changepasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public changepasswordFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String newpassword=request.getParameter("newpassword");
		String conformpassword=request.getParameter("conformpassword");
		
		if(newpassword.equals(conformpassword))
		{
			chain.doFilter(request, response);
			//((HttpServletResponse)(response)).sendRedirect("ChangePassword.java");
		}
		else 
		{
			((HttpServletResponse)(response)).sendRedirect("errorpassword.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
