package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.UserService;

import cashdesk.utils.Regex;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class LoginUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginUsersCommand.class);
    private UserService userService;

    public LoginUsersCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if (login == null || login.equals("")) {
            request.setAttribute("login_error_message", "Set in the login");
            return;
        }
        if (pass == null || pass.equals("")) {
            request.setAttribute("password_error_message", "Set in the password");
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
        if (UsersCommand.checkLoggedUser(request, login)) {
            LOGGER.debug("User logged in");
            return;
        }
        try {
            Optional<Users> user = userService.login(login, pass);
            UsersCommand.setUser(request, user.get());
            LOGGER.info("User " + login + " logged succesfully whith role: " + user.get().getRole());
            if (user.get ().getRole ().equals ( "seniorCaisher" )) {
                HttpSession session = request.getSession ();
                session.setAttribute ( "seniorcaisher",login );
                request.setAttribute ( "login",login );
                response.sendRedirect ( request.getContextPath ()+"/secured/seniorcaisher/seniorcashier.jsp" );
                return;
            }
            if (user.get ().getRole ().equals ( "supervisor" )) {
                HttpSession session = request.getSession ();
                session.setAttribute ( "supervisor",login );
                request.setAttribute ( "login",login );
                response.sendRedirect ( request.getContextPath ()+"/secured/supervisor/supervisor.jsp" );

                return;
            }
            if (user.get ().getRole ().equals ( "caisher" )) {
                HttpSession session = request.getSession ();
                session.setAttribute ( "caisher",login );
                request.setAttribute ( "login",login );
                response.sendRedirect ( request.getContextPath ()+"/secured/caisher/cashier.jsp" );
                return;
            }
            response.sendRedirect (request.getContextPath ()+ "/public/login.jsp");
            return;
        } catch (LoginException e) {
            request.setAttribute("log_error_message", "Wrong login o password");
        }
        LOGGER.info("Invalid attempt of login user: " + login);
        forward(request, response, "/public/login.jsp");
    }
}
