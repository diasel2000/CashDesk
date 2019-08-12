package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO extends GenericDAO<Product> {

    Product findById(String id) throws SQLException;

    List<Product> findAll() throws SQLException;

    void update(Product product) throws SQLException;

    void create(String productName,String code,BigDecimal price) throws SQLException;

}
