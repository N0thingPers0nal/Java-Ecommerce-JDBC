package com.java_ecommerce_jdbc.dao;

import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.models.Category;
import com.java_ecommerce_jdbc.models.Product;
import com.java_ecommerce_jdbc.utils.AppException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final Connection connection;
    private final String allProducts="SELECT*FROM products;";
    public ProductDao() {
        this.connection = DBConnection.getConnection();
    }
    public List<Product> allProducts(){
        List<Product> productList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(allProducts);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product=new Product();
                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                productList.add(product);
            }

        } catch (SQLException | AppException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
