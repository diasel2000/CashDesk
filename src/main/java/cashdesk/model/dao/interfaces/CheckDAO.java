package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Check;

import java.sql.SQLException;
import java.util.List;

public interface CheckDAO extends GenericDAO<Check> {


    Check findById(int id) throws SQLException;

    List<Check> findAll() throws SQLException;

    void update(Check check);

}
