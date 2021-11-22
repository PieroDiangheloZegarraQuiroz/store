package com.yactayo.xprs.modelsDAO;

import com.yactayo.xprs.connectionDB.ConnectionDB;
import com.yactayo.xprs.interfaces.Repostory;
import com.yactayo.xprs.modelsDTO.Client;
import com.yactayo.xprs.modelsDTO.Employee;
import com.yactayo.xprs.modelsDTO.Receipt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDAO implements Repostory<Receipt> {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    @Override
    public List<Receipt> list() {
        return null;
    }

    @Override
    public Receipt byId(int id) {
        return null;
    }

    @Override
    public void save(Receipt receipt) {
        String sql = null;
        sql = "INSERT INTO receipt(purchaseDate ,idClient ,idEmployee) VALUES (curdate(), ?, 2)"; //(2 + round(Rand() * (2 - 2)
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, receipt.getClient().getIdClient());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    public Receipt getDate(int idClient){
        Receipt r = new Receipt();
        String sql = null;
        sql = "SELECT purchaseDate, idReceipt FROM receipt WHERE idClient = " + idClient + " " +
                "ORDER BY idReceipt DESC limit 1";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                r.setPurchaseDate(rs.getDate(1));
                r.setIdReceipt(rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public Receipt getNames(int idClient){
        Receipt r = new Receipt();
        String sql = null;
        sql = "SELECT e.names, e.surnames from receipt r inner join employee e on (r.idEmployee = e.idEmployee) WHERE idClient = " + idClient;
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setNames(rs.getString(1));
                employee.setSurnames(rs.getString(2));
                r.setEmployee(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
}
