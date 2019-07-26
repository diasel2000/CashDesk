package cashdesk.db;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPool {
    private static final Logger LOG = Logger.getLogger(DBConnectionPool.class);

    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost/university?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(20);
        dataSource.setInitialSize(5);

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            LOG.debug("Connection received " + connection);
        } catch (SQLException e) {
            LOG.error("Some problem was occurred while getting connection to BD \n" + e);
        }
        return connection;    }

    private DBConnectionPool(){}

}