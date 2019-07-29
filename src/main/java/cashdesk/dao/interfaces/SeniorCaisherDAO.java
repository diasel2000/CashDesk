package cashdesk.dao.interfaces;

import cashdesk.dao.GenericDAO;
import cashdesk.model.entity.SeniorCaisher;

import java.util.List;

public interface SeniorCaisherDAO extends GenericDAO<SeniorCaisher> {

    void add(SeniorCaisher seniorCaisher);

    SeniorCaisher findById(int id);

    List<SeniorCaisher> findAll();

    void update(SeniorCaisher seniorCaisher);

    void delete(SeniorCaisher seniorCaisher);
}
