

import java.sql.*;

public class OracleConnection {

    public static Connection conn;

    public static Connection dbConnector() {
        if (conn == null) {
            String databaseURL = "jdbc:oracle:thin:@//localhost:1521/XE";
            String userid = "p";
            String userpwd = "p";
            String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
            try {
                Class.forName(jdbcDriver);
                conn = DriverManager.getConnection(databaseURL, userid, userpwd);
            } catch (Exception e) {
                return null;
            }
        }
        return conn;
    }

}