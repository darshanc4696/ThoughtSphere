package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoimpl.CommentsDAOImpl;
import com.blog.model.Comments;
import com.blog.model.User;

@WebServlet("/addcomment")
public class AddCommment extends HttpServlet
{
	private int status;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int blogId = Integer.parseInt( req.getParameter("blogId"));
		System.out.println(blogId);
		String commentText = req.getParameter("commentText");
		System.out.println(commentText);
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loggedInUser");
		
		if(user != null)
		{
			System.out.println(user.getUserId());
			Comments comment = new Comments(blogId, user.getUserId(), commentText);
			CommentsDAOImpl cdaoi = new CommentsDAOImpl();
			status = cdaoi.addComment(comment);
			
			if(status == 1)
			{
				resp.sendRedirect("successaddcomment.jsp");
			}
			else
			{
				resp.sendRedirect("failedincomment.jsp");
			}
		}
		else
		{
			resp.sendRedirect("usernotloggedin.jsp");
		}
	}
}
