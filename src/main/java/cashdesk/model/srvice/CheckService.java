package cashdesk.model.srvice;

import cashdesk.model.dao.DaoFactory;
import cashdesk.model.dao.interfaces.CheckDAO;
import cashdesk.model.entity.Check;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    public BigDecimal getSumm() throws SQLException {
        try (CheckDAO checkDAO = daoFactory.createCheckDao ()) {
           return checkDAO.getSum ();
        }
    }

    public void create(Check check) throws SQLException {
        try (CheckDAO checkDao = daoFactory.createCheckDao()) {
            checkDao.create(check);
        }
    }



    public Check getCheckById(String code) throws SQLException {
        try (CheckDAO dao = daoFactory.createCheckDao()) {
            return dao.findById (code);
        }
    }

    public void addCheck(String id_product,BigDecimal sum_price) throws SQLException {
        try(CheckDAO checkDAO = daoFactory.createCheckDao ()) {
            checkDAO.addCheck( id_product, sum_price);
        }
    }
}
