package controller;

import conection.DatabaseConnection;
import view.signup_view;
import view.Quan_ly_thiet_bi_view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class qltb_controller implements ActionListener {
private Quan_ly_thiet_bi_view view;
    private signup_view signup;


    public qltb_controller(signup_view signup) {


        this.signup = signup;

    }

    public void signup_view(Quan_ly_thiet_bi_view view) {
       this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Đăng xuất")) {
            view.danxuat();
        }

        if (src.equals("Đăng nhập")) {
            if (checkLogin(signup.getUsername(), signup.getPassword())) {
                signup.cmm(); // Chuyển sang màn hình chính
            } else {
                JOptionPane.showMessageDialog(null, "Sai tên hoặc mật khẩu!");
            }
        }

        if (src.equals("Đăng Kí")) {
            signup.register_view(); // Chuyển sang màn hình đăng ký
        }

        if (src.equals("Huỷ")) {
            System.exit(0); // Thoát chương trình
        }
    }

    private boolean checkLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên và mật khẩu không được trống!");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + username);
                return true;
            } else {
                System.out.println("Login failed! Invalid username or password.");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            return false;
        }
    }

}

