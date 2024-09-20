<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ThoughtSphere - Blog</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <!-- Navbar -->
    <header class="navbar">
        <div class="container">
            <div class="logo">
				<a href="index.jsp"><h1>ThoughtSphere</h1></a>
            </div>
            <div class="nav-buttons">
                <% User loggedInUser = (User)session.getAttribute("loggedInUser");
                if(loggedInUser != null)
                {%>
                	<a href="myblogs.jsp" class="btn">My Blogs</a>
                    <a href="logout" class="btn">Logout</a>
                <%}
                else
                {%>
                	<a href="login.jsp" class="btn">Sign Up / Sign In</a>
                <% }%>
            </div>
        </div>
    </header>

    <!-- Hero Section -->
    <section class="hero">
        <video autoplay muted loop class="background-video">
            <source src="videos/blog-creation-demo.mp4" type="video/mp4">
        </video>
        <div class="hero-content">
            <h2>Unleash Your Thoughts</h2>
            <p>Share your unique perspective with the world on ThoughtSphere. Create your own blogs effortlessly!</p>
        </div>
        <a href="create_post.jsp" class="btn create-post">Create Post</a>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 ThoughtSphere. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
