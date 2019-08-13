package cashdesk.model.dao.impl;

import cashdesk.model.dao.DaoFactory;
import cashdesk.model.dao.interfaces.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

import static cashdesk.model.dao.impl.DBConnectionPool.dataSource;
import static cashdesk.model.dao.impl.DBConnectionPool.getConnection;


public class JDBCDaoFactory extends DaoFactory {
    private static final Logger LOG = Logger.getLogger ( JDBCDaoFactory.class );

    @Override
    public UsersDAO createUserDao() throws SQLException {
        return new JDBCUserDAO ( getConnection () );
    }

    @Override
    public ProductDAO createProductDao() throws SQLException {
        return new JDBCProductDAO ( getConnection () );
    }

    @Override
    public CheckDAO createCheckDao() throws SQLException {
        return new JDBCCheckDAO ( getConnection () );
    }

   /* @Override
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
    }*/
}
