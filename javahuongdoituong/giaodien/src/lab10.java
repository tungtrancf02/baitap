import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab10 extends JFrame implements ActionListener {
    private  JComboBox<Integer> jComboBox,jComboBox2,jComboBox3;
   private JRadioButton  radioButton1,radioButton2,radioButton3,radioButton4;
    private JTextField nameField, mobileField, addressField;
    private JButton submitButton, resetButton;
    private  JCheckBox checkBox;
    private JTextArea textArea;

    public lab10() {

        // Tạo JFrame
        this.setTitle("Registration Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600, 500);

        // Tiêu đề
        JLabel label = new JLabel("Registration Form");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa
        label.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label, BorderLayout.NORTH);

        // Tạo JPanel chính với BoxLayout (sắp xếp theo chiều dọc)
        JPanel panel = new JPanel(new GridLayout(6, 2 ));


        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Name:"));
        nameField = new JTextField(10);
        namePanel.add(nameField);
        panel.add(namePanel);


        JPanel mobilePanel = new JPanel();
        mobilePanel.add(new JLabel("Mobile:"));
        mobileField = new JTextField(10);
        mobilePanel.add(mobileField);
        panel.add(mobilePanel);



        // Giới tính
        JPanel genderPanel = new JPanel();
        genderPanel.add(new JLabel("Gender:"));
         radioButton1 = new JRadioButton("Male");
         radioButton2 = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup(); // Đảm bảo chỉ chọn 1 nút radio
        genderGroup.add(radioButton1);
        genderGroup.add(radioButton2);
        genderPanel.add(radioButton1);
        genderPanel.add(radioButton2);
        panel.add(genderPanel);

        JPanel dobPanel = new JPanel();
        dobPanel.add(new JLabel("DOB:"));
        panel.add(dobPanel);

        Integer[] ngay= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        jComboBox=new JComboBox<>(ngay);
        jComboBox.setBounds(100, 100, 50, 30);
        dobPanel.add(jComboBox);



        Integer[] thang ={1,2,3,4,5,6,7,8,9,10,11,12};
        jComboBox2=new JComboBox<>(thang);
        jComboBox2.setBounds(100, 100, 50, 30);
        dobPanel.add(jComboBox2);


        Integer[] nam ={1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006};
        jComboBox3=new JComboBox<>(nam);
        jComboBox3.setBounds(100, 100, 50, 30);
        dobPanel.add(jComboBox3);


        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Address:"));
        addressField = new JTextField(10);
        addressPanel.add(addressField);
        panel.add(addressPanel);

    JPanel panel2 = new JPanel();
         checkBox=new JCheckBox("dieu khoang va sư dung");
        panel2.add(checkBox);
        panel.add(panel2);

JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
         submitButton = new JButton("Submit");

        panel3.add(submitButton);
        submitButton.addActionListener( this);


         resetButton = new JButton("Reset");

        panel3.add(resetButton);
        resetButton.addActionListener( this);

        this.add(panel3, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
 textArea = new JTextArea(45,30);
textArea.setEditable(false);
panel4.add(new JScrollPane(textArea));
panel4.add(textArea);



this.add(panel4, BorderLayout.EAST);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (checkBox.isSelected()) {
                //
                String name = nameField.getText();
                String mobile = mobileField.getText();
                String gender = radioButton1.isSelected() ? "Male" : (radioButton2.isSelected() ? "Female" : "Not Selected");
                String dob = jComboBox.getSelectedItem() + "/" + jComboBox2.getSelectedItem() + "/" + jComboBox3.getSelectedItem();
                String address = addressField.getText();

                textArea.setText("Name: " + name +
                        "\nMobile: " + mobile +
                        "\nGender: " + gender +
                        "\nDOB: " + dob +
                        "\nAddress: " + address );

            }

        }else if (e.getSource() == resetButton) {
            textArea.setText("");
            nameField.setText("");
            mobileField.setText("");
            addressField.setText("");
            checkBox.setSelected(false);
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);

        }

    }








    public static void main(String[] args) {
        new lab10();
    }
}

