package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoimpl.UserDAOImpl;
import com.blog.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		
		UserDAOImpl udaoi = new UserDAOImpl();
		
		User user = udaoi.fetchUser(email);
		
		if(user != null)
		{
			String password = req.getParameter("password");
			if(user.getPassword().equals(password))
			{
				System.out.println("success");
				HttpSession session = req.getSession();
				session.setAttribute("loggedInUser", user);
				resp.sendRedirect("index.jsp");
			}
			else
			{
				System.out.println(user.getPassword());
				System.out.println(password);
				System.out.println("failure");
				resp.sendRedirect("passwordwrong.jsp");
			}
		}
		else
		{
			resp.sendRedirect("failure.jsp");
		}
	}
}
