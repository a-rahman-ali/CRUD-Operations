package com.jdbcDemo;

// import the sql package
import java.sql.*;

public class UpdateDemo {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        //Load the Driver
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost/mysql_testdb";
        String user = "root";
        String pass = "mypassword";
        try {
            // Establishing the Connection
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");
            // Preparing the Query
            // String sql = "UPDATE cricketers SET name='Kohli' WHERE jersey=18";
            String sql = "UPDATE cricketers SET name='Mahendra Singh' WHERE jersey=7";
            // Preparing the Statement
            Statement st = con.createStatement();
            // st.execute(sql); // this can also be used but deprecated
            st.executeUpdate(sql);
            // Closing the Connection
            con.close();
            System.out.println("Connection Closed Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}
