package com.jdbcDemo;
// Import the SQL package
import java.sql.*;

public class FetchDemo {
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
            // Establishing Connection
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");
            // Preparing the Statement 
            Statement st = con.createStatement();
            String sql = "SELECT * FROM cricketers";
            ResultSet rs = st.executeQuery(sql);

            // printing the data stored in the ResultSet
            while(rs.next()){
                System.out.println(rs.getInt(1) +  " : " + rs.getString(2)); 
            }
            // Closing the connection
            con.close();
            System.out.println("Connection Closed Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
