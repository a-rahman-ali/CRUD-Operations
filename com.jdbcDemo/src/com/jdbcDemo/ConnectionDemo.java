package com.jdbcDemo;
// import the sql package
import java.sql.*;

public class ConnectionDemo {
    public static void main(String[] args) {
        // load the driver
        try {
            String driver="com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Establish the connection
        String url = "jdbc:mysql://localhost:3306";
        String user="root";
        String pass="mypassword";
        
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
            try{
                con.close();
                System.out.println("Connection closed Successfully");
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            // System.out.println("There is an exception :: " + e);
            e.printStackTrace();
        }
        
    }
}