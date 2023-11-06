package com.java_ecommerce_jdbc.utils;

public class StringUtil {


    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String BLUE = "\u001B[34m";
    static String BOLD = "\u001B[1m";
    static String UNDERLINE = "\u001B[4m";
    static String YELLOW = "\u001B[33m";
    public static final String WELCOME = BLUE + "\n----------Welcome To Shop Anywhere-------------\n" + RESET;
    public static final String LOGIN_OR_REGISTER = BOLD + "1. Register\n2. Login\n3. Exit" + RESET;
    public static final String CHOICE = YELLOW + "Please Enter your Choice: " + RESET;
    public static final String INVALID = RED + "XXXXX--Invalid Input--XXXXX" + RESET;
    public static final String EMAIL = "Enter your Email: ";
    public static final String PASSWORD = "Enter your Password: ";
    public static final String SUCCESS = GREEN + "SUCCESS" + RESET;
    public static final String PRODUCTS = BLUE + BOLD + "....................................Products....................................." + RESET;
    public static final String INVALIDCREDENTIALS = RED + "Invalid Email or Password. Please Try Again" + RESET;
    public static final String NAME = "Enter your Name: ";
    public static final String CONFIRM_PASSWORD = "Reenter the Password: ";
    public static final String PASSWORDMISMATCH = RED + "Password & Confirm Password does not matched." + RESET;
    public static final String USEROPTIONS = BOLD + "1. Categories\n2. Products\n3. Cart\n4. Orders\n5. Logout" + RESET;
    public static final String LOGOUT_SUCCESSFULLY = GREEN + "Logout Successfully" + RESET;
    public static final String BACKFROMPRODUCTS = ".\t\t\t\t\t\t\t\t9. " + UNDERLINE + "Back to Home" + RESET + "\t\t\t\t\t\t\t\t\t.";
    public static final String CATEGORY = BOLD + BLUE + "...................................Categories...................................." + RESET;
    public static final String TAB = "\t\t";
    public static final String PRODUCT_NOT_FOUND = RED + "Product not found" + RESET;
    public static final String CATEGORY_NOT_FOUND = RED + ".\t\t\t\t\t\t\t   Category not found\t\t\t\t\t\t\t\t." + RESET;
    public static final String ADD_TO_CART = GREEN + "Successfully added to Cart" + RESET;
    public static final String CART_TITLE = ".\t\t\t\t---Product_Name\tPrice   Count  Total_Price---\t\t\t\t\t.";
    public static final String CHECKOUT = BOLD + ".\t\t\t\t\t\t\t\t8.   Checkout  \t\t\t\t\t\t\t\t\t." + RESET;
    public static final String EMPTY_CART = YELLOW + "Your Cart is Empty" + RESET;
    public static final String DOT = ".................................................................................";
    public static final String EMPTY_ORDERS = YELLOW + ".\t\t\t\t\t\t\t\tNo Orders yet placed\t\t\t\t\t\t\t\t\t." + RESET;
    public static final String ANYKEY = UNDERLINE + "!!!Press any alphabets to get back to Home!!! " + RESET;
    public static final String SUCCESSFULLY_ORDERED = BOLD+GREEN+"Order Placed Successfully"+RESET;
}
