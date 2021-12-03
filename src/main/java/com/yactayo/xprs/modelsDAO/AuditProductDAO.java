package com.yactayo.xprs.modelsDAO;
import com.yactayo.xprs.connectionDB.ConnectionDB;
import com.yactayo.xprs.modelsDTO.AuditProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AuditProductDAO {
    private static final String SQL_SELECT = "SELECT * FROM audiproduct";


    public List<AuditProduct> list() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AuditProduct audiproduct = null;
        List<AuditProduct> auditProducts = new ArrayList<>();
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Date date = rs.getDate("date");
                String event = rs.getString("event");
                String nameOld = rs.getString("nameOld");
                String nameNew = rs.getString("nameNew");
                double priceOld = rs.getDouble("priceOld");
                double priceNew = rs.getDouble("priceNew");
                int stockOld = rs.getInt("stockOld");
                int stockNew = rs.getInt("stockNew");
                String author = rs.getString("user"); //probar con user
                audiproduct = new AuditProduct(date, event, nameOld, nameNew, priceOld, priceNew, stockOld, stockNew, author);
                auditProducts.add(audiproduct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return auditProducts;
    }
}