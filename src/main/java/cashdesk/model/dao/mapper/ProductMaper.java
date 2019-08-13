package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Check;
import cashdesk.model.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Product mapper (id,name,price,code)
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class ProductMaper implements Mapper<Product> {
    @Override
    public Product getEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product ();
        product.setId ( resultSet.getInt ( "id_product" ) );
        product.setProductName ( (resultSet.getString ( "product_name" )) );
        product.setPrice ( resultSet.getBigDecimal ( "price" ) );
        product.setCode ( resultSet.getString ( "code" ) );
        return product;
    }

    public Product mapProducts(Map<String, Product> cache,
                               Product product) {
        cache.putIfAbsent ( product.getCode (), product );
        return cache.get ( product.getCode () );
    }

//    public Product extractForCheck(ResultSet rs) throws SQLException {
//        Product product = new Product();
//        product.setCode(rs.getString ("code"));
//        product.setProductName (rs.getString("name"));
//        product.setPrice(rs.getBigDecimal ("price"));
//        Check check = new Check();
//        check.setId(rs.getInt("check_id"));
//        return product;
//    }
}
