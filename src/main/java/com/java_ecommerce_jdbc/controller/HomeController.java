package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.IHomeController;
import com.java_ecommerce_jdbc.utils.AppException;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.utils.UserUtil;
import com.java_ecommerce_jdbc.view.HomePage;

import static com.java_ecommerce_jdbc.utils.AppInput.enterInt;
import static com.java_ecommerce_jdbc.utils.Utils.println;

public class HomeController implements IHomeController {
    private final HomePage homePage;
    private final AuthController authController;
    private final CategoriesController categoriesController;
    private final ProductController productController;
    private final CartController cartController;
    private final OrderController orderController;

    public HomeController(AuthController authController) {
        homePage = new HomePage();
        this.authController = authController;
        categoriesController = new CategoriesController(this);
        productController = new ProductController(this);
        cartController = new CartController(this);
        orderController = new OrderController(this);
    }

    @Override
    public void menu() {
        homePage.userOptions();
        int choice = 0;
        try {
            choice = enterInt(StringUtil.CHOICE);
            if (choice == 1) {
                categoriesController.showCatogries();
            } else if (choice == 2) {
                productController.showProducts(0);
            } else if (choice == 3) {
                cartController.showCart();
            } else if (choice == 4) {
                orderController.showOrders();
            } else if (choice == 5) {
                logout();
            } else {
                invalid(new AppException(StringUtil.INVALID));
            }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
    }

    private void invalid(AppException appException) {
        println(appException.getMessage());
    }

    @Override
    public void logout() {
        try {
            homePage.logoutSuccess();
            UserUtil.setLoggedUser(null);
            Thread.sleep(500);
            authController.authServ();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
