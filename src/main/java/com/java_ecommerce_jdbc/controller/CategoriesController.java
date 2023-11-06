package com.java_ecommerce_jdbc.controller;

import com.java_ecommerce_jdbc.controller.impl.ICategoriesController;
import com.java_ecommerce_jdbc.dao.CategoryDao;
import com.java_ecommerce_jdbc.models.Category;
import com.java_ecommerce_jdbc.utils.AppException;
import com.java_ecommerce_jdbc.utils.StringUtil;
import com.java_ecommerce_jdbc.view.CategeriesPage;

import static com.java_ecommerce_jdbc.utils.AppInput.enterInt;
import static com.java_ecommerce_jdbc.utils.Utils.println;

public class CategoriesController implements ICategoriesController {
    private final CategeriesPage categeriesPage;
    private final HomeController homeController;
    private final ProductController productController;
    private final CategoryDao categoryDao;

    public CategoriesController(HomeController homeController) {
        categeriesPage = new CategeriesPage();
        this.homeController = homeController;
        productController = new ProductController(homeController);
        categoryDao=new CategoryDao();
    }

    @Override
    public void printMenu() {
       for(Category category:categoryDao.allCategory()){
           println(category.getId()+". "+category.getCategoryName());
       }
    }

    @Override
    public void showCatogries() {
        printMenu();
        int choice = 0;
        try {
            choice = enterInt(StringUtil.CHOICE);
            if (choice == 9) {
                homeController.menu();
            } else {
                int validCategoryId = 0;
                productController.showProducts(choice);
                for (Category category : categoryDao.allCategory()) {
                    if (category.getId() == choice) {
                        validCategoryId = category.getId();
                        break;
                    }
                }

                if (validCategoryId != 0) {
                    productController.showProducts(validCategoryId);
                } else {
                    invalid(new AppException(StringUtil.CATEGORY_NOT_FOUND));
                }
            }
        } catch (AppException appException) {
            invalid(appException);
        }

    }

    private void invalid(AppException appException) {
        println(appException.getMessage());
        showCatogries();
    }
}
