/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educonnect;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author prant
 */
public class javaconnect {

    Connection con;

    public static Connection connectdb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject", "root", "Pra420d@Tos");
            System.out.println("Connected");
            return con;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void main(String[] args) {
        connectdb();
    }
}
