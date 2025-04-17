package view;

import dao.LichSuBaoTriDAO;
import dao.ThietBiDAO;
import dao.ViTriDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.util.List;



public class Quan_ly_thiet_bi_view extends JFrame {
    private JPanel panelCenter;
    private JTable tableThietBi;
    private JTable tablevitri;
    private JTable tableLichSu;

    public Quan_ly_thiet_bi_view() {
        this.init();
        loadDataToTable();


        this.setVisible(true);
    }
    private void loadDataToTable() {
        ThietBiDAO thietBiDAO = new ThietBiDAO();
        List<Object[]> danhSachThietBi = thietBiDAO.layDanhSachThietBi();

        DefaultTableModel model = (DefaultTableModel) tableThietBi.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng

        for (Object[] row : danhSachThietBi) {
            model.addRow(row); // Thêm từng dòng dữ liệu vào bảng
        }


        // Lấy dữ liệu lịch sử bảo trì từ cơ sở dữ liệu
        LichSuBaoTriDAO lichSuDAO2 = new LichSuBaoTriDAO();
        List<Object[]> lichSuList = lichSuDAO2.layDanhSachLichSuBaoTri();

// Cập nhật bảng
        DefaultTableModel model2 = (DefaultTableModel) tableLichSu.getModel();
        model2.setRowCount(0); // Xóa tất cả các dòng cũ trong bảng
        for (Object[] row2 : lichSuList) {
            model2.addRow(row2);
        }




            ViTriDAO thietBiDAO1 = new ViTriDAO();
            List<Object[]> danhSachThietBi1 = thietBiDAO1.layDanhSachThietBi1();

            DefaultTableModel model1 = (DefaultTableModel) tablevitri.getModel();
            model1.setRowCount(0);
            for (Object[] row1 : danhSachThietBi1) {
                model1.addRow(row1);

            }





    }

    public void init() {
        this.setTitle("Quan_ly_thiet_bi");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color backgroundColor = new Color(240, 248, 255); // Màu xanh nhạt
        Color panelColor = new Color(173, 216, 230); // Màu xanh dương nhạt
        Color buttonColor = new Color(70, 130, 180); // Màu xanh lam đậm
        Color buttonHoverColor = new Color(100, 149, 237); // Màu khi hover vào nút
        Color buttonTextColor = Color.WHITE;


        // panel bên trái
        JPanel paneltrai = new JPanel(null);
        paneltrai.setBackground(panelColor);
        paneltrai.setPreferredSize(new Dimension(150, 700));




        //icon cho jframe

        URL urlicon=Quan_ly_thiet_bi_view.class.getResource("iconjframe.png");
        Image icon = Toolkit.getDefaultToolkit().createImage(urlicon);
        this.setIconImage(icon);
        // Thêm icon và chỉnh phông chữ






        // Tạo ImageIcon từ đường dẫn file
        ImageIcon originalIcon = new ImageIcon("E:\\Dowload\\adminicon.png");

// Resize icon
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

// Tạo JLabel với icon đã chỉnh kích thước
        JLabel seticon = new JLabel(resizedIcon);
        seticon.setBounds(25, 15, 30, 30);




        JLabel admin = new JLabel("Admin", JLabel.CENTER);
        admin.setFont(new Font("Arial", Font.BOLD, 16));// Đặt phông chữ Arial, chữ đậm, kích thước 16
        admin.setForeground(Color.BLACK);
        admin.setHorizontalTextPosition(SwingConstants.CENTER); // Căn chữ ở giữa theo chiều ngang

        admin.setBounds(15, 15, 150, 30); // Điều chỉnh kích thước và vị trí của JLabel
        paneltrai.add(admin);
        paneltrai.add(seticon);


        JButton dangxuat= new JButton("Đăng xuất");
        dangxuat.setFont(new Font("Arial", Font.BOLD, 16));
        dangxuat.setForeground(Color.BLACK);
        dangxuat.setBounds(15, 600, 120, 30);

        paneltrai.add(dangxuat);
        dangxuat.addActionListener(e -> {
            this.dispose(); // Đóng giao diện chính
            new signup_view(); // Mở giao diện đăng nhập
        });







        JButton nuttrangchu = new JButton("Trang chủ");
        nuttrangchu.setBounds(10,80,130,40);


        JButton nutquanlythietbi = new JButton("Quản lý thiết bị");
        nutquanlythietbi.setBounds(10, 140, 130, 40);

        JButton nutquanlyphongban = new JButton("Vị trí thiết bị");
        nutquanlyphongban.setBounds(10, 200, 130, 40);
        JButton nutlichsubaotri= new JButton("Lịch sử bảo trì");
        nutlichsubaotri.setBounds(10, 260, 130, 40);

        JButton nutthongkebaocao = new JButton("Thống kê và báo cáo");
        nutthongkebaocao.setBounds(10, 320, 130, 40);

        JButton nuttinhtrangthietbi = new JButton("Thông tin liên hệ");
        nuttinhtrangthietbi.setBounds(10, 380, 130, 40);


        paneltrai.add(nutquanlythietbi);
        paneltrai.add(nuttinhtrangthietbi);
        paneltrai.add(nutquanlyphongban);
        paneltrai.add(nutthongkebaocao);
        paneltrai.add(nuttrangchu);
        paneltrai.add(nutlichsubaotri);

        JButton[] buttons = {nuttrangchu, nutquanlythietbi, nutquanlyphongban, nuttinhtrangthietbi, nutthongkebaocao, nutlichsubaotri};

        // Cài đặt thuộc tính cho nút
        int yOffset = 60;
        for (JButton button : buttons) {
            button.setBounds(10, yOffset, 130, 40);
            button.setBackground(buttonColor);
            button.setForeground(buttonTextColor);
            button.setFont(new Font("Arial", Font.BOLD, 12));
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Thêm hiệu ứng hover
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(buttonHoverColor);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(buttonColor);
                }
            });

            paneltrai.add(button);
            yOffset += 60;
        }
        this.add(paneltrai, BorderLayout.WEST);

        // Center panel with CardLayout
        panelCenter = new JPanel(new CardLayout());
        this.add(panelCenter, BorderLayout.CENTER);





        JPanel panelTrangChu = new JPanel(null);
        panelTrangChu.setBackground(new Color(224, 255, 255)); // Xanh nhạt

