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
import java.sql.SQLException;

public class RegisterUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegisterUsersCommand.class);
    private UserService userService;

    public RegisterUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");
        if (username == null || username.equals("")) {
            request.setAttribute("username_error_message", "Put in the username");
            forward(request, response, "/public/registration.jsp");
            return;
        }
        if(pass == null || pass.equals("")){
            request.setAttribute("password_error_message", "Put in the password");
            forward(request, response, "/public/registration.jsp");
            return;
        }
        if(role == null || pass.equals("")){
            request.setAttribute("role_error_message", "Put in the role");
            forward(request, response, "/public/registration.jsp");
            return;
        }


        if (!Regex.isRoleCorrect(role)) {
            request.setAttribute("role_error_message", "Invalid role");
            forward(request, response, "/public/registration.jsp");
            return;
        }
        if (!Regex.isLoginCorrect(username)) {
            request.setAttribute("surname_error_message", "Invalid name");
            forward(request, response, "/public/registration.jsp");
            return;
        }
        if (!Regex.isPasswordCorrect(pass)) {
            request.setAttribute("password_error_message", "Invalid password");
            forward(request, response, "/public/registration.jsp");
            return;
        }

        try {
            userService.register(username,  pass, role);
            System.out.println("send");
        } catch (SQLException e) {
            LOGGER.debug("Database error when registering user "+ username);
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
        }
        LOGGER.info("Registration success for user "+ username);
        request.setAttribute("index_message", "Registration successful");
        forward(request, response, "/public/login.jsp");
    }
}

