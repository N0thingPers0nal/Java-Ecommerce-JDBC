package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.IAppController;
import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.view.WelcomePage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class AppController implements IAppController {
    WelcomePage welcomePage;
    AuthController authController;
//    private final Connection connection;


    public AppController() {
        welcomePage = new WelcomePage();
        authController = new AuthController(this);
//        this.connection= DBConnection.getConnection();
    }
    @Override
    public void init() {
//        PreparedStatement preparedStatement= null;
//        try {
//            preparedStatement = connection.prepareStatement("select name from dummy where id=?;");
//            preparedStatement.setInt(1,1);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            while (resultSet.next()){
//
//                System.out.println(resultSet.getString("name"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("init");
        welcomePage.welcome();
        authController.authServ();
    }

    @Override
    public void printAuthServ() {
        println(StringUtil.LOGIN_OR_REGISTER);
    }


}
