package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.srvice.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegisterUsersCommand.class);
    private UserService userService;

    public RegisterUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
