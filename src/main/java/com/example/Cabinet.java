package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cabinet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = UserService.getUserService();
    private final MagazineService magazineService = MagazineService.getMagazineService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String magazineName = request.getParameter("magazineName");
        LoggerMagazine logger = new LoggerMagazine();
        try {
            if (magazineName != null && !magazineName.trim().isEmpty()) {
                magazineService.addMagazineName(magazineName); // Add magazine with empty text initially
            }
            List<Magazine> magazineList=new ArrayList<>();
            logger.logInfo("Add new magazine "+ magazineName);
            magazineList.add(magazineService.getMagazine(magazineName));
            session.setAttribute("magazineList", magazineList);

            response.sendRedirect("cabinet");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            List<String> magazineList = magazineService.getAllMagazineNames();
            session.setAttribute("magazineList", magazineList);

            request.getRequestDispatcher("/cabinet.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
