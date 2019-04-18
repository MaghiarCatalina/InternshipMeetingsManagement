<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/18/2019
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h1> User List </h1>
    <table style="width:100%" border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
    <%
        List<User> users=(List<User>) request.getAttribute("users");
        for (User user: users) {
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getFirstName()%></td>
        <td><%=user.getLastName()%></td>

    </tr>
    <% } %>
    </table>
</body>
</html>
