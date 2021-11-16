package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.ClientDAO;
import com.yactayo.xprs.modelsDTO.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SAClients", value = "/SAClients")
public class SAClients extends HttpServlet {

    List<Client> clients = new ArrayList<>();
    ClientDAO cdao = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("list")) {
            clients = cdao.list();
            request.getSession().setAttribute("clients", clients);
            request.getRequestDispatcher("/adminClients.jsp").forward(request, response);
            System.out.println(clients);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
