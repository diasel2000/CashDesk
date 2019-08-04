package cashdesk.model.srvice;

import cashdesk.model.dao.DaoFactory;
import cashdesk.model.dao.interfaces.UsersDAO;
import cashdesk.model.entity.Users;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import javax.xml.registry.infomodel.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Users> getAllUsers() throws SQLException {
        try (UsersDAO userDao = daoFactory.createUserDao()) {
            return userDao.findAll();
        }
    }

//    public Optional<User> login(String email, String pass) throws LoginException {
//        Optional<User> result;
//        try (UsersDAO userDao = daoFactory.createUserDao()) {
//            result = userDao.findByEmail(email);
//        }
//        if (result.isPresent()) {
//            if (result.get().getPassword().equals(pass)) {
//                return result;
//            }
//            LOGGER.info("Wrong password : {} for email : {}", pass, email);
//
//        }
//        LOGGER.info("Wrong email : {}", email);
//        throw new WrongEmailException("User with email " + email + " is not found.");
//    }

    public void register(String login, String pass, String role) throws SQLException {
        UsersDAO userDao = daoFactory.createUserDao();
        userDao.register(login, pass, role);
    }

    public void update(Users user) throws SQLException {
        try (UsersDAO userDao = daoFactory.createUserDao()) {
            userDao.update(user);
        }
    }
}
