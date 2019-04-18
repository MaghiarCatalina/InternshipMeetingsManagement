package servlets;

import entity.Meeting;
import entity.Participants;
import entity.User;
import service.MeetingManager;
import service.ParticipantsManager;
import service.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/addMeeting")
public class AddMeeting extends HttpServlet {
    MeetingManager meetingManager = new MeetingManager();
    UserManager userManager = new UserManager();
    ParticipantsManager participantsManager = new ParticipantsManager();

    List<User> userList = userManager.getUserList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("users", userList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/addMeeting.jsp");
            requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Long idMeeting = Long.valueOf(req.getParameter("id"));
       String title=req.getParameter("title");
       String location = req.getParameter("location");
       LocalDateTime time = LocalDateTime.parse(req.getParameter("time"));

       meetingManager.addMeeting(new Meeting(idMeeting,title,location,time));

       String[] going = req.getParameterValues("going");
       for(String userId:going){
           Long longUserId = Long.valueOf(userId);
           participantsManager.addParticipant(new Participants(longUserId,idMeeting));
       }

       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/welcome.jsp");
       requestDispatcher.forward(req,resp);

    }
}
