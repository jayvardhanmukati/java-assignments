import java.sql.*;

public class JDBCApp {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    static final String USER = "root";
    static final String PASS = "jay04"; // change if needed

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to Database\n");

            // 1. SELECT price <= 100
            System.out.println("Items with Price <= 100:");
            Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery(
                    "SELECT * FROM MenuItem WHERE Price <= 100");
            printResult(rs1);

            // 2. Items in Cafe Java
            System.out.println("\nItems in Restaurant 'Cafe Java':");
            ResultSet rs2 = stmt.executeQuery(
                    "SELECT m.* FROM MenuItem m " +
                            "JOIN Restaurant r ON m.ResId = r.Id " +
                            "WHERE r.Name = 'Cafe Java'");
            printResult(rs2);

            // 3. UPDATE price <= 100 → 200
            System.out.println("\nUpdating prices <=100 to 200...");
            int updated = stmt.executeUpdate(
                    "UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            System.out.println(updated + " rows updated");

            // Show updated table
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM MenuItem");
            printResult(rs3);

            // 4. DELETE items starting with 'P'
            System.out.println("\nDeleting items starting with 'P'...");
            int deleted = stmt.executeUpdate(
                    "DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            System.out.println(deleted + " rows deleted");

            // Show final table
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM MenuItem");
            printResult(rs4);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print ResultSet in tabular format
    public static void printResult(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        // Print column names
        for (int i = 1; i <= columns; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        // Print rows
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}