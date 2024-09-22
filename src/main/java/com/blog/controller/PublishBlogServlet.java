package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoimpl.BlogsDAOImpl;
import com.blog.model.Blogs;
import com.blog.model.User;

@WebServlet("/publishblog")
public class PublishBlogServlet extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String title = (String)req.getParameter("title");
		String content = (String)req.getParameter("content");
		
		BlogsDAOImpl bdaoi = new BlogsDAOImpl();
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loggedInUser");
		
		Blogs blog = new Blogs(user.getUserId(), title, content);
		
		int status = bdaoi.addBlog(blog);
		
		if(status == 1)
		{
			resp.sendRedirect("publishsuccessfull.jsp");
		}
		else
		{
			System.out.println("publish not successfull");
		}

	}
}
