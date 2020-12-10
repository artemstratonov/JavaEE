<%--
  Created by IntelliJ IDEA.
  User: Мася
  Date: 12.11.2020
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="css/regstyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="outer">
    <h1 align="center">REGISTRATION</h1>
    <form action="${pageContext.request.contextPath}/Reg" method="post">
        <div>
            <label>Username</label>
            <input type="text" name="username">
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <div class="btn-box" align="center">
            <button class="register-btn" type="submit">Register</button>
        </div>
    </form>
</div>
</body>
</html>
