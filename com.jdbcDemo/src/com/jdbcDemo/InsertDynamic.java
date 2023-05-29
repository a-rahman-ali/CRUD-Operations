package com.jdbcDemo;
import java.util.*;

// import the SQL package
import java.sql.*;

public class InsertDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            System.out.println("Comnection Established");

            String sql = "INSERT INTO cricketers VALUES(?, ?)";
            
            System.out.println("Enter the Jersey Number : ");
            int j_no = sc.nextInt();
            System.out.println("Enter the Name of Player : ");
            sc.nextLine(); // if this is removed then the program doesn't take the input for name
            String name = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, j_no);
            ps.setString(2, name);
            ps.executeUpdate();

            con.close();
            System.out.println("Connection Closed Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
