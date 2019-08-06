package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.srvice.UserService;

import cashdesk.utils.Regex;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginUsersCommand.class);
    private UserService userService;

    public LoginUsersCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login =request.getParameter("login");
        String pass = request.getParameter("pass");
        if(login==null||login.equals("")){
            request.setAttribute("login_error_message","Set in the login");
            return;
        }
        if(pass==null||pass.equals("")){
            request.setAttribute("password_error_message","Set in the password");
            return;
        }
        if (!Regex.isPasswordCorrect(pass)) {
            request.setAttribute("password_error_message", "Invalid password");

            return;
        }
        if (!Regex.isLoginCorrect(login)) {
            request.setAttribute("login_error_message", "Invalid login");
            return;
        }
        if(UsersCommand.checkLoggedUser(request,login)){
            LOGGER.debug("User logged in");
            return;
        }
    }
}
