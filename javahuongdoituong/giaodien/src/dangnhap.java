import javax.swing.*;
import java.awt.*;

public class dangnhap {
    private JFrame frame;

    public dangnhap() {
        frame = new JFrame();
        frame.setTitle("Signup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Tạo JPanel sử dụng GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10); // Tạo khoảng cách giữa các thành phần

        // Label "Username"
        c.gridx = 0; // Cột đầu tiên
        c.gridy = 0; // Hàng đầu tiên
        c.anchor = GridBagConstraints.WEST; // Căn lề trái
        panel.add(new JLabel("Username:"), c);

        // TextField "Username"
        c.gridx = 1; // Cột thứ hai
        c.gridy = 0; // Hàng đầu tiên
        c.fill = GridBagConstraints.HORIZONTAL; // Cho phép kéo dài theo chiều ngang
        JTextField username = new JTextField(10);
        panel.add(username, c);

        // Label "Password"
        c.gridx = 0; // Cột đầu tiên
        c.gridy = 1; // Hàng thứ hai
        c.anchor = GridBagConstraints.WEST; // Căn lề trái
        panel.add(new JLabel("Password:"), c);

        // TextField "Password"
        c.gridx = 1; // Cột thứ hai
        c.gridy = 1; // Hàng thứ hai
        c.fill = GridBagConstraints.HORIZONTAL; // Cho phép kéo dài theo chiều ngang
        JPasswordField password = new JPasswordField(10);
        panel.add(password, c);

        // Thêm JPanel vào JFrame
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new dangnhap();
    }
}
