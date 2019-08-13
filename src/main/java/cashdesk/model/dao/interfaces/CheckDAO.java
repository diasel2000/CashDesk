package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Check;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CheckDAO extends GenericDAO<Check> {


    Check findById(String code) throws SQLException;

    List<Check> findAll() throws SQLException;

    void update(Check check);

    BigDecimal getSum() throws SQLException;

    void addCheck(String id_product, BigDecimal sum_price) throws SQLException;
}
