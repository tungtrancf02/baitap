package view;

import controller.qltb_controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class signup_view extends JFrame {
private  JTextField username;
private  JPasswordField password;

    public signup_view() {

        this.setTitle("Đăng Nhâp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,200);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);


        c.gridx=0;c.gridy=0;
        c.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Tên:"),c);

        c.gridx=1;c.gridy=0;
         username = new JTextField(15);
        panel.add(username,c);


        c.gridx=0;c.gridy=1;
        c.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Mật khẩu:"),c);

        c.gridx=1;c.gridy=1;
         password = new JPasswordField(15);
        panel.add(password,c);


        ActionListener listener = new qltb_controller(this) ;
        c.gridx=0;c.gridy=2;
        JButton Login = new JButton("Đăng nhập");
        Login.addActionListener(listener);
        panel.add(Login,c);


        c.gridx=1;c.gridy=2;
        JButton Cancel = new JButton("Huỷ");
        Cancel.addActionListener(listener);
        panel.add(Cancel,c);

        c.gridx=2;c.gridy=2;
        JButton Register = new JButton("Đăng kí");
        Register.addActionListener(listener);
        panel.add(Register,c);

       this.add(panel);
        this.setVisible(true);


    }
    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return new String (password.getPassword());
    }
public void  cmm(){
    new Quan_ly_thiet_bi_view();
    this.setVisible(false);

    }
    public void register_view(){
        new register_view();
        this.setVisible(false);
    }
}
