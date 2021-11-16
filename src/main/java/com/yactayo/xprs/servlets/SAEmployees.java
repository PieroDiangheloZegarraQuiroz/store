package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.EmployeeDAO;
import com.yactayo.xprs.modelsDTO.Employee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SAEmployees", value = "/SAEmployees")
public class SAEmployees extends HttpServlet {

    List<Employee> employees = new ArrayList<>();
    EmployeeDAO edao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("list")){
            employees = edao.list();
            System.out.println(employees);
            request.getSession().setAttribute("employees", employees);
            request.getRequestDispatcher("/adminEmployee.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
