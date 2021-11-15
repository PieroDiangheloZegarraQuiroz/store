package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.ClientDAO;
import com.yactayo.xprs.modelsDAO.UserDAO;
import com.yactayo.xprs.modelsDTO.Client;
import com.yactayo.xprs.modelsDTO.District;
import com.yactayo.xprs.modelsDTO.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SRegister", value = "/SRegister")
public class SRegister extends HttpServlet {

    List<User> users = new ArrayList<>();
    User user = new User();
    UserDAO udao = new UserDAO();
    District district = new District();
    Client client = new Client();
    ClientDAO cdao = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("register")) {
            this.saveAccount(request, response);
        }
    }

    public void saveAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int phone = Integer.parseInt(request.getParameter("phone"));
        int docIdentity = Integer.parseInt(request.getParameter("docIdentity"));

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        users = udao.list();
        boolean emailExists = users.stream().parallel().anyMatch(u -> u.getEmail().equals(email));

        if (emailExists) {
            request.setAttribute("errorReg", true);
            request.setAttribute("errorRegister", "El email ingresado ya ha sido usado");//jsp register
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            Integer idUser = null;
            user.setIdUser(idUser);
            user.setEmail(email);
            user.setPassword(password);
            user.setFlagType(0);
            udao.save(user);

            idUser = udao.getLastIdUser();
            user.setIdUser(idUser);
            district.setIdDistrict(1);

            client.setNames(name);
            client.setSurnames(surname);
            client.setPhone(phone);
            client.setDocIdentity(docIdentity);
            client.setUser(user);
            client.setDistrict(district);
            cdao.save(client);

        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
