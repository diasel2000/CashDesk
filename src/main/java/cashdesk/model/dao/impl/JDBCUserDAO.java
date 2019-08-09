package cashdesk.model.dao.impl;

import cashdesk.model.dao.interfaces.UsersDAO;
import cashdesk.model.dao.mapper.UserMaper;
import cashdesk.model.entity.Caisher;
import cashdesk.model.entity.Users;

import javax.swing.*;
import javax.xml.registry.infomodel.User;
import java.sql.*;
import java.util.*;

public class JDBCUserDAO implements UsersDAO {
    private Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Users users) throws SQLException {
        int userId = users.getId();
        String userLogin = users.getLogin();
        String userPass = users.getPassword();
        String userRole = users.getRole();
        Caisher caisher = new Caisher();
        String caisherNameRole = caisher.getLastName();
        int caicherId = caisher.getId();
        String caisherLastName = caisher.getLastName();

        try {
            String insertIntoUsers = "INSERT INTO users (id_user,user_login, user_pass, user_role) VALUES (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(insertIntoUsers);
            pst.setInt(1, userId);
            pst.setString(2, userLogin);
            pst.setString(3, userPass);
            pst.setString(4, userRole);

            pst.execute();

            String insertIntoCaisher = "INSERT INTO caisher (id_caisher, caisher_name, caisher_last_name, id_user) VALUES (?, ?, ?, ?)";
            pst = connection.prepareStatement(insertIntoCaisher);
            pst.setInt(1, caicherId);
            pst.setString(2, caisherNameRole);
            pst.setString(3,caisherLastName);
            pst.setInt(4, userId);

            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
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
    public Optional<Users> findByLogin(String login) {
        Optional<Users> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM user WHERE email = ?")){
            ps.setString( 1, login);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMaper mapper = new UserMaper();
            if (rs.next()){
                result = Optional.of(mapper.getEntity(rs));
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
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
                "INSERT INTO `cash desk`.`users` (`user_login`, `user_pass`, `user_role`) VALUES ('?', '?', '?');");
        stmt.setString(1, login);
        stmt.setString(2, pass);
        stmt.setString(3, role);
        stmt.executeUpdate();
        System.out.println("go og og");
        stmt.close();
        connection.close();
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }
}
