package com.jdbcDemo;

// import the sql pacakge
import java.sql.*;

public class InsertDemo {
    public static void main(String[] args) {
        //Load the Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mysql_testdb";
        String user = "root";
        String pass = "mypassword";
        try {
            // Establish the Connection
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");
            // Preparing the Query
            // String sql = "INSERT INTO cricketers values(45, 'Rohit')";
            String sql = "INSERT INTO cricketers values(7, 'Dhoni')";
            // String sql = "INSERT INTO cricketers values(18, 'Virat')";
            // String sql = "INSERT INTO cricketers values(10, 'Sachin')";
            // Creating Statement
            Statement st = con.createStatement();
            // while inserting the data another method rather than execute() can
            // be used. But here let's workout with this only.
            st.execute(sql);
            con.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
