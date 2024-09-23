package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RedactMagazine extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserService.getUserService();
    private final MagazineService magazineService = MagazineService.getMagazineService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String selectedMagazine = request.getParameter("magazineName");
        String magazineText = request.getParameter("magazineText");

        try {
            if (selectedMagazine != null && !selectedMagazine.trim().isEmpty()) {
                // Fetch the full magazine object from the service
                Magazine magazine = magazineService.getMagazine(selectedMagazine);

                // Update the magazine text if it's provided (e.g., from a form submission)
                if (magazine != null && magazineText != null) {
                    magazine.setTextMagazine(magazineText);
                    magazineService.updateMagazineText(selectedMagazine, magazineText);
                }

                // Set the full magazine object in the session
                session.setAttribute("selectedMagazine", magazine);
            }
            response.sendRedirect("redact.jsp");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
