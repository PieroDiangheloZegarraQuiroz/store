package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.ProductDAO;
import com.yactayo.xprs.modelsDTO.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SStore", value = "/SStore")
public class SStore extends HttpServlet {

    List<Product> products = new ArrayList<>();
    ProductDAO pdao = new ProductDAO();
    List<Product> keyboard = new ArrayList<>();
    List<Product> mouse = new ArrayList<>();
    List<Product> sound = new ArrayList<>();
    List<Product> processor = new ArrayList<>();
    List<Product> print = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        products = pdao.list();
        switch (action) {
            case "list":
                List<Product> products2 = new ProductDAO().list();
                if (!(keyboard.isEmpty() && mouse.isEmpty() && sound.isEmpty() && processor.isEmpty() && print.isEmpty())) {
                    keyboard.clear();
                    mouse.clear();
                    sound.clear();
                    processor.clear();
                    print.clear();
                }
                selectCategory(products2);
                request.setAttribute("keyboard", keyboard);
                request.setAttribute("mouse", mouse);
                request.setAttribute("sound", sound);
                request.setAttribute("processor", processor);
                request.setAttribute("print", print);
                request.getRequestDispatcher("store.jsp").forward(request, response);
                break;
        }
    }

    private void selectCategory(List<Product> products) {
        for (Product product : products) {
            int idCategory = product.getCategory().getIdCategory();
            switch (idCategory) {
                case 1:
                    keyboard.add(product);
                    break;
                case 2:
                    mouse.add(product);
                    break;
                case 3:
                    sound.add(product);
                    break;
                case 4:
                    processor.add(product);
                    break;
                case 5:
                    print.add(product);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
