package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.models.Product;
import com.java_ecommerce_jdbc.utils.StringUtil;

import java.util.List;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class ProductsPage {
    public void title() {
        println(StringUtil.PRODUCTS);
    }
    public void viewProduct(List<Product> products) {
        int i=1;
        for (Product product :products) {
            println("." + StringUtil.TAB + product.getId() + ". " + product.getTitle() + "\t" + product.getDesc() + "\tRs. " + product.getPrice() + "\t" + StringUtil.TAB + ".");
        }
        println(StringUtil.BACKFROMPRODUCTS);
        println(StringUtil.DOT);
    }
    public void successToCart(String product){
        println(product+" "+StringUtil.ADD_TO_CART);
    }
}
