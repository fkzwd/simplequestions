package com.vk.dwzkf.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection instance = null;
    private static String driver = "jdbc:postgresql://";
    private static String host = "localhost";
    private static String port = "5432";
    private static String database = "example";
    private static String user = "postgres";
    private static String password = "postgres";
    private DBConnection() {

    }

    public static Connection getInstance(){
        if (instance==null) {
            synchronized (DBConnection.class) {
                if (instance==null) {
                    try {
                        Class.forName("org.postgresql.Driver");
                        instance = DriverManager.getConnection(driver+host + ":" + port+"/"+database, user, password);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}
