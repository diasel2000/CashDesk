package cashdesk.model.srvice;

import cashdesk.model.dao.DaoFactory;
import cashdesk.model.dao.interfaces.ProductDAO;
import cashdesk.model.entity.Product;

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

    public Product getProductById(int id) throws SQLException {
        try (ProductDAO dao = daoFactory.createProductDao()) {
            return dao.findById(id);
        }
    }

//    public void addProduct(int code, String name, boolean isSoldByWeight, int number, long weight, long price) {
//        try (ProductDAO productDao = daoFactory.createProductDao()) {
//            productDao.create(product);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void create(Product product) throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            productDao.create(product);
        }
    }

    public void update(Product product) throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            productDao.update(product);
        }
    }

    public void delete(int code) throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            productDao.delete(code);
        }
    }

    public List<Product> getProductsSortedBy(String sortBy) throws SQLException {
        try (ProductDAO productDao = daoFactory.createProductDao()) {
            List<Product> products = productDao.findAll();
            return products;
        }
    }

//    public List<Product> getProductsSorted(String sortBy, int rows_on_page, Integer offset) throws SQLException {
//        try (ProductDAO productDao = daoFactory.createProductDao()) {
//            List<Product> products = productDao.
//            return products;
//        }
//    }
}
