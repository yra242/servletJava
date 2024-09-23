package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Reload extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserService.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (userService.isGuest()) {
            session.setAttribute("displayStyle", "display: none;");
        } else {
            session.setAttribute("displayStyle", "display: inline;");
        }

        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cabinet.jsp").forward(request, response);
    }
}
