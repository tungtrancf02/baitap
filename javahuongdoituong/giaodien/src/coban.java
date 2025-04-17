import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class coban {

    public static void main(String[] args) {
        // Tạo cửa sổ chính
        JFrame frame = new JFrame("may tinh casio");

        // Cấu hình cửa sổ
        frame.setSize(300, 450);
        // Kích thước cửa sổ
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Đóng chương trình khi cửa sổ đóng
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4,4));
            JButton nut1 = new JButton("1");
            JButton nut2 = new JButton("2");
            JButton nut3 = new JButton("3");
            JButton nut4 = new JButton("4");
            JButton nut5 = new JButton("5");
            JButton nut6 = new JButton("6");
            JButton nut7 = new JButton("7");
            JButton nut8 = new JButton("8");
            JButton nut9 = new JButton("9");

            panel.add(nut1);
            panel.add(nut2);
            panel.add(nut3);
            panel.add(nut4);
            panel.add(nut5);
            panel.add(nut6);
            panel.add(nut7);
            panel.add(nut8);


        frame.add(panel, "Center");




        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
