package service;

import connection.DataSource;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    Connection con = null;

    public List<User> getUserList() {
        String SQL_QUERY = "select * from users";
        List<User> userList = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            rs = pst.executeQuery();

            userList = new ArrayList<>();
            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setLastName(rs.getString("last_name"));
                user.setFirstName(rs.getString("first_name"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    public User findById(Long id) {
        User user = new User();
        String SQL_QUERY = "select * from users where id=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            pst.setLong(1, id);
            rs = pst.executeQuery();

            rs.next();
            user.setId(rs.getLong("id"));
            user.setLastName(rs.getString("last_name"));
            user.setFirstName(rs.getString("first_name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
