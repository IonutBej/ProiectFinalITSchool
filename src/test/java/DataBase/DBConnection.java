package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private static final String URL =
            System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/final_project" + "?allowPublicKeyRetrieval=true&useSSL=false");

    private static final String USER =
            System.getenv().getOrDefault("DB_USER", "root");

    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    private DBConnection() throws SQLException {
        createConnection();
    }

    private void createConnection() throws SQLException {

        connection = DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    public static synchronized DBConnection getInstance()
            throws SQLException {

        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}