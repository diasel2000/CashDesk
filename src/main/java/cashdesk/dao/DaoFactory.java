package cashdesk.dao;

import cashdesk.dao.impl.JDBCDaoFactory;
import cashdesk.dao.interfaces.*;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UsersDAO createUserDao();

    public abstract ProductDAO createProductDao();

    public abstract CheckDAO createCheckDao();

    public abstract ReportDAO createReportDao();

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
