import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cuoiki {
    public static void main(String[] args) {
        // Tạo JFrame (cửa sổ chính)
        JFrame frame = new JFrame("Quản lý thiết bị trường học");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Tạo bảng hiển thị danh sách thiết bị
        String[] columnNames = {"Tên thiết bị", "Loại", "Vị trí", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable deviceTable = new JTable(tableModel);

        // Thêm một số dữ liệu mẫu
        tableModel.addRow(new Object[]{"Máy chiếu", "Thiết bị giảng dạy", "Phòng 101", "Đang sử dụng"});
        tableModel.addRow(new Object[]{"Máy tính", "Thiết bị CNTT", "Phòng 202", "Hỏng"});
        tableModel.addRow(new Object[]{"Kính hiển vi", "Thiết bị thí nghiệm", "Phòng 301", "Bảo trì"});

        // Cuộn cho bảng
        JScrollPane scrollPane = new JScrollPane(deviceTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel chứa các nút chức năng
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Thêm");
        JButton editButton = new JButton("Sửa");
        JButton deleteButton = new JButton("Xóa");
        JButton searchButton = new JButton("Tìm kiếm");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Xử lý sự kiện cho các nút
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Nhập tên thiết bị:");
                String type = JOptionPane.showInputDialog(frame, "Nhập loại thiết bị:");
                String location = JOptionPane.showInputDialog(frame, "Nhập vị trí:");
                String status = JOptionPane.showInputDialog(frame, "Nhập trạng thái:");
                if (name != null && type != null && location != null && status != null) {
                    tableModel.addRow(new Object[]{name, type, location, status});
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = deviceTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String name = JOptionPane.showInputDialog(frame, "Nhập tên thiết bị:", tableModel.getValueAt(selectedRow, 0));
                    String type = JOptionPane.showInputDialog(frame, "Nhập loại thiết bị:", tableModel.getValueAt(selectedRow, 1));
                    String location = JOptionPane.showInputDialog(frame, "Nhập vị trí:", tableModel.getValueAt(selectedRow, 2));
                    String status = JOptionPane.showInputDialog(frame, "Nhập trạng thái:", tableModel.getValueAt(selectedRow, 3));
                    if (name != null && type != null && location != null && status != null) {
                        tableModel.setValueAt(name, selectedRow, 0);
                        tableModel.setValueAt(type, selectedRow, 1);
                        tableModel.setValueAt(location, selectedRow, 2);
                        tableModel.setValueAt(status, selectedRow, 3);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Vui lòng chọn một dòng để sửa!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = deviceTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Vui lòng chọn một dòng để xóa!");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = JOptionPane.showInputDialog(frame, "Nhập từ khóa để tìm kiếm:");
                if (keyword != null) {
                    for (int i = 0; i < deviceTable.getRowCount(); i++) {
                        boolean match = false;
                        for (int j = 0; j < deviceTable.getColumnCount(); j++) {
                            if (deviceTable.getValueAt(i, j).toString().toLowerCase().contains(keyword.toLowerCase())) {
                                match = true;
                                break;
                            }
                        }
                        deviceTable.setRowSelectionInterval(i, i);
                        if (match) break;
                    }
                }
            }
        });

        // Hiển thị giao diện
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
