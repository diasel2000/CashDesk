package cashdesk.model.dao;

import java.sql.SQLException;
import java.util.List;
/**
 * Generic DAO interface
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public interface GenericDAO<T> extends AutoCloseable {

    void create(T entity) throws SQLException;

    T findById(String id) throws SQLException;

    List<T> findAll() throws SQLException;

    void update(T entity) throws SQLException;

    void delete(String code) throws SQLException;

    void close();

    int getCount() throws SQLException;
}
