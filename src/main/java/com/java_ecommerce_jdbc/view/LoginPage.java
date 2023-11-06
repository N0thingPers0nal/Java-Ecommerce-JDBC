package com.java_ecommerce_jdbc.view;

import com.java_ecommerce_jdbc.utils.StringUtil;

import static com.java_ecommerce_jdbc.utils.Utils.println;

public class LoginPage {
    public void success() {
        try {
            Thread.sleep(500);
            println(StringUtil.SUCCESS);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fail() {
        try {
            Thread.sleep(500);
            println(StringUtil.INVALIDCREDENTIALS);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
