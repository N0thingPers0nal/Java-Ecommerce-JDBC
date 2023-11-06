package com.java_ecommerce_jdbc.controller.impl;

import com.java_ecommerce_jdbc.models.Product;

public interface ICartController {
    void addToCart(Product product);
    void showCart();
}
