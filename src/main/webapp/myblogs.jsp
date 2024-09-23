<%@page import="com.blog.daoimpl.BlogsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.Blogs, java.util.List, com.blog.model.User" %>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ThoughtSphere - My Blogs</title>
    <link rel="stylesheet" href="myblogs.css">
</head>
<body>

<div class="myblogs-container">
	<h1> </h1><br>
    <h2 class="page-title">My Blogs</h2>
    <form action="index.jsp">
        <button type="submit" class="back-btn">Back</button>
    </form>

    <% User user = (User) session.getAttribute("loggedInUser");
       BlogsDAOImpl udaoi = new BlogsDAOImpl();
       List<Blogs> blogsList = udaoi.fetchSpecificBlogs(user.getUserId());

       if (blogsList != null && !blogsList.isEmpty()) { 
           for (Blogs blog : blogsList) { %>
               <div class="blog-item">
                   <h3 class="blog-title"><%= blog.getTitle() %></h3>
                   <p class="blog-date">Published on: <%= blog.getPublishedAt() %></p>
                   <p class="blog-content"><%= blog.getContent() %></p>
                   <form action="changemyblogs" method="post" class="blog-form">
                       <input type="hidden" name="blogId" value="<%= blog.getBlogId() %>">
                       <button type="submit" name="action" value="remove" class="remove-btn">Remove</button>
                   </form>
               </div>
           <% }
       } else { %>
           <p class="no-blogs">You have not created any blogs yet!</p>
    <% } %>
</div>

</body>
</html>
