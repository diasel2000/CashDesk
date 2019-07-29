package cashdesk.dao.interfaces;

import cashdesk.dao.GenericDAO;
import cashdesk.model.entity.Users;

import java.util.List;

public interface UsersDAO extends GenericDAO<Users> {

    Users findById(int id);

    List<Users> findAll();

    void update(Users users);

}
