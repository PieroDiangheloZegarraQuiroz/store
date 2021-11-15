package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.ProductDAO;
import com.yactayo.xprs.modelsDTO.ItemCard;
import com.yactayo.xprs.modelsDTO.ListCard;
import com.yactayo.xprs.modelsDTO.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SCard", value = "/SCard")
public class SCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        ListCard listCard = (ListCard) session.getAttribute("card");
        if (listCard != null && action.equals("listCart")) {
            request.setAttribute("cardInfos", listCard.getItems());
            request.setAttribute("cardTotal", listCard.getTotal());
        }
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ListCard listCard;
        if (action == null) {
            int idProduct = Integer.parseInt(request.getParameter("idProduct"));
            Product product = new ProductDAO().byId(idProduct);
            ItemCard itemCard = new ItemCard(1, product);
            if (session.getAttribute("card") == null) {
                listCard = new ListCard();
                session.setAttribute("card", listCard);
            } else {
                listCard = (ListCard) session.getAttribute("card");
            }
            listCard.addItemCard(itemCard);
        }

        if (action.equals("Delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            listCard = (ListCard) session.getAttribute("card");
            listCard.removeItem(id);
        }
    }
}
