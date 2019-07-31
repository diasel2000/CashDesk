package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO extends GenericDAO<Users> {

    Users findById(int id) throws SQLException;

    List<Users> findAll() throws SQLException;

    void update(Users users) throws SQLException;

}
