package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.impl.DBConnectionPool;
import cashdesk.model.entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    public String authenticateUser(Users loginBean)
    {
        String userName = loginBean.getLogin();
        String password = loginBean.getPassword();

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

                if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Caisher"))
                    return "Caisher_Role";
                else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("SeniorCaisher"))
                    return "SeniorCaisher_Role";
                else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Supervisor"))
                    return "Supervisor_Role";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
