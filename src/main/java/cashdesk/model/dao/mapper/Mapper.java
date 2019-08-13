package cashdesk.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * generic interface for mappers
 *
 * @param <T>
 */
public interface Mapper<T> {
    T getEntity(ResultSet resultSet) throws SQLException;
}
