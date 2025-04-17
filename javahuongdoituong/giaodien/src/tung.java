import javax.swing.*;
import java.awt.*;

public class tung {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Tiêu đề
        JLabel titleLabel = new JLabel("STUDENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 400, 30);
        frame.add(titleLabel);

        // Các nhãn và ô nhập liệu
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(160, 60, 200, 25);
        frame.add(nameField);

        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50, 100, 100, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(160, 100, 200, 25);
        frame.add(idField);

        JLabel gradeLabel = new JLabel("Student Grade:");
        gradeLabel.setBounds(50, 140, 100, 25);
        frame.add(gradeLabel);

        JTextField gradeField = new JTextField();
        gradeField.setBounds(160, 140, 200, 25);
        frame.add(gradeField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(50, 180, 100, 25);
        frame.add(dobLabel);

        JTextField dobField = new JTextField();
        dobField.setBounds(160, 180, 200, 25);
        frame.add(dobField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 220, 100, 25);
        frame.add(genderLabel);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(160, 220, 70, 25);
        frame.add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(230, 220, 80, 25);
        frame.add(femaleButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel contactLabel = new JLabel("Contact Name:");
        contactLabel.setBounds(50, 260, 100, 25);
        frame.add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(160, 260, 200, 25);
        frame.add(contactField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 300, 100, 25);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(160, 300, 200, 25);
        frame.add(emailField);

        // Các nút chức năng
        JButton addButton = new JButton("Add Student");
        addButton.setBounds(400, 60, 150, 30);
        frame.add(addButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(400, 100, 150, 30);
        frame.add(resetButton);

        JButton deleteButton = new JButton("Delete Record");
        deleteButton.setBounds(400, 140, 150, 30);
        frame.add(deleteButton);

        JButton updateButton = new JButton("Update Record");
        updateButton.setBounds(400, 180, 150, 30);
        frame.add(updateButton);

        JLabel searchLabel = new JLabel("Search by ID:");
        searchLabel.setBounds(50, 350, 100, 25);
        frame.add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(160, 350, 200, 25);
        frame.add(searchField);

        JButton searchButton = new JButton("Search by ID");
        searchButton.setBounds(400, 350, 150, 30);
        frame.add(searchButton);

        // Bảng hiển thị dữ liệu
        String[] columnNames = {"Student Name", "Student ID", "Student Grade", "Date of Birth", "Gender", "Contact Name", "Email"};
        JTable table = new JTable(new Object[0][7], columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 400, 700, 150);
        frame.add(scrollPane);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}