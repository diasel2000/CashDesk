package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO extends GenericDAO<Product> {

    Product findById(int id) throws SQLException;

    List<Product> findAll() throws SQLException;

    void update(Product product) throws SQLException;

    void create(Product product) throws SQLException;
}
