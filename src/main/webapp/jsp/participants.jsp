<%@ page import="entity.Participants" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/18/2019
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Participants</title>
</head>
<body>
<h1> Participants List </h1>
<table style="width:100%" border="1">
    <tr>
        <th>ID User</th>
        <th>ID Meeting</th>

    </tr>
    <%
        List<Participants> participantsList=(List<Participants>) request.getAttribute("participants");
        for (Participants participants: participantsList) {
    %>
    <tr>
        <td><%=participants.getUserId()%></td>
        <td><%=participants.getMeetingId()%></td>


    </tr>
    <% } %>
</table>
</body>
</html>
