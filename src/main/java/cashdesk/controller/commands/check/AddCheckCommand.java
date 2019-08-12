package cashdesk.controller.commands.check;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Check;
import cashdesk.model.entity.Product;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.CheckService;
import cashdesk.model.srvice.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class AddCheckCommand implements Command {
    private CheckService checkService;


    public AddCheckCommand(CheckService checkService) {
        this.checkService = checkService;
    }



    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String code = request.getParameter ( "cod");
        String count = request.getParameter ( "quant" );
        if(code == null || code.equals("")){
            forward(request, response, "/secured/caisher/cashier.jsp");
            return;
        }
        if(count == null || count.equals("")){
            forward(request, response, "/secured/caisher/cashier.jsp");
            return;
        }
        try {
            ProductService productService = new ProductService();
            Product product = productService.getProductById ( code );
            request.setAttribute ( "check",product );
            Map<Integer,BigDecimal> check = new HashMap<> (  );

            check.put ( product.getId (),product.getPrice () );
            checkService.addCheck( code,product.getPrice ());
            CheckListCommand checkListCommand = new CheckListCommand(checkService);
            checkListCommand.execute(request, response);
        } catch (SQLException e) {
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            forward(request, response, "/secured/caisher/cashier.jsp");
        }
    }
}
