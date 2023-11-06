package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.IOrderController;
import com.java_ecommerce_jdbc.dao.OrderDao;
import com.java_ecommerce_jdbc.dao.ProductDao;
import com.java_ecommerce_jdbc.models.Cart;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.view.OrderPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.java_ecommerce_jdbc.utils.AppInput.enterString;
import static com.java_ecommerce_jdbc.utils.UserUtil.getLoggedUser;

public class OrderController implements IOrderController {
    private final HomeController homeController;
    private final OrderPage orderPage;
    private final OrderDao orderDao;
    private final ProductDao productDao;
    public OrderController(HomeController homeController) {
        this.homeController = homeController;
        orderPage = new OrderPage();
        orderDao=new OrderDao();
        productDao=new ProductDao();
    }
    @Override
    public void showOrders() {
       int userid=getLoggedUser().getId();
        List<Cart> orderList=orderDao.orders(userid);
        if (orderList.isEmpty()) {
            orderPage.noOrders();
        } else {
            orderPage.showOrders(orderList,productDao.allProducts());
        }
        String dummy = enterString(StringUtil.ANYKEY);
        homeController.menu();
    }
    @Override
    public void succes() {
        orderPage.success();
    }
    public String date() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
