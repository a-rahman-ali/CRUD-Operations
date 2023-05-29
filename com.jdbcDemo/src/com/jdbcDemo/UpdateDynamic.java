package com.jdbcDemo;
import java.sql.*;
import java.util.*;
public class UpdateDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mysql_testdb";
        String user = "root";
        String pass = "mypassword";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");

            System.out.println("Enter the jersey no. of player to update the name : ");
            int j_no = sc.nextInt();
            System.out.println("Enter the name to be changed : ");
            sc.nextLine();
            String name = sc.nextLine();
            
            String sql = "UPDATE cricketers " + "SET name = ? " + "WHERE jersey = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, j_no);

            ps.executeUpdate();
            
            
            con.close();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
