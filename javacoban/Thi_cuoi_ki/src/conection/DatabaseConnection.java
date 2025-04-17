package conection;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/quan_ly_thiet_bi"; // URL của CSDL
        private static final String USER = "root"; // Tài khoản CSDL
        private static final String PASSWORD = ""; // Mật khẩu CSDL

        public static Connection getConnection() {
            Connection connection = null;
            try {
                // Tải Driver MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Kết nối CSDL
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối thành công!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }


