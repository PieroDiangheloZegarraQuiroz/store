package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.DetailReceiptDAO;
import com.yactayo.xprs.modelsDAO.Summary;
import com.yactayo.xprs.modelsDTO.DetailReceipt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SControllerHome", value = "/SControllerHome")
public class SControllerHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Summary summary = new Summary();
        request.setAttribute("ventas", summary.getSummary(0));
        request.setAttribute("clientes", summary.getSummary(1));
        request.setAttribute("ingresos", summary.getIncome());

        HttpSession session = request.getSession();
        List<DetailReceipt> details = new DetailReceiptDAO().list();
        session.setAttribute("details", details);
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
