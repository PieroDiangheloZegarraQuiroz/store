package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.BrandDAO;
import com.yactayo.xprs.modelsDAO.CategoryDAO;
import com.yactayo.xprs.modelsDAO.ProductDAO;
import com.yactayo.xprs.modelsDTO.Brand;
import com.yactayo.xprs.modelsDTO.Category;
import com.yactayo.xprs.modelsDTO.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SAProducts", value = "/SAProducts")
public class SAProducts extends HttpServlet {

    List<Product> products = new ArrayList<>();
    ProductDAO pdao = new ProductDAO();
    Product product = new Product();
    CategoryDAO cdao = new CategoryDAO();
    List<Category> categorys = new ArrayList<>();
    BrandDAO bdao = new BrandDAO();
    List<Brand> brands = new ArrayList<>();
    int idProduct;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                products = pdao.list();
                request.getSession().setAttribute("products", products);
                request.getRequestDispatcher("/adminProducts.jsp").forward(request, response);
                break;
            case "getData":
                idProduct = Integer.parseInt(request.getParameter("idProduct"));
                product = pdao.byId(idProduct);
                categorys = cdao.list();
                brands = bdao.list();
                request.setAttribute("categoryProduct", product.getCategory().getIdCategory());
                request.setAttribute("categorys", categorys);
                request.setAttribute("brandProduct", product.getBrand().getIdBrand());
                request.setAttribute("brands", brands);
                request.getSession().setAttribute("product", product);
                request.getRequestDispatcher("/adminProductsControl.jsp").forward(request, response);
                break;
            case "delete":
                idProduct = Integer.parseInt(request.getParameter("idProduct"));
                pdao.delete(idProduct);
                products = pdao.list();
                request.getSession().setAttribute("products", products);
                request.getRequestDispatcher("/adminProducts.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
