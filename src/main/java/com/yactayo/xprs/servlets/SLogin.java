package com.yactayo.xprs.servlets;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import com.yactayo.xprs.modelsDAO.ClientDAO;
import com.yactayo.xprs.modelsDAO.EmployeeDAO;
import com.yactayo.xprs.modelsDAO.UserDAO;
import com.yactayo.xprs.modelsDTO.Client;
import com.yactayo.xprs.modelsDTO.Employee;
import com.yactayo.xprs.modelsDTO.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SLogin", value = "/SLogin")
public class SLogin extends HttpServlet {

    User user = new User();
    UserDAO udao = new UserDAO();
    Employee employee = new Employee();
    EmployeeDAO edao = new EmployeeDAO();
    Client client = new Client();
    ClientDAO cdao = new ClientDAO();
    Integer idUser;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("exit")) {
            //request.getSession().setAttribute("actualizateHome", actualizate = false);
            request.getSession().setAttribute("validats", false);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user.setEmail(email);
            user.setPassword(password);
            boolean userExist = udao.validate(user);
            if (userExist) {
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("password", password);
                request.getSession().setAttribute("validats", true);

                idUser = user.getIdUser();
                int flag = user.getFlagType();
                if (flag == 1) {
                    employee = edao.byId(idUser); //Remplazar por getIdUser
                    request.getSession().setAttribute("idEmployee", employee.getIdEmployee());
                    request.getSession().setAttribute("role", employee.getRole().getIdRole());
                    request.getSession().setAttribute("surnameE", employee.getSurnames());
                    response.sendRedirect("SASummary?action=list");
                } else {
                    client = cdao.getIdUser(idUser);
                    request.getSession().setAttribute("idClientHome", client.getIdClient());
                    request.getSession().setAttribute("nameHome", client.getNames());
                    response.sendRedirect("SHome?action=list");
                }
            } else {
                String errorMessage = "Datos incorrectos";
                request.setAttribute("errorLog", true);
                request.setAttribute("errorLogin", errorMessage);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

}
