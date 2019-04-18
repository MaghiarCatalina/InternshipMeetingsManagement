<%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/18/2019
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>

</head>
<body>
<h1> Welcome! </h1>
<form action="usersList" method="get">
    View All Users
    <input type="submit" value="Submit">
</form>

<form action="getMeetings" method="get">
    View all Meetings
    <input type="submit" value="Submit">
</form>

<form action="participantList" method="get">
    View All Participants
    <input type="submit" value="Submit">
</form>

<form action="addMeeting" method="get">
    Add Meeting
    <input type="submit" value="Submit">
</form>

<form action="editMeeting" method="get">
    Edit Meeting Participants
    <input type="submit" value="Submit">
</form>

</body>
</html>
