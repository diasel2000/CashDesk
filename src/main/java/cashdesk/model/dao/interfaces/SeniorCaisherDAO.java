package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.SeniorCaisher;

import java.util.List;

public interface SeniorCaisherDAO extends GenericDAO<SeniorCaisher> {

    void add(SeniorCaisher seniorCaisher);

    SeniorCaisher findByCode(int id);

    List<SeniorCaisher> findAll();

    void update(SeniorCaisher seniorCaisher);

    void delete(SeniorCaisher seniorCaisher);
}
