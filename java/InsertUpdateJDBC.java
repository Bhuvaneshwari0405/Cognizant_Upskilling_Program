import java.sql.*;

public class InsertUpdateJDBC {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            // Insert new student
            String insertSql = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, 104);
            insertStmt.setString(2, "Emma");
            insertStmt.executeUpdate();

            // Update student name
            String updateSql = "UPDATE students SET name = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, "Emily");
            updateStmt.setInt(2, 104);
            updateStmt.executeUpdate();

            System.out.println("Insert and update completed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
