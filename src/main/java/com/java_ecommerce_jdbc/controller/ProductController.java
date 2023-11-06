package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.IProductController;
import com.java_ecommerce_jdbc.dao.ProductDao;
import com.java_ecommerce_jdbc.models.Product;
import com.java_ecommerce_jdbc.utils.AppException;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.view.CategeriesPage;
import com.java_ecommerce_jdbc.view.ProductsPage;

import java.util.ArrayList;
import java.util.List;

import static com.java_ecommerce_jdbc.utils.AppInput.enterInt;
import static com.java_ecommerce_jdbc.utils.Utils.println;

public class ProductController implements IProductController {
    private final HomeController homeController;
    private final CartController cartController;
    private final ProductsPage productsPage;
    private final CategeriesPage categeriesPage;
    private final ProductDao productDao;

    public ProductController(HomeController homeController) {
        this.homeController = homeController;
        productsPage = new ProductsPage();
        categeriesPage = new CategeriesPage();
        cartController = new CartController(homeController);
        productDao = new ProductDao();
    }

    private static int categoryId = 0;

    @Override
    public void productTitle() {
        productsPage.title();
    }

    @Override
    public void showProducts(int categoryId) {

        this.categoryId = categoryId;
        List<Product> productsArr = productDao.allProducts();
        if (categoryId != 0) {
            List<Product> categoryProducts = new ArrayList<>();
            for (Product product : productsArr) {
                if (product.getCategoryId() == categoryId) {
                    categoryProducts.add(product);
                }
            }
            productsArr = categoryProducts;
        }

        if (!productsArr.isEmpty()) {
            productTitle();
            productsPage.viewProduct(productsArr);
        } else {
            categeriesPage.categoryNotFound();
        }
        try {
            int choice = enterInt(StringUtil.CHOICE);
            int productId = 0;
            Product p = null;
            String productTitle = "";
            if (choice == 9) {
                homeController.menu();
            } else {
                for (Product product : productsArr) {
                    if (product.getId() == choice) {
                        p = product;
                        productId = product.getId();
                        productTitle = product.getTitle();
                        break;
                    }
                }
            }
            if (productId != 0) {
                cartController.addToCart(p);
                productsPage.successToCart(productTitle);

            } else {
                invalid(new AppException(StringUtil.PRODUCT_NOT_FOUND));
            }
            showProducts(categoryId);
        } catch (AppException appException) {
            invalid(appException);
        }

    }


    private void invalid(AppException appException) {
        println(appException.getMessage());
        showProducts(categoryId);
    }

}
