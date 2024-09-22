<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import="com.blog.model.User" %>
<%@ include file="navbar.jsp"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ThoughtSphere - Create Post</title>
    <link rel="stylesheet" href="createpost.css">
</head>
<body>

<div class="container">
    <h2>Create Blog: Fill the Details Below</h2>

    <% User user = (User)session.getAttribute("loggedInUser"); 
    if(user != null) { %>
        <form action="publishblog" class="blog-form">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
            </div>

            <div class="form-group">
                <label for="content">Content:</label>
                <textarea id="content" name="content" placeholder="Write your opinion/thoughts here..." required></textarea>
            </div>

            <button type="submit" class="submit-btn">Publish</button>
        </form>
    <% } else { %>
        <p class="login-prompt">Please log in to publish the blog.</p>
    <% } %>
</div>

</body>
</html>
