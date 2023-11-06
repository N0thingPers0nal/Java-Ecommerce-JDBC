package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.utils.StringUtil;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class HomePage {
    public void menuProducts() {
        println(StringUtil.PRODUCTS);
    }

    public void userOptions() {
        println(StringUtil.USEROPTIONS);
    }

    public void logoutSuccess() {
        println(StringUtil.LOGOUT_SUCCESSFULLY);
    }


}
