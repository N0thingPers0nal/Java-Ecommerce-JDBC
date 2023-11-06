package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.models.Cart;
import com.java_ecommerce_jdbc.models.Product;
import com.java_ecommerce_jdbc.utils.StringUtil;

import java.util.List;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class CartPage {
    public void emptyCart() {
        println(StringUtil.EMPTY_CART);
        println(StringUtil.BACKFROMPRODUCTS);
        println(StringUtil.DOT);
    }

    public void showCart(List<Cart> cartList, List<Product> products) {
        double total = 0;
        int s_no = 1;
        println(StringUtil.CART_TITLE);
        for (Cart cart : cartList) {
            for (Product product : products) {
                if (product.getId() == cart.getProductId()) {
                    System.out.println("." + StringUtil.TAB + StringUtil.TAB + s_no++ + ". " + product.getTitle() + "\t" + product.getPrice() + "  x  " + cart.getCount() + "=   Rs. " + cart.getCount() * product.getPrice() + StringUtil.TAB + StringUtil.TAB + StringUtil.TAB + ".");
                    total += cart.getCount() * product.getPrice();
                }
            }
        }
        println("TOTAL=" + total);
        println(StringUtil.CHECKOUT);
        println(StringUtil.BACKFROMPRODUCTS);
        println(StringUtil.DOT);
    }
}
