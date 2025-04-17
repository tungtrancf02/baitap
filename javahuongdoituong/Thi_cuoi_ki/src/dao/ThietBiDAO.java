package dao;

import conection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThietBiDAO {
private Connection connection;
    public boolean themThietBi(String tenThietBi, String maThietBi, String moTa, int soLuong, String loaiThietBi, String trangThai) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = DatabaseConnection.getConnection();


            String sql = "INSERT INTO ThietBi (tenThietBi, maThietBi, moTa, soLuong, loaiThietBi, trangThai) VALUES (?, ?, ?, ?, ?, ?)";

            // Chuẩn bị câu lệnh SQL
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenThietBi);
            pstmt.setString(2, maThietBi);
            pstmt.setString(3, moTa);
            pstmt.setInt(4, soLuong);
            pstmt.setString(5, loaiThietBi);
            pstmt.setString(6, trangThai);

            // Thực thi câu lệnh SQL
            int result = pstmt.executeUpdate();
            return result > 0; // Nếu thêm thành công thì trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Nếu có lỗi thì trả về false
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Object[]> layDanhSachThietBi() {
        List<Object[]> danhSachThietBi = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT tenThietBi, maThietBi, moTa, soLuong, loaiThietBi, trangThai FROM ThietBi";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getString("tenThietBi");
                row[1] = rs.getString("maThietBi");
                row[2] = rs.getString("moTa");
                row[3] = rs.getInt("soLuong");
                row[4] = rs.getString("loaiThietBi");
                row[5] = rs.getString("trangThai");
                danhSachThietBi.add(row);
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

        return danhSachThietBi;
    }




    public ThietBiDAO() {

        this.connection = DatabaseConnection.getConnection(); // Kết nối đến cơ sở dữ liệu
    }

    // Cập nhật thiết bị
    public boolean suaThietBi(String maThietBi, String tenThietBi, String moTa, int soLuong, String loaiThietBi, String trangThai) {
        String sql = "UPDATE ThietBi SET tenThietBi = ?, moTa = ?, soLuong = ?, loaiThietBi = ?, trangThai = ? WHERE maThietBi = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tenThietBi);
            statement.setString(2, moTa);
            statement.setInt(3, soLuong);
            statement.setString(4, loaiThietBi);
            statement.setString(5, trangThai);
            statement.setString(6, maThietBi);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa thiết bị
    public boolean xoaThietBi(String maThietBi) {
        String sql = "DELETE FROM ThietBi WHERE maThietBi = ?";
        try (PreparedStatement xoa = connection.prepareStatement(sql)) {
            xoa.setString(1, maThietBi);

            int rowsDeleted = xoa.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}





