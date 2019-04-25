<%@ page import="entity.Meeting" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/19/2019
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meetings</title>
</head>
<body>
<h1> Select meeting: </h1>
<form action="editMeeting"  method="post">
<table style="width:100%" border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Location</th>
        <th>Time</th>
    </tr>
    <%
        List<Meeting> meetingList = (List<Meeting>) request.getAttribute("meetingList");
        for(Meeting meeting: meetingList){
    %>
    <tr>
        <td><%=meeting.getId() %></td>
        <td><%=meeting.getTitle() %></td>
        <td><%=meeting.getLocation() %></td>
        <td><%=meeting.getTime().toString() %></td>
        <td><input type="radio" name="selected" value="<%=meeting.getId()%>"></td>
    </tr>
    <%
        }
    %>
</table>
    <input type="submit" value="Next">
</form>
</body>
</html>
