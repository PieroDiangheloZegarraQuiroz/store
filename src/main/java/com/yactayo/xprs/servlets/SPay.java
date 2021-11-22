package com.yactayo.xprs.servlets;

import com.yactayo.xprs.modelsDAO.ClientDAO;
import com.yactayo.xprs.modelsDAO.DetailReceiptDAO;
import com.yactayo.xprs.modelsDAO.ReceiptDAO;
import com.yactayo.xprs.modelsDTO.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SPay", value = "/SPay")
public class SPay extends HttpServlet {

    District district = new District();
    Client client = new Client();
    ClientDAO cdao = new ClientDAO();
    ReceiptDAO rdao = new ReceiptDAO();
    DetailReceiptDAO drdao = new DetailReceiptDAO();
    Receipt receipt = new Receipt();
    DetailReceipt detaill = new DetailReceipt();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("validats") == null || !((boolean) session.getAttribute("validats"))) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        int idClient = (Integer) session.getAttribute("idClient");
        registerAddress(request, response, idClient);
    }

    private void registerAddress(HttpServletRequest request, HttpServletResponse response, int idClient)
            throws ServletException, IOException {
        HttpSession session;
        ListCard listCard;
        String address = request.getParameter("address");
        int idDistrict = Integer.parseInt(request.getParameter("idDistrict"));

        if (idDistrict == 0) {
            response.sendRedirect("SCard?action=listCart");
        } else {
            client.setIdClient(idClient);
            client.setAddress(address);
            district.setIdDistrict(idDistrict);
            client.setDistrict(district);
            cdao.updateAddress(client);

            request.setAttribute("address", address);
            request.setAttribute("client", client);

            session = request.getSession();
            listCard = (ListCard) session.getAttribute("card");
            request.setAttribute("cardInfos", listCard.getItems());
            request.setAttribute("cardTotal", listCard.getTotal());
            listCard.getItems();

            client.setIdClient(idClient);
            receipt.setClient(client);
            rdao.save(receipt);

            receipt = rdao.getDate(idClient);
            Date date = receipt.getPurchaseDate();
            int idReceipt = receipt.getIdReceipt();
            request.setAttribute("receipt", idReceipt);
            request.setAttribute("date", date);

            receipt = rdao.getNames(idClient);
            String nameEmployee = receipt.getEmployee().getNames();
            String surnameEmployee = receipt.getEmployee().getSurnames();
            request.setAttribute("namesEmployee", nameEmployee + " " + surnameEmployee);

            receipt.setIdReceipt(drdao.getLast());
            int detailReceipt = receipt.getIdReceipt();

            ListCard list = (ListCard) session.getAttribute("card");
            for (ItemCard items : list.getItems()) {
                detaill.setIdDetailReceipt(detailReceipt);
                detaill.setReceipt(receipt);
                detaill.setProduct(items.getProduct());
                detaill.setQuantity(items.getQuantityz());
                drdao.addP(detaill);
                System.out.println("item" + items.getProduct());
            }

            request.getRequestDispatcher("receipt.jsp").forward(request, response);
            listCard.getstockTotal();
            listCard.getItems().clear();
        }
    }
}
