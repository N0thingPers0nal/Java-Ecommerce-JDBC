package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.ICartController;
import com.java_ecommerce_jdbc.dao.CartDao;
import com.java_ecommerce_jdbc.dao.ProductDao;
import com.java_ecommerce_jdbc.models.*;
import com.java_ecommerce_jdbc.utils.AppException;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.view.CartPage;

import java.util.ArrayList;
import java.util.List;

import static com.java_ecommerce_jdbc.utils.AppInput.enterInt;
import static com.java_ecommerce_jdbc.utils.UserUtil.getLoggedUser;
import static com.java_ecommerce_jdbc.utils.UserUtil.setLoggedUser;
import static com.java_ecommerce_jdbc.utils.Utils.println;

public class CartController implements ICartController {
    private final HomeController homeController;
    private final CartPage cartPage;
    private final OrderController orderController;
    private final CartDao cartDao;
    private final ProductDao productDao;


    public CartController(HomeController homeController) {
        this.homeController = homeController;
        cartPage = new CartPage();
        orderController = new OrderController(homeController);
        cartDao = new CartDao();
        productDao=new ProductDao();
    }

    @Override
    public void addToCart(Product selectedProduct) {
        User user = getLoggedUser();
        int userid = user.getId();
        List<Cart> cart = cartDao.getUserCart(user.getId());
        int s=0;
        if (cart.isEmpty()) {
           cartDao.addToCartNew(userid, selectedProduct.getId(), 1, userid, userid);
        } else {
            for (Cart cartProduct : cart) {
                if (cartProduct.getProductId() == selectedProduct.getId()) {
                    s=1;
                    System.out.println(cartProduct.getCount());
                    cartDao.addToCartOld(userid, selectedProduct.getId(), cartProduct.getCount()+1,userid);
                    break;
                }
            }
            if(s==0){
                cartDao.addToCartNew(userid, selectedProduct.getId(), 1, userid, userid);
            }
        }
    }

    @Override
    public void showCart() {
        User user = getLoggedUser();
        int userid = user.getId();
        if (cartDao.getUserCart(user.getId()) != null) {
            cartPage.showCart(cartDao.getUserCart(userid),productDao.allProducts());
        } else {
            cartPage.emptyCart();
        }

        try {
            int choice = enterInt(StringUtil.CHOICE);
            if (choice == 9) {
                homeController.menu();
            } else if (choice == 8) {
                cartDao.order(userid);
                orderController.succes();
                homeController.menu();
            } else {
                invalid(new AppException(StringUtil.INVALID));
            }

        } catch (AppException appException) {
            invalid(appException);
        }
    }

    private void invalid(AppException appException) {
        println(appException.getMessage());
        showCart();
    }


}

