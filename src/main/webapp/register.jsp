<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .success-message {
            color: #4CAF50;
            font-weight: bold;
        }

        /* Add more styles as needed */
    </style>

    <title>Register Success</title>
</head>
<body>
    <div class="container">
        <%@page import="com.excelr.dao.UserDao"%>
        <jsp:useBean id="obj" class="com.excelr.entity.User">
        </jsp:useBean>
        <jsp:setProperty property="*" name="obj" />

        <%
            int i = UserDao.register(obj);
            if (i > 0) {
                out.print("<div class='success-message'>You are successfully registered</div>");
            } else {
                out.print("Registration failed. Please try again.");
            }
        %>
    </div>
</body>
</html>
