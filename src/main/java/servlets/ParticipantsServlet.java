package servlets;

import entity.Participants;
import service.ParticipantsManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/participantList")
public class ParticipantsServlet extends HttpServlet {

    ParticipantsManager participantsManager = new ParticipantsManager();
    List<Participants> participantsList = participantsManager.getParticipantsList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("participants",participantsList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/participants.jsp");
        requestDispatcher.forward(req,resp);
    }
}
