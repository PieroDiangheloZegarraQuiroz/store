package com.yactayo.xprs.modelsDAO;

import com.yactayo.xprs.connectionDB.ConnectionDB;
import com.yactayo.xprs.interfaces.Repostory;
import com.yactayo.xprs.modelsDTO.Brand;
import com.yactayo.xprs.modelsDTO.Category;
import com.yactayo.xprs.modelsDTO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repostory<Product> {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    @Override
    public List<Product> list() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM product AS p " +
                     "INNER JOIN category AS c ON (p.idCategory = c.idCategory) " +
                     "INNER JOIN brand AS b ON (p.idBrand = b.idBrand)")) {
            while (rs.next()) {
                Product p = createProduct(rs);
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product byId(int id) {
        Product p = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.
                     prepareStatement("SELECT * FROM product WHERE idProduct = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p = createProduct(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(int id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM product WHERE idProduct = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStock(int idProduct, int stock) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement("UPDATE producto SET stock=? WHERE idProduct=?");
            stmt.setInt(1, stock);
            stmt.setInt(2, idProduct);

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setIdProduct(rs.getInt("idProduct"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getDouble("price"));
        p.setStock(rs.getInt("stock"));
        p.setDescription(rs.getString("description"));
        p.setUrlPhoto(rs.getString("urlPhoto"));

        Category c = new Category();
        c.setIdCategory(rs.getInt("idCategory"));
        c.setName(rs.getString("name"));

        Brand b = new Brand();
        b.setIdBrand(rs.getInt("idBrand"));
        b.setName(rs.getString("name"));

        p.setCategory(c);
        p.setBrand(b);
        return p;
    }

}
