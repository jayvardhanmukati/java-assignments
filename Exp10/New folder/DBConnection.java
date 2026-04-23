import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fooddb";
    private static final String USER = "root";
    private static final String PASS = "your_password";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}