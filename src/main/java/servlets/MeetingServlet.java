package servlets;

import entity.Meeting;
import service.MeetingManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getMeetings")
public class MeetingServlet extends HttpServlet {

    MeetingManager meetingManager = new MeetingManager();
    List<Meeting> meetingList = meetingManager.getMeetingList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("meetings", meetingList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/meetings.jsp");
        requestDispatcher.forward(req,resp);
    }
}
