package com.yactayo.xprs.modelsDAO;

import com.yactayo.xprs.connectionDB.ConnectionDB;
import com.yactayo.xprs.interfaces.Repostory;
import com.yactayo.xprs.modelsDTO.Brand;
import com.yactayo.xprs.modelsDTO.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements Repostory<Brand> {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    @Override
    public List<Brand> list() {
        List<Brand> brands = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM brand")) {
            while (rs.next()) {
                Brand b = createBrand(rs);
                brands.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public Brand byId(int id) {
        return null;
    }

    @Override
    public void save(Brand brand) {

    }

    @Override
    public void delete(int id) {

    }

    private Brand createBrand(ResultSet rs) throws SQLException {
        Brand b= new Brand();
        b.setIdBrand(rs.getInt("idBrand"));
        b.setName(rs.getString("name"));
        return b;
    }
}
