package com.yactayo.xprs.modelsDAO;

import com.yactayo.xprs.connectionDB.ConnectionDB;
import com.yactayo.xprs.interfaces.Repostory;
import com.yactayo.xprs.modelsDTO.Brand;
import com.yactayo.xprs.modelsDTO.Category;
import com.yactayo.xprs.modelsDTO.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements Repostory<Category> {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    @Override
    public List<Category> list() {
        List<Category> categorys = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM category")) {
            while (rs.next()) {
                Category c = createCategory(rs);
                categorys.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorys;
    }

    @Override
    public Category byId(int id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    private Category createCategory(ResultSet rs) throws SQLException {
        Category c = new Category();
        c.setIdCategory(rs.getInt("idCategory"));
        c.setName(rs.getString("name"));
        return c;
    }
}