// Tạo JLabel cho chữ chào mừng
        JLabel lblTrangChu = new JLabel("Chào mừng đến với hệ thống quản lý thiết bị",SwingConstants.CENTER);


        lblTrangChu.setForeground(Color.BLACK);
        lblTrangChu.setFont(new Font("Arial", Font.BOLD, 20)); // Tăng kích thước chữ
        lblTrangChu.setBounds(180, 30, 500, 40);

// Tạo một đường viền bao quanh để làm nổi bật
        lblTrangChu.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));


// Tạo một JLabel phụ để hiển thị thông điệp hoặc slogan
        JLabel lblSlogan = new JLabel("Hệ thống giúp bạn quản lý thiết bị dễ dàng hơn!", SwingConstants.CENTER);
        lblSlogan.setFont(new Font("Serif", Font.ITALIC, 16));
        lblSlogan.setForeground(new Color(0, 102, 102)); // Màu xanh đậm
        lblSlogan.setBounds(150, 300, 500, 30);

// Thêm các thành phần vào panel
        panelTrangChu.add(lblTrangChu);

        panelTrangChu.add(lblSlogan);







        // Panel for "Quản lý thiết bị"
        JPanel panelQuanLyThietBi = new JPanel(null);
        panelQuanLyThietBi.setBackground(new Color(224, 255, 255));

        JLabel lbltieude = new JLabel("Quản Lý Thiết Bị");
        lbltieude.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbltieude.setBounds(300,5,400,50);

        JLabel lblTenThietBi = new JLabel("Tên thiết bị:");


        lblTenThietBi.setBounds(50, 50, 100, 30);
        JTextField txtTenThietBi = new JTextField();
        txtTenThietBi.setBounds(150, 50, 200, 30);

        JLabel lblMaThietBi = new JLabel("Mã thiết bị:");
        lblMaThietBi.setBounds(400, 50, 100, 30);
        JTextField txtMaThietBi = new JTextField();
        txtMaThietBi.setBounds(500, 50, 200, 30);

        JLabel lblMoTa = new JLabel("Mô tả:");
        lblMoTa.setBounds(50, 100, 100, 30);
        JTextField txtMoTa = new JTextField();
        txtMoTa.setBounds(150, 100, 550, 30);

        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setBounds(50, 150, 100, 30);
        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setBounds(150, 150, 200, 30);

        JLabel lblLoaiThietBi = new JLabel("Loại thiết bị:");
        lblLoaiThietBi.setBounds(50, 200, 100, 30);
        JComboBox<String> cbLoaiThietBi = new JComboBox<>(new String[]{"Thiết bị công nghệ", "Thiết bị truyền thống ","Thiết bị thí nghiệm"});
        cbLoaiThietBi.setBounds(150, 200, 200, 30);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setBounds(400, 200, 100, 30);
        JComboBox<String> cbTrangThai = new JComboBox<>(new String[]{"Hoạt động", "Bảo trì", "Hỏng"});
        cbTrangThai.setBounds(500, 200, 200, 30);






        JButton btnThemThietBi = new JButton("Thêm ");
        btnThemThietBi.setBounds(225, 300, 100, 40);

        ImageIcon iconThem = new ImageIcon("E:\\Dowload\\addicon.png");
        Image themdImage = iconThem.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconThem = new ImageIcon(themdImage);

        btnThemThietBi.setIcon(iconThem);






        JButton btnChinhSua = new JButton("Chỉnh Sửa");
            btnChinhSua.setBounds(350, 300, 100, 40);
        ImageIcon iconSua = new ImageIcon("E:\\Dowload\\editicon.png");
        Image sua = iconSua.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconSua = new ImageIcon(sua);

        btnChinhSua.setIcon(iconSua);

        JButton btnXoa = new JButton("Xoá");
        btnXoa.setBounds(475, 300, 100, 40);
        ImageIcon iconXoa = new ImageIcon("E:\\Dowload\\deleteicon.png");
        Image Xoa = iconXoa.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconXoa = new ImageIcon(Xoa);
        btnXoa.setIcon(iconXoa);

        JButton timkiem = new JButton("Tìm");
        timkiem.setBounds(50, 350, 80, 30);
        JTextField txtTimkiem = new JTextField();
        txtTimkiem.setBounds(130, 350, 200, 30);



        // Sự kiện tìm kiếm
        timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txtTimkiem.getText().trim().toLowerCase();
                if (keyword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khóa tìm kiếm!");
                    return;
                }

                DefaultTableModel model = (DefaultTableModel) tableThietBi.getModel();
                int rowCount = model.getRowCount();
                boolean found = false;

                // Tạo một bảng tạm để chứa kết quả tìm kiếm
                DefaultTableModel searchModel = new DefaultTableModel(new String[]{"Tên thiết bị", "Mã thiết bị", "Mô tả", "Số lượng", "Loại thiết bị", "Trạng thái"}, 0);

                // Duyệt qua các dòng trong bảng
                for (int i = 0; i < rowCount; i++) {
                    String tenThietBi = model.getValueAt(i, 0).toString().toLowerCase();
                    String maThietBi = model.getValueAt(i, 1).toString().toLowerCase();
                    String moTa = model.getValueAt(i, 2).toString().toLowerCase();
                    int soluong= model.getValueAt(i, 3).toString().compareTo("0");
                    String loaiThietBi = model.getValueAt(i, 4).toString().toLowerCase();
                    String trangThietBi = model.getValueAt(i, 5).toString().toLowerCase();

                    // So sánh từ khóa với các giá trị trong dòng
                    if (tenThietBi.contains(keyword) || maThietBi.contains(keyword) || moTa.contains(keyword)||loaiThietBi.contains(keyword)||trangThietBi.contains(keyword)) {
                        found = true;
                        // Thêm dòng khớp vào bảng tạm
                        searchModel.addRow(new Object[]{
                                model.getValueAt(i, 0),
                                model.getValueAt(i, 1),
                                model.getValueAt(i, 2),
                                model.getValueAt(i, 3),
                                model.getValueAt(i, 4),
                                model.getValueAt(i, 5)
                        });
                    }
                }

                // Kiểm tra nếu không tìm thấy
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy thiết bị phù hợp với từ khóa!");
                } else {
                    // Cập nhật bảng hiển thị với kết quả tìm kiếm
                    tableThietBi.setModel(searchModel);
                }
            }
        });



        panelQuanLyThietBi.add(lblTenThietBi);
        panelQuanLyThietBi.add(txtTenThietBi);
        panelQuanLyThietBi.add(lblMaThietBi);
        panelQuanLyThietBi.add(txtMaThietBi);
        panelQuanLyThietBi.add(lblMoTa);
        panelQuanLyThietBi.add(txtMoTa);
        panelQuanLyThietBi.add(lblSoLuong);
        panelQuanLyThietBi.add(txtSoLuong);
        panelQuanLyThietBi.add(lblTrangThai);
        panelQuanLyThietBi.add(cbTrangThai);
        panelQuanLyThietBi.add(lblLoaiThietBi);
        panelQuanLyThietBi.add(cbLoaiThietBi);
        panelQuanLyThietBi.add(btnThemThietBi);
        panelQuanLyThietBi.add(btnChinhSua);
        panelQuanLyThietBi.add(btnXoa);
        panelQuanLyThietBi.add(lbltieude);
        panelQuanLyThietBi.add(timkiem);
        panelQuanLyThietBi.add(txtTimkiem);


        String[] columnNames = {"Tên thiết bị", "Mã thiết bị", "Mô tả", "Số lượng", "Loại thiết bị", "Trạng thái"};
        DefaultTableModel model1 = new DefaultTableModel(columnNames, 0);
         tableThietBi = new JTable(model1);

        JScrollPane scrollPane = new JScrollPane(tableThietBi);
        scrollPane.setBounds(40, 400, 720, 200);
        panelQuanLyThietBi.add(scrollPane);


        btnThemThietBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các trường nhập liệu
                String tenThietBi = txtTenThietBi.getText().trim();
                String maThietBi = txtMaThietBi.getText().trim();
                String moTa = txtMoTa.getText().trim();
                String soLuong = txtSoLuong.getText().trim();
                String loaiThietBi = (String) cbLoaiThietBi.getSelectedItem();
                String trangThai = (String) cbTrangThai.getSelectedItem();

                // Kiểm tra dữ liệu đầu vào
                if (tenThietBi.isEmpty() || maThietBi.isEmpty() || moTa.isEmpty() || soLuong.isEmpty()) {
                    JOptionPane.showMessageDialog(panelQuanLyThietBi,
                            "Vui lòng nhập đầy đủ thông tin!",
                            "Lỗi",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int soLuongInt = Integer.parseInt(soLuong);
                    if (soLuongInt <= 0) {
                        JOptionPane.showMessageDialog(panelQuanLyThietBi,
                                "Số lượng phải là số nguyên dương!",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Thêm thiết bị vào cơ sở dữ liệu
                    ThietBiDAO thietBiDAO = new ThietBiDAO();
                    boolean isAdded = thietBiDAO.themThietBi(tenThietBi, maThietBi, moTa, soLuongInt, loaiThietBi, trangThai);

                    if (isAdded) {
                        JOptionPane.showMessageDialog(panelQuanLyThietBi,
                                "Thêm thiết bị thành công!",
                                "Thành công",
                                JOptionPane.INFORMATION_MESSAGE);

                        // Thêm thiết bị vào JTable
                        DefaultTableModel model = (DefaultTableModel) tableThietBi.getModel();
                        model.addRow(new Object[]{tenThietBi, maThietBi, moTa, soLuongInt, loaiThietBi, trangThai});

                        // Làm sạch các trường nhập liệu
                        txtTenThietBi.setText("");
                        txtMaThietBi.setText("");
                        txtMoTa.setText("");
                        txtSoLuong.setText("");
                    } else {
                        JOptionPane.showMessageDialog(panelQuanLyThietBi,
                                "Thêm thiết bị thất bại!",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelQuanLyThietBi,
                            "Số lượng phải là số nguyên dương!",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });






        btnChinhSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin từ các trường nhập
                String tenThietBi = txtTenThietBi.getText();
                String maThietBi = txtMaThietBi.getText();
                String moTa = txtMoTa.getText();
                String soLuong = txtSoLuong.getText();
                String loaiThietBi = (String) cbLoaiThietBi.getSelectedItem();
                String trangThai = (String) cbTrangThai.getSelectedItem();

                // Kiểm tra xem thông tin có hợp lệ không
                if (tenThietBi.isEmpty() || maThietBi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                    return;
                }

                // Cập nhật thiết bị trong cơ sở dữ liệu
                ThietBiDAO thietBiDAO = new ThietBiDAO();
                boolean success = thietBiDAO.suaThietBi(maThietBi, tenThietBi, moTa, Integer.parseInt(soLuong), loaiThietBi, trangThai);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thiết bị thành công.");
                    loadDataToTable(); // Tải lại dữ liệu vào bảng
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thiết bị thất bại.");
                }
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy mã thiết bị từ trường nhập
                String maThietBi = txtMaThietBi.getText();

                if (maThietBi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã thiết bị.");
                    return;
                }

                // Xóa thiết bị khỏi cơ sở dữ liệu
                ThietBiDAO thietBiDAO = new ThietBiDAO();
                boolean success = thietBiDAO.xoaThietBi(maThietBi);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Xóa thiết bị thành công.");
                    loadDataToTable(); // Tải lại dữ liệu vào bảng
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thiết bị thất bại.");
                }
            }
        });



        // Panel for "Quản lý phòng ban"
        JPanel panelQuanLyPhongBan = new JPanel(null);
        JLabel lbltieudevt = new JLabel("Vị Trí Thiết Bị");
        lbltieudevt.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbltieudevt.setBounds(300,5,400,50);
        panelQuanLyPhongBan.setBackground(new Color(224, 255, 255));
        panelQuanLyPhongBan.setBounds(10, 10, 800, 600);

        JLabel lblmathietbi=new JLabel("Mã thiết  bị:");
        lblmathietbi.setBounds(50,50,100,30);
        JTextField txtmathietbi=new JTextField();
        txtmathietbi.setBounds(150,50,200,30);

        JLabel lblTenPhongBan = new JLabel("Phòng ban:");
        lblTenPhongBan.setBounds(50, 100, 100, 30);
        JTextField txtTenPhongBan = new JTextField();
        txtTenPhongBan.setBounds(150, 100, 200, 30);

        JLabel lblMaPhongBan = new JLabel("Mã phòng ban:");
        lblMaPhongBan.setBounds(400, 50, 100, 30);
        JTextField txtMaPhongBan = new JTextField();
        txtMaPhongBan.setBounds(500, 50, 200, 30);



        JLabel lblMoTaPhongBan = new JLabel("Người sử dụng:");
        lblMoTaPhongBan.setBounds(50, 150, 100, 30);
        JTextField txtMoTaPhongBan = new JTextField();
        txtMoTaPhongBan.setBounds(150, 150, 550, 30);

        JLabel lblsucchua = new JLabel("Sức chứa phòng ban");
        lblsucchua.setBounds(50, 200,  100, 30);
        JTextField txtsucchua = new JTextField();
        txtsucchua.setBounds(150, 200, 200 , 30);


        JButton btnThemvt =new JButton("Thêm");
        btnThemvt.setBounds(225, 300, 100, 40);
        ImageIcon iconThemvt = new ImageIcon("E:\\Dowload\\addicon.png");
        Image themdImagevt = iconThemvt.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconThemvt = new ImageIcon(themdImagevt);
        btnThemvt.setIcon(iconThemvt);






        JButton btnXoavt =new JButton("Xoá");
        btnXoavt.setBounds(475, 300, 100, 40);
        ImageIcon iconXoavt = new ImageIcon("E:\\Dowload\\deleteicon.png");
        Image Xoavt = iconXoavt.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconXoavt = new ImageIcon(Xoavt);
        btnXoavt.setIcon(iconXoavt);

        JButton btnSuavt = new JButton("Sửa");
        btnSuavt.setBounds(350, 300, 100, 40);
        ImageIcon iconSuavt= new ImageIcon("E:\\Dowload\\editicon.png");
        Image suavt = iconSuavt.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconSuavt = new ImageIcon(suavt);
        btnSuavt.setIcon(iconSuavt);
        JButton timkiemvt = new JButton("Tìm");
        timkiemvt.setBounds(50, 350, 80, 30);
        JTextField txtTimkiemvt = new JTextField();
        txtTimkiemvt.setBounds(130, 350, 200, 30);



        panelQuanLyPhongBan.add(lblTenPhongBan);
        panelQuanLyPhongBan.add(lbltieudevt);
        panelQuanLyPhongBan.add(txtTenPhongBan);
        panelQuanLyPhongBan.add(lblMaPhongBan);
        panelQuanLyPhongBan.add(txtMaPhongBan);
        panelQuanLyPhongBan.add(lblMoTaPhongBan);
        panelQuanLyPhongBan.add(txtMoTaPhongBan);

        panelQuanLyPhongBan.add(lblsucchua);
        panelQuanLyPhongBan.add(txtsucchua);
        panelQuanLyPhongBan.add(lblmathietbi);
        panelQuanLyPhongBan.add(txtmathietbi);
        panelQuanLyPhongBan.add(btnThemvt);
        panelQuanLyPhongBan.add(btnXoavt);
        panelQuanLyPhongBan.add(btnSuavt);
        panelQuanLyPhongBan.add(timkiemvt);
        panelQuanLyPhongBan.add(txtTimkiemvt);

        String[] columnvitri = { "Mã thiết bị", "Mã phòng ban", "Phòng ban", "Người sử dụng", "Sức chứa"};
        DefaultTableModel modelvitri = new DefaultTableModel(columnvitri, 0); // 0 rows initially
         tablevitri = new JTable(modelvitri);

        JScrollPane scrollPanevitri = new JScrollPane(tablevitri);// cuộn nếu nhiều
        scrollPanevitri.setBounds(40, 400, 720, 200);

        panelQuanLyPhongBan.add(scrollPanevitri);

        btnThemvt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các trường nhập liệu
                String MaThietBi = txtmathietbi.getText().trim();
                String MaPhongBan = txtMaPhongBan.getText().trim();
                String PhongBan = txtTenPhongBan.getText().trim();
                String NguoiSuDung = txtMoTaPhongBan.getText().trim();

                String SucChua = txtsucchua.getText().trim();

                // Kiểm tra dữ liệu đầu vào
                if (MaThietBi.isEmpty() || MaPhongBan.isEmpty() || PhongBan.isEmpty() || NguoiSuDung.isEmpty()||SucChua.isEmpty()) {
                    JOptionPane.showMessageDialog(panelQuanLyPhongBan,
                            "Vui lòng nhập đầy đủ thông tin!",
                            "Lỗi",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int suchuaInt = Integer.parseInt(SucChua);
                    if (suchuaInt <= 0) {
                        JOptionPane.showMessageDialog(panelQuanLyPhongBan,
                                "Số lượng phải là số nguyên dương!",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Thêm thiết bị vào cơ sở dữ liệu
                    ViTriDAO thietBiDAO1 = new ViTriDAO();
                    boolean isAdded1 = thietBiDAO1.themThietBi1(MaThietBi, MaPhongBan, PhongBan, suchuaInt, NguoiSuDung);

                    if (isAdded1) {
                        JOptionPane.showMessageDialog(panelQuanLyPhongBan,
                                "Thêm thiết bị thành công!",
                                "Thành công",
                                JOptionPane.INFORMATION_MESSAGE);

                        // Thêm thiết bị vào JTable
                        DefaultTableModel model1 = (DefaultTableModel) tablevitri.getModel();
                        model1.addRow(new Object[]{MaThietBi, MaThietBi, PhongBan, suchuaInt, NguoiSuDung});

                        // Làm sạch các trường nhập liệu
                        txtmathietbi.setText("");
                        txtMaPhongBan.setText("");
                        txtTenPhongBan.setText("");
                        txtsucchua.setText("");
                        txtMoTaPhongBan.setText("");
                    } else {
                        JOptionPane.showMessageDialog(panelQuanLyPhongBan,
                                "Thêm thiết bị thất bại!",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelQuanLyPhongBan,
                            "Số lượng phải là số nguyên dương!",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSuavt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from text fields
                String maThietBi = txtmathietbi.getText();
                String tenPhongBan = txtTenPhongBan.getText();
                String maPhongBan = txtMaPhongBan.getText();
                String moTa = txtMoTaPhongBan.getText();
                String sucChua = txtsucchua.getText();

                // Call DAO to update equipment position
                ViTriDAO viTriDAO = new ViTriDAO();
                viTriDAO.suaViTri(maThietBi, tenPhongBan, maPhongBan, moTa, sucChua);

                // Reload table data
                loadDataToTable();
            }
        });

        btnXoavt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve selected row from the table
                int selectedRow = tablevitri.getSelectedRow();
                if (selectedRow != -1) {
                    String maThietBi = (String) tablevitri.getValueAt(selectedRow, 0);

                    // Call DAO to delete equipment position
                    ViTriDAO viTriDAO = new ViTriDAO();
                    viTriDAO.xoaViTri(maThietBi);

                    // Reload table data
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một thiết bị để xóa.");
                }
            }
        });

        timkiemvt.addActionListener(new ActionListener() {
            @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String keyword1 = txtTimkiemvt.getText().trim().toLowerCase();
                                            if (keyword1.isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khoá tìm kiếm");
                                                return;
                                            }
                                            DefaultTableModel modelvitri = (DefaultTableModel) tablevitri.getModel();

                                            int rowcount1 = tablevitri.getRowCount();
                                            boolean found = false;

                                            DefaultTableModel searchModel1 = new DefaultTableModel(new String[]{"Mã thiết bị", "Phòng ban", "Mã phòng ban", "Người sử dụng", "Sức chứa"}, 0);
                                            for (int i = 0; i < rowcount1; i++) {
                                                String mathietbi = modelvitri.getValueAt(i, 0).toString().toLowerCase();
                                                String tenPhongBan = modelvitri.getValueAt(i, 1).toString().toLowerCase();
                                                String maphongban = modelvitri.getValueAt(i, 2).toString().toLowerCase();
                                                String nguoisudung = modelvitri.getValueAt(i, 3).toString().toLowerCase();
                                                int succhua = modelvitri.getValueAt(i, 4).toString().compareTo("0");

                                                if (mathietbi.contains(keyword1) || tenPhongBan.contains(keyword1) || maphongban.contains(keyword1) || nguoisudung.contains(keyword1) || succhua == 0) {
                                                    found = true;

                                                    searchModel1.addRow(new Object[]{
                                                            modelvitri.getValueAt(i, 0),
                                                            modelvitri.getValueAt(i, 1),
                                                            modelvitri.getValueAt(i, 2),
                                                            modelvitri.getValueAt(i, 3),
                                                            modelvitri.getValueAt(i, 4),
                                                    });
                                                }
                                            }
                                            if (!found) {
                                                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả");

                                            } else tablevitri.setModel(searchModel1);
                                        }
                                    });




        // Panel for "Tình trạng thiết bị"
        JPanel panellienhe = new JPanel(null);
        JLabel lbltieudelienhe = new JLabel("Thông Tin Liên Hệ");
        lbltieudelienhe.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbltieudelienhe.setBounds(300,5,400,50);
        panellienhe.setBackground(new Color(224, 255, 255));
        panellienhe.setBounds(10, 10, 800, 600);

