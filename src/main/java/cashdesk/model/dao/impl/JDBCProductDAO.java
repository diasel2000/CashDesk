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

public class JDBCProductDAO implements ProductDAO {
    private Connection connection;


    public JDBCProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Product product) throws SQLException {
        int id = product.getId();
        String productName = product.getProductName();
        BigDecimal price = product.getPrice();
        int code = product.getCode();
        PreparedStatement stmt = connection.prepareStatement(
                "insert into product (id_product, product_name, price, code)" +
                        " values (?, ?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setString(2, productName);
        stmt.setBigDecimal(5, price);
        stmt.setInt(7, code);
        stmt.executeUpdate();

        stmt.close();
        connection.close();
    }

    @Override
    public Product findById(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "select * from product where id_product = (?)");
        stmt.setInt(1, id);
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
        Map<Integer, Product> products = new HashMap<>();

        final String query = "" +
                " select * from product";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        ProductMaper productMapper = new ProductMaper();

        while (rs.next()) {
            Product product = productMapper
                    .getEntity(rs);
        }
        return new ArrayList<>(products.values());
    }

    @Override
    public void update(Product product) throws SQLException {
        int id_product = product.getId();
        String productName = product.getProductName();
        BigDecimal price = product.getPrice();
        int code = product.getCode();
        PreparedStatement stmt = connection.prepareStatement(
                "update product id_product = ?,product_name = ?, price = ?, code = ?" +
                        " where id_product = ?");
        stmt.setInt(1, id_product);
        //stmt.setString(2, name);
        //stmt.setBoolean(3, isSoldByWeight);
        stmt.setString(2, productName);
        stmt.setBigDecimal(3, price);
        stmt.setLong(4, code);
        stmt.setInt(5, id_product);
        stmt.executeUpdate();

        stmt.close();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "delete from product where id_product = (?)");
        stmt.setInt(1, id);
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
