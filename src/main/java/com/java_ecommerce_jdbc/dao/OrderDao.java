package com.java_ecommerce_jdbc.dao;

import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.models.Cart;
import com.java_ecommerce_jdbc.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private final Connection connection;
    public OrderDao() {
        this.connection = DBConnection.getConnection();
    }
    private final String orders="SELECT*FROM cart WHERE user_id=? and isOrdered=TRUE;";
    public List<Cart> orders(int userId){
        List<Cart> order=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(orders);
            preparedStatement.setInt(1,userId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Cart cart=new Cart();
                cart.setUserId(resultSet.getInt("user_id"));
                cart.setProductId(resultSet.getInt("product_id"));
                cart.setCount(resultSet.getInt("count"));
                order.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return order;
    }
}
