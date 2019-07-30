package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Product;

import java.util.List;

public interface ProductDAO extends GenericDAO<Product> {

    Product findById(int id);

    List<Product> findAll();

    void update(Product product);

}