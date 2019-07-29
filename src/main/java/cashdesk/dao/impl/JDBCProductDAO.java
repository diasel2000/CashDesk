package cashdesk.dao.impl;

import cashdesk.dao.interfaces.ProductDAO;
import cashdesk.model.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCProductDAO implements ProductDAO {
    private Connection connection;


    public JDBCProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Product entity) throws SQLException {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void update(Product product) {

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
