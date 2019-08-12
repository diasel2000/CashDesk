package cashdesk.controller.commands.check;

import cashdesk.controller.commands.Command;
import cashdesk.model.srvice.CheckService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class DeleteCheckCommand implements Command {
    CheckService checkService;

    public DeleteCheckCommand(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        String code =  request.getParameter("id_check") ;

        try {
            checkService.delete(code);
            request.setAttribute ( "summ",checkService.getSumm () );
            forward ( request,response,"/secured/seniorcaisher/seniorcashier.jsp" );
        } catch (SQLException e) {
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            forward ( request,response,"/secured/seniorcaisher/seniorcashier.jsp" );
            return;
        }
    }
}
