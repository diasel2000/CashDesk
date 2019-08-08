package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginUsersCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersCommand.setUser(request,null);
        LOGGER.info("logged out");
        response.sendRedirect("/index.jsp");
    }
}
