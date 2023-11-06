package com.java_ecommerce_jdbc.dao;

import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.models.Category;
import com.java_ecommerce_jdbc.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDao {
    private static int a = 2;
    private final Connection connection;
    private final String allUsers = "SELECT*FROM user";
    private final String selectUser = "SELECT*FROM user WHERE email=? and password=?";
    private final String addUser = "INSERT INTO user(email,password,created_by,updated_by) VALUES(?,?,?,?);";

    public UserDao() {
        this.connection = DBConnection.getConnection();
    }

    public User isLoggedIn(String name, String password) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectUser);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public boolean register(String email, String password, int createdBy, int updatedBy) {
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(allUsers);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                if (Objects.equals(resultSet.getString("email"), email)) {
                    return false;
                }
            }
            a += 1;
            PreparedStatement preparedStatement = connection.prepareStatement(addUser);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, allUser());
            preparedStatement.setInt(4, allUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public int allUser() {
        int a = 0;
        List<User> userList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allUsers);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                a += 1;
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

}
