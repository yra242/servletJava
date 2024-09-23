package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserService.getUserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User newUser = new User(name, email, password);
        try {
            userService.addUser(newUser);

            HttpSession session = request.getSession(true);
            session.setAttribute("userEmail", email);
            session.setAttribute("userName", name);
            userService.setGuest(false);
            session.setAttribute("displayStyle", "display: inline;");
            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}