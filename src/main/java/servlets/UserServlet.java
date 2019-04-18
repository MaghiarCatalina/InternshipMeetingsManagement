package servlets;


import entity.User;
import service.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usersList")
public class UserServlet extends HttpServlet {

    UserManager userManager = new UserManager();
    List<User> userList = userManager.getUserList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("users",userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/users.jsp");
        requestDispatcher.forward(req,resp);
    }
}
