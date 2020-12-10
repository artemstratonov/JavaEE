<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.DAOService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>RealtorTable</title>
    <link rel="stylesheet" id="style-small-css" href="https://pomodoro.od.ua/wp-content/themes/pomodoro/css/style-top.css"/>
    <style>
        table {
            width: 300px;
            border: 1px solid green;
            margin: auto;
        }
        td {
            text-align: center;
            border: 1px solid grey;
        }
    </style>
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
    <table>
        <th>id</th><th>name</th><th>surname</th><th>commission</th><th>phoneNumber</th></tr>
        <c:forEach var="realtor" items="${DAOService.realtorDAO.realtorList}">
            <tr>
                <td><c:out value="${realtor.id}"/></td>
                <td><c:out value="${realtor.name}"/></td>
                <td><c:out value="${realtor.surname}"/></td>
                <td><c:out value="${realtor.commission}"/></td>
                <td><c:out value="${realtor.phoneNumber}"/></td>
            </tr>
        </c:forEach>
        <form action="${pageContext.request.contextPath}/AddingRealtor" method="post"><tr><th><input type="text" name="id"></th><th><input type="text" name="name"></th><th><input type="text" name="surname"></th><th><input type="text" name="commission"></th><th><input type="text" name="phoneNumber"><th><button class="enter-btn">Input</button></th></tr></form>
        <form action="${pageContext.request.contextPath}/EditRealtor" method="post"><tr><th><input type="text" name="id"></th><th><input type="text" name="name"></th><th><input type="text" name="surname"></th><th><input type="text" name="commission"></th><th><input type="text" name="phoneNumber"><th><button class="enter-btn">Edit</button></th></tr></form>
        <form action="${pageContext.request.contextPath}/DeletingRealtor" method="post"><tr><th><input type="text" name="id"></th><th><button class="enter-btn">Delete</button></th></tr></form>
    </table>
</header>
</body>
</html>
