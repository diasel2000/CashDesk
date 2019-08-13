package cashdesk.controller.commands.user;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddUsersCommand implements Command {

    private UserService userService;

    public AddUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter ( "role" );
        String sid = request.getParameter ( "id_user" );
        int id = Integer.parseInt ( sid );
        Users user = new Users ();
        user.setId ( id );
        user.setRole ( role );
        Users loggedUser = (Users) ((HttpServletRequest) request).getSession ().getAttribute ( "user" );
        if (id == loggedUser.getId ()) {
            request.setAttribute ( "self_error_message", "You cannot change your own role" );
            UserListCommand listCommand = new UserListCommand ( userService );
            listCommand.execute ( request, response );
            return;
        }
        try {
            userService.update ( user );
        } catch (SQLException e) {
            request.setAttribute ( "sql_error_message", "Database problem: " + e.getMessage () );
            UserListCommand listCommand = new UserListCommand ( userService );
            listCommand.execute ( request, response );
            return;
        }
    }
}
