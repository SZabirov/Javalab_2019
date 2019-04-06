package com.company;

import com.company.models.User;
import com.company.repositories.UsersRepository;
import com.company.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Properties;

public class AppMain {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop_db";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","postgres");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UsersRepository usersRepository =
                new UsersRepositoryJdbcImpl(conn);
        String username = "'; DROP TABLE shop_user; SELECT '";
        Optional<User> optionalUser =
                usersRepository.findOneByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user);
        } else {
            System.out.println("User with username = " + username + " not found");
        }

        System.out.println("======================");
        System.out.println(usersRepository.findAll());
    }
}
