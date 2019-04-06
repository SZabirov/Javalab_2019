package com.company.repositories;

import com.company.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private Connection connection;

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<User> userRowMapper = rs ->
            new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
            );

    @Override
    public Optional<User> findOneByUsername(String username) {
        String sqlQuery = "SELECT * FROM shop_user " +
                "WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sqlQuery)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                User u = null;
                if (rs.next()) {
                    u = userRowMapper.mapRow(rs);
                }
                return Optional.ofNullable(u);
            }
        } catch(SQLException e) {
            throw new IllegalStateException(e);
        }

//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = connection.createStatement();
//            String sqlQuery = "SELECT * FROM shop_user " +
//                    "WHERE username = '" + username + "'";
//            rs = stmt.executeQuery(sqlQuery);
//            User u = null;
//            if ( rs.next()) {
//                u = userRowMapper.mapRow(rs);
//            }
//            return Optional.ofNullable(u);
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        } finally {
//            if (stmt != null) {
//                stmt.close();//обработать исключение
//            }
//            if (rs != null) {
//                rs.close();//обработать исключение
//            }
//        }
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        String sqlQuery = "SELECT * FROM shop_user";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)) {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(userRowMapper.mapRow(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
