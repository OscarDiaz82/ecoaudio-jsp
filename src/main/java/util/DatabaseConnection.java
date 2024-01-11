package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/ecoaudio";
    private static final String user = "root";
    private static final String pasword = "";
    private static Connection connection;
    
    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, user, pasword);
        }
        return connection;
    }
    
}
