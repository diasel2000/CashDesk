package cashdesk.controller.commands.check;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Check;
import cashdesk.model.srvice.CheckService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CheckListCommand implements Command {
    private CheckService checkService;

    public CheckListCommand(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Check> checks = checkService.getAllChecks();
        request.setAttribute("checks" , checks);
    }
}
