package dao;

import conection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LichSuBaoTriDAO {

    // Thêm lịch sử bảo trì
    public boolean themLichSuBaoTri(String maThietBi, Date ngayBaoTri, String nguoiThucHien, String noiDung, double chiPhi) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO LichSuBaoTri (maThietBi, ngayBaoTri, nguoiThucHien, noiDung, chiPhi) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maThietBi);
            pstmt.setDate(2, ngayBaoTri);
            pstmt.setString(3, nguoiThucHien);
            pstmt.setString(4, noiDung);
            pstmt.setDouble(5, chiPhi);

            int result = pstmt.executeUpdate();
            return result > 0; // Nếu thêm thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Lấy danh sách lịch sử bảo trì
    public List<Object[]> layDanhSachLichSuBaoTri() {
        List<Object[]> lichSuList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT maThietBi, ngayBaoTri, nguoiThucHien, noiDung, chiPhi FROM LichSuBaoTri";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("maThietBi");
                row[1] = rs.getDate("ngayBaoTri");
                row[2] = rs.getString("nguoiThucHien");
                row[3] = rs.getString("noiDung");
                row[4] = rs.getDouble("chiPhi");
                lichSuList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lichSuList;
    }

    public void suaLichSu(String maThietBi, String ngayBaoTri, String nguoiThucHien, String noiDung, double chiPhi) {

        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "UPDATE LichSuBaoTri SET ngayBaoTri = ?, nguoiThucHien = ?, noiDung = ?, chiPhi = ? WHERE maThietBi = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, ngayBaoTri);
                ps.setString(2, nguoiThucHien);
                ps.setString(3, noiDung);
                ps.setDouble(4, chiPhi);
                ps.setString(5, maThietBi);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoaLichSu(String maThietBi) {

        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM LichSuBaoTri WHERE maThietBi = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, maThietBi);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object[]> layDanhSachLichSu() {
        List<Object[]> danhSach = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM LichSuBaoTri";
            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String maThietBi = rs.getString("maThietBi");
                    String ngayBaoTri = rs.getString("ngayBaoTri");
                    String nguoiThucHien = rs.getString("nguoiThucHien");
                    String noiDung = rs.getString("noiDung");
                    double chiPhi = rs.getDouble("chiPhi");
                    danhSach.add(new Object[]{maThietBi, ngayBaoTri, nguoiThucHien, noiDung, chiPhi});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
