package cashdesk.model.srvice;

import cashdesk.model.dao.DaoFactory;
import cashdesk.model.dao.interfaces.ProductDAO;
import cashdesk.model.entity.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Product> getAllProducts() throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            return productDao.findAll();
        }
    }

    public int getProductCount() throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            return productDao.getCount();
        }
    }

    public Product getProductById(String id) throws SQLException {
        try (ProductDAO dao = daoFactory.createProductDao()) {
            return dao.findById (id);
        }
    }
    public void create(String code, String name, BigDecimal price) throws SQLException {
        ProductDAO productDao = daoFactory.createProductDao();
            productDao.create(name,code,price);

    }




    public void update(Product product) throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            productDao.update(product);
        }
    }

    public void delete(String code) throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            productDao.delete(code);
        }
    }


}
