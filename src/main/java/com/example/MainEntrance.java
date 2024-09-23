package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainEntrance extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        LoggerMagazine logger = new LoggerMagazine();
        HttpSession session = request.getSession();
        switch (action){
            case "guest":
                userService.setGuest(true);
                session.setAttribute("displayStyle", "display: none;");
                logger.logInfo("User is guest");
                request.getRequestDispatcher("cabinet.jsp").forward(request, response);
                break;
            case "login":
                logger.logInfo("User is going to login");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "register":
                logger.logInfo("User is going to register");
                request.getRequestDispatcher("registr.jsp").forward(request, response);
                break;
            default:
                logger.logFatal("Invalid action");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }
}