// Thông tin người quản lý
        JLabel lblManager = new JLabel("Người Quản Lý:");
        lblManager.setFont(new Font("Arial", Font.PLAIN, 15));
        lblManager.setBounds(50, 80, 150, 30);
        JLabel lblten = new JLabel("Trần Văn Tùng");
        lblten.setFont(new Font("Arial", Font.PLAIN, 15));
        lblten.setBounds(200, 80, 150, 30);

        panellienhe.add(lblManager);
        panellienhe.add(lblten);


        // Thông tin nhà cung cấp
        JLabel lblSupplier = new JLabel("Nhà Cung Cấp:");
        lblSupplier.setFont(new Font("Arial", Font.ITALIC, 15));
        lblSupplier.setBounds(50, 140, 150, 30);
       JLabel nhacungcap = new JLabel("Trường Đại Học Công Nghệ Thông Tin và Truyền Thông Việt Hàn");
       nhacungcap.setFont(new Font("Arial", Font.ITALIC, 15));
        nhacungcap.setBounds(200, 140, 500, 30);
        panellienhe.add(lblSupplier);
        panellienhe.add(nhacungcap);

        // Trung tâm bảo hành
        JLabel lblWarranty = new JLabel("Trung Tâm Bảo Hành:");
        lblWarranty.setFont(new Font("Arial", Font.ITALIC, 15));
        lblWarranty.setBounds(50, 200, 180, 30);
       JLabel txtWarranty= new JLabel("Trần Văn Tùng");
       txtWarranty.setFont(new Font("Arial", Font.ITALIC, 15));
        txtWarranty.setBounds(230, 200, 500, 30);
        panellienhe.add(lblWarranty);
        panellienhe.add(txtWarranty);

        // Số điện thoại
        JLabel lblPhone = new JLabel("Số Điện Thoại Trường:");
        lblPhone.setFont(new Font("Arial", Font.ITALIC, 15));
        lblPhone.setBounds(50, 260, 150, 30);
        JLabel txtPhone =new JLabel("099999999999");
        txtPhone.setFont(new Font("Arial", Font.ITALIC, 15));
        txtPhone.setBounds(200, 260, 500, 30);
        panellienhe.add(lblPhone);
        panellienhe.add(txtPhone);
        panellienhe.add(lbltieudelienhe);

        JLabel sdt = new JLabel("Số điện thoại admin:");
        sdt.setFont(new Font("Arial", Font.ITALIC, 15));
        sdt.setBounds(50,320,150,30);
        JLabel phonr =new JLabel("012343546");
        phonr.setFont(new Font("Arial", Font.ITALIC, 15));
        phonr.setBounds(200, 320, 500, 30);
        panellienhe.add(sdt);
        panellienhe.add(phonr);


        // Panel for "Thống kê và báo cáo"
        JPanel panelThongKeBaoCao = new JPanel(null);
        JLabel lbltieudethongke = new JLabel("Thống Kê Và Báo Cáo");
        lbltieudethongke.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbltieudethongke.setBounds(300, 5, 400, 50);

        panelThongKeBaoCao.setBackground(new Color(224, 255, 255));
        panelThongKeBaoCao.setBounds(10, 10, 800, 600);

