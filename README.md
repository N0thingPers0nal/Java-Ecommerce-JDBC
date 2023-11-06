# Java_JDBC_ECommerce
---------------------
This java console application for E-Commerce has the following sections:
------------------------------------------------------------------------
1. Login - Existing User and Admin
2. Register - New User
3. Home - User
    * View Categories 
        - View products based on category.
    - Add products to cart.
    * View Products 
    - Add products to cart.
    * View Cart 
        - Check out products from cart.
    * View Order
    * Logout
-> Java for coding 
-> MySQL database for storing and retrieving data.

Steps used and challenges faced to build this application:-
Steps:
-----
1. Used MVC (Model, View, Controller) architecture for developing the console application.
2. Added the required Models, Views and Controller along with Interface implementation to achieve abstraction.
3. Added user-defined exceptions to catch anf handle the exceptions.
4. Used encapsulation to hide data and used getter and setter for getting and setting the data for the models.
5. Used "ArrayList" to store and manipulate data according to the user preferrences.
6. Used "JDBC" and "Connection Path" to connect and access the database for storing and retriving the data.
7. Used Data Access Object (dao) for accessing Database using queries.
8. Stored the Connection path, Scanner class other sensitive information in a separate Utility folder.
9. Used Singleton pattern to avoid creating objects.
10.Handled exceptions for invalid choices.

Challenges:
-----------
-> While connection with database.
 
Credentials 
-----------
-> For "User" Login use the following credentials
      Email = "user1@gmail.com" | Password = "user1"
