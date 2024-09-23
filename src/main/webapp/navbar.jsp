<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.User, java.util.List, com.blog.model.Blogs" %>
<!DOCTYPE html>
<html>
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

</body>
</html>
