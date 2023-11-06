package com.java_ecommerce_jdbc.dao;

import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryDao {
    private final Connection connection;
private static final String allCategory="SELECT*FROM category";
    public CategoryDao() {
        this.connection = DBConnection.getConnection();
    }
    public List<Category> allCategory(){
        List<Category> categoryList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(allCategory);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category=new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("category_name"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }

}
