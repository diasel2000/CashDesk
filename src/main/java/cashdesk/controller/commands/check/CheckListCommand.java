package cashdesk.controller.commands.check;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Check;
import cashdesk.model.srvice.CheckService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CheckListCommand implements Command {
    private CheckService checkService;

    public CheckListCommand(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Check> checks = checkService.getAllChecks();
        System.out.println (checks);
        request.setAttribute("checks" , checks);
        request.setAttribute ( "summ",checkService.getSumm () );
        forward ( request,response, "/secured/caisher/cashier.jsp" );
    }
}
