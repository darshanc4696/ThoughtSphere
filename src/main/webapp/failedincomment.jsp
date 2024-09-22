<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comment Failed</title>
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

        /* Container for the message and button */
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

        /* Heading Style */
        h1 {
            font-size: 2rem;
            color: #e74c3c;
            margin-bottom: 20px;
        }

        /* Button Style */
        button {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #555;
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
    <h1>Failed to Add Comment</h1>
    <form action="viewblog.jsp">
        <button type="submit">Back</button>
    </form>
</div>

</body>
</html>
