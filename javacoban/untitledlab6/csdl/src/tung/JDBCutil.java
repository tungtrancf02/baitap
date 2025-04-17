package tung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutil {
    public static Connection getConnection() {
        Connection con = null;
        //đăng kí sql driver với drivermanager
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            String url = "jdbc:mysql://localhost:3306/tung";
            String user = "root";
            String password = "";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
