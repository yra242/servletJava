package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoggerMagazine logger = new LoggerMagazine();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);

        try {
            User user = userService.getUser(email);

            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute("userEmail", email);
                session.setAttribute("userName", user.getName());
                userService.setGuest(false);
                session.setAttribute("displayStyle", "display: inline;");

                // Send success response
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Send error response
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (SQLException e) {
            // Send error response
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}