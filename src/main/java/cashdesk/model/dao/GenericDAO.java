package cashdesk.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {

    void create(T entity) throws SQLException;

    T findByCode(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int id) throws SQLException;

    void close();

    int getCount() throws SQLException;
}
