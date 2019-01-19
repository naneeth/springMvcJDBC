package com.stackroute.controller;

import java.sql.*;

public class CrudOperation {
    private Connection con;

    public void displayData() {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1","naneeth","password");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();


            //execute query
            ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void insertCustomer(String name,String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "naneeth", "password");
            Statement statement = con.createStatement();
            String sql = "Insert into user values('"+name+"','"+password+"')";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
