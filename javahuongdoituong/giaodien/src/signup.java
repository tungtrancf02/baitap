import javax.swing.*;
import java.awt.*;

public class signup {
    private JFrame frame;

    public signup() {
        frame = new JFrame();
        frame.setTitle("Signup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Sử dụng FlowLayout thay cho GridLayout để kiểm soát kích thước thành phần
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Username
        panel.add(new JLabel("Username:"));
        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(150, 25)); // Đặt kích thước cụ thể
        panel.add(username);

        // Password
        panel.add(new JLabel("Password:"));
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(150, 25)); // Đặt kích thước cụ thể
        panel.add(password);

        // Thêm panel vào frame
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new signup();
    }
}
