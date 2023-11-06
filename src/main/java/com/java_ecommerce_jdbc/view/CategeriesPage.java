package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.utils.StringUtil;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class CategeriesPage {
    public void categoryNotFound() {
        println(StringUtil.CATEGORY_NOT_FOUND);
        println(StringUtil.BACKFROMPRODUCTS);
        println(StringUtil.DOT);
    }
}
