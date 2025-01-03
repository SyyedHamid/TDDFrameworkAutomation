package com.amazon.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class readPropertiesForm {

    //Method for the load properties; here Properties is the return type
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();

        try {
            InputStream inputStream;
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            System.out.println("Properties file is loaded");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return properties;
    }
}
