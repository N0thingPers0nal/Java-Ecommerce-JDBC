package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.IAuthController;
import com.java_ecommerce_jdbc.dao.UserDao;
import com.java_ecommerce_jdbc.db.DBConnection;
import com.java_ecommerce_jdbc.models.User;
import com.java_ecommerce_jdbc.utils.AppException;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.view.LoginPage;
import com.java_ecommerce_jdbc.view.RegisterPage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.java_ecommerce_jdbc.utils.AppInput.enterInt;
import static com.java_ecommerce_jdbc.utils.AppInput.enterString;
import static com.java_ecommerce_jdbc.utils.UserUtil.setLoggedUser;
import static com.java_ecommerce_jdbc.utils.Utils.println;

public class AuthController implements IAuthController {
    private int regId = 2;
    private final AppController appController;
    private final HomeController homeController;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;
    private final Connection connection;
    private final UserDao userDao;


    public AuthController(AppController appController) {
        this.appController = appController;
        homeController = new HomeController(this);
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        this.connection = DBConnection.getConnection();
        this.userDao = new UserDao();
    }

    @Override
    public void authServ() {
        appController.printAuthServ();
        int choice = 0;
        try {
            choice = enterInt(StringUtil.CHOICE);
            if (choice == 1) {
                register();
            } else if (choice == 2) {
                login();
            } else if (choice == 3) {
                System.exit(0);
            } else {
                invalid(new AppException(StringUtil.INVALID));
            }

        } catch (AppException appException) {
            invalid(appException);
        }

    }

    private void invalid(AppException appException) {
        println(appException.getMessage());
        authServ();
    }

    @Override
    public void login() {
        String email, password;
        email = enterString(StringUtil.EMAIL);
        password = enterString(StringUtil.PASSWORD);
        System.out.println("check user");
        User user = userDao.isLoggedIn(email, password);
        if (user == null) {
            loginPage.fail();
            authServ();
        } else {
            loginPage.success();
            setLoggedUser(user);
            homeController.menu();
        }
    }


    @Override
    public void register() {
        String email, password, confirm_password;
        email = enterString(StringUtil.EMAIL);
        password = enterString(StringUtil.PASSWORD);
        confirm_password = enterString(StringUtil.CONFIRM_PASSWORD);
        if (password.equals(confirm_password) && userDao.register(email, password, regId, regId)) {
            regId += 1;
            registerPage.success();
        } else {
            registerPage.fail();
        }
        authServ();
    }

    @Override
    public void logout() {
    }
}
