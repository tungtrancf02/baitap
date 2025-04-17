package dao;

import conection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViTriDAO {
    public boolean themThietBi1(String MaThietBi, String MaPhongBan, String PhongBan, int SucChua, String NguoiSuDung) {
        Connection conn1 = null;
        PreparedStatement pstmt1 = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn1 = DatabaseConnection.getConnection();

            // Câu lệnh SQL để thêm thiết bị
            String sql1 = "INSERT INTO vitrithietbi (MaThietBi, MaPhongBan, PhongBan,NguoiSuDung, SucChua ) VALUES (?, ?, ?, ?, ?)";

            // Chuẩn bị câu lệnh SQL
            pstmt1 = conn1.prepareStatement(sql1);
            pstmt1.setString(1, MaThietBi);
            pstmt1.setString(2, MaPhongBan);
            pstmt1.setString(3, PhongBan);
            pstmt1.setInt(5, SucChua);
            pstmt1.setString(4, NguoiSuDung);

            // Thực thi câu lệnh SQL
            int result1 = pstmt1.executeUpdate();
            return result1 > 0; // Nếu thêm thành công thì trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Nếu có lỗi thì trả về false
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (conn1 != null) conn1.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }








    public List<Object[]> layDanhSachThietBi1() {
        List<Object[]> danhSachThietBi1 = new ArrayList<>();
        Connection conn1 = null;
        PreparedStatement pstmt1 = null;
        ResultSet rs1 = null;

        try {
            conn1 = DatabaseConnection.getConnection();
            String sql1 = "SELECT MaThietBi, MaPhongBan, PhongBan, NguoiSuDung, SucChua FROM ViTriThietBi";
            pstmt1 = conn1.prepareStatement(sql1);
            rs1 = pstmt1.executeQuery();

            while (rs1.next()) {
                Object[] row1 = new Object[5];
                row1[0] = rs1.getString("MaThietBi");
                row1[1] = rs1.getString("MaPhongBan");
                row1[2] = rs1.getString("PhongBan");
                row1[3] = rs1.getInt("NguoiSuDung");
                row1[4] = rs1.getString("SucChua");

                danhSachThietBi1.add(row1);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (rs1 != null) rs1.close();
                if (pstmt1 != null) pstmt1.close();
                if (conn1 != null) conn1.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return danhSachThietBi1;
    }




        public void themViTri(String maThietBi, String tenPhongBan, String maPhongBan, String moTa, String sucChua) {
            // Insert new "Vị trí thiết bị" into database
            try (Connection con = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO ViTriThietBi (maThietBi, tenPhongBan, maPhongBan, moTa, sucChua) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, maThietBi);
                    ps.setString(2, tenPhongBan);
                    ps.setString(3, maPhongBan);
                    ps.setString(4, moTa);
                    ps.setString(5, sucChua);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void suaViTri(String maThietBi, String tenPhongBan, String maPhongBan, String moTa, String sucChua) {
            // Update "Vị trí thiết bị" in the database
            try (Connection con = DatabaseConnection.getConnection()) {
                String sql = "UPDATE ViTriThietBi SET tenPhongBan = ?, maPhongBan = ?, moTa = ?, sucChua = ? WHERE maThietBi = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, tenPhongBan);
                    ps.setString(2, maPhongBan);
                    ps.setString(3, moTa);
                    ps.setString(4, sucChua);
                    ps.setString(5, maThietBi);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void xoaViTri(String maThietBi) {

            try (Connection con = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM ViTriThietBi WHERE maThietBi = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, maThietBi);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Object[]> layDanhSachViTri() {

            List<Object[]> danhSach = new ArrayList<>();
            try (Connection con = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM ViTriThietBi";
                try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String maThietBi = rs.getString("maThietBi");
                        String tenPhongBan = rs.getString("tenPhongBan");
                        String maPhongBan = rs.getString("maPhongBan");
                        String moTa = rs.getString("moTa");
                        String sucChua = rs.getString("sucChua");
                        danhSach.add(new Object[]{maThietBi, tenPhongBan, maPhongBan, moTa, sucChua});
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return danhSach;
        }
    }


