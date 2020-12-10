
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.DAOService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ApartmentsTable</title>
    <link rel="stylesheet" id="style-small-css" href="https://pomodoro.od.ua/wp-content/themes/pomodoro/css/style-top.css"/>
    <style>
        table {
            width: 300px;
            border: 1px solid black;
            margin: auto;
        }
        td {
            text-align: center;
            border: 1px solid black;
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
        <th>id</th><th>address</th><th>countOfRooms</th><th>price</th>
        <c:forEach var="apartment" items="${DAOService.apartmentDAO.apartmentList}">
            <tr>
                <td><c:out value="${apartment.id}"/></td>
                <td><c:out value="${apartment.address}"/></td>
                <td><c:out value="${apartment.countOfRooms}"/></td>
                <td><c:out value="${apartment.price}"/></td>
            </tr>
        </c:forEach>
        <form action="${pageContext.request.contextPath}/AddingApartment" method="post"><tr><th><input type="text" name="id"></th><th><input type="text" name="address"></th><th><input type="text" name="countOfRooms"></th><th><input type="text" name="price"></th><th><button class="enter-btn">Input</button></th></tr></form>
        <form action="${pageContext.request.contextPath}/EditApartment" method="post"><tr><th><input type="text" name="id"></th><th><input type="text" name="address"></th><th><input type="text" name="countOfRooms"></th><th><input type="text" name="price"></th><th><button class="enter-btn">Edit</button></th></tr></form>
        <form action="${pageContext.request.contextPath}/DeletingApartment" method="post"><tr><th><input type="text" name="id"></th><th><button class="enter-btn">Delete</button></th></tr></form>
        <form action="${pageContext.request.contextPath}/SearchApartment" method="post"><tr><th><select name="search"><option value="1">Id</option ><option value="2">Address</option><option value="3">CountOfRooms</option ></select></th><th><input type="text" name="id"></th><th><button class="enter-btn">Search</button></th></tr></form>
        <tr><th>${answer.id}</th><th>${answer.address}</th><th>${answer.countOfRooms}</th><th>${answer.price}</th></tr>
    </table>
</header>
</body>
</html>