// Bảng thống kê
        String[] columnNames1 = {"Thiết bị hoạt động", "Thiết bị hỏng"};
        DefaultTableModel tableModelThongKe = new DefaultTableModel(columnNames1, 0);
        JTable tableThongKe = new JTable(tableModelThongKe);

// Cuộn bảng
        JScrollPane scrollPaneThongKe = new JScrollPane(tableThongKe);
        scrollPaneThongKe.setBounds(50, 250, 700, 200);

// Trường nhập liệu
        JLabel lblThietBiHoatDong = new JLabel("Thiết bị hoạt động:");
        lblThietBiHoatDong.setBounds(50, 70, 150, 30);
        JTextField txtThietBiHoatDong = new JTextField();
        txtThietBiHoatDong.setBounds(200, 70, 150, 30);

        JLabel lblThietBiHong = new JLabel("Thiết bị hỏng:");
        lblThietBiHong.setBounds(50, 110, 150, 30);
        JTextField txtThietBiHong = new JTextField();
        txtThietBiHong.setBounds(200, 110, 150, 30);



// Nút thêm dữ liệu
        JButton btnThemThongKe = new JButton("Thêm");
        btnThemThongKe.setBounds(350, 180, 100, 40);

// Nút xuất báo cáo
        JButton btnXuatBaoCao = new JButton("Xuất báo cáo");
        btnXuatBaoCao.setBounds(350, 500, 150, 40);

