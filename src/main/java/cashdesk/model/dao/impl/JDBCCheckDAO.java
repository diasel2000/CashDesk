package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.CheckDAO;
import cashdesk.model.dao.mapper.CheckMaper;
import cashdesk.model.dao.mapper.ProductMaper;
import cashdesk.model.entity.Check;
import cashdesk.model.entity.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCheckDAO implements CheckDAO {
    private Connection connection;


    public JDBCCheckDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Check check) throws SQLException {
        int id = check.getId();
        BigDecimal totalPrice = check.getPriceSum();
        int productQuantitu = check.getQuantity();
        int productId = check.getProductId();

        connection.setAutoCommit(false);
        PreparedStatement stmt = connection.prepareStatement(
                "insert into check (id_check, total_price, cashier_id, shift_id, create_time)" +
                        " values (?, ?, ?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setBigDecimal(2, totalPrice);
        stmt.setInt(3, productQuantitu);
        stmt.setInt(4, productId);
        stmt.addBatch();
        stmt.executeBatch();
        stmt = connection.prepareStatement(
                "insert into product (id_product, product_name, price, code," +
                        " values (?, ?, ?, ?)");
        for(Product product : check.getProducts()){
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getProductName());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setInt(4, product.getCode());
            stmt.addBatch();
        }
        stmt.executeBatch();
        connection.commit();
        connection.setAutoCommit(true);
        stmt.close();
        connection.close();
    }

    @Override
    public Check findByCode(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "select * from check" +
                        " where check.id_check = (?) ");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        CheckMaper checkMapper = new CheckMaper();

        rs.next();
        Check check = checkMapper.getEntity(rs);

        List<Product> products = new ArrayList<>();
        ProductMaper productMapper = new ProductMaper();
        do {
            Product product = productMapper.getEntity(rs);
            products.add(product);
        }
        while(rs.next());
        check.setProducts(products);

        stmt.close();
        connection.close();
        return check;
    }

    @Override
    public List<Check> findAll() throws SQLException {
        Map<Integer, Check> checks = new HashMap<>();
        final String query = "select id_check, product_quantity, price_sum from check";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        CheckMaper checkMapper = new CheckMaper();


        return new ArrayList<>(checks.values());
    }

    @Override
    public void update(Check check) {

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "delete from check where id_check = (?)");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

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
