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
    static void setUserRole(HttpServletRequest request,
                            String role, String login) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        context.setAttribute("login", login);
        session.setAttribute("user", role);
    }

    static void setUser(HttpServletRequest request,
                        Users user) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        session.setAttribute("user", user);
    }

    static boolean checkLoggedUser(HttpServletRequest request, String login){
        if((Users) ((HttpServletRequest) request).getSession().getAttribute("user")!=null){
            return true;
        }
        return false;
    }


}
