
import javax.swing.*;

public class ComboboxExample {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Tạo các mục (items) cho JComboBox
        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4"};

        // Tạo JComboBox
        JComboBox<String> comboBox = new JComboBox<>(items);

        // Thêm sự kiện khi người dùng chọn một mục
        comboBox.addActionListener(e -> {
            String selectedItem = (String) comboBox.getSelectedItem();
            JOptionPane.showMessageDialog(frame, "You selected: " + selectedItem);
        });

        // Thêm JComboBox vào JFrame
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(comboBox);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
