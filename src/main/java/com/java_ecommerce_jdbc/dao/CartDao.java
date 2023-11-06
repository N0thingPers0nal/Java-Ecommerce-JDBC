package com.java_ecommerce_jdbc.dao;

import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.models.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private final Connection connection;
    private static String userCart="SELECT user_id,product_id,count FROM cart WHERE user_id=? and isOrdered=FALSE;";
    private static String addToCartNew="INSERT INTO cart(user_id,product_id,count,created_by,updated_by) VALUES(?,?,?,?,?);";
    private static String addToCartOld="UPDATE cart SET count=?,updated_by=?,updated_at=CURRENT_TIMESTAMP() where user_id=? and product_id=?;";
    private static String changeToOrder="UPDATE cart SET isOrdered = TRUE WHERE user_id=?;";
    public CartDao() {
        this.connection = DBConnection.getConnection();
    }

    public List<Cart> getUserCart(int id) {
        List<Cart> cartList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(userCart);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Cart cart=new Cart();
                cart.setUserId(resultSet.getInt("user_id"));
                cart.setProductId(resultSet.getInt("product_id"));
                cart.setCount(resultSet.getInt("count"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }

    public void addToCartNew(int userid, int productid, int count, int createdBy, int updatedBy) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(addToCartNew);
            preparedStatement.setInt(1,userid);
            preparedStatement.setInt(2,productid);
            preparedStatement.setInt(3,count);
            preparedStatement.setInt(4,createdBy);
            preparedStatement.setInt(5,updatedBy);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addToCartOld(int userid, int productid, int count, int updatedBy) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(addToCartOld);
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,updatedBy);
            preparedStatement.setInt(3,userid);
            preparedStatement.setInt(4,productid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void order(int userId) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(changeToOrder);
            preparedStatement.setInt(1,userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
