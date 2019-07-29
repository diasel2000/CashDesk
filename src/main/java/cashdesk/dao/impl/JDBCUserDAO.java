package cashdesk.dao.impl;

import cashdesk.dao.interfaces.UsersDAO;
import cashdesk.model.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCUserDAO implements UsersDAO {
    private Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Users entity) throws SQLException {

    }

    @Override
    public Users findById(int id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public void update(Users users) {

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
