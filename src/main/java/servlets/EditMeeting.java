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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editMeeting")
public class EditMeeting extends HttpServlet {

    MeetingManager meetingManager = new MeetingManager();
    UserManager userManager = new UserManager();
    ParticipantsManager participantsManager = new ParticipantsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Meeting> meetingList = meetingManager.getMeetingList();
        req.setAttribute("meetingList",meetingList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/editMeeting.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Meeting> meetingList = meetingManager.getMeetingList();
        List<User> userList = userManager.getUserList();
        List<Participants> participantsList = participantsManager.getParticipantsList();
        String idMeeting = req.getParameter("selected");
        Meeting meetingToEdit= new Meeting(1L,"","", LocalDateTime.now());
        for(Meeting selectedMeeting: meetingList){
            if(selectedMeeting.getId().equals(Long.parseLong(idMeeting))){
                meetingToEdit = selectedMeeting;
            }
        }
        meetingManager.removeMeeting(meetingToEdit);
        //send info to editMeetingParticipants: meeting to edit, list of all users, list of participants for the meeting
        List<Participants> participantsToMeeting = new ArrayList<>();
        for (Participants participant:participantsList){
            if(meetingToEdit.getId().equals(participant.getMeetingId())){
                participantsToMeeting.add(participant);
            }
        }
        req.setAttribute("meetingToEdit",meetingToEdit);
        req.setAttribute("users",userList);
        req.setAttribute("participants",participantsToMeeting);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/editMeetingParticipants.jsp");
        requestDispatcher.forward(req,resp);
    }
}
