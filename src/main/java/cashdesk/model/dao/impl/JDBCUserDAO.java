package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.UsersDAO;
import cashdesk.model.dao.mapper.UserMaper;
import cashdesk.model.entity.Users;

import javax.xml.registry.infomodel.User;
import java.sql.*;
import java.util.*;

public class JDBCUserDAO implements UsersDAO {
    private Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Users entity) throws SQLException {

    }

    @Override
    public Users findById(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "select * from user where id_users = (?)");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        UserMaper userMapper = new UserMaper();
        resultSet.next();
        Users users = userMapper.getEntity(resultSet);
        stmt.close();
        connection.close();
        return users;
    }

    @Override
    public List<Users> findAll() throws SQLException {
        Map<Integer, User> users = new HashMap<>();

        final String query = "" +
                " select * from users";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        UserMaper userMapper = new UserMaper();

        while (rs.next()) {
            Users user = userMapper
                    .getEntity(rs);
            userMapper.getEntity(rs);
        }
        return new ArrayList<Users>();
    }

    @Override
    public void update(Users users) throws SQLException {
        int id = users.getId();
        String role = users.getRole().toString();
        PreparedStatement stmt = connection.prepareStatement(
                "update users set user_role = ?" +
                        " where id_users = ?");
        stmt.setInt(2, id);
        stmt.setString(1, role);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "delete from users where id_users = (?)");
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
            e.printStackTrace();
        }
    }
    public void register(String login, String pass, String role) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "insert into users (users_login, user_pass, user_role) values (?, ?, ?)");
        stmt.setString(1, login);
        stmt.setString(2, pass);
        stmt.setString(3, pass);
        stmt.executeUpdate();

        stmt.close();
        connection.close();
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }
}
