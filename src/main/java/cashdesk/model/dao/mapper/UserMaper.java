package cashdesk.model.dao.mapper;

import cashdesk.model.entity.Caisher;
import cashdesk.model.entity.Users;

import javax.xml.registry.infomodel.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
/**
 * User mapper(id,login,pass,role)
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class UserMaper implements Mapper<Users> {
    @Override
    public Users getEntity(ResultSet resultSet) throws SQLException {
        Users users = new Users();
        users.setId(resultSet.getInt("id_users"));
        users.setLogin(resultSet.getString("user_login"));
       // users.setName(resultSet.getString("name"));
       // users.setLastName(resultSet.getString("lastName"));
        users.setPassword(resultSet.getString("user_pass"));
        users.setRole(resultSet.getString("user_role"));
        return users;
    }
}
