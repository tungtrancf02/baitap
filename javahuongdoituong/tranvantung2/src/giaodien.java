import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class giaodien {

    public static void main(String[] args) {
        // Tạo cửa sổ chính
        JFrame frame = new JFrame("Giao diện đơn giản");

        // Cấu hình cửa sổ
        frame.setSize(400, 300); // Kích thước cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng chương trình khi cửa sổ đóng

        // Tạo một nhãn và thêm vào cửa sổ
        JLabel label = new JLabel("Chào mừng bạn đến với giao diện!", JLabel.CENTER);
        frame.add(label);

        // Tạo một nút và thêm vào cửa sổ
        JButton button = new JButton("Nhấn vào đây");
        frame.add(button, "South"); // Đặt nút ở phía dưới

        // Thiết lập hành động khi nút được nhấn
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Nút đã được nhấn!"); // Thay đổi văn bản của nhãn
            }
        });

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
