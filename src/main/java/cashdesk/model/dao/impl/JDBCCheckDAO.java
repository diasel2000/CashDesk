package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.CheckDAO;
import cashdesk.model.dao.mapper.CheckMaper;
import cashdesk.model.dao.mapper.ProductMaper;
import cashdesk.model.entity.Check;
import cashdesk.model.entity.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class JDBCCheckDAO implements CheckDAO {
    private Connection connection;


    public JDBCCheckDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Check check) throws SQLException {
        int id = check.getId();
        BigDecimal totalPrice = check.getPriceSum();
        String productId = check.getProductId();

        connection.setAutoCommit(false);
        PreparedStatement stmt = connection.prepareStatement(
                "insert into check (id_check, price_sum, product_id)" +
                        " values (?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setBigDecimal(2, totalPrice);
        stmt.setString(3, productId);
        stmt.addBatch();
        stmt.executeBatch();
        stmt = connection.prepareStatement(
                "insert into product (id_product, product_name, price, code," +
                        " values (?, ?, ?, ?)");
        for(Product product : check.getProducts()){
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getProductName());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setString (4, product.getCode());
            stmt.addBatch();
        }
        stmt.executeBatch();
        connection.commit();
        connection.setAutoCommit ( true );
        stmt.close();
        connection.close();
    }


    @Override
    public Check findById(String id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "select * from check where id_check = (?)");
        stmt.setString (1, id);
        ResultSet rs = stmt.executeQuery();
        CheckMaper checkMaper = new CheckMaper ();
        rs.next();
        Check check = checkMaper.getEntity(rs);

        stmt.close();
        connection.close();

        return check;
    }

    @Override
    public List<Check> findAll() throws SQLException {
        Map<Integer, Check> checks = new HashMap<>();

        final String query = " select * from `check`";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        CheckMaper checkMapper = new CheckMaper();
        while (rs.next()) {
            Check check = checkMapper
                    .getEntity (rs);
            checkMapper
                    .mapChecks (checks, check);
        }
        return new ArrayList<>(checks.values());
    }

    @Override
    public void update(Check check) {

    }
    @Override
    public BigDecimal getSum() throws SQLException {
        PreparedStatement statement =  connection.prepareStatement("select sum(price_sum) from `cash desk`.`check`;");
        ResultSet rs = statement.executeQuery();
        rs.next();
        BigDecimal summ = rs.getBigDecimal (1);
        statement.close ();
        connection.close ();
            return summ;
    }

    @Override
    public void addCheck(String id_product,BigDecimal sum_price) throws SQLException {
        final String query ="INSERT INTO `cash desk`.`check` (`price_sum`, `product_code`) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setBigDecimal (1, sum_price );
        stmt.setString (2,id_product);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    @Override
    public void delete(String id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM `cash desk`.`check` WHERE (`id_check` = (?));");
        stmt.setString (1, id);
        stmt.executeUpdate ();

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
