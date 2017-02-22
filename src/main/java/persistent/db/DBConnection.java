package persistent.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection ourInstance = new DBConnection();
    private static Logger logger = Logger.getLogger(DBConnection.class);
    private Connection con;

    private DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.fatal("Postgresql driver not found", e);
        }

        try {
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/newdb",
                    "postgres",
                    "");
        } catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
        }

    }

    public static Connection get() {
        return ourInstance.con;
    }
}
