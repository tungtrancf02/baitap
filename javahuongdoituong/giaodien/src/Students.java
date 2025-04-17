import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Students {
    private JFrame frame;
    private JTable table;
    private JTextField idField, nameField, mathScoreField, englishScoreField;



    public Students() {
        JFrame frame = new JFrame("quan ly sinh vien");
        frame.setSize(500, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 20, 5));
        panel.setBorder(BorderFactory.createTitledBorder("thong tin sinh vien"));


        panel.add(new JLabel("ID"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Math Score"));
        mathScoreField = new JTextField();
        panel.add(mathScoreField);

        panel.add(new JLabel("English Score"));
        englishScoreField = new JTextField();
        panel.add(englishScoreField);

        JButton addButton = new JButton("them");
        panel.add(addButton);
        JButton updateButton = new JButton("capnhat");
        panel.add(updateButton);
        frame.add(panel, BorderLayout.NORTH);



        JPanel TUNG = new JPanel(new GridLayout(1,1,20,20));
        JButton addButton1 = new JButton("xoa");
        TUNG.add(addButton1);
        JButton sortButton2 = new JButton("xap xep");
        TUNG.add(sortButton2);
        frame.add(TUNG, BorderLayout.SOUTH);


        frame.setVisible(true);
    }



    public static void main(String[] args) {

         new Students();
    }

}