// Sự kiện nút thêm
        btnThemThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lấy dữ liệu từ các trường nhập
                    int thietBiHoatDong = Integer.parseInt(txtThietBiHoatDong.getText().trim());
                    int thietBiHong = Integer.parseInt(txtThietBiHong.getText().trim());


                    // Kiểm tra dữ liệu
                    if (thietBiHoatDong < 0 || thietBiHong < 0) {
                        JOptionPane.showMessageDialog(panelThongKeBaoCao, "Số lượng thiết bị không được âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }



                    // Thêm dữ liệu vào bảng
                    tableModelThongKe.addRow(new Object[]{thietBiHoatDong, thietBiHong});

                    // Xóa dữ liệu trong trường nhập
                    txtThietBiHoatDong.setText("");
                    txtThietBiHong.setText("");


                    JOptionPane.showMessageDialog(panelThongKeBaoCao, "Thêm dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelThongKeBaoCao, "Vui lòng nhập số hợp lệ cho số lượng thiết bị!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Sự kiện nút xuất báo cáo
        // Sự kiện nút xuất báo cáo
        btnXuatBaoCao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra xem bảng có dữ liệu không
                if (tableModelThongKe.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(panelThongKeBaoCao, "Không có dữ liệu để xuất báo cáo!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Lấy dữ liệu từ bảng
                int totalHoatDong = 0;
                int totalHong = 0;

                for (int i = 0; i < tableModelThongKe.getRowCount(); i++) {
                    try {
                        // Lấy số lượng thiết bị hoạt động và hỏng từ bảng
                        int hoatDong = Integer.parseInt(tableModelThongKe.getValueAt(i, 0).toString().trim());
                        int hong = Integer.parseInt(tableModelThongKe.getValueAt(i, 1).toString().trim());

                        // Tăng tổng số thiết bị
                        totalHoatDong += hoatDong;
                        totalHong += hong;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panelThongKeBaoCao, "Dữ liệu trên bảng không hợp lệ! Vui lòng kiểm tra.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Hiển thị biểu đồ
                JFrame chartFrame = new JFrame("Biểu đồ thống kê");
                chartFrame.setSize(600, 400);
                chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Panel vẽ biểu đồ
                int finalTotalHoatDong = totalHoatDong;
                int finalTotalHong = totalHong;
                JPanel chartPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) g;

                        // Tổng số thiết bị
                        int total = finalTotalHoatDong + finalTotalHong;
                        if (total == 0) return;

                        // Tính góc cho từng phần
                        int angleHoatDong = (int) Math.round((double) finalTotalHoatDong / total * 360);
                        int angleHong = 360 - angleHoatDong;

                        // Vẽ phần thiết bị hoạt động
                        g2d.setColor(Color.GREEN);
                        g2d.fillArc(150, 50, 200, 200, 0, angleHoatDong);

                        // Vẽ phần thiết bị hỏng
                        g2d.setColor(Color.RED);
                        g2d.fillArc(150, 50, 200, 200, angleHoatDong, angleHong);

                        // Vẽ chú thích
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("Thiết bị hoạt động: " + finalTotalHoatDong, 400, 100);
                        g2d.drawString("Thiết bị hỏng: " + finalTotalHong, 400, 130);
                    }
                };

                chartFrame.add(chartPanel);
                chartFrame.setVisible(true);
            }
        });


// Thêm các thành phần vào panel
        panelThongKeBaoCao.add(lbltieudethongke);
        panelThongKeBaoCao.add(scrollPaneThongKe);
        panelThongKeBaoCao.add(lblThietBiHoatDong);
        panelThongKeBaoCao.add(txtThietBiHoatDong);
        panelThongKeBaoCao.add(lblThietBiHong);
        panelThongKeBaoCao.add(txtThietBiHong);

        panelThongKeBaoCao.add(btnThemThongKe);
        panelThongKeBaoCao.add(btnXuatBaoCao);

        // nut lic su bao tri
        // nut lic su bao tri
        JPanel panelLichsu = new JPanel(null);
        JLabel lbltieudeLichsu = new JLabel("Lịch Sử Bảo Trì");
        lbltieudeLichsu.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbltieudeLichsu.setBounds(300,5,400,50);
        panelLichsu.setBackground(new Color(224, 255, 255));
        panelLichsu.setBounds(10, 10, 800, 600);

        JLabel lblMathietbi = new JLabel("Mã thiết bị:");
        lblMathietbi.setBounds(50, 50, 150, 30);
        JTextField txtMathietbi = new JTextField();
        txtMathietbi.setBounds(150, 50, 200, 30);

        // Thành phần chọn ngày
        JLabel lblNgayBaoTri = new JLabel("Ngày bảo trì:");
        lblNgayBaoTri.setBounds(50, 100, 150, 30);

        JComboBox<Integer> cbNgay = new JComboBox<>();
        JComboBox<Integer> cbThang = new JComboBox<>();
        JComboBox<Integer> cbNam = new JComboBox<>();

        for (int i = 1; i <= 31; i++) cbNgay.addItem(i); // Thêm ngày 1 -> 31
        for (int i = 1; i <= 12; i++) cbThang.addItem(i); // Thêm tháng 1 -> 12
        for (int i = 2021; i <= 2030; i++) cbNam.addItem(i); // Thêm năm 2021 -> 2030

        cbNgay.setBounds(150, 100, 60, 30);
        cbThang.setBounds(220, 100, 60, 30);
        cbNam.setBounds(290, 100, 80, 30);

        panelLichsu.add(lblNgayBaoTri);
        panelLichsu.add(cbNgay);
        panelLichsu.add(cbThang);
        panelLichsu.add(cbNam);
        panelLichsu.add(lbltieudeLichsu);


        JLabel lblNguoiThucHien = new JLabel("Người thực hiện:");
        lblNguoiThucHien.setBounds(50, 150, 150, 30);
        JTextField txtNguoiThucHien = new JTextField();
        txtNguoiThucHien.setBounds(150, 150, 200, 30);

        JLabel lblNoiDung = new JLabel("Nội dung bảo trì:");
        lblNoiDung.setBounds(50, 200, 150, 30);
        JTextField txtNoiDung = new JTextField();
        txtNoiDung.setBounds(150, 200, 550, 30);

        JLabel lblChiPhi = new JLabel("Chi phí:");
        lblChiPhi.setBounds(50, 250, 150, 30);
        JTextField txtChiPhi = new JTextField();
        txtChiPhi.setBounds(150, 250, 200, 30);

        JButton btnthem= new JButton("Thêm");
        btnthem.setBounds(225, 300, 100, 40);
        ImageIcon iconthemls = new ImageIcon("E:\\Dowload\\addicon.png");
        Image themdImagels = iconthemls.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconthemls = new ImageIcon(themdImagels);
        btnthem.setIcon(iconthemls);




        JButton btnLuuLichSu = new JButton("Sửa");
        btnLuuLichSu.setBounds(350, 300, 100, 40);
        ImageIcon iconSuals= new ImageIcon("E:\\Dowload\\editicon.png");
        Image suals = iconSuals.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconSuals = new ImageIcon(suals);
        btnLuuLichSu.setIcon(iconSuals);

        JButton btnxoa =new JButton("Xoá");
        btnxoa.setBounds(475, 300, 100, 40);
        ImageIcon iconXoals = new ImageIcon("E:\\Dowload\\deleteicon.png");
        Image Xoals = iconXoals.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconXoals = new ImageIcon(Xoals);
        btnxoa.setIcon(iconXoals);

        JButton timkiemls = new JButton("Tìm");
        timkiemls.setBounds(50, 350, 80, 30);
        JTextField txtTimkiemls = new JTextField();
        txtTimkiemls.setBounds(130, 350, 200, 30);

// Bảng hiển thị lịch sử bảo trì
        String[] lichSuColumns = {"Mã thiết bị", "Ngày bảo trì", "Người thực hiện", "Nội dung", "Chi phí"};
        DefaultTableModel lichSuModel = new DefaultTableModel(lichSuColumns, 0);
       tableLichSu = new JTable(lichSuModel);
        JScrollPane scrollPaneLichSu = new JScrollPane(tableLichSu);
        scrollPaneLichSu.setBounds(40, 400, 700, 200);


        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maThietBi = txtMathietbi.getText().trim();
                int ngay = (int) cbNgay.getSelectedItem();
                int thang = (int) cbThang.getSelectedItem();
                int nam = (int) cbNam.getSelectedItem();
                String nguoiThucHien = txtNguoiThucHien.getText().trim();
                String noiDung = txtNoiDung.getText().trim();
                String chiPhiStr = txtChiPhi.getText().trim();

                if (maThietBi.isEmpty() || nguoiThucHien.isEmpty() || noiDung.isEmpty() || chiPhiStr.isEmpty()) {
                    JOptionPane.showMessageDialog(panelLichsu, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    double chiPhi = Double.parseDouble(chiPhiStr);
                    Date ngayBaoTri = Date.valueOf(nam + "-" + thang + "-" + ngay); // Convert date

                    // Thêm lịch sử bảo trì vào CSDL
                    LichSuBaoTriDAO lichSuDAO = new LichSuBaoTriDAO();
                    boolean isAdded = lichSuDAO.themLichSuBaoTri(maThietBi, ngayBaoTri, nguoiThucHien, noiDung, chiPhi);

                    if (isAdded) {
                        JOptionPane.showMessageDialog(panelLichsu, "Thêm lịch sử bảo trì thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

                        // Cập nhật bảng lịch sử bảo trì
                        DefaultTableModel model = (DefaultTableModel) tableLichSu.getModel();
                        model.addRow(new Object[]{maThietBi, ngayBaoTri, nguoiThucHien, noiDung, chiPhi});

                        // Làm sạch các trường nhập liệu
                        txtMathietbi.setText("");
                        txtNguoiThucHien.setText("");
                        txtNoiDung.setText("");
                        txtChiPhi.setText("");
                    } else {
                        JOptionPane.showMessageDialog(panelLichsu, "Thêm lịch sử bảo trì thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelLichsu, "Chi phí phải là số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnLuuLichSu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String maThietBi = txtMathietbi.getText();
                int ngay = (int) cbNgay.getSelectedItem();
                int thang = (int) cbThang.getSelectedItem();
                int nam = (int) cbNam.getSelectedItem();
                String ngayBaoTri = String.format("%d-%d-%d", nam, thang, ngay);
                String nguoiThucHien = txtNguoiThucHien.getText();
                String noiDung = txtNoiDung.getText();
                double chiPhi = Double.parseDouble(txtChiPhi.getText());


                LichSuBaoTriDAO lichSuDAO = new LichSuBaoTriDAO();
                lichSuDAO.suaLichSu(maThietBi, ngayBaoTri, nguoiThucHien, noiDung, chiPhi);


                loadDataToTable();
            }
        });

        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableLichSu.getSelectedRow();
                if (selectedRow != -1) {
                    String maThietBi = (String) tableLichSu.getValueAt(selectedRow, 0);


                    LichSuBaoTriDAO lichSuDAO = new LichSuBaoTriDAO();
                    lichSuDAO.xoaLichSu(maThietBi);


                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một thiết bị để xóa.");
                }
            }
        });


        timkiemls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword2 = txtTimkiemls.getText().trim().toLowerCase();
                if (keyword2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khoá tìm kiếm");
                    return;
                }
                DefaultTableModel modellichsu = (DefaultTableModel) tableLichSu.getModel();
                int rowcount2 = tableLichSu.getRowCount();
                boolean found = false;

                DefaultTableModel searchModel2 = new DefaultTableModel(new String[]{"Mã thiết bị", "Ngày bảo trì", "Người thực hiện", "Nôi dung", "Chi phí"}, 0);
                for (int i = 0; i < rowcount2; i++) {
                    String Mathietbi = modellichsu.getValueAt(i, 0).toString().toLowerCase();
                    String ngaybaotri = modellichsu.getValueAt(i, 1).toString().toLowerCase();
                    String nguoithuchien = modellichsu.getValueAt(i, 2).toString().toLowerCase();
                    String noidung = modellichsu.getValueAt(i, 3).toString().toLowerCase();
                    double chiphi = Double.parseDouble(modellichsu.getValueAt(i, 4).toString());

                    if (Mathietbi.contains(keyword2) || ngaybaotri.contains(keyword2) || nguoithuchien.contains(keyword2) || noidung.contains(keyword2) || chiphi == 0) {
                        found = true;

                        searchModel2.addRow(new Object[]{
                                modellichsu.getValueAt(i, 0),
                                modellichsu.getValueAt(i, 1),
                                modellichsu.getValueAt(i, 2),
                                modellichsu.getValueAt(i, 3),
                                modellichsu.getValueAt(i, 4),
                        });
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả");

                } else tableLichSu.setModel(searchModel2);
            }
        });



        panelLichsu.add(lblMathietbi);
        panelLichsu.add(txtMathietbi);
        panelLichsu.add(lblNgayBaoTri);
        panelLichsu.add(lblNguoiThucHien);
        panelLichsu.add(txtNguoiThucHien);
        panelLichsu.add(lblNoiDung);
        panelLichsu.add(txtNoiDung);
        panelLichsu.add(lblChiPhi);
        panelLichsu.add(txtChiPhi);
        panelLichsu.add(btnLuuLichSu);
        panelLichsu.add(btnthem);
        panelLichsu.add(btnxoa);
        panelLichsu.add(scrollPaneLichSu);
        panelLichsu.add(timkiemls);
        panelLichsu.add(txtTimkiemls);


        // Add panels to center panel
        panelCenter.add(panelTrangChu, "trangChu");
        panelCenter.add(panelQuanLyThietBi, "quanLyThietBi");
        panelCenter.add(panelQuanLyPhongBan, "quanLyPhongBan");
        panelCenter.add(panellienhe, "tinhTrangThietBi");
        panelCenter.add(panelThongKeBaoCao, "thongKeBaoCao");
        panelCenter.add(panelLichsu, "Lichsu");



        CardLayout cl = (CardLayout) panelCenter.getLayout();

        nutlichsubaotri.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCenter,"Lichsu");
            }
        }));

        nuttrangchu.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCenter,"trangChu");
            }
        }));

        nutquanlythietbi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCenter, "quanLyThietBi");
            }
        });
// Add action listeners to buttons
        nutquanlyphongban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCenter, "quanLyPhongBan");
            }
        });

        nuttinhtrangthietbi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCenter, "tinhTrangThietBi");
            }
        });

        nutthongkebaocao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCenter, "thongKeBaoCao");
            }
        });

    }

    public void danxuat(){
new signup_view();

   this.setVisible(false);
    }
    public static void main(String[] args) {
        new  Quan_ly_thiet_bi_view().
                setVisible(true);}
}




