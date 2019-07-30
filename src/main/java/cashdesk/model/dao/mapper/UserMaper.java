package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMaper implements Mapper<Users> {
    @Override
    public Users getEntity(ResultSet resultSet) throws SQLException {
        Users users = new Users();
        users.setId(resultSet.getInt("user_id"));
        users.setLogin(resultSet.getString("login"));
        users.setName(resultSet.getString("name"));
        users.setLastName(resultSet.getString("lastName"));
        users.setPassword(resultSet.getString("password"));
        users.setRole(resultSet.getString("role"));
        return users;
    }
}
