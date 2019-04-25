package servlets;

import entity.Meeting;
import entity.Participants;
import service.MeetingManager;
import service.ParticipantsManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/editMeetingParticipants")
public class EditMeetingParticipants extends HttpServlet {
    ParticipantsManager participantsManager = new ParticipantsManager();
    MeetingManager meetingManager = new MeetingManager();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long idMeeting = Long.valueOf(req.getParameter("id"));
        String title=req.getParameter("title");
        String location = req.getParameter("location");
        LocalDateTime time = LocalDateTime.parse(req.getParameter("time"));
        meetingManager.addMeeting(new Meeting(idMeeting,title,location,time));

        List<Participants> participants = participantsManager.getParticipantsList();
        String[] go = req.getParameterValues("go"); //gets the ids of the participants
        //delete all and add them again

        for(Participants part:participants){
            if(idMeeting.equals(part.getMeetingId())){
                participantsManager.deleteParticipant(part);
            }
        }
        for (String participantId:go){
            participantsManager.addParticipant(new Participants(idMeeting,Long.parseLong(participantId)));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/welcome.jsp");
        requestDispatcher.forward(req,resp);
    }
}
