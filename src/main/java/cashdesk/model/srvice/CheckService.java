package cashdesk.model.srvice;

import cashdesk.model.dao.DaoFactory;
import cashdesk.model.dao.interfaces.CheckDAO;
import cashdesk.model.entity.Check;

import java.sql.SQLException;
import java.util.List;

public class CheckService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Check> getAllChecks() throws SQLException {
        try (CheckDAO checkDao = daoFactory.createCheckDao()) {
            try {
                return checkDao.findAll();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public void create(Check check) throws SQLException {
        try (CheckDAO checkDao = daoFactory.createCheckDao()) {
            checkDao.create(check);
        }
    }

    public Check getCheckById(int id) throws SQLException {
        try (CheckDAO dao = daoFactory.createCheckDao()) {
            return dao.findById(id);
        }
    }
}
