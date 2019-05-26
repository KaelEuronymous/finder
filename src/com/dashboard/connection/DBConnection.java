package com.dashboard.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection con;


    //DB connection.
    public DBConnection() {
        String USER = "test";
        String PASS = "fortnite";
        String CLASSNAME = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://ec2-3-217-159-183.compute-1.amazonaws.com:3306/heroes";

                try{
                    Class.forName(CLASSNAME);
                    con = DriverManager.getConnection(URL, USER, PASS);
                    System.out.println("conexion exitosa");
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("error" + e);
                }
    }

    //DB disconnect
    public void DBDisconnect() {

        try {
            if (con!=null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }

    //DB get connection.
    public Connection getConnection(){
        return con;
    }
}