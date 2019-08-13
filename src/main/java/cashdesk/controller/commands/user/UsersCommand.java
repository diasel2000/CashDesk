package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Users;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UsersCommand {

    static void setUser(HttpServletRequest request,
                        Users user) {
        HttpSession session = request.getSession ();
        session.setAttribute ( "loggedIn", user );
    }
}
