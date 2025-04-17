package interdoce;

import javax.swing.*;
import java.awt.*;

public class DALUONG extends JFrame {
    private JTextArea inputArea, outputArea;
    private JComboBox<String> methodBox;
    private JButton encryptBtn, decryptBtn;
    private Encryptable encryptor;

    public DALUONG() {
        setTitle("Mã hóa & Giải mã");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputArea = new JTextArea(5, 40);
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);

        methodBox = new JComboBox<>(new String[]{"AES", "RSA"});
        encryptBtn = new JButton("Mã hóa");
        decryptBtn = new JButton("Giải mã");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Chọn thuật toán:"));
        topPanel.add(methodBox);
        topPanel.add(encryptBtn);
        topPanel.add(decryptBtn);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(inputArea), BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        encryptBtn.addActionListener(e -> runInThread(true));
        decryptBtn.addActionListener(e -> runInThread(false));
    }

    private void runInThread(boolean isEncrypt) {
        new Thread(() -> {
            try {
                String method = (String) methodBox.getSelectedItem();
                if ("AES".equals(method)) encryptor = new AES();
                else encryptor = new RSA();

                String input = inputArea.getText();
                String result = isEncrypt ? encryptor.encrypt(input) : encryptor.decrypt(input);

                SwingUtilities.invokeLater(() -> outputArea.setText(result));
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.setText("Lỗi: " + ex.getMessage());
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DALUONG().setVisible(true));
    }
}
