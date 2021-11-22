package com.yactayo.xprs.servlets;
import com.yactayo.xprs.modelsDAO.DetailReceiptDAO;
import com.yactayo.xprs.modelsDTO.DetailReceipt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "SControllerHome", urlPatterns = {"/SControllerHome"})

public class SControllerHome extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Summary summary = new Summary();
//        request.setAttribute("ventas", summary.getSummary(0));
//        request.setAttribute("clientes", summary.getSummary(1));
//        request.setAttribute("ingresos", summary.getIncome());

        List<DetailReceipt> detail = new DetailReceiptDAO().list();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("detail", detail);
        System.out.println("detail = " + detail);
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
