package com.yactayo.xprs.modelsDAO;

import com.yactayo.xprs.connectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Summary {
    private static final String SQL_GET_TOTAL = "SELECT * FROM getTotal";

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    /*Get total*/
    public double getIncome() {
        double income = 0.0;
        try (PreparedStatement stmt = getConnection().prepareStatement(SQL_GET_TOTAL);
             ResultSet resultSet = stmt.executeQuery()) {
            if (resultSet.next()) {
                income = resultSet.getDouble("total");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return income;
    }

    public int getSummary(int type) {
        String SQL_COUNT = "SELECT count(*) AS quantity FROM ";
        // 0 = total de recibos : 1 total Clientes
        SQL_COUNT += (type == 0) ? "receipt" : "client";
        int count = 0;
        try (PreparedStatement stmt = getConnection().prepareStatement(SQL_COUNT);
             ResultSet resultSet = stmt.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt("quantity");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

}

