package cashdesk.model.dao.interfaces;

import cashdesk.model.dao.GenericDAO;
import cashdesk.model.entity.Users;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsersDAO extends GenericDAO<Users> {

    Users findById(int id) throws SQLException;

    List<Users> findAll() throws SQLException;

    void update(Users users) throws SQLException;

    Optional<Users> findByLogin(String login);

    void register(String login, String pass, String role) throws SQLException;

}
