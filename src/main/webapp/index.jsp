<%@page import="com.blog.daoimpl.UserDAOImpl"%>
<%@page import="com.blog.dao.BlogsDAO"%>
<%@page import="com.blog.daoimpl.BlogsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.User, java.util.List, com.blog.model.Blogs" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ThoughtSphere</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="container">
            <div class="logo">
                <a href="index.jsp">ThoughtSphere</a>
            </div>
            <div class="nav-buttons">
                <% User loggedInUser = (User)session.getAttribute("loggedInUser");
                if(loggedInUser != null) {%>
                    <a href="myblogs.jsp" class="btn">My Blogs</a>
                    <a href="logout" class="btn">Logout</a>
                <%} else {%>
                    <a href="login.jsp" class="btn">Sign Up / Sign In</a>
                <% } %>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-content">
            <h1>Unleash Your Thoughts</h1>
            <p>Share your stories and perspectives with ThoughtSphere. Start creating today!</p>
            <a href="create_post.jsp" class="btn create-post">Create Post</a>
        </div>
    </section>

    <!-- Blog Section -->
    <section class="blogs-section">
        <h2>Latest Blogs</h2>
        <div class="blogs-container">
            <% 
            BlogsDAOImpl bdaoi = new BlogsDAOImpl(); 
            UserDAOImpl udaoi = new UserDAOImpl();
            List<Blogs> blogsList = bdaoi.fetchAllBlogs();

            for (Blogs blog : blogsList) {
                User user = udaoi.fetchUser(blog.getUserId());
            %>
                <div class="blog-card">
                    <div class="blog-card-body">
                        <h3><%= blog.getTitle() %></h3>
                        <p><%= blog.getContent().substring(0, 100) %>...</p>
                        <form action="view_blog.jsp" method="POST">
                            <input type="hidden" name="blogId" value="<%= blog.getBlogId() %>">
                            <button type="submit" class="btn view-btn">View</button>
                        </form>
                    </div>
                    <div class="blog-card-footer">
                        <p>By: <%= user.getUsername() %></p>
                        <p><%= blog.getPublishedAt() %></p>
                    </div>
                </div>
            <% } %>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 ThoughtSphere. All rights reserved.</p>
    </footer>
</body>
</html>
