package com.jdbcDemo;

// imprt the sql package
import java.sql.*;
public class DeleteDemo {
    public static void main(String[] args) {
        // Load the Driver
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
            // Establishing the Connection
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");
            // Creating Statement
            Statement st = con.createStatement();

            // Preparing the Query
            String sql = "DELETE FROM cricketers WHERE jersey=45";
            
            // Executing the Statement
            // st.execute(sql); //this can also be used but is deprecated
            st.executeUpdate(sql);
            // Closing the Connection
            con.close();
            System.out.println("Connection Closed Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
