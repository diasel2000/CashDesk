package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.UserService;

import cashdesk.utils.MD5;
import cashdesk.utils.Regex;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Optional;

public class LoginUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginUsersCommand.class);
    private UserService userService;

    public LoginUsersCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String newPass = MD5.MD5 ( pass );
        if (login == null || login.equals("")) {
            request.setAttribute("login_error_message", "Set in the login");
        }else
        if (pass == null || pass.equals("")) {
            request.setAttribute("password_error_message", "Set in the password");
        }else
        if (!Regex.isPasswordCorrect(pass)) {
            request.setAttribute("password_error_message", "Invalid password");
        }else
        if (!Regex.isLoginCorrect(login)) {
            request.setAttribute("login_error_message", "Invalid login");
        }
        try {

            Optional<Users> user = userService.login(login, newPass);
            UsersCommand.setUser(request, user.get());
            LOGGER.info("User " + login + " logged succesfully whith role: " + user.get().getRole());
            if (user.get ().getRole ().equals ( "seniorCaisher" )) {
                response.sendRedirect ( request.getContextPath ()+"/secured/seniorcaisher/seniorcashier.jsp" );
            }else
            if (user.get ().getRole ().equals ( "supervisor" )) {
                response.sendRedirect ( request.getContextPath ()+"/secured/supervisor/supervisor.jsp" );
            }else
            if (user.get ().getRole ().equals ( "caisher" )) {
                response.sendRedirect ( request.getContextPath ()+"/secured/caisher/cashier.jsp" );
            }else response.sendRedirect (request.getContextPath ()+ "/public/login.jsp");
        } catch (LoginException e) {
            request.setAttribute("log_error_message", "Wrong login o password");
            LOGGER.info("Invalid attempt of login user: " + login);
            response.sendRedirect (request.getContextPath ()+ "/public/login.jsp");
        }
    }
}
