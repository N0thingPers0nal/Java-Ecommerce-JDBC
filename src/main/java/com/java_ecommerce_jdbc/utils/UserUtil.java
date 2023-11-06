package com.java_ecommerce_jdbc.utils;

import com.java_ecommerce_jdbc.models.User;

public class UserUtil {
    private static User loggedUser;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        UserUtil.loggedUser = loggedUser;
    }
}
