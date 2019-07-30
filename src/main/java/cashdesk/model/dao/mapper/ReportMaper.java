package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Report;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMaper implements Mapper<Report>{
    @Override
    public Report getEntity(ResultSet resultSet) throws SQLException {
        Report report =new Report();
        report.setId(resultSet.getInt("report_id"));
        report.setContent(resultSet.getString("content"));
        return report;
    }
}
