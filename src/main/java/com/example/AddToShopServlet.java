package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddToShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String magazineName = request.getParameter("magazineName");

        // Retrieve or create the shopping cart list
        List<String> shopList = (List<String>) session.getAttribute("shopList");
        if (shopList == null) {
            shopList = new ArrayList<>();
        }

        if (magazineName != null && !magazineName.trim().isEmpty()) {
            shopList.add(magazineName);
        }

        session.setAttribute("shopList", shopList);

        response.sendRedirect("cabinet");
    }
}
