package cashdesk.dao.mapper;

import cashdesk.model.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMaper implements Mapper<Product> {
    @Override
    public Product getEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        product.setCode(resultSet.getInt("code"));
        product.setPrice(resultSet.getBigDecimal("price"));
        product.setProductName(resultSet.getString("productName"));
        return product;
    }
}
