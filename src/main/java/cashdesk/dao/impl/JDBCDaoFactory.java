package cashdesk.dao.impl;

import cashdesk.dao.DaoFactory;
import cashdesk.dao.interfaces.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

import static cashdesk.dao.impl.DBConnectionPool.dataSource;


public class JDBCDaoFactory extends DaoFactory {
    private static final Logger LOG = Logger.getLogger(JDBCDaoFactory.class);

    @Override
    public UsersDAO createUserDao() {
        return new JDBCUserDAO(getConnection());
    }

    @Override
    public ProductDAO createProductDao() {
        return new JDBCProductDAO(getConnection());
    }

    @Override
    public CheckDAO createCheckDao() {
        return new JDBCCheckDAO(getConnection());
    }

    @Override
    public ReportDAO createReportDao() {
        return new JDBCReportDAO(getConnection());
    }

    @Override
    public CaisherDAO createCaisherDao() {
        return null;
    }

    @Override
    public SeniorCaisherDAO createSeniorCaisherDao() {
        return null;
    }

    @Override
    public SupervisorDAO createSupervisorDao() {
        return null;
    }

    private Connection getConnection() {
        try {
            LOG.debug("getConnection: " + dataSource);
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.debug("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }
}
