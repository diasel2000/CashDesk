package cashdesk.model.dao;

import cashdesk.model.dao.impl.JDBCDaoFactory;
import cashdesk.model.dao.interfaces.*;

import java.sql.SQLException;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UsersDAO createUserDao() throws SQLException;

    public abstract ProductDAO createProductDao() throws SQLException;

    public abstract CheckDAO createCheckDao() throws SQLException;

    public abstract CaisherDAO createCaisherDao();

    public abstract SeniorCaisherDAO createSeniorCaisherDao();

    public abstract SupervisorDAO createSupervisorDao();


    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
