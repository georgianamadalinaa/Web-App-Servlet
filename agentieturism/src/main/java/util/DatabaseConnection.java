package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://ga214.cti.ugal.ro:3306/ga214";
    private static final String USER = "ga214";
    private static final String PASSWORD = "7npuqj23";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driverul MySQL nu a fost găsit", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}