package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Supervisor;

import java.util.List;

public interface SupervisorDAO extends GenericDAO<Supervisor> {

    void add(Supervisor supervisor);

    Supervisor findById(int id);

    List<Supervisor> findAll();

    void update(Supervisor supervisor);

    void delete(Supervisor supervisor);
}
