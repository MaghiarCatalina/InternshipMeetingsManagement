<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/18/2019
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Meeting</title>
</head>
<body>
<h1>Create new meeting</h1>
<form action="addMeeting"  method="post">
    ID:<br>
    <input type="text" name="id"><br>
    Title:<br>
    <input type="text" name="title"><br>
    Location:<br>
    <input type="text" name="location"><br>
    Time:<br>
    <input type="datetime-local" name="time"><br>

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
            <td><input type="checkbox" name="going" value="<%=user.getId()%>"></td>
        </tr>
        <% } %>
    </table>

    <input type="submit" value="Create">
</form>
</body>
</html>
