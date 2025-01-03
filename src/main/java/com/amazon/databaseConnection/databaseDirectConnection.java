package com.amazon.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class databaseDirectConnection {

    public static void main(String[] args) {

        String jdbcDriver="com.mysql.cj.jdbc.Driver";
        String jdbcUrl="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC&useSSL=false";
        String userName="root";
        String password="root";

        //Create Connection
        Connection connection;//Declare reference variable
        Statement statement;

        try {
            connection= DriverManager.getConnection(jdbcUrl,userName,password);//use 3rd option with url,userName, password
            statement=connection.createStatement();
            String query="SELECT * FROM classicmodels.customers";
            statement.execute(query);
            System.out.println(statement.execute(query));
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }
}
