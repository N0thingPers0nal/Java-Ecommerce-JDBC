package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.utils.StringUtil;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class RegisterPage {
    public void success() {
        try {
            println(StringUtil.SUCCESS);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void fail(){
        try {
            println(StringUtil.PASSWORDMISMATCH);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
