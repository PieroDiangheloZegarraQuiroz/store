package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.ProductDAO;
import com.yactayo.xprs.modelsDTO.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SHome", value = "/SHome")
public class SHome extends HttpServlet {

    List<Product> products = new ArrayList<>();
    ProductDAO pdao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("list")){
            products = pdao.list();
            request.getSession().setAttribute("productsHome", products);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
