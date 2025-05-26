import java.sql.*;

public class TransactionHandlingJDBC {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb", "root", "password")) {

            conn.setAutoCommit(false);  // Start transaction

            PreparedStatement debitStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?");
            PreparedStatement creditStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?");

            debitStmt.setDouble(1, 100);
            debitStmt.setInt(2, 1);
            creditStmt.setDouble(1, 100);
            creditStmt.setInt(2, 2);

            debitStmt.executeUpdate();
            creditStmt.executeUpdate();

            conn.commit();  // Commit if both succeed
            System.out.println("Transaction completed successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
