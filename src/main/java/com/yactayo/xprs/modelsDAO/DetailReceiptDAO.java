package com.yactayo.xprs.modelsDAO;
import com.yactayo.xprs.connectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.yactayo.xprs.modelsDTO.*;
import java.util.List;


public class DetailReceiptDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM details order by details desc";
    private static final String SQL_INSERT = "INSERT INTO detailreceipt(idDetailReceipt,price,quantity,idProduct,idReceipt) VALUES (?,?,?,?,?)";
    private static final String SQL_getUltimo = "SELECT idReceipt FROM receipt ORDER BY idReceipt DESC limit 1";

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    public int getLast() {
        int id = 0;

        try (PreparedStatement stmt = getConnection().prepareStatement(SQL_getUltimo);
             ResultSet resultSet = stmt.executeQuery()) {
            if (resultSet.next()) {
                id = resultSet.getInt("idReceipt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<DetailReceipt> list() {
        List<DetailReceipt> detailReceipts = new ArrayList<>();
        try (PreparedStatement stmt = getConnection().prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detailReceipts.add(getDetailReceipt(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return detailReceipts;
    }

    /*Insert a new Receipt*/
    public int addP(DetailReceipt detail) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, detail.getIdDetailReceipt());
            stmt.setDouble(2, detail.getProduct().getPrice());
            stmt.setInt(3, detail.getQuantity());
            stmt.setInt(4, detail.getProduct().getIdProduct());
            stmt.setInt(5, detail.getReceipt().getIdReceipt());
            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    private DetailReceipt getDetailReceipt(ResultSet rs) throws SQLException {
        // id|price|quantity|name|buy|delivery|name|total|

        DetailReceipt d = new DetailReceipt();
        d.setIdDetailReceipt(rs.getInt("idDetailReceipt"));
        d.setQuantity(rs.getInt("quantity"));


        Client c = new Client();
        c.setIdClient(rs.getInt("idClient"));
        c.setNames(rs.getString("names"));
        c.setSurnames(rs.getString("surnames"));


        Employee e = new Employee();
        e.setIdEmployee(rs.getInt("idEmployee"));
        e.setNames(rs.getString("names"));

        Receipt r = new Receipt();
        r.setIdReceipt(rs.getInt("idReceipt"));
        r.setPurchaseDate(rs.getDate("purchaseDate"));
        r.setTotal(rs.getDouble("total"));

        r.setClient(c);

        Product p = new Product();
        p.setIdProduct(rs.getInt("idProduct"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getDouble("price"));

        d.setReceipt(r);
        d.setProduct(p);

        return d;
    }



}
