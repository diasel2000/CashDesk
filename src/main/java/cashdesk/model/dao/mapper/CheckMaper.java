package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Check;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
/**
 * Check mapper (id, total price, product code)
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class CheckMaper implements Mapper<Check> {
    @Override
    public Check getEntity(ResultSet resultSet) throws SQLException {
        Check check = new Check();
        check.setId(resultSet.getInt("id_check"));
        check.setPriceSum(resultSet.getBigDecimal("price_sum"));
        check.setProductId ( resultSet.getString ( "product_code" ) );
        return check;
    }
    public Check mapChecks(Map<Integer, Check> cache,
                            Check check) {
        cache.putIfAbsent(check.getId(), check);
        return cache.get(check.getId());
    }
}
