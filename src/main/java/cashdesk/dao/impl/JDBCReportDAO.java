package cashdesk.dao.impl;

import cashdesk.dao.interfaces.ReportDAO;
import cashdesk.model.entity.Report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCReportDAO implements ReportDAO {
    Connection connection;

    public JDBCReportDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Report entity) throws SQLException {

    }

    @Override
    public Report findById(int id) {
        return null;
    }

    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public void update(Report report) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }

}
