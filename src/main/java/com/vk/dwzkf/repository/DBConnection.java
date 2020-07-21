package com.vk.dwzkf.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection instance = null;
    private static String driver = "jdbc:postgresql://";
    private static String host = "ec2-54-75-246-118.eu-west-1.compute.amazonaws.com";
    private static String port = "5432";
    private static String database = "df5qtpb2u1ssca";
    private static String user = "mcucbujpdtehpv";
    private static String password = "02107ce51b2a642a18ccbd27e3516b6a80ceab668b2af0f451c64ef26c565a13";
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
