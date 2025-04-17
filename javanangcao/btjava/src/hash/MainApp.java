package hash;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private UserManager userManager = new UserManager();

    public MainApp() {
        setTitle("Ứng dụng người dùng");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton registerBtn = new JButton("Đăng ký");
        JButton loginBtn = new JButton("Đăng nhập");
        JButton exportBtn = new JButton("Xuất XML");
        JButton importBtn = new JButton("Nhập XML");

        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passwordField);
        panel.add(registerBtn);
        panel.add(loginBtn);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(exportBtn);
        bottomPanel.add(importBtn);

        add(panel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        registerBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());
            if (userManager.register(user, pass)) {
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Tên đã tồn tại.");
            }
        });

        loginBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());
            if (userManager.login(user, pass)) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Sai tên hoặc mật khẩu.");
            }
        });

        exportBtn.addActionListener(e -> {
            XMLHandler.saveToXML(userManager.getUsers(), "users.xml");
            JOptionPane.showMessageDialog(this, "Đã xuất dữ liệu!");
        });

        importBtn.addActionListener(e -> {
            userManager.setUsers(XMLHandler.loadFromXML("users.xml"));
            JOptionPane.showMessageDialog(this, "Đã nhập dữ liệu!");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
