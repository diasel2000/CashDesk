package cashdesk.dao.impl;

import cashdesk.dao.interfaces.UsersDAO;
import cashdesk.model.entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCUserDAO implements UsersDAO {
    private Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Users entity) throws SQLException {

    }

    @Override
    public Users findById(int id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }

    public String authenticateUser(Users logining)
    {
        String login = logining.getLogin();
        String password = logining.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";

        try
        {
            con = DBConnectionPool.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select user_login,user_pass,user_role from users");

            while(resultSet.next())
            {
                userNameDB = resultSet.getString("user_login");
                passwordDB = resultSet.getString("user_pass");
                roleDB = resultSet.getString("user_role");

                if(login.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
                    return "Admin_Role";
                else if(login.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
                    return "Editor_Role";
                else if(login.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
                    return "User_Role";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }

}
