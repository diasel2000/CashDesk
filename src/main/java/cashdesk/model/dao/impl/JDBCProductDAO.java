package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.ProductDAO;
import cashdesk.model.dao.mapper.ProductMaper;
import cashdesk.model.entity.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anatolii Huzov
 * @version 1.0
 */
public class JDBCProductDAO implements ProductDAO {
    private Connection connection;


    public JDBCProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(String productName,String code,BigDecimal price) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO product (product_name, price, code)" +
                        " VALUES (?, ?, ?)");
        stmt.setString(1, productName);
        stmt.setBigDecimal(2, price);
        stmt.setString (3, code);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    @Override
    public void create(Product entity) throws SQLException {

    }

    @Override
    public Product findById(String code) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "select * from product where code = (?)");
        stmt.setString (1, code);
        ResultSet rs = stmt.executeQuery();
        ProductMaper productMapper = new ProductMaper();

        rs.next();
        Product product = productMapper.getEntity(rs);

        stmt.close();
        connection.close();
        return product;
    }


    @Override
    public List<Product> findAll() throws SQLException {
        Map<String, Product> products = new HashMap<>();

        final String query = " select * from product";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        ProductMaper productMapper = new ProductMaper();

        while (rs.next()) {
            Product product = productMapper
                    .getEntity(rs);
            productMapper.mapProducts ( products,product );
        }
        return new ArrayList<>(products.values());
    }

    @Override
    public void update(Product product)  {

    }

    @Override
    public void delete(String code) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM product WHERE (code = ?);" );
        stmt.setString (1, code);
        stmt.executeUpdate();

        stmt.close();
        connection.close();
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
