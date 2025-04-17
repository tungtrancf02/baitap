package view;

import controller.qltb_controller;
import controller.signup_controller;

import javax.swing.*;
import java.awt.event.ActionListener;

public class register_view  extends JFrame {

    public register_view() {
        this.init();
        this.setVisible(true);




    }

    public void init() {

        this.setTitle("Đăng Kí");
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pndangki=new JPanel(null);

        JLabel lbtendangnhap =new JLabel("Tên Đăng Nhập :");
        lbtendangnhap.setBounds(70,30,100,30);
        JTextField tfendangnhap=new JTextField();
        tfendangnhap.setBounds(180,35,150,25);

        JLabel lbTen =new JLabel(" Họ Và Tên :");
        lbTen.setBounds(70,80,100,30);
        JTextField tften=new JTextField();
        tften.setBounds(180,85,150,25);

        JLabel lbgmail =new JLabel(" E-mail :");
        lbgmail.setBounds(70,130,100,30);
        JTextField tfemail=new JTextField();
        tfemail.setBounds(180,135,150,25);

        JLabel lbsdt =new JLabel(" SDT :");
        lbsdt.setBounds(70,180,100,30);
        JTextField tfsdt=new JTextField();
        tfsdt.setBounds(180,185,150,25);

        JLabel lbpassword =new JLabel(" Nhập Mật Khẩu :");
        lbpassword.setBounds(70,230,100,30);
        JPasswordField tspassword=new JPasswordField();
        tspassword.setBounds(180,235,150,25);

        JLabel lbpassword2 =new JLabel(" Nhập Lại Mật Khẩu :");
        lbpassword2.setBounds(70,280,150,30);
        JPasswordField tspassword2=new JPasswordField();
        tspassword2.setBounds(180,285,150,25);




        JCheckBox dieukhoan =new JCheckBox("Tôi Đồng Ý Với Điều Khoảng Sử Dụng");
        dieukhoan.setBounds(70,380,300,30);

ActionListener listener=new signup_controller(this) ;
        JButton btdangki =new JButton("Đăng Kí");
btdangki.addActionListener(listener);

        btdangki.setBounds(130,430,100,30);







        pndangki.add(lbtendangnhap);
        pndangki.add(tfendangnhap);
        pndangki.add(lbTen);
        pndangki.add(tften);
        pndangki.add(lbgmail);
        pndangki.add(tfemail);
        pndangki.add(lbsdt);
        pndangki.add(tfsdt);
        pndangki.add(lbpassword);
        pndangki.add(tspassword);
        pndangki.add(lbpassword2);
        pndangki.add(tspassword2);
        pndangki.add(btdangki);
        pndangki.add(dieukhoan);






        this.add(pndangki);

    }
public void nhayquadangnhap(){
        new signup_view();
        this.setVisible(false);

}
}



