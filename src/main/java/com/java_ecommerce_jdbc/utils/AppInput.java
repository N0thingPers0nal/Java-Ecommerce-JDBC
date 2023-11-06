package com.java_ecommerce_jdbc.utils;

import static com.java_ecommerce_jdbc.utils.AppScanner.getScanner;
import static com.java_ecommerce_jdbc.utils.Utils.print;

public class AppInput {
    public static String enterString(String msg) {
        print(msg);
        return getScanner().nextLine();
    }

    public static int enterInt(String msg) throws AppException {
        print(msg);
        int input;
        try {
            input = Integer.parseInt(getScanner().nextLine());
        } catch (Exception e) {
            throw new AppException(StringUtil.INVALID);
        }
        return input;
    }
}
