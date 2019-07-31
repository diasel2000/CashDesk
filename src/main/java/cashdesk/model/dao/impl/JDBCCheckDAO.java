package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.CheckDAO;
import cashdesk.model.entity.Check;
import cashdesk.model.entity.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

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
                "insert into check (check_id, total_price, cashier_id, shift_id, create_time)" +
                        " values (?, ?, ?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setBigDecimal(2, totalPrice);
        stmt.setInt(3, productQuantitu);
        stmt.setInt(4, productId);
        stmt.addBatch();
        stmt.executeBatch();
        stmt = connection.prepareStatement(
                "insert into product_in_check (code, name, is_sold_by_weight, number_sold," +
                        " weight_sold, price, check_id)" +
                        " values (?, ?, ?, ?, ?, ?, ?)");
        for(Product product : check.getPoductId()){
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
    public Check findById(int id) {
        return null;
    }

    @Override
    public List<Check> findAll() {
        return null;
    }

    @Override
    public void update(Check check) {

    }

    @Override
    public void delete(int id) throws SQLException {

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
