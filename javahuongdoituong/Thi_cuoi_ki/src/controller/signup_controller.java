package controller;

import conection.DatabaseConnection;
import view.register_view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class signup_controller implements ActionListener {
    private register_view register;

    public signup_controller(register_view register) {
        this.register = register;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel panel = (JPanel) register.getContentPane().getComponent(0); // Lấy JPanel chính
        JTextField tfendangnhap = (JTextField) panel.getComponent(1); // Tên đăng nhập
        JTextField tften = (JTextField) panel.getComponent(3);         // Họ và tên
        JTextField tfemail = (JTextField) panel.getComponent(5);       // Email
        JTextField tfsdt = (JTextField) panel.getComponent(7);         // Số điện thoại
        JPasswordField tspassword = (JPasswordField) panel.getComponent(9);  // Mật khẩu
        JPasswordField tspassword2 = (JPasswordField) panel.getComponent(11); // Nhập lại mật khẩu
        JCheckBox dieukhoan = (JCheckBox) panel.getComponent(13);      // Đồng ý điều khoản

        // Lấy thông tin từ các trường nhập liệu
        String tenDangNhap = tfendangnhap.getText();
        String hoVaTen = tften.getText();
        String email = tfemail.getText();
        String soDienThoai = tfsdt.getText();
        String matKhau = new String(tspassword.getPassword());
        String matKhauNhapLai = new String(tspassword2.getPassword());
        boolean dongYDieuKhoan = dieukhoan.isSelected();

        // Kiểm tra các trường thông tin
        if (tenDangNhap.isEmpty() || hoVaTen.isEmpty() || email.isEmpty() ||
                soDienThoai.isEmpty() || matKhau.isEmpty() || matKhauNhapLai.isEmpty()) {
            JOptionPane.showMessageDialog(register, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!matKhau.equals(matKhauNhapLai)) {
            JOptionPane.showMessageDialog(register, "Mật khẩu và xác nhận mật khẩu không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!dongYDieuKhoan) {
            JOptionPane.showMessageDialog(register, "Bạn phải đồng ý với điều khoản sử dụng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lưu thông tin vào cơ sở dữ liệu
        try {
            saveUserData(tenDangNhap, matKhau, hoVaTen, email, soDienThoai);
            JOptionPane.showMessageDialog(register, "Đăng ký thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            register.nhayquadangnhap(); // Chuyển sang giao diện đăng nhập
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(register, "Đăng ký thất bại: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    // Lưu thông tin người dùng vào cơ sở dữ liệu
    private void saveUserData(String username, String password, String fullname, String email, String phone) throws SQLException {
        // Kết nối với cơ sở dữ liệu
        Connection conn = DatabaseConnection.getConnection();

        // Chuẩn bị câu lệnh SQL để chèn dữ liệu vào bảng users
        String sql = "INSERT INTO users (username, password, fullname, email, phone) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Gán giá trị vào các tham số
            ps.setString(1, username);
            ps.setString(2, password);  // Bạn nên mã hóa mật khẩu trước khi lưu vào DB
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setString(5, phone);

            // Thực thi câu lệnh SQL
            ps.executeUpdate();
        }
    }
}
