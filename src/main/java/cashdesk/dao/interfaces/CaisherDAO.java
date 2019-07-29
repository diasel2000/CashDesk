package cashdesk.dao.interfaces;

import cashdesk.dao.GenericDAO;
import cashdesk.model.entity.Caisher;

import java.util.List;

public interface CaisherDAO extends GenericDAO<Caisher> {
    void add(Caisher caisher);

    Caisher findById(int id);

    List<Caisher> findAll();

    void update(Caisher caisher);

    void delete(Caisher caisher);
}
