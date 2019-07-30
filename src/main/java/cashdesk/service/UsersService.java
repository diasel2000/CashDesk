package cashdesk.service;

import cashdesk.dao.DaoFactory;
import cashdesk.dao.impl.JDBCUserDAO;
import cashdesk.dao.interfaces.UsersDAO;
import cashdesk.model.entity.Users;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.List;


public class UsersService {
    private static final Logger logger = Logger.getLogger(UsersService.class);

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Users> getAllUsers() throws SQLException {
        try () {
        }
    }



}
