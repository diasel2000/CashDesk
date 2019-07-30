package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.CheckDAO;
import cashdesk.model.entity.Check;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCCheckDAO implements CheckDAO {
    private Connection connection;


    public JDBCCheckDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Check entity) throws SQLException {

    }

    @Override
    public Check findById(int id) {
        return null;
    }

    @Override
    public List<Check> findAll() {
        return null;
    }

    @Override
    public void update(Check check) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }


}
