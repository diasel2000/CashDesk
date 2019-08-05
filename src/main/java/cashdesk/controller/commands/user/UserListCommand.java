package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserListCommand implements Command {
    private UserService userService;
    private static final Logger LOGGER = LogManager.getLogger(UserListCommand.class);

    public UserListCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Users> users = userService.getAllUsers();
            request.setAttribute("users",users);
        } catch (SQLException e) {
            LOGGER.debug("DB error while request users");
            request.setAttribute("sql_error_message","DataBase problem"+ e.getMessage());
        }
    }
}
