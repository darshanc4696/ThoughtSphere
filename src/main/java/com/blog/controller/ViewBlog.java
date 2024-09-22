package com.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoimpl.BlogsDAOImpl;
import com.blog.daoimpl.CommentsDAOImpl;
import com.blog.model.Blogs;
import com.blog.model.Comments;

@WebServlet("/viewblog")
public class ViewBlog extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int blogId = Integer.parseInt(req.getParameter("blogId"));
		String username = req.getParameter("username");
		BlogsDAOImpl bdaoi = new BlogsDAOImpl();

		Blogs blog = bdaoi.fetchSpecificBlogsOnBlogId(blogId);
		
		HttpSession session = req.getSession();
		session.setAttribute("blog", blog);
		session.setAttribute("username", username);
		
		resp.sendRedirect("viewblog.jsp");
	}
}
