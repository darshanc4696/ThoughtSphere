<%@page import="com.blog.daoimpl.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.Blogs, java.util.List,com.blog.daoimpl.CommentsDAOImpl, com.blog.model.Comments, com.blog.model.User, com.blog.daoimpl.UserDAOImpl" %>
<%@ include file="navbar.jsp"%> <!-- Navbar included -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ThoughtSphere - View Blog</title>
    <link rel="stylesheet" href="viewblog.css"> <!-- Separate CSS for viewblog.jsp -->
</head>

<body>

<!-- Blog Content Container -->
<div class="blog-container">
    <!-- Back Button -->
    <button class="back-btn" onclick="window.location.href='index.jsp'">Back</button>

    <% 
        Blogs blog = (Blogs)session.getAttribute("blog");
        String username = (String)session.getAttribute("username");

        UserDAOImpl udaoi = new UserDAOImpl();
        CommentsDAOImpl cdaoi = new CommentsDAOImpl();

        List<Comments> commentsList = cdaoi.fetchSpecificComments(blog.getBlogId());
    %>

    <!-- Blog Details -->
    <div class="blog-content">
        <h1 class="blog-title"><%= blog.getTitle() %></h1>
        <h4 class="blog-author">By: <%=username%></h4>
        <p class="blog-date">Published on: <%= blog.getPublishedAt() %></p>
        <img class="blog-image" alt="Blog Image" src="<%= blog.getImgPath() %>">
        <p class="blog-text"><%= blog.getContent() %></p>
    </div>

    <!-- Comments Section -->
    <div class="comments-section">
        <h2>Comments</h2>
        <!-- Comment Form -->
        <form action="addcomment" class="comment-form">
            <input type="hidden" name="blogId" value="<%= blog.getBlogId() %>">
            <textarea id="comments" name="commentText" placeholder="Write your comment here..."></textarea>
            <button type="submit">ADD Comment</button>
        </form>
        
        <!-- Display Previous Comments -->
        <h3>Previous Comments</h3>
        <% for(Comments comment : commentsList) {
            User user = udaoi.fetchUser(comment.getUserId()); %>
            <div class="comment">
                <p class="comment-user"><%= user.getUsername() %></p>
                <p class="comment-date">Commented on: <%= comment.getCommentedAt() %></p>
                <p class="comment-text"><%= comment.getCommentText() %></p>
            </div>
        <% } %>
    </div>
</div>

</body>
</html>
