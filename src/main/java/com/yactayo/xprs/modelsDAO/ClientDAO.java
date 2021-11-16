package com.yactayo.xprs.modelsDAO;

import com.yactayo.xprs.connectionDB.ConnectionDB;
import com.yactayo.xprs.interfaces.Repostory;
import com.yactayo.xprs.modelsDTO.Client;
import com.yactayo.xprs.modelsDTO.District;
import com.yactayo.xprs.modelsDTO.Province;
import com.yactayo.xprs.modelsDTO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements Repostory<Client> {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    @Override
    public List<Client> list() {
        List<Client> clients = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.*, u.*, p.* FROM client AS c "
                     + "INNER JOIN user AS u ON (c.idUser = u.idUser)"
                     + "INNER JOIN province AS p ON (c.idProvince = p.idProvince)")) {
            while (rs.next()) {
                Client c = createClient(rs);
                clients.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client byId(int id) {
        Client client = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.
                     prepareStatement("SELECT c.*,d.*, u.* FROM client AS c "
                             + "INNER JOIN user AS u ON (c.idUser = u.idUser) "
                             + "INNER JOIN district AS d ON (c.idDistrict = d.idDistrict) WHERE c.idClient = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    client = createClient(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void save(Client client) {
        String sql = null;
        if (client.getIdClient() != null && client.getIdClient() > 0) {
            sql = "UPDATE client SET  names=?, surnames = ?, address = ?, phone = ?, idDistrict = ? WHERE idClient = ?";
        } else {
            sql = "INSERT INTO client(names, surnames, docIdentity, address, phone, idUser, idDistrict) VALUES (?,?,?,?,?,?,?) ";
        }
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getNames());
            stmt.setString(2, client.getSurnames());

            if (client.getIdClient() != null && client.getIdClient() > 0) {
                stmt.setString(3, client.getAddress());
                stmt.setInt(4, client.getPhone());
                stmt.setInt(5, client.getDistrict().getIdDistrict());
                stmt.setInt(6, client.getIdClient());
            } else {
                stmt.setInt(3, client.getDocIdentity());
                stmt.setString(4, client.getAddress());
                stmt.setInt(5, client.getPhone());
                stmt.setInt(6, client.getUser().getIdUser());
                stmt.setInt(7, client.getDistrict().getIdDistrict());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    public Client getIdUser(int idUser) {
        Client client = new Client();
        District district = new District();
        User user = new User();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM client AS c " +
                     "INNER JOIN user AS u ON (c.idUser = u.idUser ) " +
                     "WHERE c.idUser = " + idUser)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    client.setIdClient(rs.getInt("idClient"));
                    client.setNames(rs.getString("names"));
                    client.setSurnames(rs.getString("surnames"));
                    client.setDocIdentity(rs.getInt("docIdentity"));
                    client.setPhone(rs.getInt("phone"));
                    client.setAddress(rs.getString("address"));
                }
            }
        } catch (SQLException ignored) {
        }
        return client;
    }

    private Client createClient(ResultSet rs) throws SQLException {
        Client c = new Client();
        c.setIdClient(rs.getInt("idClient"));
        c.setNames(rs.getString("names"));
        c.setSurnames(rs.getString("surnames"));
        c.setDocIdentity(rs.getInt("docIdentity"));
        c.setAddress(rs.getString("address"));
        c.setPhone(rs.getInt("phone"));

        User u = new User();
        u.setIdUser(rs.getInt("idUser"));
        u.setEmail(rs.getString("email"));
        u.setPassword(rs.getString("password"));

        District d = new District();
        d.setIdDistrict(rs.getInt("idDistrict"));
        d.setName(rs.getString("name"));

        Province p = new Province();
        p.setIdProvince(rs.getInt("idProvince"));
        p.setName(rs.getString("name"));

        c.setUser(u);
        c.setDistrict(d);
        c.setProvince(p);

        return c;
    }
}
