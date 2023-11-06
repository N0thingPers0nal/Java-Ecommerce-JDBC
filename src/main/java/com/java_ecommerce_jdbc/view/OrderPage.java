package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.models.Cart;
import com.java_ecommerce_jdbc.models.Product;
import com.java_ecommerce_jdbc.models.User;
import com.java_ecommerce_jdbc.utils.StringUtil;

import java.util.List;

import static java.lang.Integer.parseInt;
import static com.java_ecommerce_jdbc.utils.UserUtil.getLoggedUser;
import static com.java_ecommerce_jdbc.utils.Utils.print;
import static com.java_ecommerce_jdbc.utils.Utils.println;

public class OrderPage {
    public void noOrders() {
        println(StringUtil.EMPTY_ORDERS);
    }

    public void showOrders(List<Cart> orderList, List<Product> products) {
        double total = 0;
        int s_no = 1;
        print(StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + "\tOrders\n" + StringUtil.DOT + "\n");
        print(StringUtil.CART_TITLE + "\n");
        for (Cart cart : orderList) {
            for (Product product : products) {
                if (product.getId() == cart.getProductId()) {
                    System.out.println("." + StringUtil.TAB + StringUtil.TAB + s_no++ + ". " + product.getTitle() + "\t" + product.getPrice() + "  x  " + cart.getCount() + "=   Rs. " + cart.getCount() * product.getPrice() + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + ".");
                    total += cart.getCount() * product.getPrice();
                }
            }
        }
        println(StringUtil.DOT + "\n" + "." + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + "\tTotal= " + total + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + ".\n" + StringUtil.DOT + "\n");
    }

    public void success() {
        println(StringUtil.DOT);
        println(StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + StringUtil.SUCCESSFULLY_ORDERED + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB);
        println(StringUtil.DOT);
    }
}
