package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.DetailReceiptDAO;
import com.yactayo.xprs.modelsDTO.DetailReceipt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SAController", value = "/SAController")
public class SAController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<DetailReceipt> details = new DetailReceiptDAO().list();
        session.setAttribute("details", details);
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
