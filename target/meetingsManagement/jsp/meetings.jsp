<%@ page import="java.util.List" %>
<%@ page import="entity.Meeting" %><%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/18/2019
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meetings</title>
</head>
<body>
    <h1> Meetings List </h1>
    <table style="width:100%" border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Location</th>
            <th>Time</th>
        </tr>
<%
    List<Meeting> meetingList = (List<Meeting>) request.getAttribute("meetings");
    for(Meeting meeting: meetingList){
%>
        <tr>
            <td><%=meeting.getId() %></td>
            <td><%=meeting.getTitle() %></td>
            <td><%=meeting.getLocation() %></td>
            <td><%=meeting.getTime().toString() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
