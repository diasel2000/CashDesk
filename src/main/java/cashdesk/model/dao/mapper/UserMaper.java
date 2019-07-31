package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Users;

import javax.xml.registry.infomodel.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
