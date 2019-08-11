package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ProductMaper implements Mapper<Product> {
    @Override
    public Product getEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id_product"));
        product.setProductName((resultSet.getString ("product_name")));
        product.setPrice(resultSet.getBigDecimal("price"));
        product.setCode(resultSet.getString ("code"));
        return product;
    }
    public Product mapProducts(Map<String, Product> cache,
                               Product product) {
        cache.putIfAbsent(product.getCode(), product);
        return cache.get(product.getCode());
    }
}
