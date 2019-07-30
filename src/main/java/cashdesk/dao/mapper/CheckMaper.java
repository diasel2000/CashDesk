package cashdesk.dao.mapper;

import cashdesk.model.entity.Check;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckMaper implements Mapper<Check> {
    @Override
    public Check getEntity(ResultSet resultSet) throws SQLException {
        Check check =new Check();
        check.setId(resultSet.getInt("check_id"));
        check.setQuantity(resultSet.getInt("quantity"));
        check.setPriceSum(resultSet.getBigDecimal("total_price"));
        return check;
    }
}
