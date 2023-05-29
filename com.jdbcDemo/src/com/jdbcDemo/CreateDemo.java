package com.jdbcDemo;

// import sql package
import java.sql.*;

public class CreateDemo {
    public static void main(String[] args) throws Exception{
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            // Load the Driver
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String url = "jdbc:mysql://localhost:3306/mysql_testdb";
        String user= "root";
        String password = "mypassword";
        try {
            // Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established");
            // Preparing the Query
            String sql = "CREATE TABLE cricketers(jersey INT, name VARCHAR(20))";
            // Creating Statement
            Statement st = con.createStatement();
            st.execute(sql);
            // Closing the Connection
            con.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }
}
