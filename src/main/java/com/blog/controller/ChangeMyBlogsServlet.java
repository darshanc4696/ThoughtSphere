package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.daoimpl.BlogsDAOImpl;

@WebServlet("/changemyblogs")
public class ChangeMyBlogsServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int blogId = Integer.parseInt(req.getParameter("blogId"));
		
		BlogsDAOImpl bdaoi = new BlogsDAOImpl();
		int status = bdaoi.deleteSpeicficBlog(blogId);
		
		if(status == 1)
		{
			resp.sendRedirect("myblogs.jsp");
		}
		else
		{
			System.out.println("failed to delete a blog");
		}
	}
}
