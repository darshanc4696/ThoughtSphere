<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Not Logged In</title>
    <style>
        /* General Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        /* Container */
        .container {
            text-align: center;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 90%;
        }

        /* Error message */
        h1 {
            font-size: 2rem;
            color: #e74c3c; /* Red color to indicate error */
            margin-bottom: 20px;
        }

        /* Button Styles */
        .btn {
            display: inline-block;
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            margin: 10px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            font-size: 1rem;
        }

        .btn:hover {
            background-color: #2980b9;
        }

        /* Back Button Style */
        .back-btn {
            background-color: #95a5a6;
        }

        .back-btn:hover {
            background-color: #7f8c8d;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            h1 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h1>User Not Logged In</h1>
    <a href="login.jsp" class="btn">Login</a>
    <a href="viewblog.jsp" class="btn back-btn">Back</a>
</div>

</body>
</html>
