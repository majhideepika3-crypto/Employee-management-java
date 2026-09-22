import java.sql.*;
public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String pass = "your_mysql_password";
        return DriverManager.getConnection(url, user, pass);
    }
}l
