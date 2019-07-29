package cashdesk.dao.interfaces;

import cashdesk.dao.GenericDAO;
import cashdesk.model.entity.Report;

import java.util.List;

public interface ReportDAO extends GenericDAO<Report> {

    Report findById(int id);

    List<Report> findAll();

    void update(Report report);

}
