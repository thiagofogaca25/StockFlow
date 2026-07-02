package estoque.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/stockflow";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
        }
    }
}
