<%--
  Created by IntelliJ IDEA.
  User: Мася
  Date: 09.11.2020
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="css/loginstyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="outer">
    <h1 align="center">LOGIN</h1>
    <form action="${pageContext.request.contextPath}/Login" method="post">
        <div>
            <label>Username</label>
            <input type="text" name="username">
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <div class="btn-box">
            <button class="enter-btn" type="submit">Enter</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <div class="btn-box2">
            <button class="register-btn">Register</button>
        </div>
    </form>
</div>
</body>
</html>
