package com.yactayo.xprs.servlets;
import com.yactayo.xprs.modelsDTO.AuditProduct;
import com.yactayo.xprs.modelsDAO.ClientDAO;
import com.yactayo.xprs.modelsDTO.Client;
import com.yactayo.xprs.modelsDAO.AuditProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAudit", value = "/ServletAudit")
public class SAudiProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        List<AuditProduct> audit;
        if(action != null && action.equals("product")) {
            audit = new AuditProductDAO().list();
            request.setAttribute("audit", audit);

            request.getRequestDispatcher("adminAudit.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
