package cashdesk.controller.commands;

import cashdesk.controller.commands.product.ProductListCommand;
import cashdesk.model.entity.Product;
import cashdesk.model.srvice.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CaisherCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses=request.getSession(false);
        if(ses.getAttribute("loggedIn")!=null) {
            forward ( request, response, "/secured/caisher/cashier.jsp" );
        }else forward ( request, response, "/public/login.jsp" );
    }

}
