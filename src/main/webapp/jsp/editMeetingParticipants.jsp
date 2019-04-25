<%@ page import="entity.Meeting" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Participants" %><%--
  Created by IntelliJ IDEA.
  User: catalina.maghiar
  Date: 4/19/2019
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Participants</title>
</head>
<body>
<h1>Edit meeting: </h1>
<!-- get info param from post(edit meeting)-->
<%
    Meeting meeting = (Meeting)request.getAttribute("meetingToEdit");
    List<User> users = (List<User>) request.getAttribute("users");
    List<Participants> participants = (List<Participants>)request.getAttribute("participants");

%>
<form action="editMeetingParticipants" method="post">
    <!-- send this info to post to modify participants-->
    ID:<br>
    <input type="text" name="id" value="<%=meeting.getId()%>" readonly><br>
    Title:<br>
    <input type="text" name="title" value="<%=meeting.getTitle()%>"><br>
    Location:<br>
    <input type="text" name="location" value="<%=meeting.getLocation()%>"><br>
    Time:<br>
    <input type="datetime-local" name="time" value="<%=meeting.getTime().toString()%>"><br>
    <h1>Participants: </h1>
    <table style="width:100%" border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <%
            for (User user: users) {
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <% boolean participates = false;
                for(Participants participant: participants){
                    if(participant.getUserId().equals(user.getId())){
                        participates = true;
                    }
                }
            %>
            <% if(participates){%>
            <td><input type="checkbox" name="go" checked value="<%=user.getId() %>"></td>
            <% }
            else{
            %>
            <td><input type="checkbox" name="go" value="<%=user.getId() %>"></td>
            <% } %>
        </tr>
        <% } %>
    </table>
    <input type="submit" value="Done">
</form>

</body>
</html>
