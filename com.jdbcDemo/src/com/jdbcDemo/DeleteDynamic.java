package com.jdbcDemo;

import java.sql.*;
import java.util.*;
public class DeleteDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mysql_testdb";
        String user = "root";
        String pass = "mypassword";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");

            System.out.println("Enter the jersery no to be deleted : ");
            int j_no = sc.nextInt();

            String sql = "DELETE FROM cricketers WHERE jersey = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, j_no);
            ps.executeUpdate();

            con.close();
            System.out.println("Connection Closed Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
