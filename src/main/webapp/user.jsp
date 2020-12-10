<%--
  Created by IntelliJ IDEA.
  User: Мася
  Date: 11.11.2020
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USERACCESS</title>
    <link rel="stylesheet" id="style-small-css" href="https://pomodoro.od.ua/wp-content/themes/pomodoro/css/style-top.css"/>
</head>
<body>
<header>
  <nav>
      <ul>
          <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-64855">
              <form action="${pageContext.request.contextPath}/Realtor" method="post">
                  <button><a class="menu-item menu-item-type-post_type menu-item-object-page menu-item-64855">Ріелтор</a></button>
              </form>
          </li>
          <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-64855">
              <form action="${pageContext.request.contextPath}/Contract" method="post">
                  <button><a class="menu-item menu-item-type-post_type menu-item-object-page menu-item-64855">Контракти</a></button>
              </form>
          </li>
          <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-64855">
              <form action="${pageContext.request.contextPath}/Apartment" method="post">
                  <button><a class="menu-item menu-item-type-post_type menu-item-object-page menu-item-64855">Апартаменти</a></button>
              </form>
          </li>
      </ul>
  </nav>
</header>
</body>
</html>
