package com.amazon.databaseConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.amazon.utilities.readPropertiesForm.loadProperties;

public class databaseConnection {

    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;



    //this class is addition to show use the key instead of value
    public static void getDBConnection() throws FileNotFoundException {
        String filePath="src/main/resources/Configuration.properties";

        Properties properties = loadProperties(filePath);
        String jdbcDriver = properties.getProperty("MYSQLJDBC.DRIVER");
        String jdbcUrl = properties.getProperty("MYSQLJDBC.URL");
        String userName = properties.getProperty("MYSQL_USER_NAME");
        String password = properties.getProperty("MYSQL_USER_PASSWORD");



        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);//use 3rd option with url,userName, password
            statement = connection.createStatement();
            String query = "SELECT * FROM classicmodels.customers";
            statement.execute(query);
            System.out.println(statement.execute(query));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
    }
    public static void closeDatabase() {
        try {
            assert statement !=null;//if not null then close it, if null no need to close
            statement.close();
            assert connection !=null;
            connection.close();
            assert resultSet !=null;
            resultSet.close();
            System.out.println("Database Disconnect Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<String> getResulSetData(ResultSet resultSet, String columnName){//this method will help to store data in a variable
        List<String> dataList=new ArrayList<>();
        while(true){

            try {
                if(!(resultSet.next())) break;
                String items;
                items=resultSet.getString(columnName);
                dataList.add(items);
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
        }
        return dataList;
    }

public static List<String> directdatabaseQueryExecution(String query, String columnName){//This method will marge all 4 statement
    List<String> data=new ArrayList<>();
    String filepath = "ConfigProperty/secret.properties";


    try {

        databaseConnection.getDBConnection();
        // will Create connect to DB
        statement=connection.createStatement();
        resultSet=statement.executeQuery(query);
        data=getResulSetData(resultSet,columnName);
        System.out.println("Data Value "+data);
        for(String st: data){
            System.out.println(st);
        }


    } catch (Exception e) {
        System.out.println(e.getMessage()+"Not get any data ");
    }finally {
        closeDatabase();
    }
    return data;
}
    public static List<String> directdatabaseQueryExecutionwithColumnname(String tableName, String columnName){//This method will marge all 4 statement
        List<String> data=new ArrayList<>();
        String filepath = "ConfigProperty/secret.properties";


        try {
            String query= "select"+columnName+"from"+tableName;
            databaseConnection.getDBConnection();
            // will Create connect to DB
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            data=getResulSetData(resultSet,columnName);
            System.out.println("Data Value "+data);
            for(String st: data){
                System.out.println(st);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage()+"Not get any data ");
        }finally {
            closeDatabase();
        }
        return data;
    }

    public static void main(String[] args) {
        String filePath = "ConfigProperty/secret.properties";
        String query = "SELECT * FROM classicmodels.customers";

        try {
//            getDBConnection();
//            closeDatabase();
            directdatabaseQueryExecution(query,"customerName");
            //if we store in a list, we can call single value
            List<String> mydata= directdatabaseQueryExecution(query,"customerName");
            System.out.println("First Index- "+mydata.get(0));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ;
    }
}
