package Messenger.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class DBConn {


    private static DBConn instance;
    private Connection connect;

    private DBConn () throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("Messenger/Database/Properties/db");
        String host = rb.getString ("host");
        String port = rb.getString ("port");
        String db = rb.getString ("db");
        String user = rb.getString ("user");
        String password = rb.getString ("password");
        String URL = rb.getString ("jdbcUrl");

        String jdbcURL = MessageFormat.format("jdbc:{0}://{1}:{2}/{3}",URL, host, port, db);

        connect = DriverManager.getConnection(jdbcURL, user, password);
    }

    public static DBConn getInstance() {
        if (instance == null) {
            try {
                instance = new DBConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection connection () {
        return connect;
    }
}
