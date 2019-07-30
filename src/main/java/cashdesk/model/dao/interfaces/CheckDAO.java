package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Check;

import java.util.List;

public interface CheckDAO extends GenericDAO<Check> {


    Check findById(int id);

    List<Check> findAll();

    void update(Check check);

}
